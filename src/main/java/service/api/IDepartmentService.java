package service.api;

import core.dto.DepartmentCreateDTO;
import core.dto.DepartmentDTO;
import dao.entity.Department;

public interface IDepartmentService extends IServiceCRUD<DepartmentCreateDTO, DepartmentDTO> {
    Department dtoToEntity(DepartmentCreateDTO item);

    DepartmentDTO entityToDTO(Department item);
}
