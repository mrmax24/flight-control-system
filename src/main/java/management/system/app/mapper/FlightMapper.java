package management.system.app.mapper;

import management.system.app.config.MapperConfig;
import management.system.app.dto.flight.FlightDto;
import management.system.app.dto.flight.FlightRequestDto;
import management.system.app.model.Flight;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface FlightMapper {
    Flight toModel(FlightRequestDto requestDto);

    FlightDto toDto(Flight flight);
}
