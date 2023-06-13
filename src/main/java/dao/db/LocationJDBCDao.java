package dao.db;

import core.dto.DepartmentDTO;
import core.dto.LocationDTO;
import dao.api.ILocationDao;
import dao.entity.Department;
import dao.entity.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import service.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class LocationJDBCDao implements ILocationDao {
    @Override
    public Location create(Location item) {
        return null;
    }

    @Override
    public Location read(Long id) {
        return null;
    }

    @Override
    public List<Location> read() {
        EntityManager em = HibernateUtil.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Location> criteria = cb.createQuery(Location.class);
        Root<Location> departmentRoot = criteria.from(Location.class);

        criteria.select(departmentRoot);

        return em.createQuery(criteria).getResultList();
    }

    @Override
    public Location update(Location item) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
