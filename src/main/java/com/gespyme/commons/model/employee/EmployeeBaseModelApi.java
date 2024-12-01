package com.gespyme.commons.model.employee;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gespyme.commons.validator.Validable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@NoArgsConstructor
@AllArgsConstructor
public abstract class EmployeeBaseModelApi implements Validable {

  @JsonProperty("name")
  private String name;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("email")
  private String email;

  @JsonProperty("address")
  private String address;

  @JsonProperty("mobilePhone")
  private String mobilePhone;

  @JsonProperty("idNumber")
  private String idNumber;

  @JsonProperty("socialSecurityNumber")
  private String socialSecurityNumber;

  @Override
  public Map<String, Object> allParamsMap() {
    Map<String, Object> params = new HashMap<>();
    params.put("name", this.name);
    params.put("lastName", this.lastName);
    params.put("email", this.email);
    params.put("address", this.address);
    params.put("mobilePhone", this.mobilePhone);
    params.put("idNumber", this.idNumber);
    params.put("socialSecurityNumber", this.socialSecurityNumber);
    return params;
  }

  @Override
  public Map<String, Object> selectedParamsMap() {
    return allParamsMap().entrySet().stream()
        .filter(entry -> Objects.nonNull(entry.getValue()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }
}
