package com.gespyme.commons.validator;

import com.gespyme.commons.exeptions.BadRequestException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

public class StartDateBeforeEndDateValidator<T extends Validable> implements FieldsValidator<T> {

  @Override
  public Validator getEnumValue() {
    return Validator.START_DATE_BEFORE;
  }

  @Override
  public void isValid(T entity) {
    Optional<LocalDateTime> startDate = Optional.empty();
    Optional<LocalDateTime> endDate = Optional.empty();

    for (Map.Entry<String, Object> entry : entity.allParamsMap().entrySet()) {
      if (entry.getKey().contains("startDate")) {
        startDate = Optional.of((LocalDateTime) entry.getValue());
      }
      if (entry.getKey().contains("endDate")) {
        endDate = Optional.of((LocalDateTime) entry.getValue());
      }
    }
    if (startDate.isPresent() && endDate.isPresent() && !startDate.get().isBefore(endDate.get())) {
      throw new BadRequestException("Startdate must be before endDate");
    }
  }
}
