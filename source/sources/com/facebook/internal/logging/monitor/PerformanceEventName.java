package com.facebook.internal.logging.monitor;

public enum PerformanceEventName {
    EVENT_NAME_FOR_TEST_FIRST("EVENT_NAME_FOR_TEST_FIRST"),
    EVENT_NAME_FOR_TEST_SECOND("EVENT_NAME_FOR_TEST_SECOND"),
    FB_CORE_STARTUP("FB_CORE_STARTUP");
    
    private String eventName;

    private PerformanceEventName(String str) {
        this.eventName = str;
    }

    public String toString() {
        return this.eventName;
    }
}
