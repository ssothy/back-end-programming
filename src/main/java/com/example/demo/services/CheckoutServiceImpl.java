package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dto.Purchase;
import com.example.demo.dto.PurchaseResponse;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

import static com.example.demo.entities.Cart.StatusType.canceled;
import static com.example.demo.entities.Cart.StatusType.ordered;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //retrieve the order info from dto
        Cart cart = purchase.getCart();

        //populate cart with cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        //cartItems.forEach(cartItem -> cartItem.setCart(cart));
        cartItems.forEach(item -> {
            cart.add(item);
            item.setCart(cart);
            item.getExcursions().forEach(excursion -> {
                excursion.setVacation(item.getVacation());
                excursion.getCartitems().add(item);
            });
        });

        if (cart.getCartItems().isEmpty()) {
            return new PurchaseResponse("Cart is empty, Try again");

        }

        cart.setStatus(ordered);

        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);


        //return a response
        cartRepository.save(cart);
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        //generate a random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }
}
