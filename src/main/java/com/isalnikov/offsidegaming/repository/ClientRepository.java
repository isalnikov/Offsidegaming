
package com.isalnikov.offsidegaming.repository;

import com.isalnikov.offsidegaming.model.Client;
import com.isalnikov.offsidegaming.model.DeviceData;
import java.util.List;
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
     
     
     @Query(value = "Select dd.gas_value,dd.cold_water_value,dd.hot_water_value from device_data dd where id = (Select max(d.id) from device_data d where d.client_Id=:clientId)" , nativeQuery = true )
     //@Query(value = "Select new com.isalnikov.offsidegaming.model.DeviceData(dd.gasValue,dd.coldWaterValue,dd.hotWaterValue) from DeviceData dd where id = (Select max(d.id) from DeviceData d where d.client.id=:clientId)")
     Object findLastDataByClientId(@Param("clientId")Long clientId);
     
    
    
    
    
    
}
