package dao.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Location implements Serializable {
    @Id
    @SequenceGenerator(name = "location", sequenceName = "crm.location_location_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "location", strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "update_Date")
    private LocalDateTime updateDate;
    @Column(name = "create_date")
    private LocalDateTime createDate;

    public Location() {
    }

    public Location(String name, LocalDateTime updateDate, LocalDateTime createDate) {
        this.name = name;
        this.updateDate = updateDate;
        this.createDate = createDate;
    }

    public Location(Long id, String name, LocalDateTime updateDate, LocalDateTime createDate) {
        this.id = id;
        this.name = name;
        this.updateDate = updateDate;
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

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return Objects.equals(getId(), location.getId()) && Objects.equals(getName(),
                location.getName()) && Objects.equals(getUpdateDate(),
                location.getUpdateDate()) && Objects.equals(getCreateDate(), location.getCreateDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getUpdateDate(), getCreateDate());
    }
}
