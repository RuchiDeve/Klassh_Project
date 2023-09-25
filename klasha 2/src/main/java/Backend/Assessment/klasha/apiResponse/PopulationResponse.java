package Backend.Assessment.klasha.apiResponse;

import Backend.Assessment.klasha.dto.PopulationsData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class PopulationResponse {
    private String msg;
    private boolean error;
    private PopulationsData data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public PopulationsData getData() {
        return data;
    }

    public void setData(PopulationsData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PopulationResponse{" +
                "msg='" + msg + '\'' +
                ", error=" + error +
                ", data=" + data +
                '}';
    }
}
