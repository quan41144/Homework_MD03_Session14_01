package ra.hwss1301.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.hwss1301.model.dto.request.EmployeeDTO;
import ra.hwss1301.model.dto.response.ApiDataResponse;
import ra.hwss1301.model.entity.Employee;
import ra.hwss1301.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<ApiDataResponse<List<Employee>>> findAll() {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy danh sách nhân viên thành công!",
                employeeService.findAll(),
                HttpStatus.OK
        ), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ApiDataResponse<Employee>> save(@Valid @RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Tạo mới nhân viên thành công!",
                employeeService.createEmployee(employeeDTO),
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }
}
