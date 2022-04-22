package com.facebook.internal.logging;

import java.util.Collection;

public interface LoggingStore {
    Collection<ExternalLog> readAndClearStore();

    void saveLogsToDisk(Collection<ExternalLog> collection);
}
