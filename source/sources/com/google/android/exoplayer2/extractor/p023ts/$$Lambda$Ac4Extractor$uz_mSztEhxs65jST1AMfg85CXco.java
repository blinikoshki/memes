package com.google.android.exoplayer2.extractor.p023ts;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.extractor.ts.-$$Lambda$Ac4Extractor$uz_mSztEhxs65jST1AMfg85CXco  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$Ac4Extractor$uz_mSztEhxs65jST1AMfg85CXco implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$Ac4Extractor$uz_mSztEhxs65jST1AMfg85CXco INSTANCE = new $$Lambda$Ac4Extractor$uz_mSztEhxs65jST1AMfg85CXco();

    private /* synthetic */ $$Lambda$Ac4Extractor$uz_mSztEhxs65jST1AMfg85CXco() {
    }

    public final Extractor[] createExtractors() {
        return Ac4Extractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
