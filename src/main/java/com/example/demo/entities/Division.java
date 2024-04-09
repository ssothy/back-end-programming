package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DIVISIONS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Division_ID")
    private Long id;

    @Column(name = "Division")
    private String division_name;

    @CreationTimestamp
    @Column(name = "Create_Date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "Last_Update")
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Country_ID", nullable = false, insertable = false, updatable = false)
    private Country country;

    @Column(name = "Country_ID")
    private long country_id;
    public void setCountry (Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customers;


}
