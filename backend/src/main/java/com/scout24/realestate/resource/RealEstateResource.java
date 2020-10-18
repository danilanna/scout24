package com.scout24.realestate.resource;

import com.scout24.realestate.domain.RealEstate;
import com.scout24.realestate.domain.RealEstateType;
import com.scout24.realestate.service.RealEstateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/real-estate", produces = MediaType.APPLICATION_JSON_VALUE)
public class RealEstateResource {

    private final RealEstateService realEstateService;

    @GetMapping
    public ResponseEntity<List<RealEstate>> find(@RequestParam(required = false) boolean filterByPrice,
                                                 @RequestParam(required = false) RealEstateType type) {
        if (filterByPrice && type == null){
            return ResponseEntity.ok().body(realEstateService.filterByPrice());
        } else if (!filterByPrice && type != null){
            return ResponseEntity.ok().body(realEstateService.filterAllByType(type));
        } else if (filterByPrice){
            return ResponseEntity.ok().body(realEstateService.filterByPriceAndType(type));
        }
        return ResponseEntity.ok().body(realEstateService.findAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RealEstate> save(@Valid @RequestBody RealEstate realEstate) {
        return ResponseEntity.ok().body(realEstateService.save(realEstate));
    }
}
