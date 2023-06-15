package service.api;

import core.dto.LocationCreateDTO;
import core.dto.LocationDTO;
import dao.entity.Location;

public interface ILocationService extends IServiceCRUD<LocationCreateDTO, LocationDTO> {
    Location dtoToEntity(LocationCreateDTO item);

    LocationDTO entityToDTO(Location item);
}
