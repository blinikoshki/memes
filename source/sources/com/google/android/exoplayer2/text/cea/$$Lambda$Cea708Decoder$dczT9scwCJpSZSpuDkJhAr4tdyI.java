package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.util.Comparator;

/* renamed from: com.google.android.exoplayer2.text.cea.-$$Lambda$Cea708Decoder$dczT9scwCJpSZSpuDkJhAr4tdyI  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$Cea708Decoder$dczT9scwCJpSZSpuDkJhAr4tdyI implements Comparator {
    public static final /* synthetic */ $$Lambda$Cea708Decoder$dczT9scwCJpSZSpuDkJhAr4tdyI INSTANCE = new $$Lambda$Cea708Decoder$dczT9scwCJpSZSpuDkJhAr4tdyI();

    private /* synthetic */ $$Lambda$Cea708Decoder$dczT9scwCJpSZSpuDkJhAr4tdyI() {
    }

    public final int compare(Object obj, Object obj2) {
        return Integer.compare(((Cea708Decoder.Cea708CueInfo) obj).priority, ((Cea708Decoder.Cea708CueInfo) obj2).priority);
    }
}
