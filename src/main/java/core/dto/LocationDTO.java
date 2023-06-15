package core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationDTO {
    @JsonProperty("location_id")
    private Long id;
    private String name;

    public LocationDTO() {
    }

    public LocationDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
