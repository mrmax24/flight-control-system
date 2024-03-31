package management.system.app.repository.specification;

import java.util.List;
import management.system.app.model.Flight;
import management.system.app.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class StartedTimeSpecificationProvider implements SpecificationProvider<Flight> {
    private static final String START_TIME_KEY = "startedAt";

    @Override
    public String getKey() {
        return START_TIME_KEY;
    }

    @Override
    public Specification<Flight> getSpecification(List<Object> params) {
        return (root, query, criteriaBuilder) -> root.get(START_TIME_KEY)
                .in(params);
    }
}
