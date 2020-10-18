package com.scout24.realestate.repository;

import com.scout24.realestate.domain.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RealEstateRepository extends JpaRepository<RealEstate, Long> {

    @Query("SELECT re FROM RealEstate re WHERE" +
            " (re.rentalPrice >= :lowestPrice OR re.salesPrice >= :lowestPrice)" +
            " AND (re.rentalPrice <= :highestPrice OR re.salesPrice <= :highestPrice)")
    List<RealEstate> filterByPrice(@Param("lowestPrice") final BigDecimal lowestPrice,
                                  @Param("highestPrice") final BigDecimal highestPrice);

}
