package Backend.Assessment.klasha.service;

import Backend.Assessment.klasha.dto.CityDto;
import Backend.Assessment.klasha.dto.CountryDetailsDto;
import Backend.Assessment.klasha.dto.CountryInfoDto;
import Backend.Assessment.klasha.dto.StateAndCitiesDto;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.List;

public interface CountryService {
    List<CityDto> fetchTopNCitiesFromCountries(int numberOfCities) throws IOException;
   // CountryInfoDto fetchCountryInfo(String country);
    List<StateAndCitiesDto> fetchStatesAndCities(String country);
    String convertAndFormatCurrency(String country, double amount, String targetCurrency);
    public List<StateAndCitiesDto> fetchStatesAndCitiesInACountry(String country) throws JsonProcessingException;
    public CountryDetailsDto getCountryDetails(String country);


}


