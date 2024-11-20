package com.gespyme.commons.model.job;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class JobModelApi extends JobBaseModelApi{
    private String jobId;

    @Override
    public String getId() {
        return jobId;
    }
}
