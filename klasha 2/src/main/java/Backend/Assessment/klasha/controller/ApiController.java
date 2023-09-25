package Backend.Assessment.klasha.controller;

import Backend.Assessment.klasha.CustomException;
import Backend.Assessment.klasha.dto.CityDto;
import Backend.Assessment.klasha.dto.CountryDetailsDto;
import Backend.Assessment.klasha.dto.CountryInfoDto;
import Backend.Assessment.klasha.dto.StateAndCitiesDto;
import Backend.Assessment.klasha.service.CountryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final CountryService apiService;

    @GetMapping("/top-cities")
    public ResponseEntity<List<CityDto>> getTopNCities(@RequestParam int numberOfCities) {
        try {
            List<CityDto> topNCities = apiService.fetchTopNCitiesFromCountries(numberOfCities);
            return new ResponseEntity<>(topNCities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/country-detail")
    public ResponseEntity<CountryDetailsDto> getCountryDetails(@RequestParam String country) {
        try {
            CountryDetailsDto countryDetailsDto = apiService.getCountryDetails(country);
            return new ResponseEntity<>(countryDetailsDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/states-and-cities")
    public ResponseEntity<List<StateAndCitiesDto>> getStatesAndCities(@RequestParam("country") String country) throws JsonProcessingException {
        try {
            List<StateAndCitiesDto> statesAndCities = apiService.fetchStatesAndCitiesInACountry(country);
            if (!statesAndCities.isEmpty()) {
                return new ResponseEntity<>(statesAndCities, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (CustomException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/convert-currency")
    public ResponseEntity<String> convertCurrency(
            @RequestParam("country") String country,
            @RequestParam("amount") double amount,
            @RequestParam("targetCurrency") String targetCurrency) {

        try {
            String convertedAmount = apiService.convertAndFormatCurrency(country, amount, targetCurrency);
            if (convertedAmount != null && !convertedAmount.isEmpty()) {
                return new ResponseEntity<>(convertedAmount, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Conversion unsuccessful.", HttpStatus.BAD_REQUEST);
            }
        } catch (CustomException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

