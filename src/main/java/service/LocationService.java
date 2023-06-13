package service;

import core.dto.DepartmentDTO;
import core.dto.LocationCreateUpdateDTO;
import core.dto.LocationDTO;
import dao.entity.Department;
import dao.entity.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import service.api.ILocationService;

import java.util.ArrayList;
import java.util.List;

public class LocationService implements ILocationService {
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
        EntityManager em = Persistence.createEntityManagerFactory("crm").createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Location> criteria = cb.createQuery(Location.class);
        Root<Location> departmentRoot = criteria.from(Location.class);

        criteria.select(departmentRoot);

        List<Location> locations = em.createQuery(criteria).getResultList();
        List<LocationDTO> locationDTOS = new ArrayList<>();

        for (Location department : locations) {
            locationDTOS.add(entityToDTO(department));
        }

        return locationDTOS;
    }

    @Override
    public LocationDTO update(LocationCreateUpdateDTO item) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
