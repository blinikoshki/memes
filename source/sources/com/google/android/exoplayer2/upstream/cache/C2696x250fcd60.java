package com.google.android.exoplayer2.upstream.cache;

import java.util.Comparator;

/* renamed from: com.google.android.exoplayer2.upstream.cache.-$$Lambda$LeastRecentlyUsedCacheEvictor$fGGQpb4lm4rCLKn4-zylNcQiqeo */
/* compiled from: lambda */
public final /* synthetic */ class C2696x250fcd60 implements Comparator {
    public static final /* synthetic */ C2696x250fcd60 INSTANCE = new C2696x250fcd60();

    private /* synthetic */ C2696x250fcd60() {
    }

    public final int compare(Object obj, Object obj2) {
        return LeastRecentlyUsedCacheEvictor.compare((CacheSpan) obj, (CacheSpan) obj2);
    }
}
