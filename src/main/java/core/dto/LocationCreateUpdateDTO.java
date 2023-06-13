package core.dto;

public class LocationCreateUpdateDTO {
    private String name;

    public LocationCreateUpdateDTO() {
    }

    public LocationCreateUpdateDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
