package com.gespyme.commons.model.job;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gespyme.commons.exeptions.BadRequestException;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@NoArgsConstructor
public class CalendarFilterModelApi extends CalendarBaseModelApi {

  public CalendarFilterModelApi(String calendarName, List<UserByCalendarModelApi> users) {
    super(calendarName, users);
  }

  @Override
  public String getId() {
    throw new BadRequestException("Cannot filter by calendar id from this endpoint");
  }
}
