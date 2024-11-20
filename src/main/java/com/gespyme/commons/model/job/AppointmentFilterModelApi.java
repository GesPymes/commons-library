package com.gespyme.commons.model.job;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gespyme.commons.exeptions.BadRequestException;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class AppointmentFilterModelApi extends AppointmentBaseModelApi {

    @Override
    public String getId() {
        throw new BadRequestException("Cannot filter by appointment id from this endpoint");
    }
}
