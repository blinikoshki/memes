package com.memes.plus.custom.player;

import android.content.Context;
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\b"}, mo26107d2 = {"Lcom/memes/plus/custom/player/VideoCache;", "", "()V", "simpleCache", "Lcom/google/android/exoplayer2/upstream/cache/SimpleCache;", "getSimpleCache", "context", "Landroid/content/Context;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: VideoCache.kt */
public final class VideoCache {
    public static final VideoCache INSTANCE = new VideoCache();
    /* access modifiers changed from: private */
    public static SimpleCache simpleCache;

    private VideoCache() {
    }

    public static final /* synthetic */ SimpleCache access$getSimpleCache$p(VideoCache videoCache) {
        SimpleCache simpleCache2 = simpleCache;
        if (simpleCache2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("simpleCache");
        }
        return simpleCache2;
    }

    public final SimpleCache getSimpleCache(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (simpleCache == null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            simpleCache = new SimpleCache(new File(applicationContext.getCacheDir(), "video-cache"), new LeastRecentlyUsedCacheEvictor(52428800));
        }
        SimpleCache simpleCache2 = simpleCache;
        if (simpleCache2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("simpleCache");
        }
        return simpleCache2;
    }
}
