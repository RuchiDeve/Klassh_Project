package Backend.Assessment.klasha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDetailsDto {
    private String country;
    private String capitalCity;
    private List<PopulationCounts> populationCounts;
    private LocationData locationData;
    private String currency;
    private String iso2;
    private String iso3;
}
