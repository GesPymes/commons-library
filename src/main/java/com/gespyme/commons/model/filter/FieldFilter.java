package com.gespyme.commons.model.filter;

import com.gespyme.commons.repository.criteria.SearchCriteria;
import java.util.List;

public interface FieldFilter<T> {

  boolean apply(T filter);

  void addSearchCriteria(T invoiceFilter, List<SearchCriteria> searchCriteriaList);
}
