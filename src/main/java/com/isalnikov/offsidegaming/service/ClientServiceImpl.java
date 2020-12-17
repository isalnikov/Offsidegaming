
package com.isalnikov.offsidegaming.service;

import com.isalnikov.offsidegaming.model.Client;
import com.isalnikov.offsidegaming.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 *
 * @author isalnikov
 */
@Service
@Transactional
public class ClientServiceImpl  extends AbstractServiceImpl<Client, Long> implements ClientService {

    
    protected final ClientRepository repository;

    @Autowired
    public ClientServiceImpl(ClientRepository repository) {

        super(repository);
        Assert.notNull(repository, "Repository must be not null");
        this.repository = repository;
    }

    
}
