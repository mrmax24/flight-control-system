package management.system.app.service.impl;

import lombok.RequiredArgsConstructor;
import management.system.app.dto.airplane.AirplaneDto;
import management.system.app.dto.airplane.AirplaneRequestDto;
import management.system.app.exception.EntityNotFoundException;
import management.system.app.mapper.AirplaneMapper;
import management.system.app.model.Airplane;
import management.system.app.repository.AirplaneRepository;
import management.system.app.service.AirplaneService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneMapper airplaneMapper;
    private final AirplaneRepository airplaneRepository;

    @Override
    public AirplaneDto save(AirplaneRequestDto requestDto) {
        Airplane airplane = airplaneMapper.toModel(requestDto);
        return airplaneMapper.toDto(airplaneRepository.save(airplane));
    }

    @Override
    public AirplaneDto moveAirplane(Long airplaneId, Long newCompanyId) {
        Airplane airplane = airplaneRepository.findById(airplaneId)
                .orElseThrow(() -> new EntityNotFoundException("Airplane with ID "
                        + airplaneId + " not found"));
        airplane.setAirCompanyId(newCompanyId);
        return airplaneMapper.toDto(airplaneRepository.save(airplane));
    }
}
