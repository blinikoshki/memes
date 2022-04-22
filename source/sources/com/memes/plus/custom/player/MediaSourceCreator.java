package com.memes.plus.custom.player;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/custom/player/MediaSourceCreator;", "", "()V", "buildMediaSource", "Lcom/google/android/exoplayer2/source/MediaSource;", "context", "Landroid/content/Context;", "mediaUri", "Landroid/net/Uri;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaSourceCreator.kt */
public final class MediaSourceCreator {
    public static final MediaSourceCreator INSTANCE = new MediaSourceCreator();

    private MediaSourceCreator() {
    }

    public final MediaSource buildMediaSource(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "mediaUri");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        ProgressiveMediaSource createMediaSource = new ProgressiveMediaSource.Factory(new LocalCacheDataSourceFactory(applicationContext)).createMediaSource(uri);
        Intrinsics.checkNotNullExpressionValue(createMediaSource, "ProgressiveMediaSource\n …eateMediaSource(mediaUri)");
        return createMediaSource;
    }
}
