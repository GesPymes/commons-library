package com.gespyme.commons.validator;

public interface FieldsValidator<T> {
    Validator getEnumValue();
    void isValid(T request);
}
