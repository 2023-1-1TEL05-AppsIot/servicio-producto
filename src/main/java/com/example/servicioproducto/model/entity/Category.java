package com.example.servicioproducto.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "categories")
@Getter
@Setter
@JsonIgnoreProperties({"picture"})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryid")
    private int id;
    @Column(nullable = false)
    private String categoryname;
    private String description;
    @Lob
    private byte[] picture;
}
