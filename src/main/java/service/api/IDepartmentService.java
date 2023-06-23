package service.api;

import core.dto.DepartmentCreateDTO;
import core.dto.DepartmentUpdateDTO;
import dao.entity.Department;

public interface IDepartmentService extends IServiceCRUD<Department, DepartmentCreateDTO, DepartmentUpdateDTO> {
}
