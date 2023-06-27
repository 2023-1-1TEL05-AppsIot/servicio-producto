package com.example.servicioproducto.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private int id;

    @Column(nullable = false)
    private String productname;
    private BigDecimal unitprice;
    private Integer unitsinstock;
    private int unitsonorder;

    @ManyToOne
    @JoinColumn(name = "supplierid")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
    private String quantityperunit;
    private int reorderlevel;
    @Column(nullable = false)
    private boolean discontinued;

    @Transient
    private int port;

}

