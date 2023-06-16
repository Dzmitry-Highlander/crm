package service.api;

import core.dto.DepartmentCreateUpdateDTO;
import core.dto.DepartmentDTO;
import dao.entity.Department;

public interface IDepartmentService extends IServiceCRUD<DepartmentCreateUpdateDTO, DepartmentDTO> {
    Department dtoToEntity(DepartmentDTO item);

    DepartmentDTO entityToDTO(Department item);
}
