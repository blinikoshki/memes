package com.getstream.sdk.chat.utils.exomedia.core.video.p011mp;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.getstream.sdk.chat.utils.exomedia.ExoMedia;
import com.getstream.sdk.chat.utils.exomedia.core.ListenerMux;
import com.getstream.sdk.chat.utils.exomedia.core.api.VideoViewApi;
import com.getstream.sdk.chat.utils.exomedia.core.exoplayer.WindowInfo;
import com.getstream.sdk.chat.utils.exomedia.core.listener.CaptionListener;
import com.getstream.sdk.chat.utils.exomedia.core.video.ResizingTextureView;
import com.getstream.sdk.chat.utils.exomedia.core.video.p011mp.NativeVideoDelegate;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.Map;

/* renamed from: com.getstream.sdk.chat.utils.exomedia.core.video.mp.NativeTextureVideoView */
public class NativeTextureVideoView extends ResizingTextureView implements NativeVideoDelegate.Callback, VideoViewApi {
    protected NativeVideoDelegate delegate;
    protected View.OnTouchListener touchListener;

    public void clearSelectedTracks(ExoMedia.RendererType rendererType) {
    }

    public Map<ExoMedia.RendererType, TrackGroupArray> getAvailableTracks() {
        return null;
    }

    public int getSelectedTrackIndex(ExoMedia.RendererType rendererType, int i) {
        return -1;
    }

    public boolean isRendererEnabled(ExoMedia.RendererType rendererType) {
        return false;
    }

    public void release() {
    }

    public void setCaptionListener(CaptionListener captionListener) {
    }

    public void setDrmCallback(MediaDrmCallback mediaDrmCallback) {
    }

    public void setRendererEnabled(ExoMedia.RendererType rendererType, boolean z) {
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

    public NativeTextureVideoView(Context context) {
        super(context);
        setup(context, (AttributeSet) null);
    }

    public NativeTextureVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setup(context, attributeSet);
    }

    public NativeTextureVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setup(context, attributeSet);
    }

    public NativeTextureVideoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setup(context, attributeSet);
    }

    public void start() {
        this.delegate.start();
        requestFocus();
    }

    public void pause() {
        this.delegate.pause();
    }

    public long getDuration() {
        return this.delegate.getDuration();
    }

    public long getCurrentPosition() {
        return this.delegate.getCurrentPosition();
    }

    public void seekTo(long j) {
        this.delegate.seekTo(j);
    }

    public boolean isPlaying() {
        return this.delegate.isPlaying();
    }

    public void videoSizeChanged(int i, int i2) {
        if (updateVideoSize(i, i2)) {
            requestLayout();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener = this.touchListener;
        if ((onTouchListener != null ? onTouchListener.onTouch(this, motionEvent) : false) || super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.touchListener = onTouchListener;
        super.setOnTouchListener(onTouchListener);
    }

    public void setVideoUri(Uri uri) {
        setVideoUri(uri, (MediaSource) null);
    }

    public void setVideoUri(Uri uri, MediaSource mediaSource) {
        setVideoURI(uri);
    }

    public float getVolume() {
        return this.delegate.getVolume();
    }

    public boolean setVolume(float f) {
        return this.delegate.setVolume(f);
    }

    public int getBufferedPercent() {
        return this.delegate.getBufferPercentage();
    }

    public WindowInfo getWindowInfo() {
        return this.delegate.getWindowInfo();
    }

    public boolean restart() {
        return this.delegate.restart();
    }

    public void stopPlayback(boolean z) {
        this.delegate.stopPlayback(z);
    }

    public boolean setPlaybackSpeed(float f) {
        return this.delegate.setPlaybackSpeed(f);
    }

    public float getPlaybackSpeed() {
        return this.delegate.getPlaybackSpeed();
    }

    public void setListenerMux(ListenerMux listenerMux) {
        this.delegate.setListenerMux(listenerMux);
    }

    public void onVideoSizeChanged(int i, int i2, float f) {
        if (updateVideoSize((int) (((float) i) * f), i2)) {
            requestLayout();
        }
    }

    public void suspend() {
        this.delegate.suspend();
    }

    public void setVideoURI(Uri uri) {
        setVideoURI(uri, (Map<String, String>) null);
    }

    public void setVideoURI(Uri uri, Map<String, String> map) {
        this.delegate.setVideoURI(uri, map);
        requestLayout();
        invalidate();
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.delegate.setOnPreparedListener(onPreparedListener);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.delegate.setOnCompletionListener(onCompletionListener);
    }

    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.delegate.setOnBufferingUpdateListener(onBufferingUpdateListener);
    }

    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.delegate.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.delegate.setOnErrorListener(onErrorListener);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.delegate.setOnInfoListener(onInfoListener);
    }

    /* access modifiers changed from: protected */
    public void setup(Context context, AttributeSet attributeSet) {
        this.delegate = new NativeVideoDelegate(context, this, this);
        setSurfaceTextureListener(new TextureVideoViewSurfaceListener());
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        updateVideoSize(0, 0);
    }

    /* renamed from: com.getstream.sdk.chat.utils.exomedia.core.video.mp.NativeTextureVideoView$TextureVideoViewSurfaceListener */
    protected class TextureVideoViewSurfaceListener implements TextureView.SurfaceTextureListener {
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        protected TextureVideoViewSurfaceListener() {
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            NativeTextureVideoView.this.delegate.onSurfaceReady(new Surface(surfaceTexture));
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            NativeTextureVideoView.this.delegate.onSurfaceSizeChanged(i, i2);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            surfaceTexture.release();
            NativeTextureVideoView.this.suspend();
            return true;
        }
    }
}
