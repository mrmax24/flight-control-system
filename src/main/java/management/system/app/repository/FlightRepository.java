package management.system.app.repository;

import java.time.LocalDateTime;
import java.util.List;
import management.system.app.model.Flight;
import management.system.app.model.enums.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FlightRepository extends JpaRepository<Flight, Long>,
        JpaSpecificationExecutor<Flight> {
    List<Flight> findAllByFlightStatus(
            FlightStatus flightStatus);

    List<Flight> findAllByAirCompany_NameAndFlightStatus(
            String name, FlightStatus flightStatus);

    List<Flight> findAllByFlightStatusAndStartedAtBefore(
            FlightStatus flightStatus, LocalDateTime date);

    List<Flight> findAllByFlightStatusAndStartedAtBeforeAndEndedAtAfter(
            FlightStatus flightStatus, LocalDateTime startedAt, LocalDateTime endedAt);
}
