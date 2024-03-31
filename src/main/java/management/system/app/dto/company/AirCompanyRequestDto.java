package management.system.app.dto.company;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import management.system.app.model.enums.CompanyType;

@Getter
@Setter
public class AirCompanyRequestDto {
    @NotBlank
    private String name;
    @NotNull
    private CompanyType companyType;
    private LocalDate foundedAt;
}
