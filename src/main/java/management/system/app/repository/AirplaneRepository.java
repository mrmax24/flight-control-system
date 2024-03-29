package management.system.app.repository;

import management.system.app.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
}
