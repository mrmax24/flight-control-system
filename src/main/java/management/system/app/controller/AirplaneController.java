package management.system.app.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import management.system.app.dto.airplane.AirplaneDto;
import management.system.app.dto.airplane.AirplaneRequestDto;
import management.system.app.service.AirplaneService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airplanes")
@RequiredArgsConstructor
public class AirplaneController {
    private final AirplaneService airplaneService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public AirplaneDto createAirplane(@RequestBody @Valid AirplaneRequestDto requestDto) {
        return airplaneService.save(requestDto);
    }

    @PutMapping("/{id}/move/{companyId}")
    public AirplaneDto moveAirplaneToOtherCompany(@PathVariable Long id,
                                                  @PathVariable Long companyId) {
        return airplaneService.moveAirplane(id, companyId);
    }
}
