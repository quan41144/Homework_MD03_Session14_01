package ra.hwss1301.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "username", length = 100, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "full_name", length = 100)
    private String fullName;
    @Column(name = "role", length = 100, nullable = false)
    private String role;
    @Builder.Default
    @Column(name = "enabled", nullable = false, columnDefinition = "boolean default true")
    private Boolean enabled = true;
}
