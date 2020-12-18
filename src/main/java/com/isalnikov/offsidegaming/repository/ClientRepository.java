
package com.isalnikov.offsidegaming.repository;

import com.isalnikov.offsidegaming.model.Client;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author isalnikov
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    
    @Query("select c from Client c join fetch c.values where c.id=:id")
    public Client findAllDataByClientId(@Param("id")Long id);
}
