package A13.BADA.SalonSamochodowy.repository;

import A13.BADA.SalonSamochodowy.dataClasses.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}