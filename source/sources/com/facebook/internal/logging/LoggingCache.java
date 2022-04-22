package com.facebook.internal.logging;

import java.util.Collection;

public interface LoggingCache {
    boolean addLog(ExternalLog externalLog);

    boolean addLogs(Collection<? extends ExternalLog> collection);

    Collection<ExternalLog> fetchAllLogs();

    ExternalLog fetchLog();

    boolean isEmpty();
}
