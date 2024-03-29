package management.system.app.service;

import management.system.app.dto.AirplaneDto;
import management.system.app.dto.AirplaneRequestDto;

public interface AirplaneService {
    AirplaneDto save(AirplaneRequestDto requestDto);

    AirplaneDto changeCompany(Long companyId, AirplaneRequestDto requestDto);
}
