package com.isalnikov.offsidegaming.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

/**
 *
 * @author isalnikov
 */
@Service(value = "auditorAwareImpl")
public class AuditorAwareImpl implements AuditorAware<String> {

    private final ClientService clientService;

    @Autowired
    public AuditorAwareImpl(final ClientService clientService) {

        this.clientService = clientService;
    }

    @Override
    public Optional<String> getCurrentAuditor() {

        return Optional.empty();

    }

}
