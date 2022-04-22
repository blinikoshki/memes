package com.google.android.exoplayer2.extractor.p023ts;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.extractor.ts.-$$Lambda$TsExtractor$bYe9QyXe_uycRO2Fcb-UvfjPyNo  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$TsExtractor$bYe9QyXe_uycRO2FcbUvfjPyNo implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$TsExtractor$bYe9QyXe_uycRO2FcbUvfjPyNo INSTANCE = new $$Lambda$TsExtractor$bYe9QyXe_uycRO2FcbUvfjPyNo();

    private /* synthetic */ $$Lambda$TsExtractor$bYe9QyXe_uycRO2FcbUvfjPyNo() {
    }

    public final Extractor[] createExtractors() {
        return TsExtractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
