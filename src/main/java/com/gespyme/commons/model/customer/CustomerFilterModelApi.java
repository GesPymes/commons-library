package com.gespyme.commons.model.customer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gespyme.commons.exeptions.BadRequestException;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class CustomerFilterModelApi extends CustomerBaseModelApi {
    @Override
    public String getId() {
        throw new BadRequestException("Cannot filter by customer id from this endpoint");
    }
}
