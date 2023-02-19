package com.bezkoder.springjwt.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "real_estate")
public class RealEstate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "homeNumber")
    private String homeNumber;
    @Column(name = "price")
    private double price;
    @Column(name = "image")
    private String image;

    @Column(name = "street")
    private String street;

    @Column(name = "ward")
    private String ward;

    @Column(name = "district")
    private String district;

    @Column(name = "city")
    private String city;

    @Column(name = "horizontal")
    private double horizontal;

    @Column(name = "length")
    private double length;

    @Column(name = "totalArea")
    private double totalArea;

    @Column(name = "structure")
    private String structure;

    @Column(name = "priceM2")
    private double priceM2;

    @Column(name = "owner")
    private String owner;

    @Column(name = "phoneOwner")
    private String phoneOwner;

    @Column(name = "status")
    private String status;
}
