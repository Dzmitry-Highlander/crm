package endpoints.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.DepartmentService;
import service.api.IDepartmentService;
import service.factory.ObjectMapperFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/department/read_all")
public class DepartmentServlet extends HttpServlet {
    private final IDepartmentService departmentService;
    private final ObjectMapper objectMapper;

    public DepartmentServlet() {
        this.departmentService = new DepartmentService();
        this.objectMapper = ObjectMapperFactory.getInstance();
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();

        writer.write(objectMapper.writeValueAsString(departmentService.read()));
    }
}
