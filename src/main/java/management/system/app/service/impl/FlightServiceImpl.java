package management.system.app.service.impl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import management.system.app.dto.flight.ChangeFlightStatusDto;
import management.system.app.dto.flight.FlightDto;
import management.system.app.dto.flight.FlightRequestDto;
import management.system.app.dto.flight.FlightSearchParametersDto;
import management.system.app.exception.EntityNotFoundException;
import management.system.app.mapper.FlightMapper;
import management.system.app.model.Flight;
import management.system.app.model.enums.FlightStatus;
import management.system.app.repository.FlightRepository;
import management.system.app.repository.impl.FlightSpecificationBuilder;
import management.system.app.service.FlightService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;
    private final FlightSpecificationBuilder flightSpecificationBuilder;

    @Override
    public FlightDto save(FlightRequestDto requestDto) {
        Flight flight = flightMapper.toModel(requestDto);
        flight.setFlightStatus(FlightStatus.PENDING);
        return flightMapper.toDto(flightRepository.save(flight));
    }

    @Override
    public List<FlightDto> findAll(Pageable pageable) {
        return flightRepository.findAll(pageable)
                .stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FlightDto findById(Long id) {
        Flight flight = flightRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find flight by ID: " + id));
        return flightMapper.toDto(flight);
    }

    @Override
    public FlightDto updateById(Long id, FlightRequestDto requestDto) {
        Flight flightToUpdate = flightMapper.toModel(requestDto);
        flightToUpdate.setId(id);
        Flight savedFlight = flightRepository.save(flightToUpdate);
        return flightMapper.toDto(flightToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        flightRepository.deleteById(id);
    }

    private Flight getFlightById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight by ID: " + id + " was not found"));
    }

    @Override
    public List<FlightDto> findAllByAirCompanyNameAndFlightStatus(String name,
                                                                   FlightStatus flightStatus) {
        return flightRepository.findAllByAirCompanyNameAndFlightStatus(name, flightStatus)
                .stream().map(flightMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<FlightDto> findAllByFlightStatusActiveAndStartedAtBefore() {
        LocalDateTime twentyFourHoursAgo = LocalDateTime.now().minusHours(24);
        List<Flight> activeFlights = flightRepository.findAllByFlightStatusAndStartedAtBefore(
                FlightStatus.ACTIVE, twentyFourHoursAgo);
        return activeFlights.stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightDto> findAllCompletedFlightsWithTimeDifferenceGreaterThanEstimated() {
        List<Flight> completedFlights = flightRepository
                .findAllByFlightStatus(FlightStatus.COMPLETED);
        return completedFlights.stream()
                .filter(flight -> {
                    Duration duration = Duration.between(flight.getStartedAt(),
                            flight.getEndedAt());
                    return duration.toHours() > flight.getEstimatedFlightTime();
                }).map(flightMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FlightDto changeFlightStatus(Long id, ChangeFlightStatusDto requestDto) {
        Flight flight = getFlightById(id);
        FlightStatus newStatus = requestDto.getFlightStatus();
        LocalDateTime currentDateTime = LocalDateTime.now();

        Map<FlightStatus, Consumer<Flight>> statusUpdateActions = Map.of(
                FlightStatus.DELAYED, f -> f.setDelayStartedAt(currentDateTime),
                FlightStatus.ACTIVE, f -> f.setStartedAt(currentDateTime),
                FlightStatus.COMPLETED, f -> f.setEndedAt(currentDateTime)
        );

        statusUpdateActions.getOrDefault(newStatus, f -> {
            throw new IllegalArgumentException("Invalid flight status: " + newStatus);
        }).accept(flight);

        flight.setFlightStatus(newStatus);
        return flightMapper.toDto(flightRepository.save(flight));
    }

    @Override
    public List<FlightDto> search(FlightSearchParametersDto searchParametersDto) {
        Specification<Flight> flightSpecification
                = flightSpecificationBuilder.build(searchParametersDto);
        return flightRepository.findAll(flightSpecification)
                .stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
    }
}
