package io.classiccrew.user_service.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl") // This is the name of the bean that will be used in the configuration
public class AuditAwareImpl implements AuditorAware<String> {

    /**
     * Returns the current auditor of the application.
     *
     * @return the current auditor.
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        // Hardcoded for now. Until Spring security implemented.
        return Optional.of("USER-SERVICE");
    }

}
