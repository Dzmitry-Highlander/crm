package core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationUpdateDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("version")
    private Long version;

    public LocationUpdateDTO() {
    }

    public LocationUpdateDTO(String name, Long version) {
        this.name = name;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
