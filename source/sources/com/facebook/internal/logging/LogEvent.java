package com.facebook.internal.logging;

import java.io.Serializable;

public class LogEvent implements Serializable {
    private static final long serialVersionUID = 1;
    private String eventName;
    private LogCategory logCategory;

    public LogEvent(String str, LogCategory logCategory2) {
        this.eventName = str;
        this.logCategory = logCategory2;
    }

    public String getEventName() {
        return this.eventName;
    }

    public LogCategory getLogCategory() {
        return this.logCategory;
    }

    public String upperCaseEventName() {
        String upperCase = this.eventName.toUpperCase();
        this.eventName = upperCase;
        return upperCase;
    }
}
