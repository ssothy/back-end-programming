package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    @Column(name = "vacation_id")
    private Vacation vacation;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date lastUpdate;

    @ManyToOne()
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @ManyToMany()
    @JoinTable(name = "excursion_cartitem", joinColumns = @JoinColumn(name = "excursion_id"),
        inverseJoinColumns = @JoinColumn(name = "cart_item_id"))
    private Set<Excursion> excursions;
}
