package management.system.app.repository.impl;

import java.util.Collections;
import lombok.RequiredArgsConstructor;
import management.system.app.dto.flight.FlightSearchParametersDto;
import management.system.app.model.Flight;
import management.system.app.repository.SpecificationBuilder;
import management.system.app.repository.specification.FlightStatusSpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FlightSpecificationBuilder implements SpecificationBuilder<Flight> {
    private final FlightSpecificationProviderManager flightSpecificationProviderManager;
    private final FlightStatusSpecificationProvider flightStatusSpecificationProvider;

    @Override
    public Specification<Flight> build(FlightSearchParametersDto searchParameters) {
        Specification<Flight> specification = Specification.where(null);
        if (searchParameters.getStatuses() != null && !searchParameters.getStatuses().isEmpty()) {

            specification = specification.and(flightSpecificationProviderManager
                    .getSpecificationProvider(flightStatusSpecificationProvider.getKey())
                    .getSpecification(Collections.singletonList(searchParameters.getStatuses())));
        }
        return specification;
    }
}
