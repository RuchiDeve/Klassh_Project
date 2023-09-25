package Backend.Assessment.klasha.apiResponse;

import Backend.Assessment.klasha.dto.CurrencyData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyResponse {
    private boolean error;
    private CurrencyData data;
}