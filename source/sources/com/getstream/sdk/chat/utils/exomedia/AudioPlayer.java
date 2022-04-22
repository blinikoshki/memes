package com.getstream.sdk.chat.utils.exomedia;

import android.content.Context;
import android.net.Uri;
import com.getstream.sdk.chat.utils.exomedia.ExoMedia;
import com.getstream.sdk.chat.utils.exomedia.core.ListenerMux;
import com.getstream.sdk.chat.utils.exomedia.core.api.AudioPlayerApi;
import com.getstream.sdk.chat.utils.exomedia.core.audio.ExoAudioPlayer;
import com.getstream.sdk.chat.utils.exomedia.core.audio.NativeAudioPlayer;
import com.getstream.sdk.chat.utils.exomedia.core.exoplayer.ExoMediaPlayer;
import com.getstream.sdk.chat.utils.exomedia.core.exoplayer.WindowInfo;
import com.getstream.sdk.chat.utils.exomedia.core.listener.MetadataListener;
import com.getstream.sdk.chat.utils.exomedia.listener.OnBufferUpdateListener;
import com.getstream.sdk.chat.utils.exomedia.listener.OnCompletionListener;
import com.getstream.sdk.chat.utils.exomedia.listener.OnErrorListener;
import com.getstream.sdk.chat.utils.exomedia.listener.OnPreparedListener;
import com.getstream.sdk.chat.utils.exomedia.listener.OnSeekCompletionListener;
import com.getstream.sdk.chat.utils.exomedia.util.DeviceUtil;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.Map;

public class AudioPlayer {
    protected AudioPlayerApi audioPlayerImpl;
    protected ListenerMux listenerMux;
    protected long overriddenDuration;

    public AudioPlayer(Context context) {
        this(context, new DeviceUtil());
    }

    public AudioPlayer(Context context, DeviceUtil deviceUtil) {
        this.overriddenDuration = -1;
        init(deviceUtil.supportsExoPlayer(context) ? new ExoAudioPlayer(context) : new NativeAudioPlayer(context));
    }

    public AudioPlayer(AudioPlayerApi audioPlayerApi) {
        this.overriddenDuration = -1;
        init(audioPlayerApi);
    }

    /* access modifiers changed from: protected */
    public void init(AudioPlayerApi audioPlayerApi) {
        this.audioPlayerImpl = audioPlayerApi;
        ListenerMux listenerMux2 = new ListenerMux(new MuxNotifier());
        this.listenerMux = listenerMux2;
        audioPlayerApi.setListenerMux(listenerMux2);
    }

    public int getAudioSessionId() {
        return this.audioPlayerImpl.getAudioSessionId();
    }

    public void setRepeatMode(int i) {
        this.audioPlayerImpl.setRepeatMode(i);
    }

    public boolean setPlaybackSpeed(float f) {
        return this.audioPlayerImpl.setPlaybackSpeed(f);
    }

    public float getPlaybackSpeed() {
        return this.audioPlayerImpl.getPlaybackSpeed();
    }

    public void setAudioStreamType(int i) {
        this.audioPlayerImpl.setAudioStreamType(i);
    }

    public void setDataSource(Uri uri) {
        this.audioPlayerImpl.setDataSource(uri);
        overrideDuration(-1);
    }

    public void setDataSource(Uri uri, MediaSource mediaSource) {
        this.audioPlayerImpl.setDataSource(uri, mediaSource);
        overrideDuration(-1);
    }

    public void setDrmCallback(MediaDrmCallback mediaDrmCallback) {
        this.audioPlayerImpl.setDrmCallback(mediaDrmCallback);
    }

    public void prepareAsync() {
        this.audioPlayerImpl.prepareAsync();
    }

    public float getVolumeLeft() {
        return this.audioPlayerImpl.getVolumeLeft();
    }

    /* access modifiers changed from: package-private */
    public float getVolumeRight() {
        return this.audioPlayerImpl.getVolumeRight();
    }

    public void setVolume(float f, float f2) {
        this.audioPlayerImpl.setVolume(f, f2);
    }

    public void setWakeMode(Context context, int i) {
        this.audioPlayerImpl.setWakeMode(context, i);
    }

    public void reset() {
        stopPlayback();
        setDataSource((Uri) null, (MediaSource) null);
        this.audioPlayerImpl.reset();
    }

    public void seekTo(long j) {
        this.audioPlayerImpl.seekTo(j);
    }

    public boolean isPlaying() {
        return this.audioPlayerImpl.isPlaying();
    }

    public void start() {
        this.audioPlayerImpl.start();
    }

    public void pause() {
        this.audioPlayerImpl.pause();
    }

    public void stopPlayback() {
        this.audioPlayerImpl.stopPlayback();
    }

    public void release() {
        this.audioPlayerImpl.release();
    }

    public long getDuration() {
        long j = this.overriddenDuration;
        if (j >= 0) {
            return j;
        }
        return this.audioPlayerImpl.getDuration();
    }

    public void overrideDuration(long j) {
        this.overriddenDuration = j;
    }

    public long getCurrentPosition() {
        return this.audioPlayerImpl.getCurrentPosition();
    }

    public int getBufferPercentage() {
        return this.audioPlayerImpl.getBufferedPercent();
    }

    public WindowInfo getWindowInfo() {
        return this.audioPlayerImpl.getWindowInfo();
    }

    public boolean trackSelectionAvailable() {
        return this.audioPlayerImpl.trackSelectionAvailable();
    }

    @Deprecated
    public void setTrack(ExoMedia.RendererType rendererType, int i) {
        this.audioPlayerImpl.setTrack(rendererType, 0, i);
    }

    public void setTrack(ExoMedia.RendererType rendererType, int i, int i2) {
        this.audioPlayerImpl.setTrack(rendererType, i, i2);
    }

    public int getSelectedTrackIndex(ExoMedia.RendererType rendererType, int i) {
        return this.audioPlayerImpl.getSelectedTrackIndex(rendererType, i);
    }

    public Map<ExoMedia.RendererType, TrackGroupArray> getAvailableTracks() {
        return this.audioPlayerImpl.getAvailableTracks();
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.listenerMux.setOnPreparedListener(onPreparedListener);
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.listenerMux.setOnCompletionListener(onCompletionListener);
    }

    public void setOnBufferUpdateListener(OnBufferUpdateListener onBufferUpdateListener) {
        this.listenerMux.setOnBufferUpdateListener(onBufferUpdateListener);
    }

    public void setOnSeekCompletionListener(OnSeekCompletionListener onSeekCompletionListener) {
        this.listenerMux.setOnSeekCompletionListener(onSeekCompletionListener);
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.listenerMux.setOnErrorListener(onErrorListener);
    }

    public void setMetadataListener(MetadataListener metadataListener) {
        this.listenerMux.setMetadataListener(metadataListener);
    }

    public void setAnalyticsListener(AnalyticsListener analyticsListener) {
        this.listenerMux.setAnalyticsListener(analyticsListener);
    }

    /* access modifiers changed from: private */
    public void onPlaybackEnded() {
        pause();
    }

    private class MuxNotifier extends ListenerMux.Notifier {
        private MuxNotifier() {
        }

        public boolean shouldNotifyCompletion(long j) {
            long currentPosition = AudioPlayer.this.getCurrentPosition();
            long duration = AudioPlayer.this.getDuration();
            return currentPosition > 0 && duration > 0 && currentPosition + j >= duration;
        }

        public void onExoPlayerError(ExoMediaPlayer exoMediaPlayer, Exception exc) {
            AudioPlayer.this.stopPlayback();
            if (exoMediaPlayer != null) {
                exoMediaPlayer.forcePrepare();
            }
        }

        public void onMediaPlaybackEnded() {
            AudioPlayer.this.onPlaybackEnded();
        }

        public void onPrepared() {
            AudioPlayer.this.audioPlayerImpl.onMediaPrepared();
        }
    }
}
