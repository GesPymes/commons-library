package com.gespyme.commons.model.user;

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
public class UserModelApi implements Validable {
    private String userId;
    private String email;
    private String password;
    private String role;
    private LocalDateTime lastTimeLoggedIn;
    private LocalDateTime creationDate;
    private LocalDateTime lastModificationDate;

    @Override
    public Map<String, Object> allParamsMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("role", this.role);
        params.put("password", this.password);
        params.put("email", this.email);
        params.put("lastTimeLoggedIn", this.lastTimeLoggedIn);
        params.put("creationDate", this.creationDate);
        params.put("lastModificationDate", this.lastModificationDate);
        return params;
    }

    @Override
    public Map<String, Object> selectedParamsMap() {
        return allParamsMap().entrySet().stream().filter(entry -> Objects.nonNull(entry.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public String getId() {
        return userId;
    }
}
