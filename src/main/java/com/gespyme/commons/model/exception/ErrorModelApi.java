package com.gespyme.commons.model.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorModelApi {
    private String code;
    private String description;
}
