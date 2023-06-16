package endpoints.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.dto.LocationCreateDTO;
import core.dto.LocationDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.api.ILocationService;
import service.factory.LocationServiceFactory;
import service.factory.ObjectMapperFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/location")
public class LocationServlet extends HttpServlet {
    private static final String ID = "id";
    private final ILocationService locationService;
    private final ObjectMapper objectMapper;

    public LocationServlet() {
        this.locationService = LocationServiceFactory.getInstance();
        this.objectMapper = ObjectMapperFactory.getInstance();
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();

        if (req.getParameter(ID) != null) {
            String id = req.getParameter(ID);
            LocationDTO locationDTO = locationService.read(Long.parseLong(id));

            writer.write(objectMapper.writeValueAsString(locationDTO));
        } else {
            List<LocationDTO> locationDTOS = locationService.read();

            writer.write(objectMapper.writeValueAsString(locationDTOS));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        LocationCreateDTO locationDTO = objectMapper.readValue(req.getInputStream(), LocationCreateDTO.class);

        locationService.create(locationDTO);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        writer.write(objectMapper.writeValueAsString(locationDTO));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        LocationDTO locationDTO = objectMapper
                .readValue(req.getInputStream(), LocationDTO.class);

        locationService.update(locationDTO);
        writer.write(objectMapper.writeValueAsString(locationDTO));
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
