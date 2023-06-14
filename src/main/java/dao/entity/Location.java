package dao.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Location implements Serializable {
    @Id
    @SequenceGenerator(name = "location", sequenceName = "crm.location_location_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "location", strategy = GenerationType.SEQUENCE)
    @Column(name = "location_id")
    private Long id;
    @Column(name = "name")
    private String name;

    public Location() {
    }

    public Location(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Location(String name) {
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
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id) && Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
