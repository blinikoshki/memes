package com.appsflyer.internal.referrer;

import java.util.HashMap;

public class MandatoryFields extends HashMap<String, Object> {
    public MandatoryFields() {
        put("type", Payload.TYPE_STORE);
    }
}
