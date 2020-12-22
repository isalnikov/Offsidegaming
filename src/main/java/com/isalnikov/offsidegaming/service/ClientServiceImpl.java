package com.isalnikov.offsidegaming.service;

import com.isalnikov.offsidegaming.model.Client;
import com.isalnikov.offsidegaming.model.DeviceData;
import com.isalnikov.offsidegaming.repository.ClientRepository;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.persistence.LockModeType;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
@Log4j2
@Service
@Transactional(readOnly = true, timeout = 1000)
public class ClientServiceImpl implements ClientService {

    protected final ClientRepository repository;

    @Autowired
    public ClientServiceImpl(ClientRepository repository) {
        Assert.notNull(repository, "Repository must be not null");
        this.repository = repository;
    }

    @Override
    @Modifying
    @CacheEvict(cacheNames = "client")
    @Transactional(propagation = Propagation.REQUIRES_NEW, timeout = 500)
    @Lock(LockModeType.PESSIMISTIC_READ)
    public int addNewData(Long client_id, DeviceData data) {
       Client client =  repository.getClient(client_id);
       int result = 0;
       if(client != null){
           //TODO Взять последнюю запись и сравнить ее с текщими, если все больше - добавить новую запись .
             
              DeviceData max = findLastDataByClientId(client_id);
            
            if(max != null){
              if(data.compareTo(max) > 0){
                  repository.addData(client_id, data.getGasValue(), data.getHotWaterValue(), data.getColdWaterValue());
                  result = 1;
              }
            }
            
           
       }
        
        return result;
    }

    @Override
    @Cacheable(cacheNames = "client")
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

    @Override
    public DeviceData findLastDataByClientId(Long clientId) {
        Object[] list =(Object[]) repository.findLastDataByClientId(clientId);
       return new DeviceData((long) ((BigInteger)list[0]).intValue() ,(long) ((BigInteger)list[1]).intValue(),(long) ((BigInteger)list[2]).intValue());
    }

 

}
