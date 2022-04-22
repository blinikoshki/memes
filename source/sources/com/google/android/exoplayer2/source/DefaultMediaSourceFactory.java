package com.google.android.exoplayer2.source;

import android.content.Context;
import android.net.Uri;
import android.util.SparseArray;
import com.google.android.exoplayer2.C1844C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.SingleSampleMediaSource;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.List;

public final class DefaultMediaSourceFactory implements MediaSourceFactory {
    private static final String TAG = "DefaultMediaSourceFactory";
    private AdsLoader.AdViewProvider adViewProvider;
    private AdsLoaderProvider adsLoaderProvider;
    private final DataSource.Factory dataSourceFactory;
    private DrmSessionManager drmSessionManager;
    private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final MediaSourceDrmHelper mediaSourceDrmHelper;
    private final SparseArray<MediaSourceFactory> mediaSourceFactories;
    private List<StreamKey> streamKeys;
    private final int[] supportedTypes;

    public interface AdsLoaderProvider {
        AdsLoader getAdsLoader(Uri uri);
    }

    public /* synthetic */ MediaSource createMediaSource(Uri uri) {
        return MediaSourceFactory.CC.$default$createMediaSource(this, uri);
    }

    public DefaultMediaSourceFactory(Context context) {
        this((DataSource.Factory) new DefaultDataSourceFactory(context));
    }

    public DefaultMediaSourceFactory(Context context, ExtractorsFactory extractorsFactory) {
        this((DataSource.Factory) new DefaultDataSourceFactory(context), extractorsFactory);
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory) {
        this(factory, (ExtractorsFactory) new DefaultExtractorsFactory());
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        this.dataSourceFactory = factory;
        this.mediaSourceDrmHelper = new MediaSourceDrmHelper();
        SparseArray<MediaSourceFactory> loadDelegates = loadDelegates(factory, extractorsFactory);
        this.mediaSourceFactories = loadDelegates;
        this.supportedTypes = new int[loadDelegates.size()];
        for (int i = 0; i < this.mediaSourceFactories.size(); i++) {
            this.supportedTypes[i] = this.mediaSourceFactories.keyAt(i);
        }
    }

    public DefaultMediaSourceFactory setAdsLoaderProvider(AdsLoaderProvider adsLoaderProvider2) {
        this.adsLoaderProvider = adsLoaderProvider2;
        return this;
    }

    public DefaultMediaSourceFactory setAdViewProvider(AdsLoader.AdViewProvider adViewProvider2) {
        this.adViewProvider = adViewProvider2;
        return this;
    }

    public DefaultMediaSourceFactory setDrmHttpDataSourceFactory(HttpDataSource.Factory factory) {
        this.mediaSourceDrmHelper.setDrmHttpDataSourceFactory(factory);
        return this;
    }

    public DefaultMediaSourceFactory setDrmUserAgent(String str) {
        this.mediaSourceDrmHelper.setDrmUserAgent(str);
        return this;
    }

    public DefaultMediaSourceFactory setDrmSessionManager(DrmSessionManager drmSessionManager2) {
        this.drmSessionManager = drmSessionManager2;
        return this;
    }

    public DefaultMediaSourceFactory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy2) {
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        return this;
    }

    @Deprecated
    public DefaultMediaSourceFactory setStreamKeys(List<StreamKey> list) {
        if (list == null || list.isEmpty()) {
            list = null;
        }
        this.streamKeys = list;
        return this;
    }

    public int[] getSupportedTypes() {
        int[] iArr = this.supportedTypes;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public MediaSource createMediaSource(MediaItem mediaItem) {
        List<StreamKey> list;
        Assertions.checkNotNull(mediaItem.playbackProperties);
        int inferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(mediaItem.playbackProperties.uri, mediaItem.playbackProperties.mimeType);
        MediaSourceFactory mediaSourceFactory = this.mediaSourceFactories.get(inferContentTypeForUriAndMimeType);
        StringBuilder sb = new StringBuilder(68);
        sb.append("No suitable media source factory found for content type: ");
        sb.append(inferContentTypeForUriAndMimeType);
        Assertions.checkNotNull(mediaSourceFactory, sb.toString());
        DrmSessionManager drmSessionManager2 = this.drmSessionManager;
        if (drmSessionManager2 == null) {
            drmSessionManager2 = this.mediaSourceDrmHelper.create(mediaItem);
        }
        mediaSourceFactory.setDrmSessionManager(drmSessionManager2);
        if (!mediaItem.playbackProperties.streamKeys.isEmpty()) {
            list = mediaItem.playbackProperties.streamKeys;
        } else {
            list = this.streamKeys;
        }
        mediaSourceFactory.setStreamKeys(list);
        mediaSourceFactory.setLoadErrorHandlingPolicy(this.loadErrorHandlingPolicy);
        MediaSource createMediaSource = mediaSourceFactory.createMediaSource(mediaItem);
        List<MediaItem.Subtitle> list2 = mediaItem.playbackProperties.subtitles;
        if (!list2.isEmpty()) {
            MediaSource[] mediaSourceArr = new MediaSource[(list2.size() + 1)];
            int i = 0;
            mediaSourceArr[0] = createMediaSource;
            SingleSampleMediaSource.Factory factory = new SingleSampleMediaSource.Factory(this.dataSourceFactory);
            while (i < list2.size()) {
                int i2 = i + 1;
                mediaSourceArr[i2] = factory.createMediaSource(list2.get(i), C1844C.TIME_UNSET);
                i = i2;
            }
            createMediaSource = new MergingMediaSource(mediaSourceArr);
        }
        return maybeWrapWithAdsMediaSource(mediaItem, maybeClipMediaSource(mediaItem, createMediaSource));
    }

    private static MediaSource maybeClipMediaSource(MediaItem mediaItem, MediaSource mediaSource) {
        if (mediaItem.clippingProperties.startPositionMs == 0 && mediaItem.clippingProperties.endPositionMs == Long.MIN_VALUE && !mediaItem.clippingProperties.relativeToDefaultPosition) {
            return mediaSource;
        }
        return new ClippingMediaSource(mediaSource, C1844C.msToUs(mediaItem.clippingProperties.startPositionMs), C1844C.msToUs(mediaItem.clippingProperties.endPositionMs), !mediaItem.clippingProperties.startsAtKeyFrame, mediaItem.clippingProperties.relativeToLiveWindow, mediaItem.clippingProperties.relativeToDefaultPosition);
    }

    private MediaSource maybeWrapWithAdsMediaSource(MediaItem mediaItem, MediaSource mediaSource) {
        Assertions.checkNotNull(mediaItem.playbackProperties);
        Uri uri = mediaItem.playbackProperties.adTagUri;
        if (uri == null) {
            return mediaSource;
        }
        AdsLoaderProvider adsLoaderProvider2 = this.adsLoaderProvider;
        AdsLoader.AdViewProvider adViewProvider2 = this.adViewProvider;
        if (adsLoaderProvider2 == null || adViewProvider2 == null) {
            Log.m358w(TAG, "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
            return mediaSource;
        }
        AdsLoader adsLoader = adsLoaderProvider2.getAdsLoader(uri);
        if (adsLoader == null) {
            Log.m358w(TAG, "Playing media without ads. No AdsLoader for provided adTagUri");
            return mediaSource;
        }
        return new AdsMediaSource(mediaSource, new DataSpec(uri), (MediaSourceFactory) this, adsLoader, adViewProvider2);
    }

    private static SparseArray<MediaSourceFactory> loadDelegates(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        SparseArray<MediaSourceFactory> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, (MediaSourceFactory) Class.forName("com.google.android.exoplayer2.source.dash.DashMediaSource$Factory").asSubclass(MediaSourceFactory.class).getConstructor(new Class[]{DataSource.Factory.class}).newInstance(new Object[]{factory}));
        } catch (Exception unused) {
        }
        try {
            sparseArray.put(1, (MediaSourceFactory) Class.forName("com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory").asSubclass(MediaSourceFactory.class).getConstructor(new Class[]{DataSource.Factory.class}).newInstance(new Object[]{factory}));
        } catch (Exception unused2) {
        }
        try {
            sparseArray.put(2, (MediaSourceFactory) Class.forName("com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory").asSubclass(MediaSourceFactory.class).getConstructor(new Class[]{DataSource.Factory.class}).newInstance(new Object[]{factory}));
        } catch (Exception unused3) {
        }
        sparseArray.put(3, new ProgressiveMediaSource.Factory(factory, extractorsFactory));
        return sparseArray;
    }
}
