package endpoints.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.api.IDepartmentService;
import service.api.ILocationService;
import service.factory.DepartmentServiceFactory;
import service.factory.LocationServiceFactory;
import service.factory.ObjectMapperFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/location/delete")
public class DepartmentDeleteServlet extends HttpServlet {
    private static final String ID = "id";
    private final IDepartmentService departmentService;
    private final ObjectMapper objectMapper;

    public DepartmentDeleteServlet() {
        this.departmentService = DepartmentServiceFactory.getInstance();
        this.objectMapper = ObjectMapperFactory.getInstance();
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        String id = req.getParameter(ID);

        departmentService.delete(Long.parseLong(id));
        writer.write(objectMapper.writeValueAsString("OK"));
    }
}
