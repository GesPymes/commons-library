package com.gespyme.commons.model.job;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@NoArgsConstructor
public class CalendarModelApi extends CalendarBaseModelApi {
  @JsonProperty("calendarId")
  private String calendarId;

  public CalendarModelApi(String calendarName, List<String> users, String calendarId) {
    super(calendarName, users);
    this.calendarId = calendarId;
  }

  @Override
  public String getId() {
    return calendarId;
  }
}
