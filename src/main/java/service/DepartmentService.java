package service;

import core.dto.DepartmentCreateUpdateDTO;
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
    public Department create(DepartmentCreateUpdateDTO item) {
        return null;
    }

    @Override
    public Department read(Long id) {
        Department department = departmentDao.read(id);

        return null;
    }

    @Override
    public List<Department> read() {
        List<Department> departments = departmentDao.read();

        return null;
    }

    @Override
    public Department update(Long id, DepartmentCreateUpdateDTO item) {
        return null;
    }

    @Override
    public void delete(Long id) {
        departmentDao.delete(id);
    }
}
