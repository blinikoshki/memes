package com.getstream.sdk.chat.utils.exomedia.core.video.exo;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.getstream.sdk.chat.utils.exomedia.ExoMedia;
import com.getstream.sdk.chat.utils.exomedia.core.ListenerMux;
import com.getstream.sdk.chat.utils.exomedia.core.exoplayer.ExoMediaPlayer;
import com.getstream.sdk.chat.utils.exomedia.core.exoplayer.WindowInfo;
import com.getstream.sdk.chat.utils.exomedia.core.listener.CaptionListener;
import com.getstream.sdk.chat.utils.exomedia.core.listener.MetadataListener;
import com.getstream.sdk.chat.utils.exomedia.core.video.ClearableSurface;
import com.getstream.sdk.chat.utils.exomedia.listener.OnBufferUpdateListener;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.Map;

public class ExoVideoDelegate {
    protected ClearableSurface clearableSurface;
    protected Context context;
    protected ExoMediaPlayer exoMediaPlayer;
    protected InternalListeners internalListeners = new InternalListeners();
    protected ListenerMux listenerMux;
    protected boolean playRequested = false;

    public boolean trackSelectionAvailable() {
        return true;
    }

    public ExoVideoDelegate(Context context2, ClearableSurface clearableSurface2) {
        this.context = context2.getApplicationContext();
        this.clearableSurface = clearableSurface2;
        setup();
    }

    public void setVideoUri(Uri uri) {
        setVideoUri(uri, (MediaSource) null);
    }

    public void setVideoUri(Uri uri, MediaSource mediaSource) {
        this.listenerMux.setNotifiedPrepared(false);
        this.exoMediaPlayer.seekTo(0);
        if (mediaSource != null) {
            this.exoMediaPlayer.setMediaSource(mediaSource);
            this.listenerMux.setNotifiedCompleted(false);
        } else if (uri != null) {
            this.exoMediaPlayer.setUri(uri);
            this.listenerMux.setNotifiedCompleted(false);
        } else {
            this.exoMediaPlayer.setMediaSource((MediaSource) null);
        }
    }

    public void setDrmCallback(MediaDrmCallback mediaDrmCallback) {
        this.exoMediaPlayer.setDrmCallback(mediaDrmCallback);
    }

    public boolean restart() {
        if (!this.exoMediaPlayer.restart()) {
            return false;
        }
        this.listenerMux.setNotifiedPrepared(false);
        this.listenerMux.setNotifiedCompleted(false);
        return true;
    }

    public float getVolume() {
        return this.exoMediaPlayer.getVolume();
    }

    public boolean setVolume(float f) {
        this.exoMediaPlayer.setVolume(f);
        return true;
    }

    public void seekTo(long j) {
        this.exoMediaPlayer.seekTo(j);
    }

    public boolean isPlaying() {
        return this.exoMediaPlayer.getPlayWhenReady();
    }

    public void start() {
        this.exoMediaPlayer.setPlayWhenReady(true);
        this.listenerMux.setNotifiedCompleted(false);
        this.playRequested = true;
    }

    public void pause() {
        this.exoMediaPlayer.setPlayWhenReady(false);
        this.playRequested = false;
    }

    public void stopPlayback(boolean z) {
        this.exoMediaPlayer.stop();
        this.playRequested = false;
        if (z) {
            this.listenerMux.clearSurfaceWhenReady(this.clearableSurface);
        }
    }

    public void suspend() {
        this.exoMediaPlayer.release();
        this.playRequested = false;
    }

    public long getDuration() {
        if (!this.listenerMux.isPrepared()) {
            return 0;
        }
        return this.exoMediaPlayer.getDuration();
    }

    public long getCurrentPosition() {
        if (!this.listenerMux.isPrepared()) {
            return 0;
        }
        return this.exoMediaPlayer.getCurrentPosition();
    }

    public int getBufferedPercent() {
        return this.exoMediaPlayer.getBufferedPercentage();
    }

    public WindowInfo getWindowInfo() {
        return this.exoMediaPlayer.getWindowInfo();
    }

    public void setCaptionListener(CaptionListener captionListener) {
        this.exoMediaPlayer.setCaptionListener(captionListener);
    }

    @Deprecated
    public void setTrack(ExoMedia.RendererType rendererType, int i) {
        this.exoMediaPlayer.setSelectedTrack(rendererType, 0, i);
    }

    public void setTrack(ExoMedia.RendererType rendererType, int i, int i2) {
        this.exoMediaPlayer.setSelectedTrack(rendererType, i, i2);
    }

    public int getSelectedTrackIndex(ExoMedia.RendererType rendererType, int i) {
        return this.exoMediaPlayer.getSelectedTrackIndex(rendererType, i);
    }

    public void clearSelectedTracks(ExoMedia.RendererType rendererType) {
        this.exoMediaPlayer.clearSelectedTracks(rendererType);
    }

    public Map<ExoMedia.RendererType, TrackGroupArray> getAvailableTracks() {
        return this.exoMediaPlayer.getAvailableTracks();
    }

    public void setRendererEnabled(ExoMedia.RendererType rendererType, boolean z) {
        this.exoMediaPlayer.setRendererEnabled(rendererType, z);
    }

    public boolean isRendererEnabled(ExoMedia.RendererType rendererType) {
        return this.exoMediaPlayer.isRendererEnabled(rendererType);
    }

    public boolean setPlaybackSpeed(float f) {
        return this.exoMediaPlayer.setPlaybackSpeed(f);
    }

    public float getPlaybackSpeed() {
        return this.exoMediaPlayer.getPlaybackSpeed();
    }

    public void release() {
        this.exoMediaPlayer.release();
    }

    public void setListenerMux(ListenerMux listenerMux2) {
        ListenerMux listenerMux3 = this.listenerMux;
        if (listenerMux3 != null) {
            this.exoMediaPlayer.removeListener(listenerMux3);
            this.exoMediaPlayer.removeAnalyticsListener(this.listenerMux);
        }
        this.listenerMux = listenerMux2;
        this.exoMediaPlayer.addListener(listenerMux2);
        this.exoMediaPlayer.addAnalyticsListener(listenerMux2);
    }

    public void setRepeatMode(int i) {
        this.exoMediaPlayer.setRepeatMode(i);
    }

    public void onSurfaceReady(Surface surface) {
        this.exoMediaPlayer.setSurface(surface);
        if (this.playRequested) {
            this.exoMediaPlayer.setPlayWhenReady(true);
        }
    }

    public void onSurfaceDestroyed() {
        this.exoMediaPlayer.clearSurface();
    }

    /* access modifiers changed from: protected */
    public void setup() {
        initExoPlayer();
    }

    /* access modifiers changed from: protected */
    public void initExoPlayer() {
        ExoMediaPlayer exoMediaPlayer2 = new ExoMediaPlayer(this.context);
        this.exoMediaPlayer = exoMediaPlayer2;
        exoMediaPlayer2.setMetadataListener(this.internalListeners);
        this.exoMediaPlayer.setBufferUpdateListener(this.internalListeners);
    }

    protected class InternalListeners implements MetadataListener, OnBufferUpdateListener {
        protected InternalListeners() {
        }

        public void onMetadata(Metadata metadata) {
            ExoVideoDelegate.this.listenerMux.onMetadata(metadata);
        }

        public void onBufferingUpdate(int i) {
            ExoVideoDelegate.this.listenerMux.onBufferingUpdate(i);
        }
    }
}
