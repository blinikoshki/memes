package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.SlidingPercentile;
import java.util.Comparator;

/* renamed from: com.google.android.exoplayer2.util.-$$Lambda$SlidingPercentile$XeBwkcF3B7s8ZVo1WutgXnfrAOU  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$SlidingPercentile$XeBwkcF3B7s8ZVo1WutgXnfrAOU implements Comparator {
    public static final /* synthetic */ $$Lambda$SlidingPercentile$XeBwkcF3B7s8ZVo1WutgXnfrAOU INSTANCE = new $$Lambda$SlidingPercentile$XeBwkcF3B7s8ZVo1WutgXnfrAOU();

    private /* synthetic */ $$Lambda$SlidingPercentile$XeBwkcF3B7s8ZVo1WutgXnfrAOU() {
    }

    public final int compare(Object obj, Object obj2) {
        return SlidingPercentile.lambda$static$0((SlidingPercentile.Sample) obj, (SlidingPercentile.Sample) obj2);
    }
}
