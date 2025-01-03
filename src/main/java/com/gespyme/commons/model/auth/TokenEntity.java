package com.gespyme.commons.model.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@NoArgsConstructor
@AllArgsConstructor
public class TokenEntity {
  private String token;
  private Boolean isValid;
  private String userId;
}
