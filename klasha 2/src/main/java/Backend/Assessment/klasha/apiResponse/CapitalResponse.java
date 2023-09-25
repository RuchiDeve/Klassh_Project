package Backend.Assessment.klasha.apiResponse;

import Backend.Assessment.klasha.dto.CapitalData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CapitalResponse {
    private boolean error;
    private CapitalData data;
}
