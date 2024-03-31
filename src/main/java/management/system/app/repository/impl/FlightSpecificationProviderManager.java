package management.system.app.repository.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import management.system.app.exception.SpecificationNotFoundException;
import management.system.app.model.Flight;
import management.system.app.repository.SpecificationProvider;
import management.system.app.repository.SpecificationProviderManager;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FlightSpecificationProviderManager implements SpecificationProviderManager<Flight> {
    private final List<SpecificationProvider<Flight>> flightSpecificationProviders;

    @Override
    public SpecificationProvider<Flight> getSpecificationProvider(String key) {
        return flightSpecificationProviders.stream()
                .filter(p -> p.getKey().equals(key))
                .findFirst()
                .orElseThrow(() -> new SpecificationNotFoundException("Can't find "
                        + "correct specification provider for key " + key));
    }
}
