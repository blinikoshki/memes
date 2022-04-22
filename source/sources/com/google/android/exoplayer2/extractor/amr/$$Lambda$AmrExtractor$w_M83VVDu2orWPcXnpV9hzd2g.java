package com.google.android.exoplayer2.extractor.amr;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.extractor.amr.-$$Lambda$AmrExtractor$-w_M83VVDu2orWPc-XnpV9hzd2g  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$AmrExtractor$w_M83VVDu2orWPcXnpV9hzd2g implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$AmrExtractor$w_M83VVDu2orWPcXnpV9hzd2g INSTANCE = new $$Lambda$AmrExtractor$w_M83VVDu2orWPcXnpV9hzd2g();

    private /* synthetic */ $$Lambda$AmrExtractor$w_M83VVDu2orWPcXnpV9hzd2g() {
    }

    public final Extractor[] createExtractors() {
        return AmrExtractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
