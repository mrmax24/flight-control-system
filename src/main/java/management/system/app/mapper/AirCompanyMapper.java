package management.system.app.mapper;

import management.system.app.config.MapperConfig;
import management.system.app.dto.company.AirCompanyDto;
import management.system.app.dto.company.AirCompanyRequestDto;
import management.system.app.model.AirCompany;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface AirCompanyMapper {
    AirCompany toModel(AirCompanyRequestDto requestDto);

    AirCompanyDto toDto(AirCompany airCompany);
}
