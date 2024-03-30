package management.system.app.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import management.system.app.dto.flight.FlightDto;
import management.system.app.mapper.FlightMapper;
import management.system.app.model.enums.FlightStatus;
import management.system.app.repository.FlightRepository;
import management.system.app.service.FlightService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Override
    public List<FlightDto> findAllByAirCompany_NameAndFlightStatus(String name,
                                                                   FlightStatus flightStatus) {
        return flightRepository.findAllByAirCompany_NameAndFlightStatus(name, flightStatus)
                .stream().map(flightMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<FlightDto> findAllByFlightStatusActiveAndStartedAtBefore() {
        LocalDateTime twentyFourHoursAgo = LocalDateTime.now().minusHours(24);
        LocalDate toLocalDate = twentyFourHoursAgo.toLocalDate();
        return flightRepository.findAllByFlightStatusAndStartedAtBefore(FlightStatus.ACTIVE, toLocalDate)
                .stream().map(flightMapper::toDto).collect(Collectors.toList());
    }
}
