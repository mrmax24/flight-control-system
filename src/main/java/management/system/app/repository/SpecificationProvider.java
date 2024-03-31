package management.system.app.repository;

import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public interface SpecificationProvider<T> {
    String getKey();

    Specification<T> getSpecification(List<Object> params);
}
