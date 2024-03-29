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
import management.system.app.model.enums.CompanyType;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@Table(name = "air_companies")
@SQLDelete(sql = "UPDATE air_companies SET is_deleted = TRUE WHERE id = ?")
@Where(clause = "is_deleted = false")
public class AirCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private CompanyType companyType;

    @Column(nullable = false)
    private LocalDate foundedAt;

    @Column(nullable = false)
    private boolean isDeleted = false;
}