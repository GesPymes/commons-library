package com.gespyme.commons.repository;

import com.gespyme.commons.repository.criteria.SearchCriteria;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.DatePath;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Component
public class PredicateBuilder<T> {
  public BooleanExpression getBooleanBuilder(
      SimpleExpression<T> path, SearchCriteria searchCriteria) {
    switch (searchCriteria.getOperation()) {
      case EQUAL:
        return path.eq((T) searchCriteria.getValue());
      case LIKE:
        return ((StringPath) path).contains((String) searchCriteria.getValue());
      case IN:
        return path.in((Collection<T>) searchCriteria.getValue());
      case BEFORE:
        return ((DatePath<LocalDateTime>) path).before((LocalDateTime) searchCriteria.getValue());
      case AFTER:
        return ((DatePath<LocalDateTime>) path).after((LocalDateTime) searchCriteria.getValue());
    }
    return null;
  }
}
