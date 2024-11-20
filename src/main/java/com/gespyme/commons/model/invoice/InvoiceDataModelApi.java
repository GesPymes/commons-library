package com.gespyme.commons.model.invoice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gespyme.commons.validator.Validable;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class InvoiceDataModelApi implements Validable {
    private String invoiceDataId;
    private String appointmentId;
    private Integer subtotalAmount;
    private Integer taxRate;
    private Integer totalAmount;
    private String customerName;
    private String description;

    @Override
    public Map<String, Object> allParamsMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("invoiceDataId", this.invoiceDataId);
        params.put("appointmentId", this.appointmentId);
        params.put("subtotalAmount", this.subtotalAmount);
        params.put("taxRate", this.taxRate);
        params.put("totalAmount", this.totalAmount);
        params.put("customerName", this.customerName);
        params.put("description", this.description);
        return params;
    }

    @Override
    public Map<String, Object> selectedParamsMap() {
        return allParamsMap().entrySet().stream().filter(entry -> Objects.nonNull(entry.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public String getId() {
        return invoiceDataId;
    }


}
