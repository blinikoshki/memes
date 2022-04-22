package com.getstream.sdk.chat.utils.exomedia.core.api;

import android.content.Context;
import android.net.Uri;
import com.getstream.sdk.chat.utils.exomedia.ExoMedia;
import com.getstream.sdk.chat.utils.exomedia.core.ListenerMux;
import com.getstream.sdk.chat.utils.exomedia.core.exoplayer.WindowInfo;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.Map;

public interface AudioPlayerApi {
    int getAudioSessionId();

    Map<ExoMedia.RendererType, TrackGroupArray> getAvailableTracks();

    int getBufferedPercent();

    long getCurrentPosition();

    long getDuration();

    float getPlaybackSpeed();

    int getSelectedTrackIndex(ExoMedia.RendererType rendererType, int i);

    float getVolumeLeft();

    float getVolumeRight();

    WindowInfo getWindowInfo();

    boolean isPlaying();

    void onMediaPrepared();

    void pause();

    void prepareAsync();

    void release();

    void reset();

    boolean restart();

    void seekTo(long j);

    void setAudioStreamType(int i);

    void setDataSource(Uri uri);

    void setDataSource(Uri uri, MediaSource mediaSource);

    void setDrmCallback(MediaDrmCallback mediaDrmCallback);

    void setListenerMux(ListenerMux listenerMux);

    boolean setPlaybackSpeed(float f);

    void setRepeatMode(int i);

    @Deprecated
    void setTrack(ExoMedia.RendererType rendererType, int i);

    void setTrack(ExoMedia.RendererType rendererType, int i, int i2);

    void setVolume(float f, float f2);

    void setWakeMode(Context context, int i);

    void start();

    void stopPlayback();

    boolean trackSelectionAvailable();
}
