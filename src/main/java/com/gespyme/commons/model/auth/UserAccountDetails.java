package com.gespyme.commons.model.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserAccountDetails {
  private String email;
  private String password;
  private Role role;
  private LocalDateTime lastTimeLoggedIn;
  private LocalDateTime creationDate;
  private LocalDateTime lastModificationDate;
}
