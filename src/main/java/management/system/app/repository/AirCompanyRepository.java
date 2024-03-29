package management.system.app.repository;

import management.system.app.model.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirCompanyRepository extends JpaRepository<AirCompany, Long> {
}
