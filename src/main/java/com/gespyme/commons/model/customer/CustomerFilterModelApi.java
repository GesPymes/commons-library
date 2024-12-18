package com.gespyme.commons.model.customer;

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
public class CustomerFilterModelApi extends CustomerBaseModelApi {
  public CustomerFilterModelApi(
      String name,
      String lastName,
      String address,
      String mobilePhone,
      String email,
      Boolean needsInvoice) {
    super(name, lastName, address, mobilePhone, email, needsInvoice);
  }

  @JsonIgnore
  @Override
  public String getId() {
    throw new BadRequestException("Cannot filter by customer id from this endpoint");
  }
}
