package com.getstream.sdk.chat.utils.exomedia.core.source.builder;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.getstream.sdk.chat.utils.exomedia.ExoMedia;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.TransferListener;

public abstract class MediaSourceBuilder {
    public abstract MediaSource build(Context context, Uri uri, String str, Handler handler, TransferListener transferListener);

    /* access modifiers changed from: protected */
    public DataSource.Factory buildDataSourceFactory(Context context, String str, TransferListener transferListener) {
        ExoMedia.DataSourceFactoryProvider dataSourceFactoryProvider = ExoMedia.Data.dataSourceFactoryProvider;
        DataSource.Factory factory = null;
        DataSource.Factory provide = dataSourceFactoryProvider != null ? dataSourceFactoryProvider.provide(str, transferListener) : null;
        if (provide == null) {
            ExoMedia.HttpDataSourceFactoryProvider httpDataSourceFactoryProvider = ExoMedia.Data.httpDataSourceFactoryProvider;
            if (httpDataSourceFactoryProvider != null) {
                factory = httpDataSourceFactoryProvider.provide(str, transferListener);
            }
            provide = factory;
        }
        if (provide == null) {
            provide = new DefaultHttpDataSourceFactory(str, transferListener);
        }
        return new DefaultDataSourceFactory(context, transferListener, provide);
    }
}
