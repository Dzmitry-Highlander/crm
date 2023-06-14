package endpoints.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.dto.DepartmentCreateUpdateDTO;
import core.dto.DepartmentDTO;
import core.dto.DepartmentShortDTO;
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

@WebServlet("/api/department/create")
public class DepartmentCreateServlet extends HttpServlet {
    private final IDepartmentService departmentService;
    private final ObjectMapper objectMapper;

    public DepartmentCreateServlet() {
        this.departmentService = DepartmentServiceFactory.getInstance();
        this.objectMapper = ObjectMapperFactory.getInstance();
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        DepartmentDTO departmentDTO = departmentService
                .create(objectMapper.readValue(req.getInputStream(), DepartmentCreateUpdateDTO.class));

        resp.setStatus(HttpServletResponse.SC_CREATED);
        writer.write(objectMapper.writeValueAsString(departmentDTO));
    }
}
