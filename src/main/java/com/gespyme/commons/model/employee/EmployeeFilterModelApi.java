package com.gespyme.commons.model.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.gespyme.commons.exeptions.BadRequestException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@NoArgsConstructor
public class EmployeeFilterModelApi extends EmployeeBaseModelApi {

  public EmployeeFilterModelApi(
      String name,
      String lastName,
      String email,
      String address,
      String mobilePhone,
      String idNumber,
      String socialSecurityNumber) {
    super(name, lastName, email, address, mobilePhone, idNumber, socialSecurityNumber);
  }

  @JsonIgnore
  @Override
  public String getId() {
    throw new BadRequestException("Cannot filter by employee id from this endpoint");
  }
}
