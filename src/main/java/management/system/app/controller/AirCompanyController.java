package management.system.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import management.system.app.dto.company.AirCompanyDto;
import management.system.app.dto.company.AirCompanyRequestDto;
import management.system.app.service.AirCompanyService;
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
@RequestMapping("/companies")
@RequiredArgsConstructor
@Tag(name = "Air company management", description = "Endpoints for managing air companies")
public class AirCompanyController {
    private final AirCompanyService airCompanyService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    @Operation(summary = "Create a new book company", description = "Creates a new company")
    public AirCompanyDto createCompany(@RequestBody @Valid AirCompanyRequestDto requestDto) {
        return airCompanyService.save(requestDto);
    }

    @GetMapping
    @Operation(summary = "Get all companies",
            description = "Returns a list of all available companies")
    public List<AirCompanyDto> findAllCompanies(Pageable pageable) {
        return airCompanyService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a company by id", description = "Returns a company by id")
    public AirCompanyDto findCompanyById(@PathVariable Long id) {
        return airCompanyService.findById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a company by id", description = "Updates a company by id")
    public AirCompanyDto updateCompanyById(@PathVariable Long id,
                                           @RequestBody @Valid AirCompanyRequestDto requestDto) {
        return airCompanyService.updateById(id, requestDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a company by id", description = "Deletes a company by id")
    public void deleteCompanyById(@PathVariable Long id) {
        airCompanyService.deleteById(id);
    }
}
