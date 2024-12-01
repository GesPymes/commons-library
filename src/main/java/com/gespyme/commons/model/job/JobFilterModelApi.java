package com.gespyme.commons.model.job;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gespyme.commons.exeptions.BadRequestException;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@NoArgsConstructor
public class JobFilterModelApi extends JobBaseModelApi {

  @JsonProperty("employeeName")
  private String employeeName;

  @JsonProperty("customerName")
  private String customerName;

  public JobFilterModelApi(
      String calendarId,
      String customerId,
      String employeeId,
      Integer periodicity,
      Boolean isPeriodic,
      String description,
      String employeeName,
      String customerName) {
    super(calendarId, customerId, employeeId, periodicity, isPeriodic, description);
    this.employeeName = employeeName;
    this.customerName = customerName;
  }

  @Override
  public Map<String, Object> allParamsMap() {
    Map<String, Object> params = new HashMap<>();
    params.put("employeeName", this.employeeName);
    params.put("periodicity", this.getPeriodicity());
    params.put("isPeriodic", this.getIsPeriodic());
    params.put("customerName", this.customerName);
    params.put("description", this.getDescription());
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
    throw new BadRequestException("Cannot filter by appointment id from this endpoint");
  }
}
