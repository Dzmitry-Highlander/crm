package service.util;

import core.dto.*;
import dao.entity.Department;
import service.api.IDepartmentConverterUtil;

public class DepartmentConverterUtil implements IDepartmentConverterUtil {
    @Override
    public DepartmentDTO entityToDTO(Department item) {
        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setId(item.getId());
        departmentDTO.setName(item.getName());
        if (item.getParent() != null) {
            departmentDTO.setParent(new DepartmentShortDTO(item.getParent().getId(), item.getParent().getName()));
        }
        departmentDTO.setPhone(item.getPhone());
        //TODO departmentDTO.setLocation(new LocationDTO(item.getLocation().getId(), item.getLocation().getName()));

        return departmentDTO;
    }

    @Override
    public Department CreateDTOtoEntity(DepartmentCreateDTO item) {
        //TODO CreateDTOtoEntity(DepartmentCreateDTO item)
        return null;
    }

    @Override
    public Department UpdateDTOtoEntity(DepartmentUpdateDTO item) {
        //TODO UpdateDTOtoEntity(DepartmentUpdateDTO item)
        return null;
    }
}
