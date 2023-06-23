package core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class LocationUpdateDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("update_date")
    private LocalDateTime updateDate;

    public LocationUpdateDTO() {
    }

    public LocationUpdateDTO(String name, LocalDateTime updateDate) {
        this.name = name;
        this.updateDate = updateDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
