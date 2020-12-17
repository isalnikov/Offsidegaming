
package com.isalnikov.offsidegaming.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author isalnikov
 */
public interface AbstractService<T, ID> {
    long count();

    long count(Specification<T> s);

    void delete(T t);

    void deleteInBatch(Iterable<T> itrbl);

    Optional<T> findOne(ID id);

    Page<T> findAll(Specification<T> s, Pageable pgbl);

    List<T> findAll(Specification<T> s, Sort sort);

    Page<T> findAll(Pageable pgbl);

    List<T> findAll();

    void flush();

    <S extends T> S save(S s);

    <S extends T> S update(S s);

    <S extends T> S saveAndFlush(S s);

    <S extends T> List<S> save(Iterable<S> itrbl);

}
