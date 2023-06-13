package dao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Department {
    @Id
    @JsonProperty("department_id")
    private Long id;
    private String name;
    @JoinTable(
            name="department_relations",
            joinColumns= @JoinColumn(name="parent_id"),
            inverseJoinColumns= @JoinColumn(name="child_id")
    )
    @ManyToOne
    private Department parent;
    private String phone;
    @ManyToOne
    private Location location;

    public Department() {
    }
}
