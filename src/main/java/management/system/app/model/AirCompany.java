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
import lombok.Getter;
import lombok.Setter;
import management.system.app.model.enums.CompanyType;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@Table(name = "air_companies")
@SQLDelete(sql = "UPDATE air_companies SET is_deleted = true WHERE id = ?")
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
