package com.google.android.exoplayer2.extractor.wav;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.extractor.wav.-$$Lambda$WavExtractor$Qwcn1NjCsgxYvA5Vzd4jHyQOX2k  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$WavExtractor$Qwcn1NjCsgxYvA5Vzd4jHyQOX2k implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$WavExtractor$Qwcn1NjCsgxYvA5Vzd4jHyQOX2k INSTANCE = new $$Lambda$WavExtractor$Qwcn1NjCsgxYvA5Vzd4jHyQOX2k();

    private /* synthetic */ $$Lambda$WavExtractor$Qwcn1NjCsgxYvA5Vzd4jHyQOX2k() {
    }

    public final Extractor[] createExtractors() {
        return WavExtractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
