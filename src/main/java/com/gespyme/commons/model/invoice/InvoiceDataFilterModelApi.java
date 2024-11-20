package com.gespyme.commons.model.invoice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gespyme.commons.exeptions.BadRequestException;
import com.gespyme.commons.validator.Validable;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class InvoiceDataFilterModelApi implements Validable {
    private Integer subtotalAmount;
    private Integer taxRate;
    private Integer totalAmount;
    private String customerName;
    private String status;

    @Override
    public Map<String, Object> allParamsMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("subtotalAmount", this.subtotalAmount);
        params.put("taxRate", this.taxRate);
        params.put("totalAmount", this.totalAmount);
        params.put("customerName", this.customerName);
        params.put("status", this.status);
        return params;
    }

    @Override
    public Map<String, Object> selectedParamsMap() {
        return allParamsMap().entrySet().stream().filter(entry -> Objects.nonNull(entry.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public String getId() {
        throw new BadRequestException("Cannot filter by id from this endpoint");
    }
}
