package com.gespyme.commons.repository;

import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepository<T> {
  Optional<T> findById(String id);

  void deleteById(String id);

  T save(T entity);

  T merge(T newEntity, T entity);
}
