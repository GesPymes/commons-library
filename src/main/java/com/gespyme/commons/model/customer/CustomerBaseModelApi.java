package com.gespyme.commons.model.customer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gespyme.commons.validator.Validable;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public abstract class CustomerBaseModelApi implements Validable {

    private String name;
    private String lastName;
    private String address;
    private String mobilePhone;
    private String email;
    private Boolean needsInvoice;

    @Override
    public Map<String, Object> allParamsMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("name", this.name);
        params.put("lastName", this.lastName);
        params.put("address", this.address);
        params.put("mobilePhone", this.mobilePhone);
        params.put("email", this.email);
        params.put("needsInvoice", this.needsInvoice);
        return params;
    }

    @Override
    public Map<String, Object> selectedParamsMap() {
        return allParamsMap().entrySet().stream().filter(entry -> Objects.nonNull(entry.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


}
