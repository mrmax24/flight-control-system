package management.system.app.service;

import java.util.List;
import management.system.app.dto.flight.FlightDto;
import management.system.app.model.enums.FlightStatus;

public interface FlightService {
    List<FlightDto> findAllByAirCompany_NameAndFlightStatus(String name,
                                                            FlightStatus flightStatus);

    List<FlightDto> findAllByFlightStatusActiveAndStartedAtBefore();
}
