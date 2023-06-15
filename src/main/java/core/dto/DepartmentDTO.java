package core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepartmentDTO {
    @JsonProperty("department_id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("department_id")
    private DepartmentShortDTO parent;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("location_id")
    private LocationDTO location;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long id, String name, DepartmentShortDTO parent, String phone, LocationDTO location) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        this.phone = phone;
        this.location = location;
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

    public DepartmentShortDTO getParent() {
        return parent;
    }

    public void setParent(DepartmentShortDTO parent) {
        this.parent = parent;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }
}
