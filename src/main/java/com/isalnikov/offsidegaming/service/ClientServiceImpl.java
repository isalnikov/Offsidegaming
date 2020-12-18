package com.isalnikov.offsidegaming.service;

import com.isalnikov.offsidegaming.model.Client;
import com.isalnikov.offsidegaming.model.DeviceData;
import com.isalnikov.offsidegaming.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.LockModeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 *
 * @author isalnikov
 */
@Service
@Transactional(readOnly = true, timeout = 5)
public class ClientServiceImpl implements ClientService {

    protected final ClientRepository repository;

    @Autowired
    public ClientServiceImpl(ClientRepository repository) {
        Assert.notNull(repository, "Repository must be not null");
        this.repository = repository;
    }

    @Override
    @Modifying
    @Transactional(propagation = Propagation.REQUIRES_NEW, timeout = 1)
    @Lock(LockModeType.READ)
    public Client addNewData(Long client_id, DeviceData data) {
       Client client =  repository.getClient(client_id);
       if(client != null){
           //TODO Взять последнюю запись и сравнить ее с текщими, если все больше - добавить новую запись .
            DeviceData maxData = null;
            //maxData =  repository.findLastDataByClientId(client_id)
            
            if(maxData != null){
              if(data.compareTo(maxData) > 1){
                  client.addValue(data);
              }
            }
            
           repository.saveAndFlush(client);
       }
        
        return client;
    }

    @Override
    public Client findAllDataByClientId(Long Id) {
        return repository.findAllDataByClientId(Id);
    }

    //
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
    public List<Client> findAll() {
        return repository.findAll();
    }

 

}
