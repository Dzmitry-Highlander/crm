package core.dto;

public class LocationShortDTO {
    private String name;

    public LocationShortDTO() {
    }

    public LocationShortDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
