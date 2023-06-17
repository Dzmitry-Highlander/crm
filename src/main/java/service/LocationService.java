package service;

import core.dto.LocationCreateDTO;
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
    public Location create(LocationCreateDTO item) {
        return locationDao.create(new Location(item.getName()));
    }

    @Override
    public Location read(Long id) {
        return locationDao.read(id);
    }

    @Override
    public List<Location> read() {
        return locationDao.read();
    }

    @Override
    public Location update(Long id, LocationCreateDTO item) {
        return locationDao.update(id, new Location(item.getName()));
    }

    @Override
    public void delete(Long id) {
        locationDao.delete(id);
    }
}
