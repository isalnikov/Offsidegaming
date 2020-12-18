
package com.isalnikov.offsidegaming.repository;

import com.isalnikov.offsidegaming.model.Client;
import com.isalnikov.offsidegaming.model.DeviceData;
import javax.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author isalnikov
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    /**
     * получить все исторические данные для данного пользователя 
     * @param id
     * @return 
     */
    @Query("select c from Client c join fetch c.values where c.id=:id")
    public Client findAllDataByClientId(@Param("id")Long id);
    
    
    
     @Lock(LockModeType.READ)
     @Query("select c from Client c where c.id=:id")
     public Client getClient(Long id);
     
     
     @Query(value = "Select * from device_data where id = (Select max(id) from device_data d where d.client_Id=:clientId)", nativeQuery = true)
     DeviceData findLastDataByClientId(@Param("clientId")Long clientId);
    
    
    
    
}
