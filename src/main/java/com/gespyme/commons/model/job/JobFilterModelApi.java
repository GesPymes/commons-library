package com.gespyme.commons.model.job;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gespyme.commons.exeptions.BadRequestException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@NoArgsConstructor
@SuperBuilder
public class JobFilterModelApi extends JobBaseModelApi {
  String startDate;
  String endDate;

  public JobFilterModelApi(
      String calendarId,
      String customerId,
      String customerName,
      String customerLastName,
      String employeeName,
      String employeeLastName,
      String employeeId,
      Integer periodicity,
      Boolean periodic,
      String description,
      String startDate,
      String endDate) {
    super(
        calendarId,
        customerId,
        customerName,
        customerLastName,
        employeeName,
        employeeLastName,
        employeeId,
        periodicity,
        periodic,
        description);
    this.startDate = startDate;
    this.endDate = endDate;
  }

  @Override
  public Map<String, Object> allParamsMap() {
    Map<String, Object> params = new HashMap<>();
    params.put("periodicity", this.getPeriodicity());
    params.put("periodic", this.getPeriodic());
    params.put("description", this.getDescription());
    params.put("startDate", this.getStartDate());
    params.put("endDate", this.getEndDate());
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
