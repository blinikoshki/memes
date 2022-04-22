package com.google.android.exoplayer2.extractor.mp4;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.extractor.mp4.-$$Lambda$Mp4Extractor$zxba_Jp1gvw4wckCw1roj6rXQ6M  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$Mp4Extractor$zxba_Jp1gvw4wckCw1roj6rXQ6M implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$Mp4Extractor$zxba_Jp1gvw4wckCw1roj6rXQ6M INSTANCE = new $$Lambda$Mp4Extractor$zxba_Jp1gvw4wckCw1roj6rXQ6M();

    private /* synthetic */ $$Lambda$Mp4Extractor$zxba_Jp1gvw4wckCw1roj6rXQ6M() {
    }

    public final Extractor[] createExtractors() {
        return Mp4Extractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
