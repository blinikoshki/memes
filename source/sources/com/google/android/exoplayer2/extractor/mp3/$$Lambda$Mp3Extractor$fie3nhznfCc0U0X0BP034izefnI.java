package com.google.android.exoplayer2.extractor.mp3;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.extractor.mp3.-$$Lambda$Mp3Extractor$fie3nhznfCc0U0X0BP034izefnI  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$Mp3Extractor$fie3nhznfCc0U0X0BP034izefnI implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$Mp3Extractor$fie3nhznfCc0U0X0BP034izefnI INSTANCE = new $$Lambda$Mp3Extractor$fie3nhznfCc0U0X0BP034izefnI();

    private /* synthetic */ $$Lambda$Mp3Extractor$fie3nhznfCc0U0X0BP034izefnI() {
    }

    public final Extractor[] createExtractors() {
        return Mp3Extractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
