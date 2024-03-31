package management.system.app.repository.impl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import management.system.app.dto.flight.FlightSearchParametersDto;
import management.system.app.model.Flight;
import management.system.app.repository.SpecificationBuilder;
import management.system.app.repository.specification.FlightStatusSpecificationProvider;
import management.system.app.repository.specification.StartedTimeSpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FlightSpecificationBuilder implements SpecificationBuilder<Flight> {
    private final FlightSpecificationProviderManager flightSpecificationProviderManager;
    private final FlightStatusSpecificationProvider flightStatusSpecificationProvider;
    private final StartedTimeSpecificationProvider startedTimeSpecificationProvider;

    @Override
    public Specification<Flight> build(FlightSearchParametersDto searchParameters) {
        Specification<Flight> specification = Specification.where(null);
        if (searchParameters.getStatuses() != null && !searchParameters.getStatuses().isEmpty()) {

            specification = specification.and(flightSpecificationProviderManager
                    .getSpecificationProvider(flightStatusSpecificationProvider.getKey())
                    .getSpecification(Collections.singletonList(searchParameters.getStatuses())));
        }

        if (searchParameters.getDates() != null && searchParameters.getDates().length > 0) {
            List<LocalDate> dateList = Arrays.stream(searchParameters.getDates())
                    .map(LocalDate::parse)
                    .collect(Collectors.toList());

            specification = specification.and(flightSpecificationProviderManager
                    .getSpecificationProvider(startedTimeSpecificationProvider.getKey())
                    .getSpecification(Collections.singletonList(dateList)));
        }

        return specification;
    }
}
