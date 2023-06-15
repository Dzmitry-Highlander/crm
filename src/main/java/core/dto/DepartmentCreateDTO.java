package core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepartmentCreateDTO {
    @JsonProperty("department_id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("parent_id")
    private Long parent;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("location_id")
    private Long location;

    public DepartmentCreateDTO() {
    }

    public DepartmentCreateDTO(String name, Long parent, String phone, Long location) {
        this.name = name;
        this.parent = parent;
        this.phone = phone;
        this.location = location;
    }

    public DepartmentCreateDTO(Long id, String name, Long parent, String phone, Long location) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        this.phone = phone;
        this.location = location;
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
