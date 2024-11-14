package com.gespyme.commons.validator;

import java.util.Map;

public interface Validable {
    Map<String, Object> allParamsMap();
    Map<String, Object> selectedParamsMap();
    String getId();
}
