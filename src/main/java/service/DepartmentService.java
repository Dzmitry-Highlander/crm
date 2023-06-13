package service;

import core.dto.DepartmentCreateUpdateDTO;
import core.dto.DepartmentDTO;
import dao.entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import service.api.IDepartmentService;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService implements IDepartmentService {
    @Override
    public DepartmentDTO create(DepartmentCreateUpdateDTO item) {
        return null;
    }

    @Override
    public DepartmentDTO read(Long id) {
        return null;
    }

    @Override
    public List<DepartmentDTO> read() {
        EntityManager em = Persistence.createEntityManagerFactory("crm").createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Department> criteria = cb.createQuery(Department.class);
        Root<Department> departmentRoot = criteria.from(Department.class);

        criteria.select(departmentRoot);

        List<Department> departments = em.createQuery(criteria).getResultList();
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();

        for (Department department : departments) {
            departmentDTOS.add(entityToDTO(department));
        }

        return departmentDTOS;
    }

    @Override
    public DepartmentDTO update(DepartmentCreateUpdateDTO item) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Department dtoToEntity(DepartmentDTO item) {
        Department department = new Department();

        department.setId(item.getId());
        department.setName(item.getName());
        department.setParent(item.getParent());
        department.setPhone(item.getPhone());
        department.setLocation(item.getLocation());

        return department;
    }

    @Override
    public DepartmentDTO entityToDTO(Department item) {
        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setId(item.getId());
        departmentDTO.setName(item.getName());
        departmentDTO.setParent(item.getParent());
        departmentDTO.setPhone(item.getPhone());
        departmentDTO.setLocation(item.getLocation());

        return departmentDTO;
    }
}
