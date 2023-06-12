package dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Department {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    private Department parent;
    private String phone;
    @ManyToOne
    private Location location;
}
