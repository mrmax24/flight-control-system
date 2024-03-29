package management.system.app.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import management.system.app.model.enums.CompanyType;

@Getter
@Setter
public class AirCompanyRequestDto {
    private String name;
    private CompanyType companyType;
    private LocalDate foundedAt;
}
