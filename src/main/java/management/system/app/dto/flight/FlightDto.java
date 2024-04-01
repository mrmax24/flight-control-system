package management.system.app.dto.flight;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import management.system.app.model.enums.FlightStatus;

@Getter
@Setter
public class FlightDto {
    private Long id;
    private FlightStatus flightStatus;
    private Long airCompanyId;
    private Long airplaneId;
    private String departureCountry;
    private String destinationCountry;
    private double distance;
    private int estimatedFlightTime;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private LocalDateTime delayStartedAt;
    private LocalDateTime createdAt;
}
