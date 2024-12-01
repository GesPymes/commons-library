package com.gespyme.commons.model.invoice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gespyme.commons.exeptions.BadRequestException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class InvoiceOrderFilterModelApi extends InvoiceOrderBaseModelApi {

  public InvoiceOrderFilterModelApi(InvoiceStatus status) {
    super(status);
  }

  @Override
  public Map<String, Object> allParamsMap() {
    Map<String, Object> params = new HashMap<>();
    params.put("status", this.getStatus());
    return params;
  }

  @Override
  public Map<String, Object> selectedParamsMap() {
    return allParamsMap().entrySet().stream()
        .filter(entry -> Objects.nonNull(entry.getValue()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  @Override
  public String getId() {
    throw new BadRequestException("Cannot filter by id from this endpoint");
  }
}
