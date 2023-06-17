package service.api;

import core.dto.LocationCreateUpdateDTO;
import dao.entity.Location;

public interface ILocationService extends IServiceCRUD<Location, LocationCreateUpdateDTO> {
}
