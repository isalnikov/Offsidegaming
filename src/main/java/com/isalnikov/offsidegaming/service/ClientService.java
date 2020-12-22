package com.isalnikov.offsidegaming.service;

import com.isalnikov.offsidegaming.model.Client;
import com.isalnikov.offsidegaming.model.DeviceData;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author isalnikov
 */
public interface ClientService {

    String CACHE_CLIENT_DATA = "CACHE_CLIENT_DATA";

 
    public Optional<Client> findById(Long id);
 
    public Client save(Client client);

    public List<Client> findAll();

    public Client findAllDataByClientId(Long Id);

    public int addNewData(final Long client_id, final DeviceData data);

    public DeviceData findLastDataByClientId(@Param("clientId") Long clientId);

}
