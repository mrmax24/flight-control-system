package management.system.app.repository;

import java.util.List;
import management.system.app.model.Flight;
import management.system.app.model.enums.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("FROM Flight f"
            + " INNER JOIN AirCompany ac "
            + "ON f.airCompanyId = ac.id "
            + "WHERE ac.name = :name "
            + "AND f.flightStatus = :flightStatus")
    List<Flight> findAllByAirCompanyIdAndFlightStatus(String name,
                                                      FlightStatus flightStatus);
}
