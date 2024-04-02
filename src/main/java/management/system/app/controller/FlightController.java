package management.system.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import management.system.app.dto.flight.ChangeFlightStatusDto;
import management.system.app.dto.flight.FlightDto;
import management.system.app.dto.flight.FlightRequestDto;
import management.system.app.dto.flight.FlightSearchParametersDto;
import management.system.app.model.enums.FlightStatus;
import management.system.app.service.FlightService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
@Tag(name = "Flight management", description = "Endpoints for managing flights")
public class FlightController {
    private final FlightService flightService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    @Operation(summary = "Create a new flight", description = "Creates a new flight")
    public FlightDto addNewFlight(@RequestBody FlightRequestDto requestDto) {
        return flightService.save(requestDto);
    }

    @GetMapping
    @Operation(summary = "Get all flights",
            description = "Returns a list of all available flights")
    public List<FlightDto> findAllFlights(Pageable pageable) {
        return flightService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a flight by id", description = "Returns an flight by id")
    public FlightDto findFlightById(@PathVariable Long id) {
        return flightService.findById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a flight by id", description = "Updates a flight by id")
    public FlightDto updateFlightById(@PathVariable Long id,
                                          @RequestBody @Valid FlightRequestDto requestDto) {
        return flightService.updateById(id, requestDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a flight by id", description = "Deletes a flight by id")
    public void deleteFlightById(@PathVariable Long id) {
        flightService.deleteById(id);
    }

    @GetMapping("/byCompanyAndStatus")
    @Operation(summary = "Get all air company flights by flight status using company name",
            description = "Gets all air company flights by flight status using company name")
    public List<FlightDto> findAllByAirCompanyNameAndFlightStatus(
            @RequestParam String companyName, @RequestParam FlightStatus flightStatus) {
        return flightService.findAllByAirCompanyNameAndFlightStatus(companyName, flightStatus);
    }

    @GetMapping("status/active")
    @Operation(summary = "Get all flights in ACTIVE status started more than 24 hours ago",
            description = "Gets all flights in ACTIVE status started more than 24 hours ago")
    public List<FlightDto> getAllActiveFlightsStartedBefore24HoursAgo() {
        return flightService.findAllByFlightStatusActiveAndStartedAtBefore();
    }

    @GetMapping("status/completed/delayed")
    @Operation(summary = "Get all delayed flights in COMPLETED status ",
            description = "Get all flights in COMPLETED status where difference between"
                    + "started and ended time is bigger than the estimated flight time.")
    public List<FlightDto> getCompletedFlightsWithTimeDifference() {
        return flightService.findAllCompletedFlightsWithTimeDifferenceGreaterThanEstimated();
    }

    @PutMapping("/{id}/status/change")
    @Operation(summary = "Change flight status",
            description = "Changes the status of the flight along with its start and end time")
    public FlightDto changeFlightStatus(@PathVariable Long id,
                                        @RequestBody ChangeFlightStatusDto requestDto) {
        return flightService.changeFlightStatus(id, requestDto);
    }

    @GetMapping("/search")
    @Operation(summary = "Search for flights by applying the criteria",
            description = "Search for flights by filtering the flight status")
    List<FlightDto> search(FlightSearchParametersDto searchParametersDto) {
        return flightService.search(searchParametersDto);
    }
}
