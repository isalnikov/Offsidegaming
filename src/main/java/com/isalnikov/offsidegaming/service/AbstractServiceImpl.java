
package com.isalnikov.offsidegaming.service;

import com.isalnikov.offsidegaming.repository.AbstractRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;


/**
 *
 * @author isalnikov
 */
public abstract class AbstractServiceImpl<T, I extends Serializable> implements AbstractService<T, I> {

    private final AbstractRepository<T, I> repository;

    AbstractServiceImpl(AbstractRepository<T, I> repository) {

        this.repository = repository;
    }

    @Override
    public long count() {

        return repository.count();
    }

    @Override
    public long count(Specification<T> s) {

        return repository.count(s);
    }

    @Override
    public void delete(T t) {

        repository.delete(t);
    }

    @Override
    public void deleteInBatch(Iterable<T> itrbl) {

        repository.deleteInBatch(itrbl);
    }

    @Override
    public Optional<T> findOne(I id) {

        return repository.findById(id);
    }

    @Override
    public Page<T> findAll(Specification<T> s, Pageable pgbl) {

        return repository.findAll(s, pgbl);
    }

    @Override
    public List<T> findAll(Specification<T> s, Sort sort) {

        return repository.findAll(s, sort);
    }

    @Override
    public List<T> findAll() {

        return repository.findAll();
    }

    @Override
    public void flush() {

        repository.flush();
    }

    @Override
    public <S extends T> S save(S s) {

        return repository.save(s);
    }

    @Override
    public <S extends T> S update(S s) {

        return repository.save(s);
    }

    @Override
    public <S extends T> S saveAndFlush(S s) {

        return repository.saveAndFlush(s);
    }

    @Override
    public <S extends T> List<S> save(Iterable<S> itrbl) {

        return repository.saveAll(itrbl);
    }

    @Override
    public Page<T> findAll(Pageable pgbl) {

        return repository.findAll(pgbl);
    }


}

