package core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepartmentCreateUpdateDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("parent_id")
    private Long parent;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("location_id")
    private Long location;

    public DepartmentCreateUpdateDTO() {
    }

    public DepartmentCreateUpdateDTO(String name, Long parent, String phone, Long location) {
        this.name = name;
        this.parent = parent;
        this.phone = phone;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getLocation() {
        return location;
    }

    public void setLocation(Long location) {
        this.location = location;
    }
}
