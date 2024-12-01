package com.gespyme.commons.model.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@NoArgsConstructor
public class EmployeeModelApi extends EmployeeBaseModelApi {

  @JsonProperty("employeeId")
  private String employeeId;

  @JsonProperty("userId")
  private String userId;

  public EmployeeModelApi(
      String name,
      String lastName,
      String email,
      String address,
      String mobilePhone,
      String idNumber,
      String socialSecurityNumber,
      String userId,
      String employeeId) {
    super(name, lastName, email, address, mobilePhone, idNumber, socialSecurityNumber);
    this.userId = userId;
    this.employeeId = employeeId;
  }

  @JsonIgnore
  @Override
  public String getId() {
    return employeeId;
  }
}
