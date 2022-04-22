package com.getstream.sdk.chat.utils.exomedia.core;

import android.media.MediaPlayer;
import android.os.Handler;
import android.view.Surface;
import com.getstream.sdk.chat.utils.exomedia.core.exception.NativeMediaPlaybackException;
import com.getstream.sdk.chat.utils.exomedia.core.exoplayer.ExoMediaPlayer;
import com.getstream.sdk.chat.utils.exomedia.core.listener.ExoPlayerListener;
import com.getstream.sdk.chat.utils.exomedia.core.listener.MetadataListener;
import com.getstream.sdk.chat.utils.exomedia.core.video.ClearableSurface;
import com.getstream.sdk.chat.utils.exomedia.listener.OnBufferUpdateListener;
import com.getstream.sdk.chat.utils.exomedia.listener.OnCompletionListener;
import com.getstream.sdk.chat.utils.exomedia.listener.OnErrorListener;
import com.getstream.sdk.chat.utils.exomedia.listener.OnPreparedListener;
import com.getstream.sdk.chat.utils.exomedia.listener.OnSeekCompletionListener;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class ListenerMux implements ExoPlayerListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, OnBufferUpdateListener, MetadataListener, AnalyticsListener {
    private static final long COMPLETED_DURATION_LEEWAY = 1000;
    private AnalyticsListener analyticsListener;
    private OnBufferUpdateListener bufferUpdateListener;
    private boolean clearRequested = false;
    private WeakReference<ClearableSurface> clearableSurfaceRef = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public OnCompletionListener completionListener;
    private Handler delayedHandler = new Handler();
    private OnErrorListener errorListener;
    private MetadataListener metadataListener;
    private Notifier muxNotifier;
    private boolean notifiedCompleted = false;
    private boolean notifiedPrepared = false;
    private OnPreparedListener preparedListener;
    private OnSeekCompletionListener seekCompletionListener;

    public static abstract class Notifier {
        public void onBufferUpdated(int i) {
        }

        public abstract void onExoPlayerError(ExoMediaPlayer exoMediaPlayer, Exception exc);

        public abstract void onMediaPlaybackEnded();

        public void onPrepared() {
        }

        public void onPreviewImageStateChanged(boolean z) {
        }

        public void onSeekComplete() {
        }

        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
        }

        public abstract boolean shouldNotifyCompletion(long j);
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

    public /* synthetic */ void onIsLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        AnalyticsListener.CC.$default$onIsLoadingChanged(this, eventTime, z);
    }

    public /* synthetic */ void onIsPlayingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        AnalyticsListener.CC.$default$onIsPlayingChanged(this, eventTime, z);
    }

    public /* synthetic */ void onMediaItemTransition(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i) {
        AnalyticsListener.CC.$default$onMediaItemTransition(this, eventTime, mediaItem, i);
    }

    public /* synthetic */ void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
        AnalyticsListener.CC.$default$onPlayWhenReadyChanged(this, eventTime, z, i);
    }

    public /* synthetic */ void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i) {
        AnalyticsListener.CC.$default$onPlaybackStateChanged(this, eventTime, i);
    }

    public /* synthetic */ void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i) {
        AnalyticsListener.CC.$default$onPlaybackSuppressionReasonChanged(this, eventTime, i);
    }

    public /* synthetic */ void onSkipSilenceEnabledChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        AnalyticsListener.CC.$default$onSkipSilenceEnabledChanged(this, eventTime, z);
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

    public ListenerMux(Notifier notifier) {
        this.muxNotifier = notifier;
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        onBufferingUpdate(i);
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        OnCompletionListener onCompletionListener = this.completionListener;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return notifyErrorListener(new NativeMediaPlaybackException(i, i2));
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        OnSeekCompletionListener onSeekCompletionListener = this.seekCompletionListener;
        if (onSeekCompletionListener != null) {
            onSeekCompletionListener.onSeekComplete();
        }
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        notifyPreparedListener();
    }

    public void onError(ExoMediaPlayer exoMediaPlayer, Exception exc) {
        this.muxNotifier.onMediaPlaybackEnded();
        this.muxNotifier.onExoPlayerError(exoMediaPlayer, exc);
        notifyErrorListener(exc);
    }

    public void onStateChanged(boolean z, int i) {
        if (i == 4) {
            this.muxNotifier.onMediaPlaybackEnded();
            if (!this.notifiedCompleted) {
                notifyCompletionListener();
            }
        } else if (i == 3 && !this.notifiedPrepared) {
            notifyPreparedListener();
        }
        if (i == 3 && z) {
            this.muxNotifier.onPreviewImageStateChanged(false);
        }
        if (i == 1 && this.clearRequested) {
            this.clearRequested = false;
            ClearableSurface clearableSurface = (ClearableSurface) this.clearableSurfaceRef.get();
            if (clearableSurface != null) {
                clearableSurface.clearSurface();
                this.clearableSurfaceRef = new WeakReference<>((Object) null);
            }
        }
    }

    public void onSeekComplete() {
        this.muxNotifier.onSeekComplete();
        OnSeekCompletionListener onSeekCompletionListener = this.seekCompletionListener;
        if (onSeekCompletionListener != null) {
            onSeekCompletionListener.onSeekComplete();
        }
    }

    public void onBufferingUpdate(int i) {
        this.muxNotifier.onBufferUpdated(i);
        OnBufferUpdateListener onBufferUpdateListener = this.bufferUpdateListener;
        if (onBufferUpdateListener != null) {
            onBufferUpdateListener.onBufferingUpdate(i);
        }
    }

    public void onMetadata(Metadata metadata) {
        MetadataListener metadataListener2 = this.metadataListener;
        if (metadataListener2 != null) {
            metadataListener2.onMetadata(metadata);
        }
    }

    public void onVideoSizeChanged(int i, int i2, int i3, float f) {
        this.muxNotifier.onVideoSizeChanged(i, i2, i3, f);
    }

    public void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onPlayerStateChanged(eventTime, z, i);
        }
    }

    public void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onTimelineChanged(eventTime, i);
        }
    }

    public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onPositionDiscontinuity(eventTime, i);
        }
    }

    public void onSeekStarted(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onSeekStarted(eventTime);
        }
    }

    public void onSeekProcessed(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onSeekProcessed(eventTime);
        }
    }

    public void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onPlaybackParametersChanged(eventTime, playbackParameters);
        }
    }

    public void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onRepeatModeChanged(eventTime, i);
        }
    }

    public void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onShuffleModeChanged(eventTime, z);
        }
    }

    public void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onLoadingChanged(eventTime, z);
        }
    }

    public void onPlayerError(AnalyticsListener.EventTime eventTime, ExoPlaybackException exoPlaybackException) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onPlayerError(eventTime, exoPlaybackException);
        }
    }

    public void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onTracksChanged(eventTime, trackGroupArray, trackSelectionArray);
        }
    }

    public void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onLoadStarted(eventTime, loadEventInfo, mediaLoadData);
        }
    }

    public void onLoadCompleted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onLoadCompleted(eventTime, loadEventInfo, mediaLoadData);
        }
    }

    public void onLoadCanceled(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onLoadCanceled(eventTime, loadEventInfo, mediaLoadData);
        }
    }

    public void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onLoadError(eventTime, loadEventInfo, mediaLoadData, iOException, z);
        }
    }

    public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onDownstreamFormatChanged(eventTime, mediaLoadData);
        }
    }

    public void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onUpstreamDiscarded(eventTime, mediaLoadData);
        }
    }

    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onBandwidthEstimate(eventTime, i, j, j2);
        }
    }

    public void onSurfaceSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onSurfaceSizeChanged(eventTime, i, i2);
        }
    }

    public void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onVolumeChanged(eventTime, f);
        }
    }

    public void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onDrmSessionAcquired(eventTime);
        }
    }

    public void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onDrmSessionReleased(eventTime);
        }
    }

    public void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onAudioAttributesChanged(eventTime, audioAttributes);
        }
    }

    public void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onMetadata(eventTime, metadata);
        }
    }

    public void onDecoderEnabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onDecoderEnabled(eventTime, i, decoderCounters);
        }
    }

    public void onDecoderInitialized(AnalyticsListener.EventTime eventTime, int i, String str, long j) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onDecoderInitialized(eventTime, i, str, j);
        }
    }

    public void onDecoderInputFormatChanged(AnalyticsListener.EventTime eventTime, int i, Format format) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onDecoderInputFormatChanged(eventTime, i, format);
        }
    }

    public void onDecoderDisabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onDecoderDisabled(eventTime, i, decoderCounters);
        }
    }

    public void onAudioSessionId(AnalyticsListener.EventTime eventTime, int i) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onAudioSessionId(eventTime, i);
        }
    }

    public void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onAudioUnderrun(eventTime, i, j, j2);
        }
    }

    public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i, long j) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onDroppedVideoFrames(eventTime, i, j);
        }
    }

    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2, int i3, float f) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onVideoSizeChanged(eventTime, i, i2, i3, f);
        }
    }

    public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Surface surface) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onRenderedFirstFrame(eventTime, surface);
        }
    }

    public void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onDrmKeysLoaded(eventTime);
        }
    }

    public void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onDrmSessionManagerError(eventTime, exc);
        }
    }

    public void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onDrmKeysRestored(eventTime);
        }
    }

    public void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener analyticsListener2 = this.analyticsListener;
        if (analyticsListener2 != null) {
            analyticsListener2.onDrmKeysRemoved(eventTime);
        }
    }

    public void clearSurfaceWhenReady(ClearableSurface clearableSurface) {
        this.clearRequested = true;
        this.clearableSurfaceRef = new WeakReference<>(clearableSurface);
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.preparedListener = onPreparedListener;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.completionListener = onCompletionListener;
    }

    public void setOnBufferUpdateListener(OnBufferUpdateListener onBufferUpdateListener) {
        this.bufferUpdateListener = onBufferUpdateListener;
    }

    public void setOnSeekCompletionListener(OnSeekCompletionListener onSeekCompletionListener) {
        this.seekCompletionListener = onSeekCompletionListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.errorListener = onErrorListener;
    }

    public void setMetadataListener(MetadataListener metadataListener2) {
        this.metadataListener = metadataListener2;
    }

    public void setAnalyticsListener(AnalyticsListener analyticsListener2) {
        this.analyticsListener = analyticsListener2;
    }

    public void setNotifiedPrepared(boolean z) {
        this.notifiedPrepared = z;
        this.muxNotifier.onPreviewImageStateChanged(true);
    }

    public boolean isPrepared() {
        return this.notifiedPrepared;
    }

    public void setNotifiedCompleted(boolean z) {
        this.notifiedCompleted = z;
    }

    private boolean notifyErrorListener(Exception exc) {
        OnErrorListener onErrorListener = this.errorListener;
        return onErrorListener != null && onErrorListener.onError(exc);
    }

    private void notifyPreparedListener() {
        this.notifiedPrepared = true;
        this.delayedHandler.post(new Runnable() {
            public void run() {
                ListenerMux.this.performPreparedHandlerNotification();
            }
        });
    }

    /* access modifiers changed from: private */
    public void performPreparedHandlerNotification() {
        this.muxNotifier.onPrepared();
        OnPreparedListener onPreparedListener = this.preparedListener;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared();
        }
    }

    private void notifyCompletionListener() {
        if (this.muxNotifier.shouldNotifyCompletion(1000)) {
            this.notifiedCompleted = true;
            this.delayedHandler.post(new Runnable() {
                public void run() {
                    if (ListenerMux.this.completionListener != null) {
                        ListenerMux.this.completionListener.onCompletion();
                    }
                }
            });
        }
    }
}
