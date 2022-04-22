package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    /* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
    public interface Types {
        public static final int EVENT_TYPE_ACQUIRE_WAKE_LOCK = 7;
        public static final int EVENT_TYPE_RELEASE_WAKE_LOCK = 8;
    }

    public abstract long getDurationMillis();

    public abstract int getEventType();

    public abstract long getTimeMillis();

    public abstract String zzu();

    public String toString() {
        long timeMillis = getTimeMillis();
        int eventType = getEventType();
        long durationMillis = getDurationMillis();
        String zzu = zzu();
        StringBuilder sb = new StringBuilder(String.valueOf(zzu).length() + 53);
        sb.append(timeMillis);
        sb.append("\t");
        sb.append(eventType);
        sb.append("\t");
        sb.append(durationMillis);
        sb.append(zzu);
        return sb.toString();
    }
}
