package service;

import core.dto.LocationCreateDTO;
import core.dto.LocationUpdateDTO;
import dao.api.ILocationDao;
import dao.entity.Location;
import service.api.ILocationService;

import java.time.LocalDateTime;
import java.util.List;

public class LocationService implements ILocationService {
    private final ILocationDao locationDao;

    public LocationService(ILocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @Override
    public Location create(LocationCreateDTO item) {
        Location location = new Location();
        LocalDateTime createDate = LocalDateTime.now();

        location.setName(item.getName());
        location.setCreateDate(createDate);
        location.setUpdateDate(createDate);

        return locationDao.create(location);
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
    public Location update(Long id, LocalDateTime date, LocationUpdateDTO item) throws IllegalArgumentException {
        Location location = locationDao.read(id);

        if (location != null) {
            if (location.getUpdateDate().equals(date)) {
                location.setId(id);
                location.setName(item.getName());
                location.setUpdateDate(LocalDateTime.now());
                location.setCreateDate(locationDao.read(id).getCreateDate());

                locationDao.update(location);

                return location;
            }

            throw new IllegalArgumentException("Объект был обновлен!");
        }

        throw new IllegalArgumentException("Локация не найдена!");
    }

    @Override
    public void delete(Long id) {
        locationDao.delete(id);
    }
}
