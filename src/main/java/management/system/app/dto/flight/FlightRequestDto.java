package management.system.app.dto.flight;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import management.system.app.model.enums.FlightStatus;

@Getter
@Setter
public class FlightRequestDto {
    private FlightStatus flightStatus;
    private Long airCompanyId;
    private Long airplaneId;
    private String departureCountry;
    private String destinationCountry;
    private double distance;
    private int estimatedFlightTime;
    private LocalDate startedAt;
    private LocalDate endedAt;
    private LocalDate delayStartedAt;
    private LocalDate createdAt;

}
