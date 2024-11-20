package com.gespyme.commons.repository;

import com.gespyme.commons.repository.criteria.SearchCriteria;
import com.querydsl.core.BooleanBuilder;

public interface QueryField {

    String getFieldName();
    void addToQuery(BooleanBuilder booleanBuilder, SearchCriteria searchCriteria);
}
