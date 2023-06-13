package service;

import core.dto.DepartmentCreateUpdateDTO;
import core.dto.DepartmentDTO;
import dao.entity.Department;
import service.api.IDepartmentService;

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
        return null;
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
