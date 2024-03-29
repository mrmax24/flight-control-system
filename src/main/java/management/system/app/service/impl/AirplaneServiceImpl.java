package management.system.app.service.impl;

import lombok.RequiredArgsConstructor;
import management.system.app.dto.AirplaneDto;
import management.system.app.dto.AirplaneRequestDto;
import management.system.app.mapper.AirplaneMapper;
import management.system.app.model.Airplane;
import management.system.app.repository.AirCompanyRepository;
import management.system.app.repository.AirplaneRepository;
import management.system.app.service.AirplaneService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneMapper airplaneMapper;
    private final AirplaneRepository airplaneRepository;
    private final AirCompanyRepository airCompanyRepository;

    @Override
    public AirplaneDto save(AirplaneRequestDto requestDto) {
        Airplane airplane = airplaneMapper.toModel(requestDto);
        return airplaneMapper.toDto(airplaneRepository.save(airplane));
    }

    @Override
    public AirplaneDto changeCompany(Long companyId, AirplaneRequestDto requestDto) {
        Airplane airplane = airplaneMapper.toModel(requestDto);
        airCompanyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Air Company not found with id: "
                        + companyId));
        airplane.setAirCompanyId(companyId);
        return airplaneMapper.toDto(airplaneRepository.save(airplane));
    }
}
