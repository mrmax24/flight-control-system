package management.system.app.mapper;

import management.system.app.config.MapperConfig;
import management.system.app.dto.flight.ChangeFlightStatusDto;
import management.system.app.dto.flight.FlightDto;
import management.system.app.dto.flight.FlightRequestDto;
import management.system.app.model.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface FlightMapper {
    @Mapping(target = "airCompany.id", source = "airCompanyId")
    @Mapping(target = "airplane.id", source = "airplaneId")
    Flight toModel(FlightRequestDto requestDto);

    @Mapping(target = "airCompanyId", source = "airCompany.id")
    @Mapping(target = "airplaneId", source = "airplane.id")
    FlightDto toDto(Flight flight);

    Flight toModelAfterChangingStatus(ChangeFlightStatusDto requestDto);

    ChangeFlightStatusDto toDtoAfterChangingStatus(Flight flight);
}
