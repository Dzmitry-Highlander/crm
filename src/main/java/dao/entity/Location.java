package dao.entity;

import jakarta.persistence.*;

import java.io.Serializable;
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
    @Column(name = "version")
    private Long version;

    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }

    public Location(String name, Long version) {
        this.name = name;
        this.version = version;
    }

    public Location(Long id, String name, Long version) {
        this.id = id;
        this.name = name;
        this.version = version;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return Objects.equals(getId(), location.getId()) && Objects.equals(getName(),
                location.getName()) && Objects.equals(getVersion(), location.getVersion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getVersion());
    }
}
