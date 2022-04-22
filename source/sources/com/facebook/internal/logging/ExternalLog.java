package com.facebook.internal.logging;

import java.io.Serializable;
import org.json.JSONObject;

public interface ExternalLog extends Serializable {
    JSONObject convertToJSONObject();

    String getEventName();

    LogCategory getLogCategory();
}
