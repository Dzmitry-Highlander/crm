package core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationCreateDTO {
    @JsonProperty("name")
    private String name;

    public LocationCreateDTO() {
    }

    public LocationCreateDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
