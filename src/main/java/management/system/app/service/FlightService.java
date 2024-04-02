package management.system.app.service;

import java.util.List;
import management.system.app.dto.flight.ChangeFlightStatusDto;
import management.system.app.dto.flight.FlightDto;
import management.system.app.dto.flight.FlightRequestDto;
import management.system.app.dto.flight.FlightSearchParametersDto;
import management.system.app.model.enums.FlightStatus;
import org.springframework.data.domain.Pageable;

public interface FlightService {
    FlightDto save(FlightRequestDto requestDto);

    List<FlightDto> findAll(Pageable pageable);

    FlightDto findById(Long id);

    FlightDto updateById(Long id, FlightRequestDto requestDto);

    void deleteById(Long id);

    List<FlightDto> findAllByAirCompanyNameAndFlightStatus(String name,
                                                            FlightStatus flightStatus);

    List<FlightDto> findAllByFlightStatusActiveAndStartedAtBefore();

    List<FlightDto> findAllCompletedFlightsWithTimeDifferenceGreaterThanEstimated();

    FlightDto changeFlightStatus(Long id, ChangeFlightStatusDto changeDto);

    List<FlightDto> search(FlightSearchParametersDto searchParametersDto);
}
