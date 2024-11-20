package com.gespyme.commons.model.job;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gespyme.commons.validator.Validable;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public abstract class AppointmentBaseModelApi implements Validable {
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String employeeName;
    private Integer periodicity;
    private Boolean isPeriodic;
    private String customerName;


    @Override
    public Map<String, Object> allParamsMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("status", this.status);
        params.put("startDate", this.startDate);
        params.put("endDate", this.endDate);
        params.put("employeeName", this.employeeName);
        params.put("periodicity", this.periodicity);
        params.put("isPeriodic", this.isPeriodic);
        params.put("customerName", this.customerName);
        return params;
    }

    @Override
    public Map<String, Object> selectedParamsMap() {
        return allParamsMap().entrySet().stream().filter(entry -> Objects.nonNull(entry.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
