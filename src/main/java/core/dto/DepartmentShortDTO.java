package core.dto;

public class DepartmentShortDTO {
    private String name;

    public DepartmentShortDTO() {
    }

    public DepartmentShortDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
