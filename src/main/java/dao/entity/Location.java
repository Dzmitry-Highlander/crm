package dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Location {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String name;

    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }

    public Location(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return Objects.equals(getId(), location.getId()) && Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name);
    }
}
