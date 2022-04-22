package com.facebook.internal.logging.monitor;

import com.facebook.internal.logging.ExternalLog;
import com.facebook.internal.logging.LoggingCache;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class MonitorLoggingQueue implements LoggingCache {
    private static final Integer FLUSH_LIMIT = 100;
    private static MonitorLoggingQueue monitorLoggingQueue;
    private Queue<ExternalLog> logQueue = new LinkedList();

    private MonitorLoggingQueue() {
    }

    public static synchronized MonitorLoggingQueue getInstance() {
        MonitorLoggingQueue monitorLoggingQueue2;
        synchronized (MonitorLoggingQueue.class) {
            if (monitorLoggingQueue == null) {
                monitorLoggingQueue = new MonitorLoggingQueue();
            }
            monitorLoggingQueue2 = monitorLoggingQueue;
        }
        return monitorLoggingQueue2;
    }

    public boolean addLog(ExternalLog externalLog) {
        return addLogs(Arrays.asList(new ExternalLog[]{externalLog}));
    }

    public boolean addLogs(Collection<? extends ExternalLog> collection) {
        if (collection != null) {
            this.logQueue.addAll(collection);
        }
        return hasReachedFlushLimit();
    }

    private boolean hasReachedFlushLimit() {
        return this.logQueue.size() >= FLUSH_LIMIT.intValue();
    }

    public boolean isEmpty() {
        return this.logQueue.isEmpty();
    }

    public ExternalLog fetchLog() {
        return this.logQueue.poll();
    }

    public Collection<ExternalLog> fetchAllLogs() {
        LinkedList linkedList = new LinkedList(this.logQueue);
        this.logQueue.clear();
        return linkedList;
    }
}
