package com.getstream.sdk.chat.utils.exomedia.core.exoplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.view.Surface;
import androidx.collection.ArrayMap;
import com.getstream.sdk.chat.utils.exomedia.ExoMedia;
import com.getstream.sdk.chat.utils.exomedia.core.listener.CaptionListener;
import com.getstream.sdk.chat.utils.exomedia.core.listener.ExoPlayerListener;
import com.getstream.sdk.chat.utils.exomedia.core.listener.MetadataListener;
import com.getstream.sdk.chat.utils.exomedia.core.renderer.RendererProvider;
import com.getstream.sdk.chat.utils.exomedia.listener.OnBufferUpdateListener;
import com.getstream.sdk.chat.utils.exomedia.util.Repeater;
import com.google.android.exoplayer2.C1844C;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.drm.MediaDrmCallbackException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;

public class ExoMediaPlayer implements Player.EventListener {
    private static final int BUFFER_REPEAT_DELAY = 1000;
    private static final String TAG = "ExoMediaPlayer";
    private static final int WAKE_LOCK_TIMEOUT = 1000;
    /* access modifiers changed from: private */
    public AnalyticsCollector analyticsCollector;
    /* access modifiers changed from: private */
    public int audioSessionId = 0;
    private DefaultBandwidthMeter bandwidthMeter;
    private Repeater bufferRepeater = new Repeater();
    /* access modifiers changed from: private */
    public OnBufferUpdateListener bufferUpdateListener;
    /* access modifiers changed from: private */
    public CaptionListener captionListener;
    private final Context context;
    /* access modifiers changed from: private */
    public MediaDrmCallback drmCallback;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<ExoPlayerListener> listeners = new CopyOnWriteArrayList<>();
    private TaggedLogger logger = ChatLogger.Companion.get(TAG);
    private final Handler mainHandler;
    private MediaSource mediaSource;
    /* access modifiers changed from: private */
    public MetadataListener metadataListener;
    private final ExoPlayer player;
    private boolean prepared = false;
    private List<Renderer> renderers;
    protected float requestedVolume = 1.0f;
    private StateStore stateStore = new StateStore((C17151) null);
    private final AtomicBoolean stopped = new AtomicBoolean();
    private Surface surface;
    private final DefaultTrackSelector trackSelector;
    private PowerManager.WakeLock wakeLock = null;

    public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
        Player.EventListener.CC.$default$onExperimentalOffloadSchedulingEnabledChanged(this, z);
    }

    public /* synthetic */ void onIsLoadingChanged(boolean z) {
        Player.EventListener.CC.$default$onIsLoadingChanged(this, z);
    }

    public /* synthetic */ void onIsPlayingChanged(boolean z) {
        Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
    }

    public /* synthetic */ void onLoadingChanged(boolean z) {
        Player.EventListener.CC.$default$onLoadingChanged(this, z);
    }

    public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
        Player.EventListener.CC.$default$onMediaItemTransition(this, mediaItem, i);
    }

    public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
        Player.EventListener.CC.$default$onPlayWhenReadyChanged(this, z, i);
    }

    public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        Player.EventListener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
    }

    public /* synthetic */ void onPlaybackStateChanged(int i) {
        Player.EventListener.CC.$default$onPlaybackStateChanged(this, i);
    }

    public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
        Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
    }

    public /* synthetic */ void onPositionDiscontinuity(int i) {
        Player.EventListener.CC.$default$onPositionDiscontinuity(this, i);
    }

    public /* synthetic */ void onRepeatModeChanged(int i) {
        Player.EventListener.CC.$default$onRepeatModeChanged(this, i);
    }

    public /* synthetic */ void onSeekProcessed() {
        Player.EventListener.CC.$default$onSeekProcessed(this);
    }

    public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
        Player.EventListener.CC.$default$onShuffleModeEnabledChanged(this, z);
    }

    public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
        Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
    }

    public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i) {
        Player.EventListener.CC.$default$onTimelineChanged(this, timeline, obj, i);
    }

    public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        Player.EventListener.CC.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
    }

    public ExoMediaPlayer(Context context2) {
        this.context = context2;
        this.bandwidthMeter = new DefaultBandwidthMeter.Builder(context2).build();
        this.bufferRepeater.setRepeaterDelay(1000);
        this.bufferRepeater.setRepeatListener(new BufferRepeatListener(this, (C17151) null));
        Handler handler = new Handler();
        this.mainHandler = handler;
        ComponentListener componentListener = new ComponentListener(this, (C17151) null);
        RendererProvider rendererProvider = new RendererProvider(context2, handler, componentListener, componentListener, componentListener, componentListener);
        rendererProvider.setDrmSessionManager(generateDrmSessionManager());
        this.renderers = rendererProvider.generate();
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(context2, (TrackSelection.Factory) new AdaptiveTrackSelection.Factory());
        this.trackSelector = defaultTrackSelector;
        ExoPlayer build = new ExoPlayer.Builder(context2, (Renderer[]) this.renderers.toArray(new Renderer[0])).setTrackSelector(defaultTrackSelector).setLoadControl(ExoMedia.Data.loadControl != null ? ExoMedia.Data.loadControl : new DefaultLoadControl()).setBandwidthMeter(this.bandwidthMeter).build();
        this.player = build;
        build.addListener(this);
        AnalyticsCollector analyticsCollector2 = new AnalyticsCollector(Clock.DEFAULT);
        this.analyticsCollector = analyticsCollector2;
        analyticsCollector2.setPlayer(build);
        build.addListener(this.analyticsCollector);
    }

    public void onPlayerStateChanged(boolean z, int i) {
        reportPlayerState();
    }

    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        Iterator<ExoPlayerListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onError(this, exoPlaybackException);
        }
    }

    public void setDrmCallback(MediaDrmCallback mediaDrmCallback) {
        this.drmCallback = mediaDrmCallback;
    }

    public void setUri(Uri uri) {
        setMediaSource(uri != null ? ExoMedia.Data.mediaSourceProvider.generate(this.context, this.mainHandler, uri, this.bandwidthMeter) : null);
    }

    public void setMediaSource(MediaSource mediaSource2) {
        MediaSource mediaSource3 = this.mediaSource;
        if (mediaSource3 != null) {
            mediaSource3.removeEventListener(this.analyticsCollector);
        }
        if (mediaSource2 != null) {
            mediaSource2.addEventListener(this.mainHandler, this.analyticsCollector);
        }
        this.mediaSource = mediaSource2;
        this.prepared = false;
        prepare();
    }

    public void addListener(ExoPlayerListener exoPlayerListener) {
        if (exoPlayerListener != null) {
            this.listeners.add(exoPlayerListener);
        }
    }

    public void removeListener(ExoPlayerListener exoPlayerListener) {
        if (exoPlayerListener != null) {
            this.listeners.remove(exoPlayerListener);
        }
    }

    public void setBufferUpdateListener(OnBufferUpdateListener onBufferUpdateListener) {
        this.bufferUpdateListener = onBufferUpdateListener;
        setBufferRepeaterStarted(onBufferUpdateListener != null);
    }

    public void setCaptionListener(CaptionListener captionListener2) {
        this.captionListener = captionListener2;
    }

    public void setMetadataListener(MetadataListener metadataListener2) {
        this.metadataListener = metadataListener2;
    }

    public Surface getSurface() {
        return this.surface;
    }

    public void setSurface(Surface surface2) {
        this.surface = surface2;
        sendMessage(2, 1, surface2, false);
    }

    public ExoPlayer getExoPlayer() {
        return this.player;
    }

    public BandwidthMeter getBandwidthMeter() {
        return this.bandwidthMeter;
    }

    public AnalyticsCollector getAnalyticsCollector() {
        return this.analyticsCollector;
    }

    public void addAnalyticsListener(AnalyticsListener analyticsListener) {
        this.analyticsCollector.addListener(analyticsListener);
    }

    public void removeAnalyticsListener(AnalyticsListener analyticsListener) {
        this.analyticsCollector.removeListener(analyticsListener);
    }

    public void clearSurface() {
        Surface surface2 = this.surface;
        if (surface2 != null) {
            surface2.release();
        }
        this.surface = null;
        sendMessage(2, 1, (Object) null, false);
    }

    @Deprecated
    public void blockingClearSurface() {
        clearSurface();
    }

    public Map<ExoMedia.RendererType, TrackGroupArray> getAvailableTracks() {
        if (getPlaybackState() == 1) {
            return null;
        }
        ArrayMap arrayMap = new ArrayMap();
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.trackSelector.getCurrentMappedTrackInfo();
        if (currentMappedTrackInfo == null) {
            return arrayMap;
        }
        ExoMedia.RendererType[] rendererTypeArr = {ExoMedia.RendererType.AUDIO, ExoMedia.RendererType.VIDEO, ExoMedia.RendererType.CLOSED_CAPTION, ExoMedia.RendererType.METADATA};
        for (int i = 0; i < 4; i++) {
            ExoMedia.RendererType rendererType = rendererTypeArr[i];
            ArrayList arrayList = new ArrayList();
            for (Integer intValue : getExoPlayerTracksInfo(rendererType, 0, currentMappedTrackInfo).rendererTrackIndexes) {
                TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(intValue.intValue());
                for (int i2 = 0; i2 < trackGroups.length; i2++) {
                    arrayList.add(trackGroups.get(i2));
                }
            }
            if (!arrayList.isEmpty()) {
                arrayMap.put(rendererType, new TrackGroupArray((TrackGroup[]) arrayList.toArray(new TrackGroup[arrayList.size()])));
            }
        }
        return arrayMap;
    }

    public int getSelectedTrackIndex(ExoMedia.RendererType rendererType) {
        return getSelectedTrackIndex(rendererType, 0);
    }

    public int getSelectedTrackIndex(ExoMedia.RendererType rendererType, int i) {
        TrackGroupArray trackGroupArray;
        DefaultTrackSelector.SelectionOverride selectionOverride;
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.trackSelector.getCurrentMappedTrackInfo();
        ExoPlayerRendererTracksInfo exoPlayerTracksInfo = getExoPlayerTracksInfo(rendererType, i, currentMappedTrackInfo);
        if (exoPlayerTracksInfo.rendererTrackIndex == -1) {
            trackGroupArray = null;
        } else {
            trackGroupArray = currentMappedTrackInfo.getTrackGroups(exoPlayerTracksInfo.rendererTrackIndex);
        }
        if (trackGroupArray == null || trackGroupArray.length == 0 || (selectionOverride = this.trackSelector.getParameters().getSelectionOverride(exoPlayerTracksInfo.rendererTrackIndex, trackGroupArray)) == null || selectionOverride.groupIndex != exoPlayerTracksInfo.rendererTrackGroupIndex || selectionOverride.length <= 0) {
            return -1;
        }
        return selectionOverride.tracks[0];
    }

    @Deprecated
    public void setSelectedTrack(ExoMedia.RendererType rendererType, int i) {
        setSelectedTrack(rendererType, 0, i);
    }

    public void setSelectedTrack(ExoMedia.RendererType rendererType, int i, int i2) {
        TrackGroup trackGroup;
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.trackSelector.getCurrentMappedTrackInfo();
        ExoPlayerRendererTracksInfo exoPlayerTracksInfo = getExoPlayerTracksInfo(rendererType, i, currentMappedTrackInfo);
        TrackGroupArray trackGroups = (exoPlayerTracksInfo.rendererTrackIndex == -1 || currentMappedTrackInfo == null) ? null : currentMappedTrackInfo.getTrackGroups(exoPlayerTracksInfo.rendererTrackIndex);
        if (trackGroups != null && trackGroups.length != 0 && trackGroups.length > exoPlayerTracksInfo.rendererTrackGroupIndex && (trackGroup = trackGroups.get(exoPlayerTracksInfo.rendererTrackGroupIndex)) != null && trackGroup.length > i2) {
            DefaultTrackSelector.ParametersBuilder buildUponParameters = this.trackSelector.buildUponParameters();
            for (Integer intValue : exoPlayerTracksInfo.rendererTrackIndexes) {
                int intValue2 = intValue.intValue();
                buildUponParameters.clearSelectionOverrides(intValue2);
                if (exoPlayerTracksInfo.rendererTrackIndex == intValue2) {
                    buildUponParameters.setSelectionOverride(intValue2, trackGroups, new DefaultTrackSelector.SelectionOverride(exoPlayerTracksInfo.rendererTrackGroupIndex, i2));
                    buildUponParameters.setRendererDisabled(intValue2, false);
                } else {
                    buildUponParameters.setRendererDisabled(intValue2, true);
                }
            }
            this.trackSelector.setParameters(buildUponParameters);
        }
    }

    public void clearSelectedTracks(ExoMedia.RendererType rendererType) {
        ExoPlayerRendererTracksInfo exoPlayerTracksInfo = getExoPlayerTracksInfo(rendererType, 0, this.trackSelector.getCurrentMappedTrackInfo());
        DefaultTrackSelector.ParametersBuilder buildUponParameters = this.trackSelector.buildUponParameters();
        for (Integer intValue : exoPlayerTracksInfo.rendererTrackIndexes) {
            int intValue2 = intValue.intValue();
            buildUponParameters.setRendererDisabled(intValue2, false).clearSelectionOverrides(intValue2);
        }
        this.trackSelector.setParameters(buildUponParameters);
    }

    public void setRendererEnabled(ExoMedia.RendererType rendererType, boolean z) {
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.trackSelector.getCurrentMappedTrackInfo();
        ExoPlayerRendererTracksInfo exoPlayerTracksInfo = getExoPlayerTracksInfo(rendererType, 0, currentMappedTrackInfo);
        if (!exoPlayerTracksInfo.rendererTrackIndexes.isEmpty()) {
            DefaultTrackSelector.ParametersBuilder buildUponParameters = this.trackSelector.buildUponParameters();
            boolean z2 = false;
            for (Integer intValue : exoPlayerTracksInfo.rendererTrackIndexes) {
                int intValue2 = intValue.intValue();
                if (!z) {
                    buildUponParameters.setRendererDisabled(intValue2, true);
                } else if (this.trackSelector.getParameters().getSelectionOverride(intValue2, currentMappedTrackInfo.getTrackGroups(intValue2)) != null) {
                    buildUponParameters.setRendererDisabled(intValue2, false);
                    z2 = true;
                }
            }
            if (z && !z2) {
                buildUponParameters.setRendererDisabled(exoPlayerTracksInfo.rendererTrackIndexes.get(0).intValue(), false);
            }
            this.trackSelector.setParameters(buildUponParameters);
        }
    }

    public boolean isRendererEnabled(ExoMedia.RendererType rendererType) {
        ExoPlayerRendererTracksInfo exoPlayerTracksInfo = getExoPlayerTracksInfo(rendererType, 0, this.trackSelector.getCurrentMappedTrackInfo());
        DefaultTrackSelector.Parameters parameters = this.trackSelector.getParameters();
        for (Integer intValue : exoPlayerTracksInfo.rendererTrackIndexes) {
            if (!parameters.getRendererDisabled(intValue.intValue())) {
                return true;
            }
        }
        return false;
    }

    public float getVolume() {
        return this.requestedVolume;
    }

    public void setVolume(float f) {
        this.requestedVolume = f;
        sendMessage(1, 2, Float.valueOf(f));
    }

    public void setAudioStreamType(int i) {
        int audioUsageForStreamType = Util.getAudioUsageForStreamType(i);
        sendMessage(1, 3, new AudioAttributes.Builder().setUsage(audioUsageForStreamType).setContentType(Util.getAudioContentTypeForStreamType(i)).build());
    }

    public void forcePrepare() {
        this.prepared = false;
    }

    public void prepare() {
        if (!this.prepared && this.mediaSource != null) {
            if (!this.renderers.isEmpty()) {
                this.player.stop();
            }
            this.stateStore.reset();
            this.player.prepare(this.mediaSource);
            this.prepared = true;
            this.stopped.set(false);
        }
    }

    public void stop() {
        if (!this.stopped.getAndSet(true)) {
            this.player.setPlayWhenReady(false);
            this.player.stop();
        }
    }

    public void seekTo(long j) {
        seekTo(j, false);
    }

    public void seekTo(long j, boolean z) {
        this.analyticsCollector.notifySeekStarted();
        if (z) {
            this.player.seekTo(j);
            StateStore stateStore2 = this.stateStore;
            stateStore2.setMostRecentState(stateStore2.isLastReportedPlayWhenReady(), 100);
            return;
        }
        Timeline currentTimeline = this.player.getCurrentTimeline();
        int windowCount = currentTimeline.getWindowCount();
        long j2 = 0;
        Timeline.Window window = new Timeline.Window();
        int i = 0;
        while (i < windowCount) {
            currentTimeline.getWindow(i, window);
            long durationMs = window.getDurationMs();
            if (j2 >= j || j > j2 + durationMs) {
                j2 += durationMs;
                i++;
            } else {
                this.player.seekTo(i, j - j2);
                StateStore stateStore3 = this.stateStore;
                stateStore3.setMostRecentState(stateStore3.isLastReportedPlayWhenReady(), 100);
                return;
            }
        }
        this.logger.logE("Unable to seek across windows, falling back to in-window seeking");
        this.player.seekTo(j);
        StateStore stateStore4 = this.stateStore;
        stateStore4.setMostRecentState(stateStore4.isLastReportedPlayWhenReady(), 100);
    }

    public boolean restart() {
        int playbackState = getPlaybackState();
        if (playbackState != 1 && playbackState != 4) {
            return false;
        }
        seekTo(0);
        setPlayWhenReady(true);
        forcePrepare();
        prepare();
        return true;
    }

    public void release() {
        setBufferRepeaterStarted(false);
        this.listeners.clear();
        MediaSource mediaSource2 = this.mediaSource;
        if (mediaSource2 != null) {
            mediaSource2.removeEventListener(this.analyticsCollector);
        }
        this.surface = null;
        this.player.release();
        stayAwake(false);
    }

    public int getPlaybackState() {
        return this.player.getPlaybackState();
    }

    public int getAudioSessionId() {
        return this.audioSessionId;
    }

    public boolean setPlaybackSpeed(float f) {
        this.player.setPlaybackParameters(new PlaybackParameters(f, 1.0f));
        return true;
    }

    public float getPlaybackSpeed() {
        return this.player.getPlaybackParameters().speed;
    }

    public long getCurrentPosition() {
        return getCurrentPosition(false);
    }

    public long getCurrentPosition(boolean z) {
        long currentPosition = this.player.getCurrentPosition();
        if (z) {
            return currentPosition;
        }
        Timeline currentTimeline = this.player.getCurrentTimeline();
        int min = Math.min(currentTimeline.getWindowCount() - 1, this.player.getCurrentWindowIndex());
        long j = 0;
        Timeline.Window window = new Timeline.Window();
        for (int i = 0; i < min; i++) {
            currentTimeline.getWindow(i, window);
            j += window.getDurationMs();
        }
        return j + currentPosition;
    }

    public long getDuration() {
        return this.player.getDuration();
    }

    public int getBufferedPercentage() {
        return this.player.getBufferedPercentage();
    }

    public WindowInfo getWindowInfo() {
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        int currentWindowIndex = this.player.getCurrentWindowIndex();
        return new WindowInfo(this.player.getPreviousWindowIndex(), currentWindowIndex, this.player.getNextWindowIndex(), currentTimeline.getWindow(currentWindowIndex, new Timeline.Window(), true));
    }

    public boolean getPlayWhenReady() {
        return this.player.getPlayWhenReady();
    }

    public void setPlayWhenReady(boolean z) {
        this.player.setPlayWhenReady(z);
        stayAwake(z);
    }

    public void setWakeMode(Context context2, int i) {
        boolean z;
        PowerManager.WakeLock wakeLock2 = this.wakeLock;
        if (wakeLock2 != null) {
            if (wakeLock2.isHeld()) {
                z = true;
                this.wakeLock.release();
            } else {
                z = false;
            }
            this.wakeLock = null;
        } else {
            z = false;
        }
        if (context2.getPackageManager().checkPermission("android.permission.WAKE_LOCK", context2.getPackageName()) == 0) {
            PowerManager powerManager = (PowerManager) context2.getSystemService("power");
            if (powerManager != null) {
                PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(i | 536870912, ExoMediaPlayer.class.getName());
                this.wakeLock = newWakeLock;
                newWakeLock.setReferenceCounted(false);
            } else {
                this.logger.logE("Unable to acquire WAKE_LOCK due to a null power manager");
            }
        } else {
            this.logger.logW("Unable to acquire WAKE_LOCK due to missing manifest permission");
        }
        stayAwake(z);
    }

    public void setRepeatMode(int i) {
        this.player.setRepeatMode(i);
    }

    /* renamed from: com.getstream.sdk.chat.utils.exomedia.core.exoplayer.ExoMediaPlayer$1 */
    static /* synthetic */ class C17151 {

        /* renamed from: $SwitchMap$com$getstream$sdk$chat$utils$exomedia$ExoMedia$RendererType */
        static final /* synthetic */ int[] f164xc1dc4ba1;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.getstream.sdk.chat.utils.exomedia.ExoMedia$RendererType[] r0 = com.getstream.sdk.chat.utils.exomedia.ExoMedia.RendererType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f164xc1dc4ba1 = r0
                com.getstream.sdk.chat.utils.exomedia.ExoMedia$RendererType r1 = com.getstream.sdk.chat.utils.exomedia.ExoMedia.RendererType.AUDIO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f164xc1dc4ba1     // Catch:{ NoSuchFieldError -> 0x001d }
                com.getstream.sdk.chat.utils.exomedia.ExoMedia$RendererType r1 = com.getstream.sdk.chat.utils.exomedia.ExoMedia.RendererType.VIDEO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f164xc1dc4ba1     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.getstream.sdk.chat.utils.exomedia.ExoMedia$RendererType r1 = com.getstream.sdk.chat.utils.exomedia.ExoMedia.RendererType.CLOSED_CAPTION     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f164xc1dc4ba1     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.getstream.sdk.chat.utils.exomedia.ExoMedia$RendererType r1 = com.getstream.sdk.chat.utils.exomedia.ExoMedia.RendererType.METADATA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.utils.exomedia.core.exoplayer.ExoMediaPlayer.C17151.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public int getExoPlayerTrackType(ExoMedia.RendererType rendererType) {
        int i = C17151.f164xc1dc4ba1[rendererType.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        return -1;
                    }
                }
            }
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public ExoMedia.RendererType getExoMediaRendererType(int i) {
        if (i == 1) {
            return ExoMedia.RendererType.AUDIO;
        }
        if (i == 2) {
            return ExoMedia.RendererType.VIDEO;
        }
        if (i == 3) {
            return ExoMedia.RendererType.CLOSED_CAPTION;
        }
        if (i != 4) {
            return null;
        }
        return ExoMedia.RendererType.METADATA;
    }

    /* access modifiers changed from: protected */
    public ExoPlayerRendererTracksInfo getExoPlayerTracksInfo(ExoMedia.RendererType rendererType, int i, MappingTrackSelector.MappedTrackInfo mappedTrackInfo) {
        int i2;
        ArrayList arrayList = new ArrayList();
        int i3 = -1;
        if (mappedTrackInfo != null) {
            int i4 = 0;
            int i5 = -1;
            i2 = -1;
            for (int i6 = 0; i6 < mappedTrackInfo.getRendererCount(); i6++) {
                if (rendererType == getExoMediaRendererType(mappedTrackInfo.getRendererType(i6))) {
                    arrayList.add(Integer.valueOf(i6));
                    TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i6);
                    if (trackGroups.length + i4 <= i) {
                        i4 += trackGroups.length;
                    } else if (i5 == -1) {
                        i2 = i - i4;
                        i5 = i6;
                    }
                }
            }
            i3 = i5;
        } else {
            i2 = -1;
        }
        return new ExoPlayerRendererTracksInfo(arrayList, i3, i2);
    }

    /* access modifiers changed from: protected */
    public void sendMessage(int i, int i2, Object obj) {
        sendMessage(i, i2, obj, false);
    }

    /* access modifiers changed from: protected */
    public void sendMessage(int i, int i2, Object obj, boolean z) {
        if (!this.renderers.isEmpty()) {
            ArrayList<PlayerMessage> arrayList = new ArrayList<>();
            for (Renderer next : this.renderers) {
                if (next.getTrackType() == i) {
                    arrayList.add(this.player.createMessage(next).setType(i2).setPayload(obj));
                }
            }
            if (z) {
                blockingSendMessages(arrayList);
                return;
            }
            for (PlayerMessage send : arrayList) {
                send.send();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void blockingSendMessages(List<PlayerMessage> list) {
        boolean z = false;
        for (PlayerMessage next : list) {
            boolean z2 = true;
            while (z2) {
                try {
                    next.blockUntilDelivered();
                    z2 = false;
                } catch (InterruptedException unused) {
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    /* access modifiers changed from: protected */
    public void stayAwake(boolean z) {
        PowerManager.WakeLock wakeLock2 = this.wakeLock;
        if (wakeLock2 != null) {
            if (z && !wakeLock2.isHeld()) {
                this.wakeLock.acquire(1000);
            } else if (!z && this.wakeLock.isHeld()) {
                this.wakeLock.release();
            }
        }
    }

    /* access modifiers changed from: protected */
    public DrmSessionManager generateDrmSessionManager() {
        if (Build.VERSION.SDK_INT < 18) {
            return null;
        }
        try {
            return new DefaultDrmSessionManager.Builder().setUuidAndExoMediaDrmProvider(C1844C.WIDEVINE_UUID, FrameworkMediaDrm.DEFAULT_PROVIDER).build(new DelegatedMediaDrmCallback(this, (C17151) null));
        } catch (Exception e) {
            this.logger.logE((Throwable) e);
            return null;
        }
    }

    private void reportPlayerState() {
        boolean playWhenReady = this.player.getPlayWhenReady();
        int playbackState = getPlaybackState();
        int state = this.stateStore.getState(playWhenReady, playbackState);
        if (state != this.stateStore.getMostRecentState()) {
            this.stateStore.setMostRecentState(playWhenReady, playbackState);
            if (state == 3) {
                setBufferRepeaterStarted(true);
            } else if (state == 1 || state == 4) {
                setBufferRepeaterStarted(false);
            }
            boolean matchesHistory = this.stateStore.matchesHistory(new int[]{100, 2, 3}, true) | this.stateStore.matchesHistory(new int[]{2, 100, 3}, true) | this.stateStore.matchesHistory(new int[]{100, 3, 2, 3}, true);
            Iterator<ExoPlayerListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                ExoPlayerListener next = it.next();
                next.onStateChanged(playWhenReady, playbackState);
                if (matchesHistory) {
                    next.onSeekComplete();
                }
            }
        }
    }

    private void setBufferRepeaterStarted(boolean z) {
        if (!z || this.bufferUpdateListener == null) {
            this.bufferRepeater.stop();
        } else {
            this.bufferRepeater.start();
        }
    }

    private static class StateStore {
        public static final int FLAG_PLAY_WHEN_READY = -268435456;
        public static final int STATE_SEEKING = 100;
        private int[] prevStates;

        public int getState(boolean z, int i) {
            return (z ? FLAG_PLAY_WHEN_READY : 0) | i;
        }

        private StateStore() {
            this.prevStates = new int[]{1, 1, 1, 1};
        }

        /* synthetic */ StateStore(C17151 r1) {
            this();
        }

        public void reset() {
            int i = 0;
            while (true) {
                int[] iArr = this.prevStates;
                if (i < iArr.length) {
                    iArr[i] = 1;
                    i++;
                } else {
                    return;
                }
            }
        }

        public void setMostRecentState(boolean z, int i) {
            int state = getState(z, i);
            int[] iArr = this.prevStates;
            if (iArr[3] != state) {
                iArr[0] = iArr[1];
                iArr[1] = iArr[2];
                iArr[2] = iArr[3];
                iArr[3] = i;
            }
        }

        public int getMostRecentState() {
            return this.prevStates[3];
        }

        public boolean isLastReportedPlayWhenReady() {
            return (this.prevStates[3] & FLAG_PLAY_WHEN_READY) != 0;
        }

        public boolean matchesHistory(int[] iArr, boolean z) {
            int i = z ? 268435455 : -1;
            int length = this.prevStates.length - iArr.length;
            int i2 = length;
            boolean z2 = true;
            while (true) {
                int[] iArr2 = this.prevStates;
                if (i2 >= iArr2.length) {
                    return z2;
                }
                z2 &= (iArr2[i2] & i) == (iArr[i2 - length] & i);
                i2++;
            }
        }
    }

    class ExoPlayerRendererTracksInfo {
        final int rendererTrackGroupIndex;
        final int rendererTrackIndex;
        final List<Integer> rendererTrackIndexes;

        public ExoPlayerRendererTracksInfo(List<Integer> list, int i, int i2) {
            this.rendererTrackIndexes = Collections.unmodifiableList(list);
            this.rendererTrackIndex = i;
            this.rendererTrackGroupIndex = i2;
        }
    }

    private class BufferRepeatListener implements Repeater.RepeatListener {
        private BufferRepeatListener() {
        }

        /* synthetic */ BufferRepeatListener(ExoMediaPlayer exoMediaPlayer, C17151 r2) {
            this();
        }

        public void onRepeat() {
            if (ExoMediaPlayer.this.bufferUpdateListener != null) {
                ExoMediaPlayer.this.bufferUpdateListener.onBufferingUpdate(ExoMediaPlayer.this.getBufferedPercentage());
            }
        }
    }

    private class DelegatedMediaDrmCallback implements MediaDrmCallback {
        private DelegatedMediaDrmCallback() {
        }

        /* synthetic */ DelegatedMediaDrmCallback(ExoMediaPlayer exoMediaPlayer, C17151 r2) {
            this();
        }

        public byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws MediaDrmCallbackException {
            return ExoMediaPlayer.this.drmCallback != null ? ExoMediaPlayer.this.drmCallback.executeProvisionRequest(uuid, provisionRequest) : new byte[0];
        }

        public byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws MediaDrmCallbackException {
            return ExoMediaPlayer.this.drmCallback != null ? ExoMediaPlayer.this.drmCallback.executeKeyRequest(uuid, keyRequest) : new byte[0];
        }
    }

    private class ComponentListener implements VideoRendererEventListener, AudioRendererEventListener, TextOutput, MetadataOutput {
        public /* synthetic */ void onAudioPositionAdvancing(long j) {
            AudioRendererEventListener.CC.$default$onAudioPositionAdvancing(this, j);
        }

        public /* synthetic */ void onAudioUnderrun(int i, long j, long j2) {
            AudioRendererEventListener.CC.$default$onAudioUnderrun(this, i, j, j2);
        }

        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
            AudioRendererEventListener.CC.$default$onSkipSilenceEnabledChanged(this, z);
        }

        public /* synthetic */ void onVideoFrameProcessingOffset(long j, int i) {
            VideoRendererEventListener.CC.$default$onVideoFrameProcessingOffset(this, j, i);
        }

        private ComponentListener() {
        }

        /* synthetic */ ComponentListener(ExoMediaPlayer exoMediaPlayer, C17151 r2) {
            this();
        }

        public void onAudioEnabled(DecoderCounters decoderCounters) {
            ExoMediaPlayer.this.analyticsCollector.onAudioEnabled(decoderCounters);
        }

        public void onAudioDisabled(DecoderCounters decoderCounters) {
            int unused = ExoMediaPlayer.this.audioSessionId = 0;
            ExoMediaPlayer.this.analyticsCollector.onAudioDisabled(decoderCounters);
        }

        public void onAudioSessionId(int i) {
            int unused = ExoMediaPlayer.this.audioSessionId = i;
            ExoMediaPlayer.this.analyticsCollector.onAudioSessionId(i);
        }

        public void onAudioDecoderInitialized(String str, long j, long j2) {
            ExoMediaPlayer.this.analyticsCollector.onAudioDecoderInitialized(str, j, j2);
        }

        public void onAudioInputFormatChanged(Format format) {
            ExoMediaPlayer.this.analyticsCollector.onAudioInputFormatChanged(format);
        }

        public void onVideoEnabled(DecoderCounters decoderCounters) {
            ExoMediaPlayer.this.analyticsCollector.onVideoEnabled(decoderCounters);
        }

        public void onVideoDisabled(DecoderCounters decoderCounters) {
            ExoMediaPlayer.this.analyticsCollector.onVideoDisabled(decoderCounters);
        }

        public void onVideoDecoderInitialized(String str, long j, long j2) {
            ExoMediaPlayer.this.analyticsCollector.onVideoDecoderInitialized(str, j, j2);
        }

        public void onVideoInputFormatChanged(Format format) {
            ExoMediaPlayer.this.analyticsCollector.onVideoInputFormatChanged(format);
        }

        public void onDroppedFrames(int i, long j) {
            ExoMediaPlayer.this.analyticsCollector.onDroppedFrames(i, j);
        }

        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            Iterator it = ExoMediaPlayer.this.listeners.iterator();
            while (it.hasNext()) {
                ((ExoPlayerListener) it.next()).onVideoSizeChanged(i, i2, i3, f);
            }
            ExoMediaPlayer.this.analyticsCollector.onVideoSizeChanged(i, i2, i3, f);
        }

        public void onRenderedFirstFrame(Surface surface) {
            ExoMediaPlayer.this.analyticsCollector.onRenderedFirstFrame(surface);
        }

        public void onMetadata(Metadata metadata) {
            if (ExoMediaPlayer.this.metadataListener != null) {
                ExoMediaPlayer.this.metadataListener.onMetadata(metadata);
            }
            ExoMediaPlayer.this.analyticsCollector.onMetadata(metadata);
        }

        public void onCues(List<Cue> list) {
            if (ExoMediaPlayer.this.captionListener != null) {
                ExoMediaPlayer.this.captionListener.onCues(list);
            }
        }
    }
}
