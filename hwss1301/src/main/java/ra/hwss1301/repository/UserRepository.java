package ra.hwss1301.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.hwss1301.model.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
