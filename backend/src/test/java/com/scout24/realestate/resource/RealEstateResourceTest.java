package com.scout24.realestate.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scout24.realestate.common.RealEstateTestHelper;
import com.scout24.realestate.domain.RealEstate;
import com.scout24.realestate.repository.RealEstateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RealEstateResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RealEstateRepository realEstateRepository;

    @BeforeEach
    public void setUp() {
        realEstateRepository.deleteAll();
        final List<RealEstate> realEstateList = RealEstateTestHelper.buildRealEstateList();
        realEstateRepository.saveAll(realEstateList);
    }

    @Test
    public void shouldGetAllValues() throws Exception {
        this.mockMvc.perform(get("/real-estate"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(12)));
    }

    @Test
    public void shouldGetOnlyPricesBetween400And600() throws Exception {
        this.mockMvc.perform(get("/real-estate?filterByPrice=true"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(6)));
    }

    @Test
    public void shouldGetOnlyPricesBetween400And600AndByType() throws Exception {
        this.mockMvc.perform(get("/real-estate?filterByPrice=true&type=APARTMENT_RENT"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void shouldGetOnlyByType() throws Exception {
        this.mockMvc.perform(get("/real-estate?filterByPrice=false&type=APARTMENT_BUY"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(9)));
    }

    @Test
    public void shouldPostAndReturnSuccess() throws Exception {
        final RealEstate realEstate = RealEstateTestHelper.buildRealEstate().build();
        this.mockMvc.perform(post("/real-estate")
                .content(objectMapper.writeValueAsString(realEstate))
                .contentType(APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(notNullValue()));
    }

    @Test
    public void shouldPostAndReturnErrorWhenMissingFields() throws Exception {
        final RealEstate realEstate = RealEstateTestHelper.buildRealEstate().street(null).build();
        this.mockMvc.perform(post("/real-estate")
                .content(objectMapper.writeValueAsString(realEstate))
                .contentType(APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.street").value("must not be null"));
    }
}
