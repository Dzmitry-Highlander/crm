package service.util;

import core.dto.*;
import dao.entity.Department;
import service.api.IConverterUtil;

public class DepartmentConverterUtil implements IConverterUtil<DepartmentDTO, Department> {
    @Override
    public DepartmentDTO entityToDTO(Department item) {
        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setId(item.getId());
        departmentDTO.setName(item.getName());

        if (item.getParent() != null) {
            departmentDTO.setParent(new DepartmentShortDTO(item.getParent().getName()));
        }

        departmentDTO.setPhone(item.getPhone());
        departmentDTO.setLocation(new LocationShortDTO(item.getLocation().getName()));
        departmentDTO.setCreateDate(item.getCreateDate());
        departmentDTO.setUpdateDate(item.getUpdateDate());

        return departmentDTO;
    }
}
