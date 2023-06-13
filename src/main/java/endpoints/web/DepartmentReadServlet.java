package endpoints.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.dto.DepartmentDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.api.IDepartmentService;
import service.factory.DepartmentServiceFactory;
import service.factory.ObjectMapperFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/department/read")
public class DepartmentReadServlet extends HttpServlet {
    private static final String ID = "id";
    private final IDepartmentService departmentService;
    private final ObjectMapper objectMapper;

    public DepartmentReadServlet() {
        this.departmentService = DepartmentServiceFactory.getInstance();
        this.objectMapper = ObjectMapperFactory.getInstance();
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        String id = req.getParameter(ID);
        PrintWriter writer = resp.getWriter();
        DepartmentDTO dto =departmentService.read(Long.parseLong(id));

        writer.write(objectMapper.writeValueAsString(dto));
    }
}
