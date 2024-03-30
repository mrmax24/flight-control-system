package management.system.app.service.impl;

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
    public List<FlightDto> findAllByAirCompanyIdAndFlightStatus(String name,
                                                             FlightStatus flightStatus) {
        return flightRepository.findAllByAirCompanyIdAndFlightStatus(name, flightStatus)
                .stream().map(flightMapper::toDto).collect(Collectors.toList());
    }
}
