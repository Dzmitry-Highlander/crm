package service.api;

import core.dto.LocationCreateDTO;
import core.dto.LocationUpdateDTO;
import dao.entity.Location;

public interface ILocationService extends IServiceCRUD<Location, LocationCreateDTO, LocationUpdateDTO> {
}
