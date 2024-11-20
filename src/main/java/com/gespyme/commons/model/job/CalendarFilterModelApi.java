package com.gespyme.commons.model.job;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gespyme.commons.exeptions.BadRequestException;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class CalendarFilterModelApi extends CalendarBaseModelApi{
    @Override
    public String getId() {
        throw new BadRequestException("Cannot filter by calendar id from this endpoint");
    }
}
