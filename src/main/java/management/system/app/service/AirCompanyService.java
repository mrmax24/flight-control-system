package management.system.app.service;

import java.util.List;
import management.system.app.dto.AirCompanyDto;
import management.system.app.dto.AirCompanyRequestDto;
import org.springframework.data.domain.Pageable;

public interface AirCompanyService {
    AirCompanyDto save(AirCompanyRequestDto requestDto);

    List<AirCompanyDto> findAll(Pageable pageable);

    AirCompanyDto findById(Long id);

    AirCompanyDto updateById(Long id, AirCompanyRequestDto createBookDto);

    void deleteById(Long id);

}
