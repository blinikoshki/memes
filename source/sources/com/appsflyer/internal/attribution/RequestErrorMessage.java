package com.appsflyer.internal.attribution;

public class RequestErrorMessage {
    public static String EVENT_TIMEOUT = "Event timeout. Check 'minTimeBetweenSessions' param";
    public static String NO_DEV_KEY = "No dev key";
    public static String RESPONSE_CODE_FAILURE = "Status code failure";
    public static String STOP_TRACKING = "Skipping event because 'isStopped' is true";
}
