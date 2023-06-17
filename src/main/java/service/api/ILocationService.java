package service.api;

import core.dto.LocationCreateDTO;
import dao.entity.Location;

public interface ILocationService extends IServiceCRUD<Location, LocationCreateDTO> {
}
