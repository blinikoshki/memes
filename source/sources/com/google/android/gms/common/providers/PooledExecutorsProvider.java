package com.google.android.gms.common.providers;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public class PooledExecutorsProvider {
    private static PooledExecutorFactory zzfk;

    /* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
    public interface PooledExecutorFactory {
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    public static synchronized PooledExecutorFactory getInstance() {
        PooledExecutorFactory pooledExecutorFactory;
        synchronized (PooledExecutorsProvider.class) {
            if (zzfk == null) {
                zzfk = new zza();
            }
            pooledExecutorFactory = zzfk;
        }
        return pooledExecutorFactory;
    }

    private PooledExecutorsProvider() {
    }
}
