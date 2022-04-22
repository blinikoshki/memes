package com.google.android.exoplayer2.extractor.flv;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.extractor.flv.-$$Lambda$FlvExtractor$uGPIR_OZmcT4Rba70dWWmnPAxgs  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$FlvExtractor$uGPIR_OZmcT4Rba70dWWmnPAxgs implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$FlvExtractor$uGPIR_OZmcT4Rba70dWWmnPAxgs INSTANCE = new $$Lambda$FlvExtractor$uGPIR_OZmcT4Rba70dWWmnPAxgs();

    private /* synthetic */ $$Lambda$FlvExtractor$uGPIR_OZmcT4Rba70dWWmnPAxgs() {
    }

    public final Extractor[] createExtractors() {
        return FlvExtractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
