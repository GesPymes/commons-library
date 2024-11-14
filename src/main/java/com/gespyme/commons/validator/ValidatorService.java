package com.gespyme.commons.validator;

import com.gespyme.commons.exeptions.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ValidatorService<T> {
    Map<Validator, FieldsValidator<T>> validatorMap;

    public ValidatorService(List<FieldsValidator<T>> validators) {
        this.validatorMap = validators.stream().collect(Collectors.toMap(FieldsValidator::getEnumValue, validator->validator));
    }

    public void validate(T entity, List<Validator> validators)  throws BadRequestException {
        validators.stream().forEach(validator ->  validatorMap.get(validator).isValid(entity));
    }

    public void validateId(String id) throws BadRequestException{
        if(id.isBlank()) {
            throw new BadRequestException("Id cannot be null or empty");
        }
    }
}
