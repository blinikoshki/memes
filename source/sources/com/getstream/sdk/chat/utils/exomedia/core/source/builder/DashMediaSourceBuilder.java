package com.getstream.sdk.chat.utils.exomedia.core.source.builder;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.upstream.TransferListener;

public class DashMediaSourceBuilder extends MediaSourceBuilder {
    public MediaSource build(Context context, Uri uri, String str, Handler handler, TransferListener transferListener) {
        return new DashMediaSource.Factory(new DefaultDashChunkSource.Factory(buildDataSourceFactory(context, str, transferListener)), buildDataSourceFactory(context, str, (TransferListener) null)).createMediaSource(uri);
    }
}
