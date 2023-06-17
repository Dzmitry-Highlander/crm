package endpoints.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.dto.DepartmentCreateUpdateDTO;
import core.dto.DepartmentDTO;
import dao.entity.Department;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.api.IDepartmentService;
import service.factory.DepartmentConverterUtilFactory;
import service.factory.DepartmentServiceFactory;
import service.factory.ObjectMapperFactory;
import service.util.DepartmentConverterUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/department")
public class DepartmentServlet extends HttpServlet {
    private static final String ID = "id";
    private final IDepartmentService departmentService;
    private final DepartmentConverterUtil departmentConverterUtil;
    private final ObjectMapper objectMapper;

    public DepartmentServlet() {
        this.departmentService = DepartmentServiceFactory.getInstance();
        this.departmentConverterUtil = DepartmentConverterUtilFactory.getInstance();
        this.objectMapper = ObjectMapperFactory.getInstance();
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();

        if (req.getParameter(ID) != null) {
            String id = req.getParameter(ID);
            Department department = departmentService.read(Long.parseLong(id));

            writer.write(objectMapper.writeValueAsString(departmentConverterUtil.entityToDTO(department)));
        } else {
            List<Department> departments = departmentService.read();
            List<DepartmentDTO> departmentDTOS = new ArrayList<>();

            for (Department department : departments) {
                departmentDTOS.add(departmentConverterUtil.entityToDTO(department));
            }

            writer.write(objectMapper.writeValueAsString(departmentDTOS));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        DepartmentCreateUpdateDTO departmentDTO = objectMapper
                .readValue(req.getInputStream(), DepartmentCreateUpdateDTO.class);
        Department department = departmentService.create(departmentDTO);

        resp.setStatus(HttpServletResponse.SC_CREATED);
        writer.write(objectMapper.writeValueAsString(departmentConverterUtil.entityToDTO(department)));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        String id = req.getParameter(ID);
        DepartmentCreateUpdateDTO departmentDTO = objectMapper
                .readValue(req.getInputStream(), DepartmentCreateUpdateDTO.class);
        Department department = departmentService.update(Long.parseLong(id), departmentDTO);

        writer.write(objectMapper.writeValueAsString(departmentConverterUtil.entityToDTO(department)));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();

        try {
            if (req.getParameter(ID) != null) {
                String id = req.getParameter(ID);

                departmentService.delete(Long.parseLong(id));
            } else {
                throw new IllegalArgumentException("Укажите id!");
            }
        } catch (IllegalArgumentException e) {
            log(e.getMessage());
        }

        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
