package com.gespyme.authenticator.auth.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TokenResponse {
    private String token;
    private boolean isValid;
    private String userId;

}
