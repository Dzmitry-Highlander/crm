package core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationCreateUpdateDTO {
    @JsonProperty("name")
    private String name;

    public LocationCreateUpdateDTO() {
    }

    public LocationCreateUpdateDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
