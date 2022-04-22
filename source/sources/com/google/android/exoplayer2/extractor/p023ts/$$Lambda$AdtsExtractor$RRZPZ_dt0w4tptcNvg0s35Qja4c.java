package com.google.android.exoplayer2.extractor.p023ts;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.extractor.ts.-$$Lambda$AdtsExtractor$RRZPZ_dt0w4tptcNvg0s35Qja4c  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$AdtsExtractor$RRZPZ_dt0w4tptcNvg0s35Qja4c implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$AdtsExtractor$RRZPZ_dt0w4tptcNvg0s35Qja4c INSTANCE = new $$Lambda$AdtsExtractor$RRZPZ_dt0w4tptcNvg0s35Qja4c();

    private /* synthetic */ $$Lambda$AdtsExtractor$RRZPZ_dt0w4tptcNvg0s35Qja4c() {
    }

    public final Extractor[] createExtractors() {
        return AdtsExtractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
