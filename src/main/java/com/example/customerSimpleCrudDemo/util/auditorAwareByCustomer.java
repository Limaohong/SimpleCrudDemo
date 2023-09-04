package com.example.customerSimpleCrudDemo.util;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditorAwareByCustomer")
public class auditorAwareByCustomer implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("System");
    }
}
