package com.scout24.realestate.service;

import com.scout24.realestate.common.RealEstateTestHelper;
import com.scout24.realestate.domain.RealEstate;
import com.scout24.realestate.domain.RealEstateType;
import com.scout24.realestate.repository.RealEstateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RealEstateServiceTest {

    @InjectMocks
    private RealEstateService realEstateService;

    @Mock
    private RealEstateRepository realEstateRepository;

    @Test
    public void shouldFindAllRecordsSuccessfully() {
        final List<RealEstate> realEstateList = RealEstateTestHelper.buildRealEstateList();
        when(realEstateRepository.findAll()).thenReturn(realEstateList);
        final List<RealEstate> list = realEstateService.findAll();
        assertEquals(list.size(), 12);
    }

    @Test
    public void shouldFindFilteredByPriceRecordsSuccessfully() {
        final List<RealEstate> realEstateList = RealEstateTestHelper.buildRealEstateFilteredList();
        when(realEstateRepository.filterByPrice(BigDecimal.valueOf(400), BigDecimal.valueOf(600))).thenReturn(realEstateList);
        final List<RealEstate> list = realEstateService.filterByPrice();
        assertEquals(list.size(), 6);
    }

    @Test
    public void shouldGetOnlyPricesBetween400And600AndByType() {
        final List<RealEstate> realEstateList = RealEstateTestHelper.buildRealEstateFilteredList()
                .stream()
                .filter(realEstate -> realEstate.getType().equals(RealEstateType.APARTMENT_RENT))
                .collect(Collectors.toList());
        when(realEstateRepository.filterByPriceAndType(BigDecimal.valueOf(400), BigDecimal.valueOf(600), RealEstateType.APARTMENT_RENT)).thenReturn(realEstateList);
        final List<RealEstate> list = realEstateService.filterByPriceAndType(RealEstateType.APARTMENT_RENT);
        assertEquals(list.size(), 1);
    }

    @Test
    public void shouldGetOnlyByType() {
        final List<RealEstate> realEstateList = RealEstateTestHelper.buildRealEstateList()
                .stream()
                .filter(realEstate -> realEstate.getType().equals(RealEstateType.HOUSE_RENT))
                .collect(Collectors.toList());
        when(realEstateRepository.findAllByType(RealEstateType.HOUSE_RENT)).thenReturn(realEstateList);
        final List<RealEstate> list = realEstateService.filterAllByType(RealEstateType.HOUSE_RENT);
        assertEquals(list.size(), 1);
    }

    @Test
    public void shouldSaveSuccessfully() {
        final RealEstate realEstate = RealEstateTestHelper.buildRealEstate().build();
        final RealEstate expectedRealEstate = RealEstateTestHelper.buildRealEstate().id(1L).build();
        when(realEstateRepository.save(realEstate)).thenReturn(expectedRealEstate);
        final RealEstate realEstateSaved = realEstateService.save(realEstate);
        assertEquals(realEstateSaved, expectedRealEstate);
    }
}
