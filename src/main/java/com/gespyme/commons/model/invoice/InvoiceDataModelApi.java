package com.gespyme.commons.model.invoice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class InvoiceDataModelApi extends InvoiceDataBaseModelApi {

  @JsonProperty("invoiceDataId")
  private String invoiceDataId;

  @JsonProperty("appointmentId")
  private String appointmentId;

  public InvoiceDataModelApi(
      Integer subtotalAmount,
      Integer taxRate,
      Integer totalAmount,
      String description,
      InvoiceStatus status,
      String customerId,
      String invoiceDataId,
      String appointmentId) {
    super(subtotalAmount, taxRate, totalAmount, description, status, customerId);
    this.invoiceDataId = invoiceDataId;
    this.appointmentId = appointmentId;
  }

  @Override
  public Map<String, Object> allParamsMap() {
    Map<String, Object> params = new HashMap<>();
    params.put("subtotalAmount", this.getSubtotalAmount());
    params.put("taxRate", this.getTaxRate());
    params.put("totalAmount", this.getTotalAmount());
    params.put("description", this.getDescription());
    params.put("customerId", this.getCustomerId());
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
    return invoiceDataId;
  }
}
