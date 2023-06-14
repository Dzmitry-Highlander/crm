package service;

import core.dto.DepartmentCreateUpdateDTO;
import core.dto.DepartmentDTO;
import dao.api.IDepartmentDao;
import dao.entity.Department;
import service.api.IDepartmentService;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService implements IDepartmentService {
    private final IDepartmentDao departmentDao;

    public DepartmentService(IDepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
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

    @Override
    public DepartmentDTO create(DepartmentCreateUpdateDTO item) {
        DepartmentDTO dto = new DepartmentDTO();

        dto.setName(item.getName());
        dto.setParent(item.getParent());
        dto.setPhone(item.getPhone());
        dto.setLocation(item.getLocation());

        return dto;
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
    public DepartmentDTO update(DepartmentCreateUpdateDTO item) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
