package com.gespyme.commons.model.customer;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class CustomerModelApi extends CustomerBaseModelApi {
    private String customerId;

    @Override
    public String getId() {
        return customerId;
    }
}
