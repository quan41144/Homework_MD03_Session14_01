package ra.hwss1301.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.hwss1301.model.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
