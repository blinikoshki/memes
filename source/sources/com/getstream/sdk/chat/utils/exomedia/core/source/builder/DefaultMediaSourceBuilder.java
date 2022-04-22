package com.getstream.sdk.chat.utils.exomedia.core.source.builder;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.TransferListener;

public class DefaultMediaSourceBuilder extends MediaSourceBuilder {
    public MediaSource build(Context context, Uri uri, String str, Handler handler, TransferListener transferListener) {
        return new ExtractorMediaSource.Factory(buildDataSourceFactory(context, str, transferListener)).setExtractorsFactory(new DefaultExtractorsFactory()).createMediaSource(uri);
    }
}
