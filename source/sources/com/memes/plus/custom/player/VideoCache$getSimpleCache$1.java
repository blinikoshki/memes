package com.memes.plus.custom.player;

import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: VideoCache.kt */
final /* synthetic */ class VideoCache$getSimpleCache$1 extends MutablePropertyReference0Impl {
    VideoCache$getSimpleCache$1(VideoCache videoCache) {
        super(videoCache, VideoCache.class, "simpleCache", "getSimpleCache()Lcom/google/android/exoplayer2/upstream/cache/SimpleCache;", 0);
    }

    public Object get() {
        return VideoCache.access$getSimpleCache$p((VideoCache) this.receiver);
    }

    public void set(Object obj) {
        VideoCache.simpleCache = (SimpleCache) obj;
    }
}
