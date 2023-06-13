package dao.entity;

import jakarta.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue
    @Column(name = "department_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @JoinTable(
            name="department_relations",
            joinColumns= @JoinColumn(name="parent_id"),
            inverseJoinColumns= @JoinColumn(name="child_id")
    )
    @ManyToOne
    private Department parent;
    @Column(name = "phone")
    private String phone;
    @ManyToOne
    private Location location;

    public Department() {
    }

    public Department(String name, Department parent, String phone, Location location) {
        this.name = name;
        this.parent = parent;
        this.phone = phone;
        this.location = location;
    }

    public Department(Long id, String name, Department parent, String phone, Location location) {
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
