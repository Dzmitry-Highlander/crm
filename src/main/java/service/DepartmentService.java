package service;

import core.dto.DepartmentCreateDTO;
import core.dto.DepartmentUpdateDTO;
import dao.api.IDepartmentDao;
import dao.api.ILocationDao;
import dao.entity.Department;
import service.api.IDepartmentService;

import java.time.LocalDateTime;
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
        Department department = new Department();

        return departmentDao.create(department);
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
    public Department update(Long id, LocalDateTime date, DepartmentUpdateDTO item) throws IllegalArgumentException {
        Department department = departmentDao.read(id);

        if (department != null) {
            if (department.getUpdateDate().equals(date)) {
                department.setId(id);
                department.setName(item.getName());

                if (item.getParent() != null) {
                    department.setParent(departmentDao.read(id).getParent());
                }

                department.setPhone(item.getPhone());
                department.setLocation(locationDao.read(item.getLocation()));

                return departmentDao.update(department);
            }

            throw new IllegalArgumentException("Объект был обновлен!");
        }

        throw new IllegalArgumentException("Департамент не найден!");
    }

    @Override
    public void delete(Long id) {
        departmentDao.delete(id);
    }
}
