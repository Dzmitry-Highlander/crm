package dao.entity;

import jakarta.persistence.*;

@Entity
public class Department {
    @Id
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
}
