package com.gespyme.commons.model.job;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gespyme.commons.exeptions.BadRequestException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@NoArgsConstructor
@SuperBuilder
public class AppointmentFilterModelApi extends AppointmentBaseModelApi {
  public AppointmentFilterModelApi(
      AppointmentStatus status, LocalDateTime startDate, LocalDateTime endDate, String jobId) {
    super(status, startDate, endDate, jobId);
  }

  @Override
  public Map<String, Object> allParamsMap() {
    Map<String, Object> params = new HashMap<>();
    params.put("status", this.getStatus());
    params.put("startDate", this.getStartDate());
    params.put("endDate", this.getEndDate());
    params.put("jobId", this.getJobId());
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
