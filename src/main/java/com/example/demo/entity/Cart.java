package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "carts")
@Getter
@Setter
public class Cart {

    private Long id;

    private String orderTrackingNumber;

    private BigDecimal packagePrice;

    private int partySize;


}
