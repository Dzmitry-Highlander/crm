package core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dao.entity.Department;
import dao.entity.Location;

public class DepartmentDTO {
    @JsonProperty("department_id")
    private Long id;
    private String name;
    private Department parent;
    private String phone;
    private Location location;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long id, String name, Department parent, String phone, Location location) {
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

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
