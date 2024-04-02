package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="EXCURSIONS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Excursion_ID")
    private Long id;

    @Column(name = "Excursion_Title")
    private String excursion_title;

    @Column(name = "Excursion_Price")
    private BigDecimal excursion_price;

    @Column(name = "Image_URL")
    private String image_URL;

    @CreationTimestamp
    @Column(name = "Create_Date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "Last_Update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "Vacation_ID", nullable = false)
    private Vacation vacation;

    @ManyToMany
    @JoinTable(name = "excursion_cartitem",
        joinColumns = @JoinColumn(name = "Excursion_ID"),
            inverseJoinColumns = @JoinColumn(name = "Cart_Item_ID"))
    private Set<CartItem> cartitems;
}
