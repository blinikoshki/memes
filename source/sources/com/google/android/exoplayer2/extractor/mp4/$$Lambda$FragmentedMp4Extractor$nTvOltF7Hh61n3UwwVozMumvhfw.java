package com.google.android.exoplayer2.extractor.mp4;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.extractor.mp4.-$$Lambda$FragmentedMp4Extractor$nTvOltF7Hh61n3UwwVozMumvhfw  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$FragmentedMp4Extractor$nTvOltF7Hh61n3UwwVozMumvhfw implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$FragmentedMp4Extractor$nTvOltF7Hh61n3UwwVozMumvhfw INSTANCE = new $$Lambda$FragmentedMp4Extractor$nTvOltF7Hh61n3UwwVozMumvhfw();

    private /* synthetic */ $$Lambda$FragmentedMp4Extractor$nTvOltF7Hh61n3UwwVozMumvhfw() {
    }

    public final Extractor[] createExtractors() {
        return FragmentedMp4Extractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
