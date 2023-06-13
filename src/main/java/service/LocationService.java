package service;

import core.dto.LocationCreateUpdateDTO;
import core.dto.LocationDTO;
import dao.api.ILocationDao;
import dao.entity.Location;
import service.api.ILocationService;

import java.util.List;

public class LocationService implements ILocationService {
    private final ILocationDao locationDao;

    public LocationService(ILocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @Override
    public Location dtoToEntity(LocationDTO item) {
        Location location = new Location();

        location.setId(item.getId());
        location.setName(item.getName());

        return location;
    }

    @Override
    public LocationDTO entityToDTO(Location item) {
        LocationDTO locationDTO = new LocationDTO();

        locationDTO.setId(item.getId());
        locationDTO.setName(item.getName());

        return locationDTO;
    }

    @Override
    public LocationDTO create(LocationCreateUpdateDTO item) {
        return null;
    }

    @Override
    public LocationDTO read(Long id) {
        return null;
    }

    @Override
    public List<LocationDTO> read() {
        return null;
    }

    @Override
    public LocationDTO update(LocationCreateUpdateDTO item) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
