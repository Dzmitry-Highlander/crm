package endpoints.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.dto.DepartmentCreateUpdateDTO;
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
import java.util.List;

@WebServlet("api/department")
public class DepartmentServlet extends HttpServlet {
    private static final String ID = "id";
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

        if (req.getParameter(ID) != null) {
            String id = req.getParameter(ID);
            DepartmentDTO departmentDTO = departmentService.read(Long.parseLong(id));

            writer.write(objectMapper.writeValueAsString(departmentDTO));
        } else {
            List<DepartmentDTO> departmentDTOS = departmentService.read();

            writer.write(objectMapper.writeValueAsString(departmentDTOS));
        }
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

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        DepartmentCreateUpdateDTO departmentDTO = objectMapper
                .readValue(req.getInputStream(), DepartmentCreateUpdateDTO.class);

        departmentService.update(departmentDTO);
        resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        writer.write(objectMapper.writeValueAsString(departmentDTO));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        String id = req.getParameter(ID);

        departmentService.delete(Long.parseLong(id));
        writer.write(objectMapper.writeValueAsString("OK"));
    }
}
