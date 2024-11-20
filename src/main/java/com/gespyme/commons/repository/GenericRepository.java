package com.gespyme.commons.repository;

import com.gespyme.commons.repository.criteria.SearchCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenericRepository<T> {
    Optional<T> findById(String id);
    void deleteById(String id);
    T save(T entity);
    T merge(T newEntity, T entity);
}
