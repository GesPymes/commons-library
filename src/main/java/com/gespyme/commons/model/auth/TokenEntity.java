package com.gespyme.commons.model.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class TokenEntity {
    private String token;
    private Boolean isValid;
    private String userId;

}
