package Backend.Assessment.klasha;

import Backend.Assessment.klasha.controller.ApiController;
import Backend.Assessment.klasha.dto.CityDto;
import Backend.Assessment.klasha.dto.CountryDetailsDto;
import Backend.Assessment.klasha.dto.StateAndCitiesDto;
import Backend.Assessment.klasha.service.CountryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FetchTopNCitiesFromCountriesTest {

    @InjectMocks
    private ApiController apiController;

    @Mock
    private CountryService countryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getTopNCities() throws IOException {
        int numberOfCities = 5;
        List<CityDto> expectedCities = new ArrayList<>();

        when(countryService.fetchTopNCitiesFromCountries(numberOfCities)).thenReturn(expectedCities);

        ResponseEntity<List<CityDto>> responseEntity = apiController.getTopNCities(numberOfCities);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedCities, responseEntity.getBody());

        verify(countryService, times(1)).fetchTopNCitiesFromCountries(numberOfCities);
    }


    @Test
    void getCountryDetails_ReturnsCountryDetails() {
        CountryDetailsDto mockCountryDetails = new CountryDetailsDto();
        mockCountryDetails.setCountry("TestCountry");

        when(countryService.getCountryDetails("TestCountry")).thenReturn(mockCountryDetails);

        ResponseEntity<CountryDetailsDto> responseEntity = apiController.getCountryDetails("TestCountry");

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockCountryDetails, responseEntity.getBody());
        verify(countryService, times(1)).getCountryDetails("TestCountry");
    }

    @Test
    void getCountryDetails_ReturnsInternalServerErrorOnException() {
        when(countryService.getCountryDetails("InvalidCountry")).thenThrow(new RuntimeException("Something went wrong"));

        ResponseEntity<CountryDetailsDto> responseEntity = apiController.getCountryDetails("InvalidCountry");

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals(null, responseEntity.getBody());

        verify(countryService, times(1)).getCountryDetails("InvalidCountry");
    }

    @Test
    void getStatesAndCities_ReturnsStatesAndCities() throws JsonProcessingException {
        String country = "TestCountry";
        List<StateAndCitiesDto> mockStatesAndCities = Collections.singletonList(new StateAndCitiesDto());

        when(countryService.fetchStatesAndCitiesInACountry(country)).thenReturn(mockStatesAndCities);

        ResponseEntity<List<StateAndCitiesDto>> responseEntity = apiController.getStatesAndCities(country);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockStatesAndCities, responseEntity.getBody());
        verify(countryService, times(1)).fetchStatesAndCitiesInACountry(country);
    }

}