package com.getstream.sdk.chat.utils.exomedia.core.video.p011mp;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import com.getstream.sdk.chat.utils.exomedia.core.ListenerMux;
import com.getstream.sdk.chat.utils.exomedia.core.exoplayer.WindowInfo;
import com.getstream.sdk.chat.utils.exomedia.core.video.ClearableSurface;
import com.memes.eventtracker.util.Util;
import java.io.IOException;
import java.util.Map;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;

/* renamed from: com.getstream.sdk.chat.utils.exomedia.core.video.mp.NativeVideoDelegate */
public class NativeVideoDelegate {
    protected Callback callback;
    protected ClearableSurface clearableSurface;
    protected Context context;
    protected int currentBufferPercent;
    protected State currentState = State.IDLE;
    protected Map<String, String> headers;
    protected InternalListeners internalListeners = new InternalListeners();
    protected ListenerMux listenerMux;
    /* access modifiers changed from: private */
    public TaggedLogger logger = ChatLogger.Companion.get("NativeVideoDelegate");
    protected MediaPlayer mediaPlayer;
    protected MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener;
    protected MediaPlayer.OnCompletionListener onCompletionListener;
    protected MediaPlayer.OnErrorListener onErrorListener;
    protected MediaPlayer.OnInfoListener onInfoListener;
    protected MediaPlayer.OnPreparedListener onPreparedListener;
    protected MediaPlayer.OnSeekCompleteListener onSeekCompleteListener;
    protected boolean playRequested = false;
    protected long requestedSeek;
    protected float requestedVolume = 1.0f;

    /* renamed from: com.getstream.sdk.chat.utils.exomedia.core.video.mp.NativeVideoDelegate$Callback */
    public interface Callback {
        void videoSizeChanged(int i, int i2);
    }

    /* renamed from: com.getstream.sdk.chat.utils.exomedia.core.video.mp.NativeVideoDelegate$State */
    public enum State {
        ERROR,
        IDLE,
        PREPARING,
        PREPARED,
        PLAYING,
        PAUSED,
        COMPLETED
    }

    public WindowInfo getWindowInfo() {
        return null;
    }

    public NativeVideoDelegate(Context context2, Callback callback2, ClearableSurface clearableSurface2) {
        this.context = context2;
        this.callback = callback2;
        this.clearableSurface = clearableSurface2;
        initMediaPlayer();
        this.currentState = State.IDLE;
    }

    public void start() {
        if (isReady()) {
            this.mediaPlayer.start();
            this.currentState = State.PLAYING;
        }
        this.playRequested = true;
        this.listenerMux.setNotifiedCompleted(false);
    }

    public void pause() {
        if (isReady() && this.mediaPlayer.isPlaying()) {
            this.mediaPlayer.pause();
            this.currentState = State.PAUSED;
        }
        this.playRequested = false;
    }

    public long getDuration() {
        if (!this.listenerMux.isPrepared() || !isReady()) {
            return 0;
        }
        return (long) this.mediaPlayer.getDuration();
    }

    public long getCurrentPosition() {
        if (!this.listenerMux.isPrepared() || !isReady()) {
            return 0;
        }
        return (long) this.mediaPlayer.getCurrentPosition();
    }

    public float getVolume() {
        return this.requestedVolume;
    }

    public boolean setVolume(float f) {
        this.requestedVolume = f;
        this.mediaPlayer.setVolume(f, f);
        return true;
    }

    public void seekTo(long j) {
        if (isReady()) {
            this.mediaPlayer.seekTo((int) j);
            this.requestedSeek = 0;
            return;
        }
        this.requestedSeek = j;
    }

    public boolean isPlaying() {
        return isReady() && this.mediaPlayer.isPlaying();
    }

    public int getBufferPercentage() {
        if (this.mediaPlayer != null) {
            return this.currentBufferPercent;
        }
        return 0;
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

    public void stopPlayback(boolean z) {
        this.currentState = State.IDLE;
        if (isReady()) {
            try {
                this.mediaPlayer.stop();
            } catch (Exception e) {
                this.logger.logE("stopPlayback: error calling mediaPlayer.stop()", (Throwable) e);
            }
        }
        this.playRequested = false;
        if (z) {
            this.listenerMux.clearSurfaceWhenReady(this.clearableSurface);
        }
    }

    public void suspend() {
        this.currentState = State.IDLE;
        try {
            this.mediaPlayer.reset();
            this.mediaPlayer.release();
        } catch (Exception e) {
            this.logger.logE("stopPlayback: error calling mediaPlayer.reset() or mediaPlayer.release().", (Throwable) e);
        }
        this.playRequested = false;
    }

    public boolean restart() {
        if (this.currentState != State.COMPLETED) {
            return false;
        }
        seekTo(0);
        start();
        this.listenerMux.setNotifiedPrepared(false);
        this.listenerMux.setNotifiedCompleted(false);
        return true;
    }

    public void setVideoURI(Uri uri, Map<String, String> map) {
        this.headers = map;
        this.requestedSeek = 0;
        this.playRequested = false;
        openVideo(uri);
    }

    public void setListenerMux(ListenerMux listenerMux2) {
        this.listenerMux = listenerMux2;
        setOnCompletionListener(listenerMux2);
        setOnPreparedListener(listenerMux2);
        setOnBufferingUpdateListener(listenerMux2);
        setOnSeekCompleteListener(listenerMux2);
        setOnErrorListener(listenerMux2);
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener2) {
        this.onPreparedListener = onPreparedListener2;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener2) {
        this.onCompletionListener = onCompletionListener2;
    }

    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener2) {
        this.onBufferingUpdateListener = onBufferingUpdateListener2;
    }

    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener2) {
        this.onSeekCompleteListener = onSeekCompleteListener2;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener2) {
        this.onErrorListener = onErrorListener2;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener2) {
        this.onInfoListener = onInfoListener2;
    }

    public void onSurfaceSizeChanged(int i, int i2) {
        if (this.mediaPlayer != null && i > 0 && i2 > 0) {
            long j = this.requestedSeek;
            if (j != 0) {
                seekTo(j);
            }
            if (this.playRequested) {
                start();
            }
        }
    }

    public void onSurfaceReady(Surface surface) {
        this.mediaPlayer.setSurface(surface);
        if (this.playRequested) {
            start();
        }
    }

    /* access modifiers changed from: protected */
    public void initMediaPlayer() {
        MediaPlayer mediaPlayer2 = new MediaPlayer();
        this.mediaPlayer = mediaPlayer2;
        mediaPlayer2.setOnInfoListener(this.internalListeners);
        this.mediaPlayer.setOnErrorListener(this.internalListeners);
        this.mediaPlayer.setOnPreparedListener(this.internalListeners);
        this.mediaPlayer.setOnCompletionListener(this.internalListeners);
        this.mediaPlayer.setOnSeekCompleteListener(this.internalListeners);
        this.mediaPlayer.setOnBufferingUpdateListener(this.internalListeners);
        this.mediaPlayer.setOnVideoSizeChangedListener(this.internalListeners);
        this.mediaPlayer.setAudioStreamType(3);
        this.mediaPlayer.setScreenOnWhilePlaying(true);
    }

    /* access modifiers changed from: protected */
    public boolean isReady() {
        return (this.currentState == State.ERROR || this.currentState == State.IDLE || this.currentState == State.PREPARING) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void openVideo(Uri uri) {
        if (uri != null) {
            this.currentBufferPercent = 0;
            try {
                this.mediaPlayer.reset();
                this.mediaPlayer.setDataSource(this.context.getApplicationContext(), uri, this.headers);
                this.mediaPlayer.prepareAsync();
                this.currentState = State.PREPARING;
            } catch (IOException | IllegalArgumentException e) {
                TaggedLogger taggedLogger = this.logger;
                taggedLogger.logE("Unable to open content: " + uri, e);
                this.currentState = State.ERROR;
                this.internalListeners.onError(this.mediaPlayer, 1, 0);
            }
        }
    }

    /* renamed from: com.getstream.sdk.chat.utils.exomedia.core.video.mp.NativeVideoDelegate$InternalListeners */
    public class InternalListeners implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {
        public InternalListeners() {
        }

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            NativeVideoDelegate.this.currentBufferPercent = i;
            if (NativeVideoDelegate.this.onBufferingUpdateListener != null) {
                NativeVideoDelegate.this.onBufferingUpdateListener.onBufferingUpdate(mediaPlayer, i);
            }
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            NativeVideoDelegate.this.currentState = State.COMPLETED;
            if (NativeVideoDelegate.this.onCompletionListener != null) {
                NativeVideoDelegate.this.onCompletionListener.onCompletion(NativeVideoDelegate.this.mediaPlayer);
            }
        }

        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (NativeVideoDelegate.this.onSeekCompleteListener != null) {
                NativeVideoDelegate.this.onSeekCompleteListener.onSeekComplete(mediaPlayer);
            }
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            TaggedLogger access$000 = NativeVideoDelegate.this.logger;
            access$000.logE("Error: " + i + Util.EVENT_ID_SEPARATOR + i2);
            NativeVideoDelegate.this.currentState = State.ERROR;
            return NativeVideoDelegate.this.onErrorListener == null || NativeVideoDelegate.this.onErrorListener.onError(NativeVideoDelegate.this.mediaPlayer, i, i2);
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            NativeVideoDelegate.this.currentState = State.PREPARED;
            if (NativeVideoDelegate.this.onPreparedListener != null) {
                NativeVideoDelegate.this.onPreparedListener.onPrepared(NativeVideoDelegate.this.mediaPlayer);
            }
            NativeVideoDelegate.this.callback.videoSizeChanged(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            if (NativeVideoDelegate.this.requestedSeek != 0) {
                NativeVideoDelegate nativeVideoDelegate = NativeVideoDelegate.this;
                nativeVideoDelegate.seekTo(nativeVideoDelegate.requestedSeek);
            }
            if (NativeVideoDelegate.this.playRequested) {
                NativeVideoDelegate.this.start();
            }
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            return NativeVideoDelegate.this.onInfoListener == null || NativeVideoDelegate.this.onInfoListener.onInfo(mediaPlayer, i, i2);
        }

        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            NativeVideoDelegate.this.callback.videoSizeChanged(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        }
    }
}
