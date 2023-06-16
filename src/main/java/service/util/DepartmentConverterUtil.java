package service.util;

import core.dto.DepartmentDTO;
import core.dto.DepartmentShortDTO;
import core.dto.LocationDTO;
import dao.entity.Department;
import service.api.IConverterUtil;

public class DepartmentConverterUtil implements IConverterUtil<Department, DepartmentDTO> {
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
}
