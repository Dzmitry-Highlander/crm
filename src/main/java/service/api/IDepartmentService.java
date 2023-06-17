package service.api;

import core.dto.DepartmentCreateDTO;
import dao.entity.Department;

public interface IDepartmentService extends IServiceCRUD<Department, DepartmentCreateDTO> {
}
