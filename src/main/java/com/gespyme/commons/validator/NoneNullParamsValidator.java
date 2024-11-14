package com.gespyme.commons.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NoneNullParamsValidator<T extends Validable> implements FieldsValidator<T> {
    private final ParamsValidator paramsValidator;

    @Override
    public Validator getEnumValue() {
        return Validator.ALL_PARAMS_NOT_NULL;
    }

    @Override
    public void isValid(T request) {
        paramsValidator.validateNotNullParams(request.allParamsMap());
    }
}
