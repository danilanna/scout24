package com.scout24.realestate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "real_estate")
public class RealEstate {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "type", length = 15)
    @Enumerated(EnumType.STRING)
    private RealEstateType type;

    @NotNull
    @Size(max = 250)
    @Column(name = "street", length = 250)
    private String street;

    @NotNull
    @Size(max = 250)
    @Column(name = "house_number", length = 250)
    private String houseNumber;

    @NotNull
    @Column(name = "postcode")
    private Long postcode;

    @NotNull
    @Size(max = 250)
    @Column(name = "city", length = 250)
    private String city;

    @NotNull
    @Column(name = "living_area")
    private Long livingArea;

    @Column(name = "site_area")
    private Long siteArea;

    @Column(name = "rental_price")
    private BigDecimal rentalPrice;

    @Column(name = "sales_price")
    private BigDecimal salesPrice;

    @Size(max = 250)
    @Column(name = "image_url", length = 250)
    private String imageURL;
}
