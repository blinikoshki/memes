package com.getstream.sdk.chat.utils.exomedia.core.audio;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import com.getstream.sdk.chat.utils.exomedia.ExoMedia;
import com.getstream.sdk.chat.utils.exomedia.core.ListenerMux;
import com.getstream.sdk.chat.utils.exomedia.core.api.AudioPlayerApi;
import com.getstream.sdk.chat.utils.exomedia.core.exoplayer.WindowInfo;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.Map;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;

public class NativeAudioPlayer implements AudioPlayerApi {
    private static final String TAG = "NativeMediaPlayer";
    protected final Context context;
    protected int currentBufferPercent = 0;
    protected InternalListeners internalListeners = new InternalListeners();
    protected ListenerMux listenerMux;
    private TaggedLogger logger = ChatLogger.Companion.get("NativeAudioPlayer");
    protected final MediaPlayer mediaPlayer;
    protected long requestedSeek;
    protected float volumeLeft = 1.0f;
    protected float volumeRight = 1.0f;

    public Map<ExoMedia.RendererType, TrackGroupArray> getAvailableTracks() {
        return null;
    }

    public int getSelectedTrackIndex(ExoMedia.RendererType rendererType, int i) {
        return -1;
    }

    public WindowInfo getWindowInfo() {
        return null;
    }

    public void setDrmCallback(MediaDrmCallback mediaDrmCallback) {
    }

    public void setRepeatMode(int i) {
    }

    public void setTrack(ExoMedia.RendererType rendererType, int i) {
    }

    public void setTrack(ExoMedia.RendererType rendererType, int i, int i2) {
    }

    public boolean trackSelectionAvailable() {
        return false;
    }

    public NativeAudioPlayer(Context context2) {
        this.context = context2;
        MediaPlayer mediaPlayer2 = new MediaPlayer();
        this.mediaPlayer = mediaPlayer2;
        mediaPlayer2.setOnBufferingUpdateListener(this.internalListeners);
    }

    public void setDataSource(Uri uri) {
        setDataSource(uri, (MediaSource) null);
    }

    public void setDataSource(Uri uri, MediaSource mediaSource) {
        try {
            this.requestedSeek = 0;
            this.mediaPlayer.setDataSource(this.context, uri);
        } catch (Exception e) {
            this.logger.logE("Eerror setting data source", (Throwable) e);
        }
    }

    public void prepareAsync() {
        try {
            this.mediaPlayer.prepareAsync();
        } catch (Exception unused) {
        }
    }

    public void reset() {
        this.mediaPlayer.reset();
    }

    public float getVolumeLeft() {
        return this.volumeLeft;
    }

    public float getVolumeRight() {
        return this.volumeRight;
    }

    public void setVolume(float f, float f2) {
        this.volumeLeft = f;
        this.volumeRight = f2;
        this.mediaPlayer.setVolume(f, f2);
    }

    public void seekTo(long j) {
        ListenerMux listenerMux2 = this.listenerMux;
        if (listenerMux2 == null || !listenerMux2.isPrepared()) {
            this.requestedSeek = j;
            return;
        }
        this.mediaPlayer.seekTo((int) j);
        this.requestedSeek = 0;
    }

    public boolean isPlaying() {
        return this.mediaPlayer.isPlaying();
    }

    public void start() {
        this.mediaPlayer.start();
        ListenerMux listenerMux2 = this.listenerMux;
        if (listenerMux2 != null) {
            listenerMux2.setNotifiedCompleted(false);
        }
    }

    public void pause() {
        this.mediaPlayer.pause();
    }

    public void stopPlayback() {
        this.mediaPlayer.stop();
    }

    public boolean restart() {
        ListenerMux listenerMux2 = this.listenerMux;
        if (listenerMux2 == null || !listenerMux2.isPrepared()) {
            return false;
        }
        this.mediaPlayer.seekTo(0);
        this.mediaPlayer.start();
        this.listenerMux.setNotifiedCompleted(false);
        return true;
    }

    public long getDuration() {
        ListenerMux listenerMux2 = this.listenerMux;
        if (listenerMux2 == null || !listenerMux2.isPrepared()) {
            return 0;
        }
        return (long) this.mediaPlayer.getDuration();
    }

    public long getCurrentPosition() {
        ListenerMux listenerMux2 = this.listenerMux;
        if (listenerMux2 == null || !listenerMux2.isPrepared()) {
            return 0;
        }
        return (long) this.mediaPlayer.getCurrentPosition();
    }

    public int getBufferedPercent() {
        return this.currentBufferPercent;
    }

    public void release() {
        this.mediaPlayer.release();
    }

    public int getAudioSessionId() {
        return this.mediaPlayer.getAudioSessionId();
    }

    public boolean setPlaybackSpeed(float f) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        PlaybackParams playbackParams = new PlaybackParams();
        playbackParams.setSpeed(f);
        this.mediaPlayer.setPlaybackParams(playbackParams);
        return true;
    }

    public float getPlaybackSpeed() {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.mediaPlayer.getPlaybackParams().getSpeed();
        }
        return 1.0f;
    }

    public void setAudioStreamType(int i) {
        this.mediaPlayer.setAudioStreamType(i);
    }

    public void setWakeMode(Context context2, int i) {
        this.mediaPlayer.setWakeMode(context2, i);
    }

    public void setListenerMux(ListenerMux listenerMux2) {
        this.listenerMux = listenerMux2;
        this.mediaPlayer.setOnCompletionListener(listenerMux2);
        this.mediaPlayer.setOnPreparedListener(listenerMux2);
        this.mediaPlayer.setOnBufferingUpdateListener(listenerMux2);
        this.mediaPlayer.setOnSeekCompleteListener(listenerMux2);
        this.mediaPlayer.setOnErrorListener(listenerMux2);
    }

    public void onMediaPrepared() {
        long j = this.requestedSeek;
        if (j != 0) {
            seekTo(j);
        }
    }

    protected class InternalListeners implements MediaPlayer.OnBufferingUpdateListener {
        protected InternalListeners() {
        }

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            NativeAudioPlayer.this.listenerMux.onBufferingUpdate(i);
            NativeAudioPlayer.this.currentBufferPercent = i;
        }
    }
}
