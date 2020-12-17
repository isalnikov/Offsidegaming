package com.isalnikov.offsidegaming.service;

import com.isalnikov.offsidegaming.model.Client;
import java.util.List;

/**
 *
 * @author isalnikov
 */
public interface ClientService extends AbstractService<Client, Long> {

    @Override
    List<Client> findAll();

  

}
