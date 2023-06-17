package service;

import core.dto.DepartmentCreateDTO;
import dao.api.IDepartmentDao;
import dao.api.ILocationDao;
import dao.entity.Department;
import service.api.IDepartmentService;

import java.util.List;

public class DepartmentService implements IDepartmentService {
    private final IDepartmentDao departmentDao;
    private final ILocationDao locationDao;

    public DepartmentService(IDepartmentDao departmentDao, ILocationDao locationDao) {
        this.departmentDao = departmentDao;
        this.locationDao = locationDao;
    }

    @Override
    public Department create(DepartmentCreateDTO item) {
        return departmentDao.create(DTOtoEntity(item));
    }

    @Override
    public Department read(Long id) {
        return departmentDao.read(id);
    }

    @Override
    public List<Department> read() {
        return departmentDao.read();
    }

    @Override
    public Department update(Long id, DepartmentCreateDTO item) {
        return departmentDao.update(id, DTOtoEntity(item));
    }

    @Override
    public void delete(Long id) {
        departmentDao.delete(id);
    }

    public Department DTOtoEntity(DepartmentCreateDTO item) {
        Department department = new Department();

        department.setName(item.getName());

        if (item.getParent() != null) {
            departmentDao.read(item.getParent());
        }

        department.setPhone(item.getPhone());
        department.setLocation(locationDao.read(item.getLocation()));

        return department;
    }
}
