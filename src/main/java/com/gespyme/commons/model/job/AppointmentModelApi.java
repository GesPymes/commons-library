package com.gespyme.commons.model.job;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class AppointmentModelApi  extends AppointmentBaseModelApi {
    private String appointmentId;

    @Override
    public String getId() {
        return appointmentId;
    }
}
