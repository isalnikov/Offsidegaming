
package com.isalnikov.offsidegaming.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;


/**
 *
 * @author isalnikov
 */
@NoRepositoryBean
public interface AbstractRepository <T, I extends Serializable> extends JpaRepository<T, I>, JpaSpecificationExecutor<T> {}
    

