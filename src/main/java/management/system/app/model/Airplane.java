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
import management.system.app.model.enums.AirplaneType;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@Table(name = "airplanes")
@SQLDelete(sql = "UPDATE airplanes SET is_deleted = TRUE WHERE id = ?")
@Where(clause = "is_deleted = FALSE")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String factorySerialNumber;

    @Column(nullable = false)
    private Long airCompanyId;

    @Column(nullable = false)
    private int numberOfFlights;

    @Column(nullable = false)
    private double flightDistance;

    @Column(nullable = false)
    private double fuelCapacity;

    @Enumerated(EnumType.STRING)
    private AirplaneType type;

    @Column(nullable = false)
    private LocalDate createdAt;

    @Column(nullable = false)
    private boolean isDeleted = false;
}
