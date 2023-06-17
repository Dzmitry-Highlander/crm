package core.dto;

import java.time.LocalDateTime;

public class DepartmentDTO {
    private Long id;
    private String name;
    private DepartmentShortDTO parent;
    private String phone;
    private LocationDTO location;
    private LocalDateTime version;
    private LocalDateTime createDate;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long id, String name, DepartmentShortDTO parent, String phone, LocationDTO location,
                         LocalDateTime version, LocalDateTime createDate) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        this.phone = phone;
        this.location = location;
        this.version = version;
        this.createDate = createDate;
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

    public LocalDateTime getVersion() {
        return version;
    }

    public void setVersion(LocalDateTime version) {
        this.version = version;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
