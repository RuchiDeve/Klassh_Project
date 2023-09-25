package Backend.Assessment.klasha.apiResponse;

import Backend.Assessment.klasha.dto.LocationData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationResponse {
    private boolean error;
    private LocationData data;
}
