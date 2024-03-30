package management.system.app.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import management.system.app.model.enums.FlightStatus;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@Table(name = "flights")
@SQLDelete(sql = "UPDATE flights SET is_deleted = TRUE WHERE id = ?")
@Where(clause = "is_deleted = false")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FlightStatus flightStatus;

    @Column(nullable = false)
    private Long airCompanyId;

    @Column(nullable = false)
    private Long airplaneId;

    @Column(nullable = false)
    private String departureCountry;

    @Column(nullable = false)
    private String destinationCountry;

    @Column(nullable = false)
    private double distance;

    @Column(nullable = false)
    private int estimatedFlightTime;

    @Column(nullable = false)
    private LocalDate startedAt;

    @Column(nullable = false)
    private LocalDate endedAt;

    @Column(nullable = false)
    private LocalDate delayStartedAt;

    @Column(nullable = false)
    private LocalDate createdAt;

    @Column(nullable = false)
    private boolean isDeleted = false;
}
