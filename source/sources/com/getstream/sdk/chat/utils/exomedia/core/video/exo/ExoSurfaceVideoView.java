package com.getstream.sdk.chat.utils.exomedia.core.video.exo;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.getstream.sdk.chat.utils.exomedia.ExoMedia;
import com.getstream.sdk.chat.utils.exomedia.core.ListenerMux;
import com.getstream.sdk.chat.utils.exomedia.core.api.VideoViewApi;
import com.getstream.sdk.chat.utils.exomedia.core.exoplayer.WindowInfo;
import com.getstream.sdk.chat.utils.exomedia.core.listener.CaptionListener;
import com.getstream.sdk.chat.utils.exomedia.core.video.ResizingSurfaceView;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.Map;

public class ExoSurfaceVideoView extends ResizingSurfaceView implements VideoViewApi {
    protected ExoVideoDelegate delegate;

    public ExoSurfaceVideoView(Context context) {
        super(context);
        setup();
    }

    public ExoSurfaceVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setup();
    }

    public ExoSurfaceVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setup();
    }

    public ExoSurfaceVideoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setup();
    }

    public void setVideoUri(Uri uri) {
        this.delegate.setVideoUri(uri);
    }

    public void setVideoUri(Uri uri, MediaSource mediaSource) {
        this.delegate.setVideoUri(uri, mediaSource);
    }

    public void setDrmCallback(MediaDrmCallback mediaDrmCallback) {
        this.delegate.setDrmCallback(mediaDrmCallback);
    }

    public boolean restart() {
        return this.delegate.restart();
    }

    public float getVolume() {
        return this.delegate.getVolume();
    }

    public boolean setVolume(float f) {
        return this.delegate.setVolume(f);
    }

    public void seekTo(long j) {
        this.delegate.seekTo(j);
    }

    public boolean isPlaying() {
        return this.delegate.isPlaying();
    }

    public void start() {
        this.delegate.start();
    }

    public void pause() {
        this.delegate.pause();
    }

    public void stopPlayback(boolean z) {
        this.delegate.stopPlayback(z);
    }

    public void suspend() {
        this.delegate.suspend();
    }

    public long getDuration() {
        return this.delegate.getDuration();
    }

    public long getCurrentPosition() {
        return this.delegate.getCurrentPosition();
    }

    public int getBufferedPercent() {
        return this.delegate.getBufferedPercent();
    }

    public WindowInfo getWindowInfo() {
        return this.delegate.getWindowInfo();
    }

    public boolean setPlaybackSpeed(float f) {
        return this.delegate.setPlaybackSpeed(f);
    }

    public float getPlaybackSpeed() {
        return this.delegate.getPlaybackSpeed();
    }

    public void setCaptionListener(CaptionListener captionListener) {
        this.delegate.setCaptionListener(captionListener);
    }

    public boolean trackSelectionAvailable() {
        return this.delegate.trackSelectionAvailable();
    }

    public void setTrack(ExoMedia.RendererType rendererType, int i) {
        this.delegate.setTrack(rendererType, 0, i);
    }

    public void setTrack(ExoMedia.RendererType rendererType, int i, int i2) {
        this.delegate.setTrack(rendererType, i, i2);
    }

    public int getSelectedTrackIndex(ExoMedia.RendererType rendererType, int i) {
        return this.delegate.getSelectedTrackIndex(rendererType, i);
    }

    public void clearSelectedTracks(ExoMedia.RendererType rendererType) {
        this.delegate.clearSelectedTracks(rendererType);
    }

    public Map<ExoMedia.RendererType, TrackGroupArray> getAvailableTracks() {
        return this.delegate.getAvailableTracks();
    }

    public void setRendererEnabled(ExoMedia.RendererType rendererType, boolean z) {
        this.delegate.setRendererEnabled(rendererType, z);
    }

    public boolean isRendererEnabled(ExoMedia.RendererType rendererType) {
        return this.delegate.isRendererEnabled(rendererType);
    }

    public void release() {
        this.delegate.release();
    }

    public void setListenerMux(ListenerMux listenerMux) {
        this.delegate.setListenerMux(listenerMux);
    }

    public void onVideoSizeChanged(int i, int i2, float f) {
        if (updateVideoSize((int) (((float) i) * f), i2)) {
            requestLayout();
        }
    }

    public void setRepeatMode(int i) {
        this.delegate.setRepeatMode(i);
    }

    /* access modifiers changed from: protected */
    public void setup() {
        this.delegate = new ExoVideoDelegate(getContext(), this);
        getHolder().addCallback(new HolderCallback());
        updateVideoSize(0, 0);
    }

    protected class HolderCallback implements SurfaceHolder.Callback {
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        protected HolderCallback() {
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            ExoSurfaceVideoView.this.delegate.onSurfaceReady(surfaceHolder.getSurface());
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            ExoSurfaceVideoView.this.delegate.onSurfaceDestroyed();
            surfaceHolder.getSurface().release();
        }
    }
}
