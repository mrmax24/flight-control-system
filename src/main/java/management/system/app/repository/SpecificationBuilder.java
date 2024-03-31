package management.system.app.repository;

import management.system.app.dto.flight.FlightSearchParametersDto;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<T> {
    Specification<T> build(FlightSearchParametersDto searchParameters);
}
