package com.gespyme.commons.model.invoice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gespyme.commons.model.job.AppointmentStatus;
import com.gespyme.commons.validator.Validable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class InvoiceDataBaseModelApi implements Validable {
  @JsonProperty("subtotalAmount")
  private Integer subtotalAmount;

  @JsonProperty("taxRate")
  private Integer taxRate;

  @JsonProperty("totalAmount")
  private Integer totalAmount;

  @JsonProperty("description")
  private String description;

  @JsonProperty("status")
  private InvoiceStatus status;

  @JsonProperty("customerId")
  private String customerId;
}
