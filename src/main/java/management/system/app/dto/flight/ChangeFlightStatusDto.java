package management.system.app.dto.flight;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import management.system.app.model.enums.FlightStatus;

@Getter
@Setter
public class ChangeFlightStatusDto {
    @NotNull
    private FlightStatus flightStatus;
}
