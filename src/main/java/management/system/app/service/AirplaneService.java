package management.system.app.service;

import management.system.app.dto.airplane.AirplaneDto;
import management.system.app.dto.airplane.AirplaneRequestDto;

public interface AirplaneService {
    AirplaneDto save(AirplaneRequestDto requestDto);

    AirplaneDto moveAirplaneToOtherCompany(Long id, Long newCompanyId);
}
