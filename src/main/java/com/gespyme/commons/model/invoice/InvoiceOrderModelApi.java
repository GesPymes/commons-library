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
public class InvoiceOrderModelApi implements Validable {
    private String invoiceDataId;
    private String invoiceOrderId;
    private String appointmentId;
    private String status;

    @Override
    public Map<String, Object> allParamsMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("invoiceDataId", this.invoiceDataId);
        params.put("invoiceOrderId", this.invoiceOrderId);
        params.put("appointmentId", this.appointmentId);
        params.put("status", this.status);
        return params;
    }

    @Override
    public Map<String, Object> selectedParamsMap() {
        return allParamsMap().entrySet().stream().filter(entry -> Objects.nonNull(entry.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public String getId() {
        return invoiceOrderId;
    }
}
