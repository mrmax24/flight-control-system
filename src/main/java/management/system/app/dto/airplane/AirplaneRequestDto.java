package management.system.app.dto.airplane;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import management.system.app.model.enums.AirplaneType;

@Getter
@Setter
public class AirplaneRequestDto {
    private String name;
    private String factorySerialNumber;
    private Long airCompanyId;
    private int numberOfFlights;
    private double flightDistance;
    private double fuelCapacity;
    private AirplaneType type;
    private LocalDate createdAt;
}
