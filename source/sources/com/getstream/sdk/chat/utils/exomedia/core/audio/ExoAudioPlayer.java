package com.getstream.sdk.chat.utils.exomedia.core.audio;

import android.content.Context;
import android.net.Uri;
import com.getstream.sdk.chat.utils.exomedia.ExoMedia;
import com.getstream.sdk.chat.utils.exomedia.core.ListenerMux;
import com.getstream.sdk.chat.utils.exomedia.core.api.AudioPlayerApi;
import com.getstream.sdk.chat.utils.exomedia.core.exoplayer.ExoMediaPlayer;
import com.getstream.sdk.chat.utils.exomedia.core.exoplayer.WindowInfo;
import com.getstream.sdk.chat.utils.exomedia.core.listener.MetadataListener;
import com.getstream.sdk.chat.utils.exomedia.listener.OnBufferUpdateListener;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.Map;

public class ExoAudioPlayer implements AudioPlayerApi {
    protected final Context context;
    protected final ExoMediaPlayer exoMediaPlayer;
    protected InternalListeners internalListeners = new InternalListeners();
    protected ListenerMux listenerMux;
    protected boolean playRequested = false;

    public void onMediaPrepared() {
    }

    public void reset() {
    }

    public boolean trackSelectionAvailable() {
        return true;
    }

    public ExoAudioPlayer(Context context2) {
        this.context = context2;
        ExoMediaPlayer exoMediaPlayer2 = new ExoMediaPlayer(context2);
        this.exoMediaPlayer = exoMediaPlayer2;
        exoMediaPlayer2.setMetadataListener(this.internalListeners);
        exoMediaPlayer2.setBufferUpdateListener(this.internalListeners);
    }

    public void setDataSource(Uri uri) {
        setDataSource(uri, (MediaSource) null);
    }

    public void setDataSource(Uri uri, MediaSource mediaSource) {
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

    public void prepareAsync() {
        this.exoMediaPlayer.prepare();
    }

    public float getVolumeLeft() {
        return this.exoMediaPlayer.getVolume();
    }

    public float getVolumeRight() {
        return this.exoMediaPlayer.getVolume();
    }

    public void setVolume(float f, float f2) {
        this.exoMediaPlayer.setVolume((f + f2) / 2.0f);
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

    public void stopPlayback() {
        this.exoMediaPlayer.stop();
        this.playRequested = false;
    }

    public boolean restart() {
        if (!this.exoMediaPlayer.restart()) {
            return false;
        }
        this.listenerMux.setNotifiedCompleted(false);
        this.listenerMux.setNotifiedPrepared(false);
        return true;
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

    public void release() {
        this.exoMediaPlayer.release();
    }

    public int getAudioSessionId() {
        return this.exoMediaPlayer.getAudioSessionId();
    }

    public boolean setPlaybackSpeed(float f) {
        return this.exoMediaPlayer.setPlaybackSpeed(f);
    }

    public float getPlaybackSpeed() {
        return this.exoMediaPlayer.getPlaybackSpeed();
    }

    public void setAudioStreamType(int i) {
        this.exoMediaPlayer.setAudioStreamType(i);
    }

    public void setWakeMode(Context context2, int i) {
        this.exoMediaPlayer.setWakeMode(context2, i);
    }

    public void setTrack(ExoMedia.RendererType rendererType, int i) {
        this.exoMediaPlayer.setSelectedTrack(rendererType, 0, i);
    }

    public void setTrack(ExoMedia.RendererType rendererType, int i, int i2) {
        this.exoMediaPlayer.setSelectedTrack(rendererType, i, i2);
    }

    public int getSelectedTrackIndex(ExoMedia.RendererType rendererType, int i) {
        return this.exoMediaPlayer.getSelectedTrackIndex(rendererType, i);
    }

    public Map<ExoMedia.RendererType, TrackGroupArray> getAvailableTracks() {
        return this.exoMediaPlayer.getAvailableTracks();
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

    protected class InternalListeners implements MetadataListener, OnBufferUpdateListener {
        protected InternalListeners() {
        }

        public void onMetadata(Metadata metadata) {
            ExoAudioPlayer.this.listenerMux.onMetadata(metadata);
        }

        public void onBufferingUpdate(int i) {
            ExoAudioPlayer.this.listenerMux.onBufferingUpdate(i);
        }
    }
}
