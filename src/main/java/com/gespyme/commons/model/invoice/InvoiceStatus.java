package com.gespyme.commons.model.invoice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InvoiceStatus {
  CREATED,
  DELETED,
  SIGNED,
  APPROVED,
  SENT;

  @JsonCreator
  public static InvoiceStatus fromString(String value) {
    for (InvoiceStatus status : InvoiceStatus.values()) {
      if (status.name().equalsIgnoreCase(value)) {
        return status;
      }
    }
    throw new IllegalArgumentException("Unknown status: " + value);
  }

  @JsonValue
  public String toValue() {
    return name();
  }
}
