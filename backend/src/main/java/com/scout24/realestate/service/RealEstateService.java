package com.scout24.realestate.service;

import com.scout24.realestate.domain.RealEstate;
import com.scout24.realestate.repository.RealEstateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RealEstateService {

    private static final BigDecimal LOWEST_PRICE = BigDecimal.valueOf(400);
    private static final BigDecimal HIGHEST_PRICE = BigDecimal.valueOf(600);
    private final RealEstateRepository realEstateRepository;

    public List<RealEstate> findAll() {
        return realEstateRepository.findAll();
    }

    public List<RealEstate> filterByPrice() {
        return realEstateRepository.filterByPrice(LOWEST_PRICE, HIGHEST_PRICE);
    }

    public RealEstate save(RealEstate realEstate) {
        return realEstateRepository.save(realEstate);
    }
}
