package endpoints.web;

import com.fasterxml.jackson.databind.ObjectMapper;
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

@WebServlet("/api/location/read_all")
public class LocationReadAllServlet extends HttpServlet {
    private final ILocationService locationService;
    private final ObjectMapper objectMapper;

    public LocationReadAllServlet() {
        this.locationService = LocationServiceFactory.getInstance();
        this.objectMapper = ObjectMapperFactory.getInstance();
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        List<LocationDTO> locationDTOS = locationService.read();

        writer.write(objectMapper.writeValueAsString(locationDTOS));
    }
}
