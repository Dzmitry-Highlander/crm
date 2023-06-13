package service;

import core.dto.DepartmentCreateUpdateDTO;
import core.dto.DepartmentDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import service.api.IDepartmentService;

import java.util.List;

public class DepartmentService implements IDepartmentService {
    @Override
    public DepartmentDTO create(DepartmentCreateUpdateDTO item) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("crm");

        EntityManager em = factory.createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        return null;
    }

    @Override
    public DepartmentDTO read(Long id) {
        return null;
    }

    @Override
    public List<DepartmentDTO> read() {
        return null;
    }

    @Override
    public DepartmentDTO update(DepartmentCreateUpdateDTO item) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
