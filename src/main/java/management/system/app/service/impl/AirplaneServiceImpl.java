package management.system.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import management.system.app.dto.airplane.AirplaneDto;
import management.system.app.dto.airplane.AirplaneRequestDto;
import management.system.app.exception.EntityNotFoundException;
import management.system.app.mapper.AirplaneMapper;
import management.system.app.model.Airplane;
import management.system.app.repository.AirplaneRepository;
import management.system.app.service.AirplaneService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneMapper airplaneMapper;
    private final AirplaneRepository airplaneRepository;

    @Override
    public AirplaneDto save(AirplaneRequestDto requestDto) {
        Airplane airplane = airplaneMapper.toModel(requestDto);
        if (requestDto.getAirCompanyId() != null) {
            return airplaneMapper.toDto(airplaneRepository.save(airplane));
        }
        airplane.setAirCompany(null);
        return airplaneMapper.toDto(airplaneRepository.save(airplane));
    }

    @Override
    public List<AirplaneDto> findAll(Pageable pageable) {
        return airplaneRepository.findAll(pageable)
                .stream()
                .map(airplaneMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AirplaneDto findById(Long id) {
        Airplane airplane = airplaneRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find company by ID: " + id));
        return airplaneMapper.toDto(airplane);
    }

    @Override
    public AirplaneDto updateById(Long id, AirplaneRequestDto requestDto) {
        Airplane airplaneToUpdate = airplaneMapper.toModel(requestDto);
        airplaneToUpdate.setId(id);
        Airplane savedAirplane = airplaneRepository.save(airplaneToUpdate);
        return airplaneMapper.toDto(savedAirplane);
    }

    @Override
    public void deleteById(Long id) {
        airplaneRepository.deleteById(id);
    }

    @Override
    public AirplaneDto moveAirplaneToOtherCompany(Long airplaneId, Long newCompanyId) {
        Airplane airplane = airplaneRepository.findById(airplaneId)
                .orElseThrow(() -> new EntityNotFoundException("Airplane with ID "
                        + airplaneId + " not found"));
        airplane.getAirCompany().setId(newCompanyId);
        return airplaneMapper.toDto(airplaneRepository.save(airplane));
    }
}
