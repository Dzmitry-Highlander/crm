package dao.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Department implements Serializable {
    @Id
    @SequenceGenerator(name = "department", sequenceName = "crm.department_department_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "department", strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinTable(
            name = "department_relations",
            joinColumns = @JoinColumn(name = "parent_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id")
    )
    private Department parent;
    @Column(name = "phone")
    private String phone;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @Column(name = "update_Date")
    private LocalDateTime updateDate;
    @Column(name = "create_date")
    private LocalDateTime createDate;

    public Department() {
    }

    public Department(String name, Department parent, String phone, Location location, LocalDateTime updateDate,
                      LocalDateTime createDate) {
        this.name = name;
        this.parent = parent;
        this.phone = phone;
        this.location = location;
        this.updateDate = updateDate;
        this.createDate = createDate;
    }

    public Department(Long id, String name, Department parent, String phone, Location location,
                      LocalDateTime updateDate, LocalDateTime createDate) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        this.phone = phone;
        this.location = location;
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
        if (!(o instanceof Department that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(),
                that.getName()) && Objects.equals(getParent(), that.getParent()) && Objects.equals(getPhone(),
                that.getPhone()) && Objects.equals(getLocation(), that.getLocation()) && Objects.equals(getUpdateDate(),
                that.getUpdateDate()) && Objects.equals(getCreateDate(), that.getCreateDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getParent(), getPhone(), getLocation(), getUpdateDate(),
                getCreateDate());
    }
}
