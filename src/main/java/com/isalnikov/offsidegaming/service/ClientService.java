package com.isalnikov.offsidegaming.service;

import com.isalnikov.offsidegaming.model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;


/**
 *
 * @author isalnikov
 */
public interface ClientService  {

    String CACHE_CLIENT_DATA = "CACHE_CLIENT_DATA";


    //@Cacheable("client")
    public Optional<Client> findById(Long id);


  //@CacheEvict(value="client", key = client.id)
    public Client save(Client client);

    
     public List<Client> findAll();
    
     public Client findAllDataByClientId(Long Id);

}
