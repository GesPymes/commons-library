package com.gespyme.commons.model.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class CustomerModelApi extends CustomerBaseModelApi {
    @JsonProperty("customerId")
    private String customerId;

    @JsonIgnore
    @Override
    public String getId() {
        return customerId;
    }
}
