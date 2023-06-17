package service;

import core.dto.DepartmentCreateDTO;
import core.dto.DepartmentUpdateDTO;
import dao.api.IDepartmentDao;
import dao.entity.Department;
import service.api.IDepartmentConverterUtil;
import service.api.IDepartmentService;

import java.util.List;

public class DepartmentService implements IDepartmentService {
    private final IDepartmentDao departmentDao;
    private final IDepartmentConverterUtil departmentConverterUtil;

    public DepartmentService(IDepartmentDao departmentDao, IDepartmentConverterUtil departmentConverterUtil) {
        this.departmentDao = departmentDao;
        this.departmentConverterUtil = departmentConverterUtil;
    }

    @Override
    public Department create(DepartmentCreateDTO item) {
        return departmentDao.create(departmentConverterUtil.CreateDTOtoEntity(item));
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
    public Department update(Long id, DepartmentUpdateDTO item) {
        return departmentDao.update(id, departmentConverterUtil.UpdateDTOtoEntity(item));
    }

    @Override
    public void delete(Long id) {
        departmentDao.delete(id);
    }
}
