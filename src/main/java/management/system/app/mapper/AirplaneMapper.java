package management.system.app.mapper;

import management.system.app.config.MapperConfig;
import management.system.app.dto.AirplaneDto;
import management.system.app.dto.AirplaneRequestDto;
import management.system.app.model.Airplane;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface AirplaneMapper {
    Airplane toModel(AirplaneRequestDto requestDto);

    AirplaneDto toDto(Airplane airplane);
}
