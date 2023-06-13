package service.api;

import core.dto.LocationCreateUpdateDTO;
import core.dto.LocationDTO;
import dao.entity.Location;

public interface ILocationService extends IServiceCRUD<LocationCreateUpdateDTO, LocationDTO> {
    Location dtoToEntity(LocationDTO item);

    LocationDTO entityToDTO(Location item);
}
