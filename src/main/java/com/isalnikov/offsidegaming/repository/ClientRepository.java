package com.isalnikov.offsidegaming.repository;

import com.isalnikov.offsidegaming.model.Client;
import com.isalnikov.offsidegaming.model.DeviceData;
import java.util.List;
import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author isalnikov
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    /**
     * получить все исторические данные для данного пользователя
     *
     * @param id
     * @return
     */
    @Query("select c from Client c join fetch c.values where c.id=:id")
    public Client findAllDataByClientId(@Param("id") Long id);

    /**
     * получаем исключительную блокировку для того чтобы произвести добавление
     * новых данных (тест)
     *
     * @param id
     * @return
     */
  
    @Lock(LockModeType.PESSIMISTIC_READ)
    @QueryHints({
        @QueryHint(name = "javax.persistence.lock.timeout", value = "300")})
    @Query("select c from Client c where c.id=:id")
    public Client getClient(Long id);

    /**
     * Находим последнии показания максимально эффективным подзапосом для данной
     * объектной модели
     *
     * @param clientId
     * @return
     */
    @Query(value = "Select dd.gas_value,dd.cold_water_value,dd.hot_water_value from device_data dd where id = (Select max(d.id) from device_data d where d.client_Id=:clientId)", nativeQuery = true)
    Object findLastDataByClientId(@Param("clientId") Long clientId);

    /**
     * It's very fast because does not need load the collection.
     *
     * @param clientId
     * @param gasValue
     * @param coldWaterValue
     * @param hotWaterValue
     */
    @Modifying
    @Transactional(propagation = Propagation.MANDATORY)
    @Query(nativeQuery = true, value = "INSERT INTO device_data (client_id, gas_value,cold_water_value,hot_water_value) VALUES (?1, ?2 , ?3 , ?4)")
    public void addData(long clientId, long gasValue, long coldWaterValue, long hotWaterValue);

}
