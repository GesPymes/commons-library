package com.gespyme.commons.exeptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class BadRequestException extends RuntimeException {
    @Getter
    private final String messageDescription;
    private Throwable throwable;
}