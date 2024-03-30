package management.system.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import management.system.app.dto.company.AirCompanyDto;
import management.system.app.dto.company.AirCompanyRequestDto;
import management.system.app.exception.EntityNotFoundException;
import management.system.app.mapper.AirCompanyMapper;
import management.system.app.model.AirCompany;
import management.system.app.repository.AirCompanyRepository;
import management.system.app.service.AirCompanyService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirCompanyServiceImpl implements AirCompanyService {
    private final AirCompanyMapper airCompanyMapper;
    private final AirCompanyRepository airCompanyRepository;

    @Override
    public AirCompanyDto save(AirCompanyRequestDto requestDto) {
        AirCompany airCompany = airCompanyMapper.toModel(requestDto);
        return airCompanyMapper.toDto(airCompanyRepository.save(airCompany));
    }

    @Override
    public List<AirCompanyDto> findAll(Pageable pageable) {
        return airCompanyRepository.findAll(pageable)
                .stream()
                .map(airCompanyMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AirCompanyDto findById(Long id) {
        AirCompany airCompany = airCompanyRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find company by ID: " + id));
        return airCompanyMapper.toDto(airCompany);
    }

    @Override
    public AirCompanyDto findByName(String name) {
        AirCompany airCompany = airCompanyRepository.findByName(name);
        return airCompanyMapper.toDto(airCompany);
    }

    @Override
    public AirCompanyDto updateById(Long id, AirCompanyRequestDto requestDto) {
        AirCompany companyToUpdate = airCompanyMapper.toModel(requestDto);
        companyToUpdate.setId(id);
        AirCompany updatedCompany = airCompanyRepository.save(companyToUpdate);
        return airCompanyMapper.toDto(updatedCompany);
    }

    @Override
    public void deleteById(Long id) {
        airCompanyRepository.deleteById(id);
    }
}
