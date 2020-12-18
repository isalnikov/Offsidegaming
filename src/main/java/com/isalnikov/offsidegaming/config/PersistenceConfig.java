
package com.isalnikov.offsidegaming.config;

/**
 *
 * @author isalnikov
 */
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackageClasses =  {
    com.isalnikov.offsidegaming. model.Client.class,
    com.isalnikov.offsidegaming. model.DeviceData.class
})
@ComponentScan(basePackageClasses = {
    com.isalnikov.offsidegaming.service.ClientService.class,
})
@EnableJpaRepositories(basePackageClasses = {
    com.isalnikov.offsidegaming.repository.ClientRepository.class
})
public class PersistenceConfig {}
