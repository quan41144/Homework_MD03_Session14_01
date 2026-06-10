package ra.hwss1301.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeDTO {
    @NotBlank(message = "Không được để trống tên nhân viên!")
    private String fullName;
    private Double salary;
}
