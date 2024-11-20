package com.gespyme.commons.model.job;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gespyme.commons.validator.Validable;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public abstract class CalendarBaseModelApi implements Validable {
    private String calendarName;

    @Override
    public Map<String, Object> allParamsMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("calendarName", this.calendarName);
        return params;
    }

    @Override
    public Map<String, Object> selectedParamsMap() {
        return allParamsMap().entrySet().stream().filter(entry -> Objects.nonNull(entry.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
