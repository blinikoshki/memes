package com.memes.plus.custom.player;

import android.content.Context;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import com.memes.plus.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/plus/custom/player/LocalCacheDataSourceFactory;", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cacheDataSink", "Lcom/google/android/exoplayer2/upstream/cache/CacheDataSink;", "defaultDataSourceFactory", "Lcom/google/android/exoplayer2/upstream/DefaultDataSourceFactory;", "fileDataSource", "Lcom/google/android/exoplayer2/upstream/FileDataSource;", "simpleCache", "Lcom/google/android/exoplayer2/upstream/cache/SimpleCache;", "createDataSource", "Lcom/google/android/exoplayer2/upstream/DataSource;", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: LocalCacheDataSourceFactory.kt */
public final class LocalCacheDataSourceFactory implements DataSource.Factory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long MAX_VIDEO_CACHE_SIZE = 52428800;
    public static final long MAX_VIDEO_FILE_SIZE = 52428800;
    private final CacheDataSink cacheDataSink;
    private final Context context;
    private final DefaultDataSourceFactory defaultDataSourceFactory;
    private final FileDataSource fileDataSource = new FileDataSource();
    private final SimpleCache simpleCache;

    public LocalCacheDataSourceFactory(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        SimpleCache simpleCache2 = VideoCache.INSTANCE.getSimpleCache(context2);
        this.simpleCache = simpleCache2;
        this.cacheDataSink = new CacheDataSink(simpleCache2, 52428800);
        this.defaultDataSourceFactory = new DefaultDataSourceFactory(context2, (TransferListener) new DefaultBandwidthMeter(), (DataSource.Factory) new DefaultHttpDataSourceFactory(BuildConfig.APPLICATION_ID));
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/plus/custom/player/LocalCacheDataSourceFactory$Companion;", "", "()V", "MAX_VIDEO_CACHE_SIZE", "", "MAX_VIDEO_FILE_SIZE", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: LocalCacheDataSourceFactory.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DataSource createDataSource() {
        return new CacheDataSource(this.simpleCache, this.defaultDataSourceFactory.createDataSource(), this.fileDataSource, this.cacheDataSink, 2, (CacheDataSource.EventListener) null);
    }
}
