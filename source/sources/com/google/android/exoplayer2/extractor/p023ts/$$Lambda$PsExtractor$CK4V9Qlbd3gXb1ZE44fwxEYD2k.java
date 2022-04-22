package com.google.android.exoplayer2.extractor.p023ts;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.extractor.ts.-$$Lambda$PsExtractor$CK4V9Qlbd3gXb-1ZE44fwxEYD2k  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$PsExtractor$CK4V9Qlbd3gXb1ZE44fwxEYD2k implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$PsExtractor$CK4V9Qlbd3gXb1ZE44fwxEYD2k INSTANCE = new $$Lambda$PsExtractor$CK4V9Qlbd3gXb1ZE44fwxEYD2k();

    private /* synthetic */ $$Lambda$PsExtractor$CK4V9Qlbd3gXb1ZE44fwxEYD2k() {
    }

    public final Extractor[] createExtractors() {
        return PsExtractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
