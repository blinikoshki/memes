package com.getstream.sdk.chat.utils.exomedia.core.source.builder;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.upstream.TransferListener;

public class HlsMediaSourceBuilder extends MediaSourceBuilder {
    public MediaSource build(Context context, Uri uri, String str, Handler handler, TransferListener transferListener) {
        return new HlsMediaSource.Factory(buildDataSourceFactory(context, str, transferListener)).createMediaSource(uri);
    }
}
