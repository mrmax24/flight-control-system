package management.system.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import management.system.app.dto.airplane.AirplaneDto;
import management.system.app.dto.airplane.AirplaneRequestDto;
import management.system.app.service.AirplaneService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@Tag(name = "Airplane management", description = "Endpoints for managing airplanes")
public class AirplaneController {
    private final AirplaneService airplaneService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    @Operation(summary = "Create a new airplane", description = "Creates a new airplane")
    public AirplaneDto createAirplane(@RequestBody @Valid AirplaneRequestDto requestDto) {
        return airplaneService.save(requestDto);
    }

    @GetMapping
    @Operation(summary = "Get all airplanes",
            description = "Returns a list of all available airplanes")
    public List<AirplaneDto> findAllAirplanes(Pageable pageable) {
        return airplaneService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an airplane by id", description = "Returns an airplane by id")
    public AirplaneDto findAirplaneById(@PathVariable Long id) {
        return airplaneService.findById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an airplane by id", description = "Updates an airplane by id")
    public AirplaneDto updateAirplaneById(@PathVariable Long id,
                                           @RequestBody @Valid AirplaneRequestDto requestDto) {
        return airplaneService.updateById(id, requestDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an airplane by id", description = "Deletes an airplane by id")
    public void deleteAirplaneById(@PathVariable Long id) {
        airplaneService.deleteById(id);
    }

    @PutMapping("/{id}/move/{companyId}")
    @Operation(summary = "Move an airplane to other company",
            description = "Sets a different company id for the plane")
    public AirplaneDto moveAirplaneToOtherCompany(@PathVariable Long id,
                                                  @PathVariable Long companyId) {
        return airplaneService.moveAirplaneToOtherCompany(id, companyId);
    }
}
