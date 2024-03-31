package management.system.app.dto.flight;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import management.system.app.model.enums.FlightStatus;

@Getter
@Setter
public class FlightRequestDto {
    @NotNull
    private FlightStatus flightStatus;
    @NotNull
    private Long airCompanyId;
    @NotNull
    private Long airplaneId;
    @NotBlank
    private String departureCountry;
    @NotBlank
    private String destinationCountry;
    @Positive
    private double distance;
    @Positive
    private int estimatedFlightTime;
    private LocalDate startedAt;
    private LocalDate endedAt;
    private LocalDate delayStartedAt;
    private LocalDate createdAt;

}
