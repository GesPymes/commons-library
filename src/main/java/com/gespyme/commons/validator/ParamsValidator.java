package com.gespyme.commons.validator;

import com.gespyme.commons.exeptions.BadRequestException;
import com.gespyme.commons.validator.FieldsValidator;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Component
public class ParamsValidator {
    protected void validateNotNullParams(Map<String,Object> params) throws BadRequestException {
        params.entrySet().stream()
                .filter(this::validateParam)
                .findAny() //
                .ifPresent(param -> {
                    throw new BadRequestException("Param " + param.getKey() + " cannot be null");
                });
    }


    private boolean validateParam(Map.Entry<String, Object> param) throws BadRequestException {
        //TODO para fechas poner @DateTimeFormat y si no que lance excepcion y se coge con el controller advice
        //TODO para numeros @Min(value = 1, message = "El valor debe ser mayor que cero")
        //ESto combinado con jacskon ignore unknown
        if(param.getValue() instanceof String) {
            return ((String) param.getValue()).isBlank();
        }
        return Objects.isNull(param.getValue());
    }
}
