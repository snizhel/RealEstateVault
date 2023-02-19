package com.bezkoder.springjwt.Dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link com.bezkoder.springjwt.models.RealEstate} entity
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RealEstateDto implements Serializable {
    private long id;
    private String homeNumber;
    private double price;
    private String image;
    private String street;
    private String ward;
    private String district;
    private String city;
    private double horizontal;
    private double length;
    private double totalArea;
    private String structure;
    private double priceM2;
    private String owner;
    private String phoneOwner;
    private String status;
}