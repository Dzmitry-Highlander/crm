package service.util;

import core.dto.LocationDTO;
import dao.entity.Location;
import service.api.IConverterUtil;

public class LocationConverterUtil implements IConverterUtil<LocationDTO, Location> {
    public LocationDTO entityToDTO(Location item) {
        LocationDTO locationDTO = new LocationDTO();

        locationDTO.setId(item.getId());
        locationDTO.setName(item.getName());
        locationDTO.setCreateDate(item.getCreateDate());
        locationDTO.setUpdateDate(item.getUpdateDate());

        return locationDTO;
    }
}
