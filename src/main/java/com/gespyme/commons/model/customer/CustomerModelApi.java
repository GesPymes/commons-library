package com.gespyme.commons.model.customer;

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
public class CustomerModelApi extends CustomerBaseModelApi {

  public CustomerModelApi(
      String name,
      String lastName,
      String address,
      String mobilePhone,
      String email,
      Boolean needsInvoice,
      String customerId) {
    super(name, lastName, address, mobilePhone, email, needsInvoice);
    this.customerId = customerId;
  }

  @JsonProperty("customerId")
  private String customerId;

  @JsonIgnore
  @Override
  public String getId() {
    return customerId;
  }
}
