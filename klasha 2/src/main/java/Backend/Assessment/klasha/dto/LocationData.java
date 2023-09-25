package Backend.Assessment.klasha.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationData {
    @JsonProperty("lat")
    private String latitude;
    @JsonProperty("long")
    private String longitude;
}
