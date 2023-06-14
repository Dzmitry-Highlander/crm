package endpoints.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.dto.LocationCreateUpdateDTO;
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

@WebServlet("/api/location/update")
public class LocationUpdateServlet extends HttpServlet {
    private final ILocationService locationService;
    private final ObjectMapper objectMapper;

    public LocationUpdateServlet() {
        this.locationService = LocationServiceFactory.getInstance();
        this.objectMapper = ObjectMapperFactory.getInstance();
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        LocationCreateUpdateDTO locationDTOOld = new LocationCreateUpdateDTO("Брагин, Беларусь");
        LocationDTO locationDTO = locationService
                .update(locationDTOOld, objectMapper.readValue(req.getInputStream(), LocationCreateUpdateDTO.class));

        resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        writer.write(objectMapper.writeValueAsString(locationDTO));
    }
}
