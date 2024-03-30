package management.system.app.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import management.system.app.dto.flight.FlightDto;
import management.system.app.model.enums.FlightStatus;
import management.system.app.service.FlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @GetMapping
    public List<FlightDto> findAllByAirCompanyNameAndFlightStatus(
            @RequestParam String companyName, @RequestParam FlightStatus flightStatus) {
        return flightService.findAllByAirCompany_NameAndFlightStatus(companyName, flightStatus);
    }

    @GetMapping("/active")
    public List<FlightDto> getAllActiveFlightsStartedBefore24HoursAgo() {
        return flightService.findAllByFlightStatusActiveAndStartedAtBefore();
    }
}
