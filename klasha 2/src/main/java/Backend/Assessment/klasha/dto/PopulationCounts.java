package Backend.Assessment.klasha.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PopulationCounts {
    private String year;
    private String value;
    private String sex;
    private String reliabilty;


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getReliabilty() {
        return reliabilty;
    }

    public void setReliabilty(String reliability) {
        this.reliabilty = reliability;
    }
}




