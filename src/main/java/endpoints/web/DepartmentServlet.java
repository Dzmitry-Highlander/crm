package endpoints.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.DepartmentService;
import service.LocationService;
import service.api.IDepartmentService;
import service.api.ILocationService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/test")
public class DepartmentServlet extends HttpServlet {
    private final ILocationService locationService;
    private final ObjectMapper objectMapper;

    public DepartmentServlet() {
        this.locationService = new LocationService();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();

        writer.write(objectMapper.writeValueAsString(locationService.read()));
    }
}
