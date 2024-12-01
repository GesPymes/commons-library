package com.gespyme.commons.model.invoice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gespyme.commons.validator.Validable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class InvoiceOrderModelApi extends InvoiceOrderBaseModelApi {
  @JsonProperty("invoiceDataId")
  private String invoiceDataId;

  @JsonProperty("invoiceOrderId")
  private String invoiceOrderId;

  @JsonProperty("appointmentId")
  private String appointmentId;

  public InvoiceOrderModelApi(
      InvoiceStatus status, String invoiceDataId, String invoiceOrderId, String appointmentId) {
    super(status);
    this.invoiceDataId = invoiceDataId;
    this.invoiceOrderId = invoiceOrderId;
    this.appointmentId = appointmentId;
  }

  @Override
  public Map<String, Object> allParamsMap() {
    Map<String, Object> params = new HashMap<>();
    params.put("invoiceDataId", this.invoiceDataId);
    params.put("appointmentId", this.appointmentId);
    params.put("status", this.getStatus());
    return params;
  }

  @Override
  public Map<String, Object> selectedParamsMap() {
    return allParamsMap().entrySet().stream()
        .filter(entry -> Objects.nonNull(entry.getValue()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  @Override
  public String getId() {
    return invoiceOrderId;
  }
}
