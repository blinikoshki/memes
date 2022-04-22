package com.getstream.sdk.chat.utils.exomedia.core.api;

import android.net.Uri;
import android.view.View;
import com.getstream.sdk.chat.utils.exomedia.ExoMedia;
import com.getstream.sdk.chat.utils.exomedia.core.ListenerMux;
import com.getstream.sdk.chat.utils.exomedia.core.exoplayer.WindowInfo;
import com.getstream.sdk.chat.utils.exomedia.core.listener.CaptionListener;
import com.getstream.sdk.chat.utils.exomedia.core.video.scale.ScaleType;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.Map;

public interface VideoViewApi {

    public interface OnSurfaceSizeChanged {
        void onSurfaceSizeChanged(int i, int i2);
    }

    void clearSelectedTracks(ExoMedia.RendererType rendererType);

    Map<ExoMedia.RendererType, TrackGroupArray> getAvailableTracks();

    int getBufferedPercent();

    long getCurrentPosition();

    long getDuration();

    int getHeight();

    float getPlaybackSpeed();

    ScaleType getScaleType();

    int getSelectedTrackIndex(ExoMedia.RendererType rendererType, int i);

    float getVolume();

    int getWidth();

    WindowInfo getWindowInfo();

    boolean isPlaying();

    boolean isRendererEnabled(ExoMedia.RendererType rendererType);

    void onVideoSizeChanged(int i, int i2, float f);

    void pause();

    void release();

    boolean restart();

    void seekTo(long j);

    void setCaptionListener(CaptionListener captionListener);

    void setDrmCallback(MediaDrmCallback mediaDrmCallback);

    void setListenerMux(ListenerMux listenerMux);

    void setMeasureBasedOnAspectRatioEnabled(boolean z);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    boolean setPlaybackSpeed(float f);

    void setRendererEnabled(ExoMedia.RendererType rendererType, boolean z);

    void setRepeatMode(int i);

    void setScaleType(ScaleType scaleType);

    @Deprecated
    void setTrack(ExoMedia.RendererType rendererType, int i);

    void setTrack(ExoMedia.RendererType rendererType, int i, int i2);

    void setVideoRotation(int i, boolean z);

    void setVideoUri(Uri uri);

    void setVideoUri(Uri uri, MediaSource mediaSource);

    boolean setVolume(float f);

    void start();

    void stopPlayback(boolean z);

    void suspend();

    boolean trackSelectionAvailable();
}
