package service.api;

import core.dto.DepartmentCreateDTO;
import core.dto.DepartmentDTO;
import core.dto.DepartmentUpdateDTO;
import dao.entity.Department;

public interface IDepartmentConverterUtil extends IConverterUtil<Department, DepartmentDTO> {
    Department CreateDTOtoEntity(DepartmentCreateDTO item);

    Department UpdateDTOtoEntity(DepartmentUpdateDTO item);
}
