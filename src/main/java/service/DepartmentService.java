package service;

import core.dto.DepartmentCreateUpdateDTO;
import core.dto.DepartmentDTO;
import core.dto.DepartmentShortDTO;
import core.dto.LocationDTO;
import dao.api.IDepartmentDao;
import dao.api.ILocationDao;
import dao.entity.Department;
import service.api.IDepartmentService;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService implements IDepartmentService {
    private final IDepartmentDao departmentDao;
    private final ILocationDao locationDao;

    public DepartmentService(IDepartmentDao departmentDao, ILocationDao locationDao) {
        this.departmentDao = departmentDao;
        this.locationDao = locationDao;
    }

    @Override
    public Department dtoToEntity(DepartmentDTO item) {
        Department department = new Department();

        department.setId(item.getId());
        department.setName(item.getName());
        if (item.getParent() != null) {
            department.setParent(departmentDao.read(item.getId()));
        }
        department.setPhone(item.getPhone());
        department.setLocation(locationDao.read(item.getId()));

        return department;
    }

    @Override
    public DepartmentDTO entityToDTO(Department item) {
        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setId(item.getId());
        departmentDTO.setName(item.getName());
        if (item.getParent() != null) {
            departmentDTO.setParent(new DepartmentShortDTO(item.getParent().getId(), item.getParent().getName()));
        }
        departmentDTO.setPhone(item.getPhone());
        departmentDTO.setLocation(new LocationDTO(item.getLocation().getId(), item.getLocation().getName()));

        return departmentDTO;
    }

    @Override
    public DepartmentDTO create(DepartmentCreateUpdateDTO item) {
        Department department = new Department();

        department.setName(item.getName());
        department.setParent(departmentDao.read(item.getParent()));
        department.setPhone(item.getPhone());
        department.setLocation(locationDao.read(item.getId()));

        departmentDao.create(department);

        return entityToDTO(department);
    }

    @Override
    public DepartmentDTO read(Long id) {
        Department department = departmentDao.read(id);

        return entityToDTO(department);
    }

    @Override
    public List<DepartmentDTO> read() {
        List<Department> departments = departmentDao.read();
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();

        for (Department department : departments) {
            departmentDTOS.add(entityToDTO(department));
        }

        return departmentDTOS;
    }

    @Override
    public DepartmentDTO update(DepartmentDTO item) {
        Department department = departmentDao.update(dtoToEntity(item));

        return entityToDTO(department);
    }

    @Override
    public void delete(Long id) {
        departmentDao.delete(id);
    }
}
