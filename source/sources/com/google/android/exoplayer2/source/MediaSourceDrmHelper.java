package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;
import com.google.android.exoplayer2.drm.HttpMediaDrmCallback;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;
import java.util.Map;

public final class MediaSourceDrmHelper {
    private HttpDataSource.Factory drmHttpDataSourceFactory;
    private String userAgent;

    public void setDrmHttpDataSourceFactory(HttpDataSource.Factory factory) {
        this.drmHttpDataSourceFactory = factory;
    }

    public void setDrmUserAgent(String str) {
        this.userAgent = str;
    }

    public DrmSessionManager create(MediaItem mediaItem) {
        Assertions.checkNotNull(mediaItem.playbackProperties);
        MediaItem.DrmConfiguration drmConfiguration = mediaItem.playbackProperties.drmConfiguration;
        if (drmConfiguration == null || drmConfiguration.licenseUri == null || Util.SDK_INT < 18) {
            return DrmSessionManager.CC.getDummyDrmSessionManager();
        }
        HttpDataSource.Factory factory = this.drmHttpDataSourceFactory;
        if (factory == null) {
            String str = this.userAgent;
            if (str == null) {
                str = ExoPlayerLibraryInfo.DEFAULT_USER_AGENT;
            }
            factory = new DefaultHttpDataSourceFactory(str);
        }
        HttpMediaDrmCallback httpMediaDrmCallback = new HttpMediaDrmCallback(((Uri) Util.castNonNull(drmConfiguration.licenseUri)).toString(), drmConfiguration.forceDefaultLicenseUri, factory);
        for (Map.Entry next : drmConfiguration.requestHeaders.entrySet()) {
            httpMediaDrmCallback.setKeyRequestProperty((String) next.getKey(), (String) next.getValue());
        }
        DefaultDrmSessionManager build = new DefaultDrmSessionManager.Builder().setUuidAndExoMediaDrmProvider(drmConfiguration.uuid, FrameworkMediaDrm.DEFAULT_PROVIDER).setMultiSession(drmConfiguration.multiSession).setPlayClearSamplesWithoutKeys(drmConfiguration.playClearContentWithoutKey).setUseDrmSessionsForClearContent(Ints.toArray(drmConfiguration.sessionForClearTypes)).build(httpMediaDrmCallback);
        build.setMode(0, drmConfiguration.getKeySetId());
        return build;
    }
}
