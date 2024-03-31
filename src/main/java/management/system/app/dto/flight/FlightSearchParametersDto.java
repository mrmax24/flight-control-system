package management.system.app.dto.flight;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import management.system.app.model.enums.FlightStatus;

@Getter
@Setter
public class FlightSearchParametersDto {
    private List<FlightStatus> statuses;
    private String[] dates;
}
