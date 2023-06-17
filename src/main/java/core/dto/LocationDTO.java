package core.dto;

import java.time.LocalDateTime;

public class LocationDTO {
    private Long id;
    private String name;
    private LocalDateTime version;
    private LocalDateTime createDate;

    public LocationDTO() {
    }

    public LocationDTO(Long id, String name, LocalDateTime version, LocalDateTime createDate) {
        this.id = id;
        this.name = name;
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
