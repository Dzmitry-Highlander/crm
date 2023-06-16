package service.api;

import core.dto.DepartmentCreateUpdateDTO;
import dao.entity.Department;

public interface IDepartmentService extends IServiceCRUD<Department, DepartmentCreateUpdateDTO> {
}
