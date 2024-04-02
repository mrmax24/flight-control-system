package management.system.app.service;

import java.util.List;
import management.system.app.dto.airplane.AirplaneDto;
import management.system.app.dto.airplane.AirplaneRequestDto;
import org.springframework.data.domain.Pageable;

public interface AirplaneService {
    AirplaneDto save(AirplaneRequestDto requestDto);

    List<AirplaneDto> findAll(Pageable pageable);

    AirplaneDto findById(Long id);

    AirplaneDto updateById(Long id, AirplaneRequestDto requestDto);

    void deleteById(Long id);

    AirplaneDto moveAirplaneToOtherCompany(Long id, Long newCompanyId);
}
