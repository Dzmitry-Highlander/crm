package service;

import core.dto.LocationCreateUpdateDTO;
import core.dto.LocationDTO;
import dao.api.ILocationDao;
import dao.entity.Location;
import service.api.ILocationService;

import java.util.ArrayList;
import java.util.List;

public class LocationService implements ILocationService {
    private final ILocationDao locationDao;

    public LocationService(ILocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @Override
    public Location dtoToEntity(LocationCreateUpdateDTO item) {
        Location location = new Location();

        if (item.getId() != null) {
            location.setId(item.getId());
        }
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
        Location location = locationDao.create(dtoToEntity(item));

        return entityToDTO(location);
    }

    @Override
    public LocationDTO read(Long id) {
        Location location = locationDao.read(id);

        return entityToDTO(location);
    }

    @Override
    public List<LocationDTO> read() {
        List<Location> locations = locationDao.read();
        List<LocationDTO> locationDTOS = new ArrayList<>();

        for (Location location : locations) {
            locationDTOS.add(entityToDTO(location));
        }

        return locationDTOS;
    }

    @Override
    public void update(LocationCreateUpdateDTO item) {
        locationDao.update(dtoToEntity(item));
    }

    @Override
    public void delete(Long id) {
        locationDao.delete(id);
    }
}
