package management.system.app.repository;

import java.time.LocalDate;
import java.util.List;
import management.system.app.model.Flight;
import management.system.app.model.enums.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findAllByAirCompany_NameAndFlightStatus(
            String name, FlightStatus flightStatus);

    List<Flight> findAllByFlightStatusAndStartedAtBefore(
            FlightStatus flightStatus, LocalDate date);
}
