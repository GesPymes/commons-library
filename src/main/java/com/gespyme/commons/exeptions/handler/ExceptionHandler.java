package com.gespyme.commons.exeptions.handler;

import com.gespyme.commons.exeptions.*;
import com.gespyme.commons.model.exception.ErrorModelApi;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorModelApi> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorModelApi.builder().code("400").description(ex.getMessageDescription()).build());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ErrorModelApi> handleForbiddenException(ForbiddenException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ErrorModelApi.builder().code("403").description("Forbidden").build());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorModelApi> handleUnauthorizedException(UnauthorizedException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ErrorModelApi.builder().code("401").description("Unauthorized").build());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ErrorModelApi> handleUnauthorizedException(ExpiredJwtException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ErrorModelApi.builder().code("401").description("Unauthorized").build());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorModelApi> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorModelApi.builder().code("404").description(ex.getMessageDescription()).build());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InternalServerError.class)
    public ResponseEntity<ErrorModelApi> handleNotFoundException(InternalServerError ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorModelApi.builder().code("500").description("Unexpected server error").build());
    }
}
