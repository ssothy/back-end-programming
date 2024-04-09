package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CUSTOMERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_ID")
    private Long id;

    @Column(name = "Customer_First_Name", nullable = false)
    private String firstName;

    @Column(name = "Customer_Last_Name", nullable = false)
    private String lastName;

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "Postal_Code", nullable = false)
    private String postal_code;

    @Column(name = "Phone", nullable = false)
    private String phone;

    @CreationTimestamp
    @Column(name = "Create_Date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "Last_Update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "Division_ID")
    private Division division;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts = new HashSet<>();

    public void add(Cart cart) {
        if (cart != null) {
            if (carts == null ) {
                carts = new HashSet<>();
            }

            carts.add(cart);
            cart.setCustomer(this);
        }
    }
}
