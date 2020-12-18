
package com.isalnikov.offsidegaming.service;

import com.isalnikov.offsidegaming.model.Client;
import com.isalnikov.offsidegaming.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 *
 * @author isalnikov
 */
@Service
@Transactional(readOnly = true)
public class ClientServiceImpl  implements ClientService {

    
    protected final ClientRepository repository;

    @Autowired
    public ClientServiceImpl(ClientRepository repository) {
        Assert.notNull(repository, "Repository must be not null");
        this.repository = repository;
    }

    @Override
    public Optional<Client> findById(Long id) {
        return repository.findById(id); 
    }

    @Override
    @Transactional
    public Client save(Client client) {
        return repository.saveAndFlush(client);
    }

    @Override
    public Client findAllDataByClientId(Long Id) {
        return repository.findAllDataByClientId(Id);
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }






    
    
    
}
