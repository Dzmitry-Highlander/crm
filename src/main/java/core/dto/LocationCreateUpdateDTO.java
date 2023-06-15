package core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationCreateUpdateDTO {
    @JsonProperty("location_id")
    private Long id;
    @JsonProperty("name")
    private String name;

    public LocationCreateUpdateDTO() {
    }

    public LocationCreateUpdateDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public LocationCreateUpdateDTO(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
