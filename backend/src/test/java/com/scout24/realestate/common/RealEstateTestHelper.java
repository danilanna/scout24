package com.scout24.realestate.common;

import com.scout24.realestate.domain.RealEstate;
import com.scout24.realestate.domain.RealEstateType;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RealEstateTestHelper {

    public static List<RealEstate> buildRealEstateList(){
        final List<RealEstate> realEstateList = Arrays.asList(
                buildRealEstate().salesPrice(BigDecimal.valueOf(1000L)).build(),
                buildRealEstate().salesPrice(BigDecimal.valueOf(2000L)).build(),
                buildRealEstate().salesPrice(BigDecimal.valueOf(3000L)).build(),
                buildRealEstate().rentalPrice(BigDecimal.valueOf(1000L)).build(),
                buildRealEstate().rentalPrice(BigDecimal.valueOf(2000L)).build(),
                buildRealEstate().rentalPrice(BigDecimal.valueOf(3000L)).build());
        return Stream
                .concat(realEstateList.stream(), buildRealEstateFilteredList().stream())
                .collect(Collectors.toList());
    }

    public static List<RealEstate> buildRealEstateFilteredList(){
        return Arrays.asList(
                buildRealEstate().salesPrice(BigDecimal.valueOf(400L)).build(),
                buildRealEstate().salesPrice(BigDecimal.valueOf(600L)).build(),
                buildRealEstate().salesPrice(BigDecimal.valueOf(450L)).build(),
                buildRealEstate().rentalPrice(BigDecimal.valueOf(400L)).build(),
                buildRealEstate().rentalPrice(BigDecimal.valueOf(600L)).build(),
                buildRealEstate().rentalPrice(BigDecimal.valueOf(450L)).build());
    }

    public static RealEstate.RealEstateBuilder buildRealEstate() {
        return RealEstate.builder()
                .type(RealEstateType.APARTMENT_BUY)
                .city("München")
                .houseNumber("12-15")
                .livingArea(30L)
                .postcode(80808L)
                .street("Strasse");
    }
}
