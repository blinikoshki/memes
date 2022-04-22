package com.google.android.exoplayer2.analytics;

import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.C1844C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager;
import com.google.android.exoplayer2.analytics.PlaybackStats;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class PlaybackStatsListener implements AnalyticsListener, PlaybackSessionManager.Listener {
    private String activeAdPlayback;
    private String activeContentPlayback;
    private final Callback callback;
    private PlaybackStats finishedPlaybackStats = PlaybackStats.EMPTY;
    private boolean isSuppressed;
    private final boolean keepHistory;
    private boolean onSeekStartedCalled;
    private final Timeline.Period period = new Timeline.Period();
    private boolean playWhenReady = false;
    private float playbackSpeed = 1.0f;
    private int playbackState = 1;
    private final Map<String, PlaybackStatsTracker> playbackStatsTrackers = new HashMap();
    private final PlaybackSessionManager sessionManager;
    private final Map<String, AnalyticsListener.EventTime> sessionStartEventTimes = new HashMap();

    public interface Callback {
        void onPlaybackStatsReady(AnalyticsListener.EventTime eventTime, PlaybackStats playbackStats);
    }

    public /* synthetic */ void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        AnalyticsListener.CC.$default$onAudioAttributesChanged(this, eventTime, audioAttributes);
    }

    public /* synthetic */ void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j) {
        AnalyticsListener.CC.$default$onAudioDecoderInitialized(this, eventTime, str, j);
    }

    public /* synthetic */ void onAudioDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        AnalyticsListener.CC.$default$onAudioDisabled(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void onAudioEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        AnalyticsListener.CC.$default$onAudioEnabled(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
        AnalyticsListener.CC.$default$onAudioInputFormatChanged(this, eventTime, format);
    }

    public /* synthetic */ void onAudioPositionAdvancing(AnalyticsListener.EventTime eventTime, long j) {
        AnalyticsListener.CC.$default$onAudioPositionAdvancing(this, eventTime, j);
    }

    public /* synthetic */ void onAudioSessionId(AnalyticsListener.EventTime eventTime, int i) {
        AnalyticsListener.CC.$default$onAudioSessionId(this, eventTime, i);
    }

    public /* synthetic */ void onDecoderDisabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
        AnalyticsListener.CC.$default$onDecoderDisabled(this, eventTime, i, decoderCounters);
    }

    public /* synthetic */ void onDecoderEnabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
        AnalyticsListener.CC.$default$onDecoderEnabled(this, eventTime, i, decoderCounters);
    }

    public /* synthetic */ void onDecoderInitialized(AnalyticsListener.EventTime eventTime, int i, String str, long j) {
        AnalyticsListener.CC.$default$onDecoderInitialized(this, eventTime, i, str, j);
    }

    public /* synthetic */ void onDecoderInputFormatChanged(AnalyticsListener.EventTime eventTime, int i, Format format) {
        AnalyticsListener.CC.$default$onDecoderInputFormatChanged(this, eventTime, i, format);
    }

    public /* synthetic */ void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener.CC.$default$onDrmKeysLoaded(this, eventTime);
    }

    public /* synthetic */ void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener.CC.$default$onDrmKeysRemoved(this, eventTime);
    }

    public /* synthetic */ void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener.CC.$default$onDrmKeysRestored(this, eventTime);
    }

    public /* synthetic */ void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener.CC.$default$onDrmSessionAcquired(this, eventTime);
    }

    public /* synthetic */ void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener.CC.$default$onDrmSessionReleased(this, eventTime);
    }

    public /* synthetic */ void onIsLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        AnalyticsListener.CC.$default$onIsLoadingChanged(this, eventTime, z);
    }

    public /* synthetic */ void onIsPlayingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        AnalyticsListener.CC.$default$onIsPlayingChanged(this, eventTime, z);
    }

    public /* synthetic */ void onLoadCanceled(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.CC.$default$onLoadCanceled(this, eventTime, loadEventInfo, mediaLoadData);
    }

    public /* synthetic */ void onLoadCompleted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.CC.$default$onLoadCompleted(this, eventTime, loadEventInfo, mediaLoadData);
    }

    public /* synthetic */ void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        AnalyticsListener.CC.$default$onLoadingChanged(this, eventTime, z);
    }

    public /* synthetic */ void onMediaItemTransition(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i) {
        AnalyticsListener.CC.$default$onMediaItemTransition(this, eventTime, mediaItem, i);
    }

    public /* synthetic */ void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        AnalyticsListener.CC.$default$onMetadata(this, eventTime, metadata);
    }

    public /* synthetic */ void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
        AnalyticsListener.CC.$default$onPlayerStateChanged(this, eventTime, z, i);
    }

    public /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Surface surface) {
        AnalyticsListener.CC.$default$onRenderedFirstFrame(this, eventTime, surface);
    }

    public /* synthetic */ void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i) {
        AnalyticsListener.CC.$default$onRepeatModeChanged(this, eventTime, i);
    }

    public /* synthetic */ void onSeekProcessed(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener.CC.$default$onSeekProcessed(this, eventTime);
    }

    public /* synthetic */ void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        AnalyticsListener.CC.$default$onShuffleModeChanged(this, eventTime, z);
    }

    public /* synthetic */ void onSkipSilenceEnabledChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        AnalyticsListener.CC.$default$onSkipSilenceEnabledChanged(this, eventTime, z);
    }

    public /* synthetic */ void onSurfaceSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2) {
        AnalyticsListener.CC.$default$onSurfaceSizeChanged(this, eventTime, i, i2);
    }

    public /* synthetic */ void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        AnalyticsListener.CC.$default$onUpstreamDiscarded(this, eventTime, mediaLoadData);
    }

    public /* synthetic */ void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j) {
        AnalyticsListener.CC.$default$onVideoDecoderInitialized(this, eventTime, str, j);
    }

    public /* synthetic */ void onVideoDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        AnalyticsListener.CC.$default$onVideoDisabled(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void onVideoEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        AnalyticsListener.CC.$default$onVideoEnabled(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void onVideoFrameProcessingOffset(AnalyticsListener.EventTime eventTime, long j, int i) {
        AnalyticsListener.CC.$default$onVideoFrameProcessingOffset(this, eventTime, j, i);
    }

    public /* synthetic */ void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
        AnalyticsListener.CC.$default$onVideoInputFormatChanged(this, eventTime, format);
    }

    public /* synthetic */ void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f) {
        AnalyticsListener.CC.$default$onVolumeChanged(this, eventTime, f);
    }

    public PlaybackStatsListener(boolean z, Callback callback2) {
        this.callback = callback2;
        this.keepHistory = z;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = new DefaultPlaybackSessionManager();
        this.sessionManager = defaultPlaybackSessionManager;
        defaultPlaybackSessionManager.setListener(this);
    }

    public PlaybackStats getCombinedPlaybackStats() {
        int i = 1;
        PlaybackStats[] playbackStatsArr = new PlaybackStats[(this.playbackStatsTrackers.size() + 1)];
        playbackStatsArr[0] = this.finishedPlaybackStats;
        for (PlaybackStatsTracker build : this.playbackStatsTrackers.values()) {
            playbackStatsArr[i] = build.build(false);
            i++;
        }
        return PlaybackStats.merge(playbackStatsArr);
    }

    public PlaybackStats getPlaybackStats() {
        PlaybackStatsTracker playbackStatsTracker;
        String str = this.activeAdPlayback;
        if (str != null) {
            playbackStatsTracker = this.playbackStatsTrackers.get(str);
        } else {
            String str2 = this.activeContentPlayback;
            playbackStatsTracker = str2 != null ? this.playbackStatsTrackers.get(str2) : null;
        }
        if (playbackStatsTracker == null) {
            return null;
        }
        return playbackStatsTracker.build(false);
    }

    public void finishAllSessions() {
        PlaybackSessionManager playbackSessionManager = this.sessionManager;
        AnalyticsListener.EventTime eventTime = r2;
        AnalyticsListener.EventTime eventTime2 = new AnalyticsListener.EventTime(SystemClock.elapsedRealtime(), Timeline.EMPTY, 0, (MediaSource.MediaPeriodId) null, 0, Timeline.EMPTY, 0, (MediaSource.MediaPeriodId) null, 0, 0);
        playbackSessionManager.finishAllSessions(eventTime);
    }

    public void onSessionCreated(AnalyticsListener.EventTime eventTime, String str) {
        PlaybackStatsTracker playbackStatsTracker = new PlaybackStatsTracker(this.keepHistory, eventTime);
        if (this.onSeekStartedCalled) {
            playbackStatsTracker.onSeekStarted(eventTime, true);
        }
        playbackStatsTracker.onPlaybackStateChanged(eventTime, this.playbackState, true);
        playbackStatsTracker.onPlayWhenReadyChanged(eventTime, this.playWhenReady, true);
        playbackStatsTracker.onIsSuppressedChanged(eventTime, this.isSuppressed, true);
        playbackStatsTracker.onPlaybackSpeedChanged(eventTime, this.playbackSpeed);
        this.playbackStatsTrackers.put(str, playbackStatsTracker);
        this.sessionStartEventTimes.put(str, eventTime);
    }

    public void onSessionActive(AnalyticsListener.EventTime eventTime, String str) {
        ((PlaybackStatsTracker) Assertions.checkNotNull(this.playbackStatsTrackers.get(str))).onForeground(eventTime);
        if (eventTime.mediaPeriodId == null || !eventTime.mediaPeriodId.isAd()) {
            this.activeContentPlayback = str;
        } else {
            this.activeAdPlayback = str;
        }
    }

    public void onAdPlaybackStarted(AnalyticsListener.EventTime eventTime, String str, String str2) {
        AnalyticsListener.EventTime eventTime2 = eventTime;
        Assertions.checkState(((MediaSource.MediaPeriodId) Assertions.checkNotNull(eventTime2.mediaPeriodId)).isAd());
        long adGroupTimeUs = eventTime2.timeline.getPeriodByUid(eventTime2.mediaPeriodId.periodUid, this.period).getAdGroupTimeUs(eventTime2.mediaPeriodId.adGroupIndex);
        long j = Long.MIN_VALUE;
        if (adGroupTimeUs != Long.MIN_VALUE) {
            j = this.period.getPositionInWindowUs() + adGroupTimeUs;
        }
        ((PlaybackStatsTracker) Assertions.checkNotNull(this.playbackStatsTrackers.get(str))).onInterruptedByAd(new AnalyticsListener.EventTime(eventTime2.realtimeMs, eventTime2.timeline, eventTime2.windowIndex, new MediaSource.MediaPeriodId(eventTime2.mediaPeriodId.periodUid, eventTime2.mediaPeriodId.windowSequenceNumber, eventTime2.mediaPeriodId.adGroupIndex), C1844C.usToMs(j), eventTime2.timeline, eventTime2.currentWindowIndex, eventTime2.currentMediaPeriodId, eventTime2.currentPlaybackPositionMs, eventTime2.totalBufferedDurationMs));
    }

    public void onSessionFinished(AnalyticsListener.EventTime eventTime, String str, boolean z) {
        if (str.equals(this.activeAdPlayback)) {
            this.activeAdPlayback = null;
        } else if (str.equals(this.activeContentPlayback)) {
            this.activeContentPlayback = null;
        }
        PlaybackStatsTracker playbackStatsTracker = (PlaybackStatsTracker) Assertions.checkNotNull(this.playbackStatsTrackers.remove(str));
        AnalyticsListener.EventTime eventTime2 = (AnalyticsListener.EventTime) Assertions.checkNotNull(this.sessionStartEventTimes.remove(str));
        if (z) {
            playbackStatsTracker.onPlaybackStateChanged(eventTime, 4, false);
        }
        playbackStatsTracker.onFinished(eventTime);
        PlaybackStats build = playbackStatsTracker.build(true);
        this.finishedPlaybackStats = PlaybackStats.merge(this.finishedPlaybackStats, build);
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onPlaybackStatsReady(eventTime2, build);
        }
    }

    public void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i) {
        this.playbackState = i;
        maybeAddSession(eventTime);
        for (String next : this.playbackStatsTrackers.keySet()) {
            this.playbackStatsTrackers.get(next).onPlaybackStateChanged(eventTime, this.playbackState, this.sessionManager.belongsToSession(eventTime, next));
        }
    }

    public void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
        this.playWhenReady = z;
        maybeAddSession(eventTime);
        for (String next : this.playbackStatsTrackers.keySet()) {
            this.playbackStatsTrackers.get(next).onPlayWhenReadyChanged(eventTime, z, this.sessionManager.belongsToSession(eventTime, next));
        }
    }

    public void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i) {
        this.isSuppressed = i != 0;
        maybeAddSession(eventTime);
        for (String next : this.playbackStatsTrackers.keySet()) {
            this.playbackStatsTrackers.get(next).onIsSuppressedChanged(eventTime, this.isSuppressed, this.sessionManager.belongsToSession(eventTime, next));
        }
    }

    public void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i) {
        this.sessionManager.updateSessionsWithTimelineChange(eventTime);
        for (String next : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, next)) {
                this.playbackStatsTrackers.get(next).onPositionDiscontinuity(eventTime, false);
            }
        }
    }

    public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i) {
        if (!(eventTime.timeline.isEmpty() && this.playbackState == 1)) {
            this.sessionManager.updateSessionsWithDiscontinuity(eventTime, i);
        }
        if (i == 1) {
            this.onSeekStartedCalled = false;
        }
        for (String next : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, next)) {
                this.playbackStatsTrackers.get(next).onPositionDiscontinuity(eventTime, i == 1);
            }
        }
    }

    public void onSeekStarted(AnalyticsListener.EventTime eventTime) {
        maybeAddSession(eventTime);
        for (String next : this.playbackStatsTrackers.keySet()) {
            this.playbackStatsTrackers.get(next).onSeekStarted(eventTime, this.sessionManager.belongsToSession(eventTime, next));
        }
        this.onSeekStartedCalled = true;
    }

    public void onPlayerError(AnalyticsListener.EventTime eventTime, ExoPlaybackException exoPlaybackException) {
        maybeAddSession(eventTime);
        for (String next : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, next)) {
                this.playbackStatsTrackers.get(next).onFatalError(eventTime, exoPlaybackException);
            }
        }
    }

    public void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        this.playbackSpeed = playbackParameters.speed;
        maybeAddSession(eventTime);
        for (PlaybackStatsTracker onPlaybackSpeedChanged : this.playbackStatsTrackers.values()) {
            onPlaybackSpeedChanged.onPlaybackSpeedChanged(eventTime, this.playbackSpeed);
        }
    }

    public void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        maybeAddSession(eventTime);
        for (String next : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, next)) {
                this.playbackStatsTrackers.get(next).onTracksChanged(eventTime, trackSelectionArray);
            }
        }
    }

    public void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        maybeAddSession(eventTime);
        for (String next : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, next)) {
                this.playbackStatsTrackers.get(next).onLoadStarted(eventTime);
            }
        }
    }

    public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        maybeAddSession(eventTime);
        for (String next : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, next)) {
                this.playbackStatsTrackers.get(next).onDownstreamFormatChanged(eventTime, mediaLoadData);
            }
        }
    }

    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2, int i3, float f) {
        maybeAddSession(eventTime);
        for (String next : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, next)) {
                this.playbackStatsTrackers.get(next).onVideoSizeChanged(eventTime, i, i2);
            }
        }
    }

    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        maybeAddSession(eventTime);
        for (String next : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, next)) {
                this.playbackStatsTrackers.get(next).onBandwidthData((long) i, j);
            }
        }
    }

    public void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        maybeAddSession(eventTime);
        for (String next : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, next)) {
                this.playbackStatsTrackers.get(next).onAudioUnderrun();
            }
        }
    }

    public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i, long j) {
        maybeAddSession(eventTime);
        for (String next : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, next)) {
                this.playbackStatsTrackers.get(next).onDroppedVideoFrames(i);
            }
        }
    }

    public void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        maybeAddSession(eventTime);
        for (String next : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, next)) {
                this.playbackStatsTrackers.get(next).onNonFatalError(eventTime, iOException);
            }
        }
    }

    public void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        maybeAddSession(eventTime);
        for (String next : this.playbackStatsTrackers.keySet()) {
            if (this.sessionManager.belongsToSession(eventTime, next)) {
                this.playbackStatsTrackers.get(next).onNonFatalError(eventTime, exc);
            }
        }
    }

    private void maybeAddSession(AnalyticsListener.EventTime eventTime) {
        boolean z = true;
        if (!eventTime.timeline.isEmpty() || this.playbackState != 1) {
            z = false;
        }
        if (!z) {
            this.sessionManager.updateSessions(eventTime);
        }
    }

    private static final class PlaybackStatsTracker {
        private long audioFormatBitrateTimeProduct;
        private final List<PlaybackStats.EventTimeAndFormat> audioFormatHistory;
        private long audioFormatTimeMs;
        private long audioUnderruns;
        private long bandwidthBytes;
        private long bandwidthTimeMs;
        private Format currentAudioFormat;
        private float currentPlaybackSpeed;
        private int currentPlaybackState;
        private long currentPlaybackStateStartTimeMs;
        private Format currentVideoFormat;
        private long droppedFrames;
        private int fatalErrorCount;
        private final List<PlaybackStats.EventTimeAndException> fatalErrorHistory;
        private long firstReportedTimeMs;
        private boolean hasBeenReady;
        private boolean hasEnded;
        private boolean hasFatalError;
        private long initialAudioFormatBitrate;
        private long initialVideoFormatBitrate;
        private int initialVideoFormatHeight;
        private final boolean isAd;
        private boolean isFinished;
        private boolean isForeground;
        private boolean isInterruptedByAd;
        private boolean isJoinTimeInvalid;
        private boolean isSeeking;
        private boolean isSuppressed;
        private final boolean keepHistory;
        private long lastAudioFormatStartTimeMs;
        private long lastRebufferStartTimeMs;
        private long lastVideoFormatStartTimeMs;
        private long maxRebufferTimeMs;
        private final List<long[]> mediaTimeHistory;
        private int nonFatalErrorCount;
        private final List<PlaybackStats.EventTimeAndException> nonFatalErrorHistory;
        private int pauseBufferCount;
        private int pauseCount;
        private boolean playWhenReady;
        private final long[] playbackStateDurationsMs = new long[16];
        private final List<PlaybackStats.EventTimeAndPlaybackState> playbackStateHistory;
        private int playerPlaybackState;
        private int rebufferCount;
        private int seekCount;
        private boolean startedLoading;
        private long videoFormatBitrateTimeMs;
        private long videoFormatBitrateTimeProduct;
        private long videoFormatHeightTimeMs;
        private long videoFormatHeightTimeProduct;
        private final List<PlaybackStats.EventTimeAndFormat> videoFormatHistory;

        private static boolean isInvalidJoinTransition(int i, int i2) {
            return ((i != 1 && i != 2 && i != 14) || i2 == 1 || i2 == 2 || i2 == 14 || i2 == 3 || i2 == 4 || i2 == 9 || i2 == 11) ? false : true;
        }

        private static boolean isPausedState(int i) {
            return i == 4 || i == 7;
        }

        private static boolean isReadyState(int i) {
            return i == 3 || i == 4 || i == 9;
        }

        private static boolean isRebufferingState(int i) {
            return i == 6 || i == 7 || i == 10;
        }

        public PlaybackStatsTracker(boolean z, AnalyticsListener.EventTime eventTime) {
            this.keepHistory = z;
            this.playbackStateHistory = z ? new ArrayList<>() : Collections.emptyList();
            this.mediaTimeHistory = z ? new ArrayList<>() : Collections.emptyList();
            this.videoFormatHistory = z ? new ArrayList<>() : Collections.emptyList();
            this.audioFormatHistory = z ? new ArrayList<>() : Collections.emptyList();
            this.fatalErrorHistory = z ? new ArrayList<>() : Collections.emptyList();
            this.nonFatalErrorHistory = z ? new ArrayList<>() : Collections.emptyList();
            boolean z2 = false;
            this.currentPlaybackState = 0;
            this.currentPlaybackStateStartTimeMs = eventTime.realtimeMs;
            this.playerPlaybackState = 1;
            this.firstReportedTimeMs = C1844C.TIME_UNSET;
            this.maxRebufferTimeMs = C1844C.TIME_UNSET;
            if (eventTime.mediaPeriodId != null && eventTime.mediaPeriodId.isAd()) {
                z2 = true;
            }
            this.isAd = z2;
            this.initialAudioFormatBitrate = -1;
            this.initialVideoFormatBitrate = -1;
            this.initialVideoFormatHeight = -1;
            this.currentPlaybackSpeed = 1.0f;
        }

        public void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i, boolean z) {
            this.playerPlaybackState = i;
            if (i != 1) {
                this.hasFatalError = false;
            }
            if (i != 2) {
                this.isSeeking = false;
            }
            if (i == 1 || i == 4) {
                this.isInterruptedByAd = false;
            }
            maybeUpdatePlaybackState(eventTime, z);
        }

        public void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z, boolean z2) {
            this.playWhenReady = z;
            maybeUpdatePlaybackState(eventTime, z2);
        }

        public void onIsSuppressedChanged(AnalyticsListener.EventTime eventTime, boolean z, boolean z2) {
            this.isSuppressed = z;
            maybeUpdatePlaybackState(eventTime, z2);
        }

        public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, boolean z) {
            if (z && this.playerPlaybackState == 1) {
                this.isSeeking = false;
            }
            this.isInterruptedByAd = false;
            maybeUpdatePlaybackState(eventTime, true);
        }

        public void onSeekStarted(AnalyticsListener.EventTime eventTime, boolean z) {
            this.isSeeking = true;
            maybeUpdatePlaybackState(eventTime, z);
        }

        public void onFatalError(AnalyticsListener.EventTime eventTime, Exception exc) {
            this.fatalErrorCount++;
            if (this.keepHistory) {
                this.fatalErrorHistory.add(new PlaybackStats.EventTimeAndException(eventTime, exc));
            }
            this.hasFatalError = true;
            this.isInterruptedByAd = false;
            this.isSeeking = false;
            maybeUpdatePlaybackState(eventTime, true);
        }

        public void onLoadStarted(AnalyticsListener.EventTime eventTime) {
            this.startedLoading = true;
            maybeUpdatePlaybackState(eventTime, true);
        }

        public void onForeground(AnalyticsListener.EventTime eventTime) {
            this.isForeground = true;
            maybeUpdatePlaybackState(eventTime, true);
        }

        public void onInterruptedByAd(AnalyticsListener.EventTime eventTime) {
            this.isInterruptedByAd = true;
            this.isSeeking = false;
            maybeUpdatePlaybackState(eventTime, true);
        }

        public void onFinished(AnalyticsListener.EventTime eventTime) {
            this.isFinished = true;
            maybeUpdatePlaybackState(eventTime, false);
        }

        public void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackSelectionArray trackSelectionArray) {
            boolean z = false;
            boolean z2 = false;
            for (TrackSelection trackSelection : trackSelectionArray.getAll()) {
                if (trackSelection != null && trackSelection.length() > 0) {
                    int trackType = MimeTypes.getTrackType(trackSelection.getFormat(0).sampleMimeType);
                    if (trackType == 2) {
                        z = true;
                    } else if (trackType == 1) {
                        z2 = true;
                    }
                }
            }
            if (!z) {
                maybeUpdateVideoFormat(eventTime, (Format) null);
            }
            if (!z2) {
                maybeUpdateAudioFormat(eventTime, (Format) null);
            }
        }

        public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
            if (mediaLoadData.trackType == 2 || mediaLoadData.trackType == 0) {
                maybeUpdateVideoFormat(eventTime, mediaLoadData.trackFormat);
            } else if (mediaLoadData.trackType == 1) {
                maybeUpdateAudioFormat(eventTime, mediaLoadData.trackFormat);
            }
        }

        public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2) {
            Format format = this.currentVideoFormat;
            if (format != null && format.height == -1) {
                maybeUpdateVideoFormat(eventTime, this.currentVideoFormat.buildUpon().setWidth(i).setHeight(i2).build());
            }
        }

        public void onPlaybackSpeedChanged(AnalyticsListener.EventTime eventTime, float f) {
            maybeUpdateMediaTimeHistory(eventTime.realtimeMs, eventTime.eventPlaybackPositionMs);
            maybeRecordVideoFormatTime(eventTime.realtimeMs);
            maybeRecordAudioFormatTime(eventTime.realtimeMs);
            this.currentPlaybackSpeed = f;
        }

        public void onAudioUnderrun() {
            this.audioUnderruns++;
        }

        public void onDroppedVideoFrames(int i) {
            this.droppedFrames += (long) i;
        }

        public void onBandwidthData(long j, long j2) {
            this.bandwidthTimeMs += j;
            this.bandwidthBytes += j2;
        }

        public void onNonFatalError(AnalyticsListener.EventTime eventTime, Exception exc) {
            this.nonFatalErrorCount++;
            if (this.keepHistory) {
                this.nonFatalErrorHistory.add(new PlaybackStats.EventTimeAndException(eventTime, exc));
            }
        }

        public PlaybackStats build(boolean z) {
            ArrayList arrayList;
            long[] jArr;
            long j;
            long[] jArr2 = this.playbackStateDurationsMs;
            List<long[]> list = this.mediaTimeHistory;
            if (!z) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long[] copyOf = Arrays.copyOf(this.playbackStateDurationsMs, 16);
                long max = Math.max(0, elapsedRealtime - this.currentPlaybackStateStartTimeMs);
                int i = this.currentPlaybackState;
                copyOf[i] = copyOf[i] + max;
                maybeUpdateMaxRebufferTimeMs(elapsedRealtime);
                maybeRecordVideoFormatTime(elapsedRealtime);
                maybeRecordAudioFormatTime(elapsedRealtime);
                ArrayList arrayList2 = new ArrayList(this.mediaTimeHistory);
                if (this.keepHistory && this.currentPlaybackState == 3) {
                    arrayList2.add(guessMediaTimeBasedOnElapsedRealtime(elapsedRealtime));
                }
                jArr = copyOf;
                arrayList = arrayList2;
            } else {
                jArr = jArr2;
                arrayList = list;
            }
            int i2 = (this.isJoinTimeInvalid || !this.hasBeenReady) ? 1 : 0;
            if (i2 != 0) {
                j = C1844C.TIME_UNSET;
            } else {
                j = jArr[2];
            }
            long j2 = j;
            int i3 = jArr[1] > 0 ? 1 : 0;
            List arrayList3 = z ? this.videoFormatHistory : new ArrayList(this.videoFormatHistory);
            List arrayList4 = z ? this.audioFormatHistory : new ArrayList(this.audioFormatHistory);
            List arrayList5 = z ? this.playbackStateHistory : new ArrayList(this.playbackStateHistory);
            long j3 = this.firstReportedTimeMs;
            boolean z2 = this.isForeground;
            boolean z3 = !this.hasBeenReady;
            boolean z4 = this.hasEnded;
            int i4 = i2 ^ 1;
            int i5 = this.pauseCount;
            int i6 = this.pauseBufferCount;
            int i7 = this.seekCount;
            int i8 = this.rebufferCount;
            int i9 = i6;
            long j4 = this.maxRebufferTimeMs;
            boolean z5 = this.isAd;
            long[] jArr3 = jArr;
            long j5 = this.videoFormatHeightTimeMs;
            long j6 = this.videoFormatHeightTimeProduct;
            long j7 = this.videoFormatBitrateTimeMs;
            long j8 = this.videoFormatBitrateTimeProduct;
            long j9 = this.audioFormatTimeMs;
            long j10 = this.audioFormatBitrateTimeProduct;
            int i10 = this.initialVideoFormatHeight;
            int i11 = i10;
            int i12 = i10 == -1 ? 0 : 1;
            long j11 = this.initialVideoFormatBitrate;
            long j12 = j11;
            int i13 = j11 == -1 ? 0 : 1;
            long j13 = this.initialAudioFormatBitrate;
            long j14 = j13;
            int i14 = j13 == -1 ? 0 : 1;
            long j15 = this.bandwidthTimeMs;
            long j16 = this.bandwidthBytes;
            long j17 = this.droppedFrames;
            long j18 = this.audioUnderruns;
            int i15 = this.fatalErrorCount;
            return new PlaybackStats(1, jArr3, arrayList5, arrayList, j3, z2 ? 1 : 0, z3 ? 1 : 0, z4 ? 1 : 0, i3, j2, i4, i5, i9, i7, i8, j4, z5 ? 1 : 0, arrayList3, arrayList4, j5, j6, j7, j8, j9, j10, i12, i13, i11, j12, i14, j14, j15, j16, j17, j18, i15 > 0 ? 1 : 0, i15, this.nonFatalErrorCount, this.fatalErrorHistory, this.nonFatalErrorHistory);
        }

        private void maybeUpdatePlaybackState(AnalyticsListener.EventTime eventTime, boolean z) {
            int resolveNewPlaybackState = resolveNewPlaybackState();
            if (resolveNewPlaybackState != this.currentPlaybackState) {
                boolean z2 = false;
                Assertions.checkArgument(eventTime.realtimeMs >= this.currentPlaybackStateStartTimeMs);
                long j = eventTime.realtimeMs - this.currentPlaybackStateStartTimeMs;
                long[] jArr = this.playbackStateDurationsMs;
                int i = this.currentPlaybackState;
                jArr[i] = jArr[i] + j;
                long j2 = this.firstReportedTimeMs;
                long j3 = C1844C.TIME_UNSET;
                if (j2 == C1844C.TIME_UNSET) {
                    this.firstReportedTimeMs = eventTime.realtimeMs;
                }
                this.isJoinTimeInvalid |= isInvalidJoinTransition(this.currentPlaybackState, resolveNewPlaybackState);
                this.hasBeenReady |= isReadyState(resolveNewPlaybackState);
                boolean z3 = this.hasEnded;
                if (resolveNewPlaybackState == 11) {
                    z2 = true;
                }
                this.hasEnded = z3 | z2;
                if (!isPausedState(this.currentPlaybackState) && isPausedState(resolveNewPlaybackState)) {
                    this.pauseCount++;
                }
                if (resolveNewPlaybackState == 5) {
                    this.seekCount++;
                }
                if (!isRebufferingState(this.currentPlaybackState) && isRebufferingState(resolveNewPlaybackState)) {
                    this.rebufferCount++;
                    this.lastRebufferStartTimeMs = eventTime.realtimeMs;
                }
                if (isRebufferingState(this.currentPlaybackState) && this.currentPlaybackState != 7 && resolveNewPlaybackState == 7) {
                    this.pauseBufferCount++;
                }
                long j4 = eventTime.realtimeMs;
                if (z) {
                    j3 = eventTime.eventPlaybackPositionMs;
                }
                maybeUpdateMediaTimeHistory(j4, j3);
                maybeUpdateMaxRebufferTimeMs(eventTime.realtimeMs);
                maybeRecordVideoFormatTime(eventTime.realtimeMs);
                maybeRecordAudioFormatTime(eventTime.realtimeMs);
                this.currentPlaybackState = resolveNewPlaybackState;
                this.currentPlaybackStateStartTimeMs = eventTime.realtimeMs;
                if (this.keepHistory) {
                    this.playbackStateHistory.add(new PlaybackStats.EventTimeAndPlaybackState(eventTime, this.currentPlaybackState));
                }
            }
        }

        private int resolveNewPlaybackState() {
            if (this.isFinished) {
                if (this.currentPlaybackState == 11) {
                    return 11;
                }
                return 15;
            } else if (this.isSeeking && this.isForeground) {
                return 5;
            } else {
                if (this.hasFatalError) {
                    return 13;
                }
                if (!this.isForeground) {
                    return this.startedLoading ? 1 : 0;
                }
                if (this.isInterruptedByAd) {
                    return 14;
                }
                int i = this.playerPlaybackState;
                if (i == 4) {
                    return 11;
                }
                if (i == 2) {
                    int i2 = this.currentPlaybackState;
                    if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 14) {
                        return 2;
                    }
                    if (!this.playWhenReady) {
                        return 7;
                    }
                    return this.isSuppressed ? 10 : 6;
                } else if (i == 3) {
                    if (!this.playWhenReady) {
                        return 4;
                    }
                    if (this.isSuppressed) {
                        return 9;
                    }
                    return 3;
                } else if (i != 1 || this.currentPlaybackState == 0) {
                    return this.currentPlaybackState;
                } else {
                    return 12;
                }
            }
        }

        private void maybeUpdateMaxRebufferTimeMs(long j) {
            if (isRebufferingState(this.currentPlaybackState)) {
                long j2 = j - this.lastRebufferStartTimeMs;
                long j3 = this.maxRebufferTimeMs;
                if (j3 == C1844C.TIME_UNSET || j2 > j3) {
                    this.maxRebufferTimeMs = j2;
                }
            }
        }

        private void maybeUpdateMediaTimeHistory(long j, long j2) {
            long[] jArr;
            if (this.keepHistory) {
                if (this.currentPlaybackState != 3) {
                    if (j2 != C1844C.TIME_UNSET) {
                        if (!this.mediaTimeHistory.isEmpty()) {
                            List<long[]> list = this.mediaTimeHistory;
                            long j3 = list.get(list.size() - 1)[1];
                            if (j3 != j2) {
                                this.mediaTimeHistory.add(new long[]{j, j3});
                            }
                        }
                    } else {
                        return;
                    }
                }
                List<long[]> list2 = this.mediaTimeHistory;
                if (j2 == C1844C.TIME_UNSET) {
                    jArr = guessMediaTimeBasedOnElapsedRealtime(j);
                } else {
                    jArr = new long[]{j, j2};
                }
                list2.add(jArr);
            }
        }

        private long[] guessMediaTimeBasedOnElapsedRealtime(long j) {
            List<long[]> list = this.mediaTimeHistory;
            long[] jArr = list.get(list.size() - 1);
            return new long[]{j, jArr[1] + ((long) (((float) (j - jArr[0])) * this.currentPlaybackSpeed))};
        }

        private void maybeUpdateVideoFormat(AnalyticsListener.EventTime eventTime, Format format) {
            if (!Util.areEqual(this.currentVideoFormat, format)) {
                maybeRecordVideoFormatTime(eventTime.realtimeMs);
                if (format != null) {
                    if (this.initialVideoFormatHeight == -1 && format.height != -1) {
                        this.initialVideoFormatHeight = format.height;
                    }
                    if (this.initialVideoFormatBitrate == -1 && format.bitrate != -1) {
                        this.initialVideoFormatBitrate = (long) format.bitrate;
                    }
                }
                this.currentVideoFormat = format;
                if (this.keepHistory) {
                    this.videoFormatHistory.add(new PlaybackStats.EventTimeAndFormat(eventTime, format));
                }
            }
        }

        private void maybeUpdateAudioFormat(AnalyticsListener.EventTime eventTime, Format format) {
            if (!Util.areEqual(this.currentAudioFormat, format)) {
                maybeRecordAudioFormatTime(eventTime.realtimeMs);
                if (!(format == null || this.initialAudioFormatBitrate != -1 || format.bitrate == -1)) {
                    this.initialAudioFormatBitrate = (long) format.bitrate;
                }
                this.currentAudioFormat = format;
                if (this.keepHistory) {
                    this.audioFormatHistory.add(new PlaybackStats.EventTimeAndFormat(eventTime, format));
                }
            }
        }

        private void maybeRecordVideoFormatTime(long j) {
            Format format;
            if (this.currentPlaybackState == 3 && (format = this.currentVideoFormat) != null) {
                long j2 = (long) (((float) (j - this.lastVideoFormatStartTimeMs)) * this.currentPlaybackSpeed);
                if (format.height != -1) {
                    this.videoFormatHeightTimeMs += j2;
                    this.videoFormatHeightTimeProduct += ((long) this.currentVideoFormat.height) * j2;
                }
                if (this.currentVideoFormat.bitrate != -1) {
                    this.videoFormatBitrateTimeMs += j2;
                    this.videoFormatBitrateTimeProduct += j2 * ((long) this.currentVideoFormat.bitrate);
                }
            }
            this.lastVideoFormatStartTimeMs = j;
        }

        private void maybeRecordAudioFormatTime(long j) {
            Format format;
            if (!(this.currentPlaybackState != 3 || (format = this.currentAudioFormat) == null || format.bitrate == -1)) {
                long j2 = (long) (((float) (j - this.lastAudioFormatStartTimeMs)) * this.currentPlaybackSpeed);
                this.audioFormatTimeMs += j2;
                this.audioFormatBitrateTimeProduct += j2 * ((long) this.currentAudioFormat.bitrate);
            }
            this.lastAudioFormatStartTimeMs = j;
        }
    }
}
