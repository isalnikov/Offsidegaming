
package com.isalnikov.offsidegaming.config;

/**
 *
 * @author isalnikov
 */
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@EntityScan(basePackageClasses =  {com.isalnikov.offsidegaming. model.AbstractAuditEntity.class})
@ComponentScan(basePackageClasses = { com.isalnikov.offsidegaming.service.AbstractService.class})
@EnableJpaRepositories(basePackageClasses = {com.isalnikov.offsidegaming.repository.AbstractRepository.class})
public class PersistenceConfig {}
