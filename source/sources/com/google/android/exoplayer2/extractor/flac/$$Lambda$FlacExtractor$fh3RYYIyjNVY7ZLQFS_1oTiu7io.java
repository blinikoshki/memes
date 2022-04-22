package com.google.android.exoplayer2.extractor.flac;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.extractor.flac.-$$Lambda$FlacExtractor$fh3RYYIyjNVY7ZLQFS_1oTiu7io  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$FlacExtractor$fh3RYYIyjNVY7ZLQFS_1oTiu7io implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$FlacExtractor$fh3RYYIyjNVY7ZLQFS_1oTiu7io INSTANCE = new $$Lambda$FlacExtractor$fh3RYYIyjNVY7ZLQFS_1oTiu7io();

    private /* synthetic */ $$Lambda$FlacExtractor$fh3RYYIyjNVY7ZLQFS_1oTiu7io() {
    }

    public final Extractor[] createExtractors() {
        return FlacExtractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
