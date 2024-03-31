package management.system.app.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import management.system.app.dto.flight.ChangeFlightStatusDto;
import management.system.app.dto.flight.FlightDto;
import management.system.app.dto.flight.FlightRequestDto;
import management.system.app.dto.flight.FlightSearchParametersDto;
import management.system.app.model.enums.FlightStatus;
import management.system.app.service.FlightService;
import org.springframework.http.HttpStatus;
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
public class FlightController {
    private final FlightService flightService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public FlightDto addNewFlight(@RequestBody FlightRequestDto requestDto) {
        return flightService.save(requestDto);
    }

    @GetMapping
    public List<FlightDto> findAllByAirCompanyNameAndFlightStatus(
            @RequestParam String companyName, @RequestParam FlightStatus flightStatus) {
        return flightService.findAllByAirCompany_NameAndFlightStatus(companyName, flightStatus);
    }

    @GetMapping("status/active")
    public List<FlightDto> getAllActiveFlightsStartedBefore24HoursAgo() {
        return flightService.findAllByFlightStatusActiveAndStartedAtBefore();
    }

    @GetMapping("status/completed/delayed")
    public List<FlightDto> getCompletedFlightsWithTimeDifference() {
        return flightService.findAllCompletedFlightsWithTimeDifferenceGreaterThanEstimated();
    }

    @PutMapping("/{id}/status/change")
    public FlightDto changeFlightStatus(@PathVariable Long id,
                                        @RequestBody ChangeFlightStatusDto requestDto) {
        return flightService.changeFlightStatus(id, requestDto);
    }

    @GetMapping("/search")
    List<FlightDto> search(FlightSearchParametersDto searchParametersDto) {
        return flightService.search(searchParametersDto);
    }
}
