package ra.hwss1301.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.hwss1301.model.dto.request.EmployeeDTO;
import ra.hwss1301.model.entity.Employee;
import ra.hwss1301.repository.EmployeeRepository;
import ra.hwss1301.service.EmployeeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = Employee.builder()
                .fullName(employeeDTO.getFullName())
                .salary(employeeDTO.getSalary())
                .build();
        return employeeRepository.save(employee);
    }
}
