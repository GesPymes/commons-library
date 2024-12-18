package com.gespyme.commons.validator;

import com.gespyme.commons.exeptions.BadRequestException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class ParamsValidator {
  protected void validateNotNullParams(Map<String, Object> params) throws BadRequestException {
    List<String> errors = new ArrayList<>();
    params.entrySet().stream()
        .filter(this::validateParam)
        .forEach(errorParam -> errors.add(errorParam.getKey()));
    if (!errors.isEmpty()) {
      if (errors.size() == 1) {
        throw new BadRequestException("Param " + errors.get(0) + " cannot be null");
      }
      throw new BadRequestException("Params: " + errors + " cannot be null");
    }
  }

  private boolean validateParam(Map.Entry<String, Object> param) throws BadRequestException {
    if (param.getValue() instanceof String) {
      return ((String) param.getValue()).isBlank();
    }
    return Objects.isNull(param.getValue());
  }
}
