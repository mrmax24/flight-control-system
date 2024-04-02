package management.system.app.service;

import java.util.List;
import management.system.app.dto.company.AirCompanyDto;
import management.system.app.dto.company.AirCompanyRequestDto;
import org.springframework.data.domain.Pageable;

public interface AirCompanyService {
    AirCompanyDto save(AirCompanyRequestDto requestDto);

    List<AirCompanyDto> findAll(Pageable pageable);

    AirCompanyDto findById(Long id);

    AirCompanyDto findByName(String name);

    AirCompanyDto updateById(Long id, AirCompanyRequestDto requestDto);

    void deleteById(Long id);
}
