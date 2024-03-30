package management.system.app.controller;

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
public class AirCompanyController {
    private final AirCompanyService airCompanyService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public AirCompanyDto createCompany(@RequestBody @Valid AirCompanyRequestDto requestDto) {
        return airCompanyService.save(requestDto);
    }

    @GetMapping
    public List<AirCompanyDto> findAllCompanies(Pageable pageable) {
        return airCompanyService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public AirCompanyDto findCompanyById(@PathVariable Long id) {
        return airCompanyService.findById(id);
    }

    @PutMapping("/{id}")
    public AirCompanyDto updateCompanyById(@PathVariable Long id,
                                           @RequestBody @Valid AirCompanyRequestDto requestDto) {
        return airCompanyService.updateById(id, requestDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCompanyById(@PathVariable Long id) {
        airCompanyService.deleteById(id);
    }
}
