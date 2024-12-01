package com.gespyme.commons.model.invoice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gespyme.commons.validator.Validable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class InvoiceOrderBaseModelApi implements Validable {

  @JsonProperty("status")
  private InvoiceStatus status;
}
