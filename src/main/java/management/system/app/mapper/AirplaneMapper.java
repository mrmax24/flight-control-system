package management.system.app.mapper;

import management.system.app.config.MapperConfig;
import management.system.app.dto.airplane.AirplaneDto;
import management.system.app.dto.airplane.AirplaneRequestDto;
import management.system.app.model.Airplane;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface AirplaneMapper {
    Airplane toModel(AirplaneRequestDto requestDto);

    AirplaneDto toDto(Airplane airplane);
}
