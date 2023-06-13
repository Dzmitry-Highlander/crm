package core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dao.entity.Department;
import dao.entity.Location;

public class DepartmentDTO {
    @JsonProperty("department_id")
    private Long id;
    private String name;
    private Department parent;
    private String phone;
    private Location location;
}
