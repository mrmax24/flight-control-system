package management.system.app.mapper;

import management.system.app.config.MapperConfig;
import management.system.app.dto.airplane.AirplaneDto;
import management.system.app.dto.airplane.AirplaneRequestDto;
import management.system.app.model.Airplane;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface AirplaneMapper {
    @Mapping(target = "airCompany.id", source = "airCompanyId")
    Airplane toModel(AirplaneRequestDto requestDto);

    @Mapping(target = "airCompanyId", source = "airCompany.id")
    AirplaneDto toDto(Airplane airplane);
}
