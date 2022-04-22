package com.facebook.internal.logging.monitor;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.logging.ExternalLog;
import com.facebook.internal.logging.LoggingStore;
import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;

public class MonitorLoggingStore implements LoggingStore {
    public static final String PERSISTED_LOGS_FILENAME = "facebooksdk.monitoring.persistedlogs";
    private static MonitorLoggingStore monitorLoggingStore;

    private MonitorLoggingStore() {
    }

    public static synchronized MonitorLoggingStore getInstance() {
        MonitorLoggingStore monitorLoggingStore2;
        synchronized (MonitorLoggingStore.class) {
            if (monitorLoggingStore == null) {
                monitorLoggingStore = new MonitorLoggingStore();
            }
            monitorLoggingStore2 = monitorLoggingStore;
        }
        return monitorLoggingStore2;
    }

    public Collection<ExternalLog> readAndClearStore() {
        ArrayList arrayList = new ArrayList();
        Context applicationContext = FacebookSdk.getApplicationContext();
        ObjectInputStream objectInputStream = null;
        try {
            ObjectInputStream objectInputStream2 = new ObjectInputStream(new BufferedInputStream(applicationContext.openFileInput(PERSISTED_LOGS_FILENAME)));
            try {
                Collection<ExternalLog> collection = (Collection) objectInputStream2.readObject();
                Utility.closeQuietly(objectInputStream2);
                try {
                    applicationContext.getFileStreamPath(PERSISTED_LOGS_FILENAME).delete();
                } catch (Exception unused) {
                }
                return collection;
            } catch (Exception unused2) {
                objectInputStream = objectInputStream2;
                Utility.closeQuietly(objectInputStream);
                try {
                    applicationContext.getFileStreamPath(PERSISTED_LOGS_FILENAME).delete();
                    return arrayList;
                } catch (Exception unused3) {
                    return arrayList;
                }
            } catch (Throwable th) {
                th = th;
                objectInputStream = objectInputStream2;
                Utility.closeQuietly(objectInputStream);
                try {
                    applicationContext.getFileStreamPath(PERSISTED_LOGS_FILENAME).delete();
                } catch (Exception unused4) {
                }
                throw th;
            }
        } catch (Exception unused5) {
            Utility.closeQuietly(objectInputStream);
            applicationContext.getFileStreamPath(PERSISTED_LOGS_FILENAME).delete();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            Utility.closeQuietly(objectInputStream);
            applicationContext.getFileStreamPath(PERSISTED_LOGS_FILENAME).delete();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        r7 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0024 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0022 A[ExcHandler: all (th java.lang.Throwable), PHI: r2 
      PHI: (r2v3 java.io.ObjectOutputStream) = (r2v0 java.io.ObjectOutputStream), (r2v2 java.io.ObjectOutputStream), (r2v2 java.io.ObjectOutputStream), (r2v0 java.io.ObjectOutputStream) binds: [B:1:0x0007, B:11:0x0024, B:12:?, B:2:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x0007] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveLogsToDisk(java.util.Collection<com.facebook.internal.logging.ExternalLog> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "facebooksdk.monitoring.persistedlogs"
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()
            r2 = 0
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x0024, all -> 0x0022 }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0024, all -> 0x0022 }
            r5 = 0
            java.io.FileOutputStream r5 = r1.openFileOutput(r0, r5)     // Catch:{ Exception -> 0x0024, all -> 0x0022 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0024, all -> 0x0022 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0024, all -> 0x0022 }
            r3.writeObject(r7)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            com.facebook.internal.Utility.closeQuietly(r3)
            goto L_0x0033
        L_0x001d:
            r7 = move-exception
            r2 = r3
            goto L_0x002c
        L_0x0020:
            r2 = r3
            goto L_0x0024
        L_0x0022:
            r7 = move-exception
            goto L_0x002c
        L_0x0024:
            java.io.File r7 = r1.getFileStreamPath(r0)     // Catch:{ Exception -> 0x0030, all -> 0x0022 }
            r7.delete()     // Catch:{ Exception -> 0x0030, all -> 0x0022 }
            goto L_0x0030
        L_0x002c:
            com.facebook.internal.Utility.closeQuietly(r2)
            throw r7
        L_0x0030:
            com.facebook.internal.Utility.closeQuietly(r2)
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.logging.monitor.MonitorLoggingStore.saveLogsToDisk(java.util.Collection):void");
    }
}
