
package com.isalnikov.offsidegaming.repository;

import com.isalnikov.offsidegaming.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author isalnikov
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
