package endpoints.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.dto.LocationCreateUpdateDTO;
import core.dto.LocationDTO;
import dao.entity.Location;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.api.ILocationService;
import service.factory.LocationConverterUtilFactory;
import service.factory.LocationServiceFactory;
import service.factory.ObjectMapperFactory;
import service.util.LocationConverterUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/location")
public class LocationServlet extends HttpServlet {
    private static final String ID = "id";
    private final ILocationService locationService;
    private final LocationConverterUtil locationConverterUtil;
    private final ObjectMapper objectMapper;


    public LocationServlet() {
        this.locationService = LocationServiceFactory.getInstance();
        this.locationConverterUtil = LocationConverterUtilFactory.getInstance();
        this.objectMapper = ObjectMapperFactory.getInstance();
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();

        if (req.getParameter(ID) != null) {
            String id = req.getParameter(ID);
            Location location = locationService.read(Long.parseLong(id));

            writer.write(objectMapper.writeValueAsString(locationConverterUtil.entityToDTO(location)));
        } else {
            List<Location> locations = locationService.read();
            List<LocationDTO> locationDTOS = new ArrayList<>();

            for (Location location : locations) {
                locationDTOS.add(locationConverterUtil.entityToDTO(location));
            }

            writer.write(objectMapper.writeValueAsString(locationDTOS));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        LocationCreateUpdateDTO locationDTO = objectMapper
                .readValue(req.getInputStream(), LocationCreateUpdateDTO.class);
        Location location = locationService.create(locationDTO);

        resp.setStatus(HttpServletResponse.SC_CREATED);
        writer.write(objectMapper.writeValueAsString(locationConverterUtil.entityToDTO(location)));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        LocationCreateUpdateDTO locationDTO = objectMapper
                .readValue(req.getInputStream(), LocationCreateUpdateDTO.class);
        Location location = locationService.create(locationDTO);

        writer.write(objectMapper.writeValueAsString(locationConverterUtil.entityToDTO(location)));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();

        try {
            if (req.getParameter(ID) != null) {
                String id = req.getParameter(ID);

                locationService.delete(Long.parseLong(id));
                writer.write(objectMapper.writeValueAsString("DELETED"));
            } else {
                throw new IllegalArgumentException("Укажите id!");
            }
        } catch (IllegalArgumentException e) {
            log(e.getMessage());
        }
    }
}
