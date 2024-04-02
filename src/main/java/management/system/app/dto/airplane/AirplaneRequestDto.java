package management.system.app.dto.airplane;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import management.system.app.model.enums.AirplaneType;

@Getter
@Setter
public class AirplaneRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String factorySerialNumber;
    private Long airCompanyId;
    @PositiveOrZero
    private int numberOfFlights;
    @Positive
    private double flightDistance;
    @Positive
    private double fuelCapacity;
    @NotNull
    private AirplaneType type;
    @NotNull
    private LocalDate createdAt;
}
