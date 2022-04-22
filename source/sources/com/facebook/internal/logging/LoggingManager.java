package com.facebook.internal.logging;

public interface LoggingManager {
    void addLog(ExternalLog externalLog);

    void flushAndWait();

    void flushLoggingStore();
}
