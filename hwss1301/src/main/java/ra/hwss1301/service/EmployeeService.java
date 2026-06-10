package ra.hwss1301.service;

import ra.hwss1301.model.dto.request.EmployeeDTO;
import ra.hwss1301.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee createEmployee(EmployeeDTO employeeDTO);
}
