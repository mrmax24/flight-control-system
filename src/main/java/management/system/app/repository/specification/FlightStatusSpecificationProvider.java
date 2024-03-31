package management.system.app.repository.specification;

import java.util.List;
import management.system.app.model.Flight;
import management.system.app.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class FlightStatusSpecificationProvider implements SpecificationProvider<Flight> {
    private static final String STATUS_KEY = "flightStatus";

    @Override
    public String getKey() {
        return STATUS_KEY;
    }

    @Override
    public Specification<Flight> getSpecification(List<Object> params) {
        return (root, query, criteriaBuilder) -> root.get(STATUS_KEY)
                .in(params);
    }
}
