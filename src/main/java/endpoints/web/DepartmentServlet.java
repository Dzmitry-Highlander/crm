package endpoints.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.dto.DepartmentDTO;
import dao.entity.Department;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/department/read_all")
public class DepartmentServlet extends HttpServlet {
    private final IDepartmentService departmentService;
    private final ObjectMapper objectMapper;

    public DepartmentServlet() {
        this.departmentService = DepartmentServiceFactory.getInstance();
        this.objectMapper = ObjectMapperFactory.getInstance();
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        List<DepartmentDTO> departmentDTOS = departmentService.read();
        List<Department> departments = new ArrayList<>();

        for (DepartmentDTO dto : departmentDTOS) {
            departments.add(departmentService.dtoToEntity(dto));
        }

        writer.write(objectMapper.writeValueAsString(departments));
    }
}
