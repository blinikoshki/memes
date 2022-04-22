package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.SlidingPercentile;
import java.util.Comparator;

/* renamed from: com.google.android.exoplayer2.util.-$$Lambda$SlidingPercentile$cu-pftxKT-M9mboAUjZRvmYSjJ0  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$SlidingPercentile$cupftxKTM9mboAUjZRvmYSjJ0 implements Comparator {
    public static final /* synthetic */ $$Lambda$SlidingPercentile$cupftxKTM9mboAUjZRvmYSjJ0 INSTANCE = new $$Lambda$SlidingPercentile$cupftxKTM9mboAUjZRvmYSjJ0();

    private /* synthetic */ $$Lambda$SlidingPercentile$cupftxKTM9mboAUjZRvmYSjJ0() {
    }

    public final int compare(Object obj, Object obj2) {
        return Float.compare(((SlidingPercentile.Sample) obj).value, ((SlidingPercentile.Sample) obj2).value);
    }
}
