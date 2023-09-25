package Backend.Assessment.klasha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyData {
    private String currency;
    private String iso2;
    private String iso3;
}
