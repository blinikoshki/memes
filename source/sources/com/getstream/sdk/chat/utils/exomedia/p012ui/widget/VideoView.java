package com.getstream.sdk.chat.utils.exomedia.p012ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.getstream.sdk.chat.utils.exomedia.ExoMedia;
import com.getstream.sdk.chat.utils.exomedia.core.ListenerMux;
import com.getstream.sdk.chat.utils.exomedia.core.api.VideoViewApi;
import com.getstream.sdk.chat.utils.exomedia.core.exoplayer.ExoMediaPlayer;
import com.getstream.sdk.chat.utils.exomedia.core.exoplayer.WindowInfo;
import com.getstream.sdk.chat.utils.exomedia.core.listener.CaptionListener;
import com.getstream.sdk.chat.utils.exomedia.core.listener.MetadataListener;
import com.getstream.sdk.chat.utils.exomedia.core.video.scale.ScaleType;
import com.getstream.sdk.chat.utils.exomedia.listener.OnBufferUpdateListener;
import com.getstream.sdk.chat.utils.exomedia.listener.OnCompletionListener;
import com.getstream.sdk.chat.utils.exomedia.listener.OnErrorListener;
import com.getstream.sdk.chat.utils.exomedia.listener.OnPreparedListener;
import com.getstream.sdk.chat.utils.exomedia.listener.OnSeekCompletionListener;
import com.getstream.sdk.chat.utils.exomedia.listener.OnVideoSizeChangedListener;
import com.getstream.sdk.chat.utils.exomedia.util.DeviceUtil;
import com.getstream.sdk.chat.utils.exomedia.util.StopWatch;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Map;
import p015io.getstream.chat.android.p016ui.common.C1891R;

/* renamed from: com.getstream.sdk.chat.utils.exomedia.ui.widget.VideoView */
public class VideoView extends RelativeLayout {
    private static final String TAG = "VideoView";
    protected AudioFocusHelper audioFocusHelper = new AudioFocusHelper();
    protected AudioManager audioManager;
    protected DeviceUtil deviceUtil = new DeviceUtil();
    protected boolean handleAudioFocus = true;
    protected ListenerMux listenerMux;
    protected boolean matchOverridePositionSpeed = true;
    protected MuxNotifier muxNotifier = new MuxNotifier();
    protected long overriddenDuration = -1;
    protected StopWatch overriddenPositionStopWatch = new StopWatch();
    protected boolean overridePosition = false;
    protected long positionOffset = 0;
    protected ImageView previewImageView;
    protected boolean releaseOnDetachFromWindow = true;
    protected VideoControlsCore videoControls;
    protected Uri videoUri;
    protected VideoViewApi videoViewImpl;

    public VideoView(Context context) {
        super(context);
        setup(context, (AttributeSet) null);
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setup(context, attributeSet);
    }

    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setup(context, attributeSet);
    }

    public VideoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setup(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!isInEditMode() && this.releaseOnDetachFromWindow) {
            release();
        }
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.videoViewImpl.setOnTouchListener(onTouchListener);
        super.setOnTouchListener(onTouchListener);
    }

    public void setReleaseOnDetachFromWindow(boolean z) {
        this.releaseOnDetachFromWindow = z;
    }

    public void release() {
        VideoControlsCore videoControlsCore = this.videoControls;
        if (videoControlsCore != null) {
            videoControlsCore.onDetachedFromView(this);
            this.videoControls = null;
        }
        stopPlayback();
        this.overriddenPositionStopWatch.stop();
        this.videoViewImpl.release();
    }

    public void setPreviewImage(Drawable drawable) {
        ImageView imageView = this.previewImageView;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setPreviewImage(int i) {
        ImageView imageView = this.previewImageView;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public void setPreviewImage(Bitmap bitmap) {
        ImageView imageView = this.previewImageView;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public void setPreviewImage(Uri uri) {
        ImageView imageView = this.previewImageView;
        if (imageView != null) {
            imageView.setImageURI(uri);
        }
    }

    public ImageView getPreviewImageView() {
        return this.previewImageView;
    }

    @Deprecated
    public void setControls(VideoControls videoControls2) {
        setControls((VideoControlsCore) videoControls2);
    }

    public void setControls(VideoControlsCore videoControlsCore) {
        VideoControlsCore videoControlsCore2 = this.videoControls;
        if (!(videoControlsCore2 == null || videoControlsCore2 == videoControlsCore)) {
            videoControlsCore2.onDetachedFromView(this);
        }
        this.videoControls = videoControlsCore;
        if (videoControlsCore != null) {
            videoControlsCore.onAttachedToView(this);
        }
        TouchListener touchListener = new TouchListener(getContext());
        if (this.videoControls == null) {
            touchListener = null;
        }
        setOnTouchListener(touchListener);
    }

    public void showControls() {
        VideoControlsCore videoControlsCore = this.videoControls;
        if (videoControlsCore != null) {
            videoControlsCore.show();
            if (isPlaying()) {
                this.videoControls.hide(true);
            }
        }
    }

    @Deprecated
    public VideoControls getVideoControls() {
        VideoControlsCore videoControlsCore = this.videoControls;
        if (videoControlsCore == null || !(videoControlsCore instanceof VideoControls)) {
            return null;
        }
        return (VideoControls) videoControlsCore;
    }

    public VideoControlsCore getVideoControlsCore() {
        return this.videoControls;
    }

    public void setVideoURI(Uri uri) {
        this.videoUri = uri;
        this.videoViewImpl.setVideoUri(uri);
        VideoControlsCore videoControlsCore = this.videoControls;
        if (videoControlsCore != null) {
            videoControlsCore.showLoading(true);
        }
    }

    public void setVideoURI(Uri uri, MediaSource mediaSource) {
        this.videoUri = uri;
        this.videoViewImpl.setVideoUri(uri, mediaSource);
        VideoControlsCore videoControlsCore = this.videoControls;
        if (videoControlsCore != null) {
            videoControlsCore.showLoading(true);
        }
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public Uri getVideoUri() {
        return this.videoUri;
    }

    public void setDrmCallback(MediaDrmCallback mediaDrmCallback) {
        this.videoViewImpl.setDrmCallback(mediaDrmCallback);
    }

    public float getVolume() {
        return this.videoViewImpl.getVolume();
    }

    public boolean setVolume(float f) {
        return this.videoViewImpl.setVolume(f);
    }

    public void setHandleAudioFocus(boolean z) {
        this.audioFocusHelper.abandonFocus();
        this.handleAudioFocus = z;
    }

    public void reset() {
        stopPlayback();
        setVideoURI((Uri) null);
    }

    public void seekTo(long j) {
        VideoControlsCore videoControlsCore = this.videoControls;
        if (videoControlsCore != null) {
            videoControlsCore.showLoading(false);
        }
        this.videoViewImpl.seekTo(j);
    }

    public boolean isPlaying() {
        return this.videoViewImpl.isPlaying();
    }

    public void start() {
        if (this.audioFocusHelper.requestFocus()) {
            this.videoViewImpl.start();
            if (!this.videoViewImpl.restart()) {
                this.videoViewImpl.restart();
            }
            setKeepScreenOn(true);
            VideoControlsCore videoControlsCore = this.videoControls;
            if (videoControlsCore != null) {
                videoControlsCore.updatePlaybackState(true);
            }
        }
    }

    public void pause() {
        pause(false);
    }

    public void pause(boolean z) {
        if (!z) {
            this.audioFocusHelper.abandonFocus();
        }
        this.videoViewImpl.pause();
        setKeepScreenOn(false);
        VideoControlsCore videoControlsCore = this.videoControls;
        if (videoControlsCore != null) {
            videoControlsCore.updatePlaybackState(false);
        }
    }

    public void stopPlayback() {
        stopPlayback(true);
    }

    public boolean restart() {
        boolean z = false;
        if (this.videoUri == null) {
            return false;
        }
        if (this.videoViewImpl.restart()) {
            VideoControlsCore videoControlsCore = this.videoControls;
            z = true;
            if (videoControlsCore != null) {
                videoControlsCore.showLoading(true);
            }
        }
        return z;
    }

    public void suspend() {
        this.audioFocusHelper.abandonFocus();
        this.videoViewImpl.suspend();
        setKeepScreenOn(false);
        VideoControlsCore videoControlsCore = this.videoControls;
        if (videoControlsCore != null) {
            videoControlsCore.updatePlaybackState(false);
        }
    }

    public long getDuration() {
        long j = this.overriddenDuration;
        if (j >= 0) {
            return j;
        }
        return this.videoViewImpl.getDuration();
    }

    public void overrideDuration(long j) {
        this.overriddenDuration = j;
    }

    public long getCurrentPosition() {
        long j;
        long currentPosition;
        if (this.overridePosition) {
            j = this.positionOffset;
            currentPosition = this.overriddenPositionStopWatch.getTime();
        } else {
            j = this.positionOffset;
            currentPosition = this.videoViewImpl.getCurrentPosition();
        }
        return j + currentPosition;
    }

    public void setPositionOffset(long j) {
        this.positionOffset = j;
    }

    public void restartOverridePosition() {
        this.overriddenPositionStopWatch.reset();
    }

    public void overridePosition(boolean z) {
        if (z) {
            this.overriddenPositionStopWatch.start();
        } else {
            this.overriddenPositionStopWatch.stop();
        }
        this.overridePosition = z;
    }

    public void setOverridePositionMatchesPlaybackSpeed(boolean z) {
        if (z != this.matchOverridePositionSpeed) {
            this.matchOverridePositionSpeed = z;
            if (z) {
                this.overriddenPositionStopWatch.setSpeedMultiplier(getPlaybackSpeed());
            } else {
                this.overriddenPositionStopWatch.setSpeedMultiplier(1.0f);
            }
        }
    }

    public int getBufferPercentage() {
        return this.videoViewImpl.getBufferedPercent();
    }

    public WindowInfo getWindowInfo() {
        return this.videoViewImpl.getWindowInfo();
    }

    public void setRepeatMode(int i) {
        this.videoViewImpl.setRepeatMode(i);
    }

    public boolean setPlaybackSpeed(float f) {
        boolean playbackSpeed = this.videoViewImpl.setPlaybackSpeed(f);
        if (playbackSpeed && this.matchOverridePositionSpeed) {
            this.overriddenPositionStopWatch.setSpeedMultiplier(f);
        }
        return playbackSpeed;
    }

    public void setCaptionListener(CaptionListener captionListener) {
        this.videoViewImpl.setCaptionListener(captionListener);
    }

    public float getPlaybackSpeed() {
        return this.videoViewImpl.getPlaybackSpeed();
    }

    public boolean trackSelectionAvailable() {
        return this.videoViewImpl.trackSelectionAvailable();
    }

    @Deprecated
    public void setTrack(ExoMedia.RendererType rendererType, int i) {
        this.videoViewImpl.setTrack(rendererType, 0, i);
    }

    public void setTrack(ExoMedia.RendererType rendererType, int i, int i2) {
        this.videoViewImpl.setTrack(rendererType, i, i2);
    }

    public int getSelectedTrackIndex(ExoMedia.RendererType rendererType, int i) {
        return this.videoViewImpl.getSelectedTrackIndex(rendererType, i);
    }

    public void clearSelectedTracks(ExoMedia.RendererType rendererType) {
        this.videoViewImpl.clearSelectedTracks(rendererType);
    }

    public Map<ExoMedia.RendererType, TrackGroupArray> getAvailableTracks() {
        return this.videoViewImpl.getAvailableTracks();
    }

    public void setRendererEnabled(ExoMedia.RendererType rendererType, boolean z) {
        this.videoViewImpl.setRendererEnabled(rendererType, z);
    }

    public boolean isRendererEnabled(ExoMedia.RendererType rendererType) {
        return this.videoViewImpl.isRendererEnabled(rendererType);
    }

    public void setScaleType(ScaleType scaleType) {
        this.videoViewImpl.setScaleType(scaleType);
    }

    public void setMeasureBasedOnAspectRatioEnabled(boolean z) {
        this.videoViewImpl.setMeasureBasedOnAspectRatioEnabled(z);
    }

    public void setVideoRotation(int i) {
        this.videoViewImpl.setVideoRotation(i, true);
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

    public void setId3MetadataListener(MetadataListener metadataListener) {
        this.listenerMux.setMetadataListener(metadataListener);
    }

    public void setAnalyticsListener(AnalyticsListener analyticsListener) {
        this.listenerMux.setAnalyticsListener(analyticsListener);
    }

    public void setOnVideoSizedChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.muxNotifier.videoSizeChangedListener = onVideoSizeChangedListener;
    }

    public Bitmap getBitmap() {
        VideoViewApi videoViewApi = this.videoViewImpl;
        if (videoViewApi instanceof TextureView) {
            return ((TextureView) videoViewApi).getBitmap();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void setup(Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            this.audioManager = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            AttributeContainer attributeContainer = new AttributeContainer(context, attributeSet);
            initView(context, attributeContainer);
            postInit(attributeContainer);
        }
    }

    /* access modifiers changed from: protected */
    public void initView(Context context, AttributeContainer attributeContainer) {
        inflateVideoView(context, attributeContainer);
        this.previewImageView = (ImageView) findViewById(C1891R.C1895id.exomedia_video_preview_image);
        this.videoViewImpl = (VideoViewApi) findViewById(C1891R.C1895id.exomedia_video_view);
        MuxNotifier muxNotifier2 = new MuxNotifier();
        this.muxNotifier = muxNotifier2;
        ListenerMux listenerMux2 = new ListenerMux(muxNotifier2);
        this.listenerMux = listenerMux2;
        this.videoViewImpl.setListenerMux(listenerMux2);
    }

    /* access modifiers changed from: protected */
    public void postInit(AttributeContainer attributeContainer) {
        if (attributeContainer.useDefaultControls) {
            setControls((VideoControls) new VideoControlsMobile(getContext()));
        }
        if (attributeContainer.scaleType != null) {
            setScaleType(attributeContainer.scaleType);
        }
        if (attributeContainer.measureBasedOnAspectRatio != null) {
            setMeasureBasedOnAspectRatioEnabled(attributeContainer.measureBasedOnAspectRatio.booleanValue());
        }
    }

    /* access modifiers changed from: protected */
    public void inflateVideoView(Context context, AttributeContainer attributeContainer) {
        View.inflate(context, C1891R.C1897layout.stream_exomedia_video_view_layout, this);
        ViewStub viewStub = (ViewStub) findViewById(C1891R.C1895id.video_view_api_impl_stub);
        viewStub.setLayoutResource(getVideoViewApiImplementation(context, attributeContainer));
        viewStub.inflate();
    }

    /* access modifiers changed from: protected */
    public int getVideoViewApiImplementation(Context context, AttributeContainer attributeContainer) {
        return this.deviceUtil.supportsExoPlayer(context) ^ true ? attributeContainer.apiImplLegacyResourceId : attributeContainer.apiImplResourceId;
    }

    /* access modifiers changed from: protected */
    public void onPlaybackEnded() {
        stopPlayback(false);
    }

    /* access modifiers changed from: protected */
    public void stopPlayback(boolean z) {
        this.audioFocusHelper.abandonFocus();
        this.videoViewImpl.stopPlayback(z);
        setKeepScreenOn(false);
        VideoControlsCore videoControlsCore = this.videoControls;
        if (videoControlsCore != null) {
            videoControlsCore.updatePlaybackState(false);
        }
    }

    /* renamed from: com.getstream.sdk.chat.utils.exomedia.ui.widget.VideoView$AudioFocusHelper */
    protected class AudioFocusHelper implements AudioManager.OnAudioFocusChangeListener {
        protected int currentFocus = 0;
        protected AudioFocusRequest lastFocusRequest;
        protected boolean pausedForLoss = false;
        protected boolean startRequested = false;

        protected AudioFocusHelper() {
        }

        public void onAudioFocusChange(int i) {
            if (VideoView.this.handleAudioFocus && this.currentFocus != i) {
                this.currentFocus = i;
                if (i == -3 || i == -2) {
                    if (VideoView.this.isPlaying()) {
                        this.pausedForLoss = true;
                        VideoView.this.pause(true);
                    }
                } else if (i != -1) {
                    if (i != 1 && i != 2) {
                        return;
                    }
                    if (this.startRequested || this.pausedForLoss) {
                        VideoView.this.start();
                        this.startRequested = false;
                        this.pausedForLoss = false;
                    }
                } else if (VideoView.this.isPlaying()) {
                    this.pausedForLoss = true;
                    VideoView.this.pause();
                }
            }
        }

        public boolean requestFocus() {
            int i;
            if (!VideoView.this.handleAudioFocus || this.currentFocus == 1) {
                return true;
            }
            if (VideoView.this.audioManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                this.lastFocusRequest = new AudioFocusRequest.Builder(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).build();
                i = VideoView.this.audioManager.requestAudioFocus(this.lastFocusRequest);
            } else {
                i = VideoView.this.audioManager.requestAudioFocus(this, 3, 1);
            }
            if (1 == i) {
                this.currentFocus = 1;
                return true;
            }
            this.startRequested = true;
            return false;
        }

        public boolean abandonFocus() {
            int i;
            if (!VideoView.this.handleAudioFocus) {
                return true;
            }
            if (VideoView.this.audioManager == null) {
                return false;
            }
            this.startRequested = false;
            if (Build.VERSION.SDK_INT < 26) {
                i = VideoView.this.audioManager.abandonAudioFocus(this);
            } else if (this.lastFocusRequest != null) {
                i = VideoView.this.audioManager.abandonAudioFocusRequest(this.lastFocusRequest);
                if (1 == i) {
                    this.lastFocusRequest = null;
                }
            } else {
                i = 1;
            }
            if (1 == i) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.getstream.sdk.chat.utils.exomedia.ui.widget.VideoView$MuxNotifier */
    protected class MuxNotifier extends ListenerMux.Notifier {
        public OnVideoSizeChangedListener videoSizeChangedListener;

        protected MuxNotifier() {
        }

        public boolean shouldNotifyCompletion(long j) {
            long currentPosition = VideoView.this.getCurrentPosition();
            long duration = VideoView.this.getDuration();
            return currentPosition > 0 && duration > 0 && currentPosition + j >= duration;
        }

        public void onExoPlayerError(ExoMediaPlayer exoMediaPlayer, Exception exc) {
            VideoView.this.stopPlayback();
            if (exoMediaPlayer != null) {
                exoMediaPlayer.forcePrepare();
            }
        }

        public void onMediaPlaybackEnded() {
            VideoView.this.setKeepScreenOn(false);
            VideoView.this.onPlaybackEnded();
        }

        public void onSeekComplete() {
            if (VideoView.this.videoControls != null) {
                VideoView.this.videoControls.finishLoading();
            }
        }

        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            VideoView.this.videoViewImpl.setVideoRotation(i3, false);
            VideoView.this.videoViewImpl.onVideoSizeChanged(i, i2, f);
            OnVideoSizeChangedListener onVideoSizeChangedListener = this.videoSizeChangedListener;
            if (onVideoSizeChangedListener != null) {
                onVideoSizeChangedListener.onVideoSizeChanged(i, i2, f);
            }
        }

        public void onPrepared() {
            if (VideoView.this.videoControls != null) {
                VideoView.this.videoControls.setDuration(VideoView.this.getDuration());
                VideoView.this.videoControls.finishLoading();
            }
        }

        public void onPreviewImageStateChanged(boolean z) {
            if (VideoView.this.previewImageView != null) {
                VideoView.this.previewImageView.setVisibility(z ? 0 : 8);
            }
        }
    }

    /* renamed from: com.getstream.sdk.chat.utils.exomedia.ui.widget.VideoView$TouchListener */
    protected class TouchListener extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {
        protected GestureDetector gestureDetector;

        public TouchListener(Context context) {
            this.gestureDetector = new GestureDetector(context, this);
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.gestureDetector.onTouchEvent(motionEvent);
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (VideoView.this.videoControls == null || !VideoView.this.videoControls.isVisible()) {
                VideoView.this.showControls();
                return true;
            }
            VideoView.this.videoControls.hide(false);
            return true;
        }
    }

    /* renamed from: com.getstream.sdk.chat.utils.exomedia.ui.widget.VideoView$AttributeContainer */
    protected class AttributeContainer {
        public int apiImplLegacyResourceId = C1891R.C1897layout.stream_exomedia_default_native_texture_video_view;
        public int apiImplResourceId = C1891R.C1897layout.stream_exomedia_default_exo_texture_video_view;
        public Boolean measureBasedOnAspectRatio;
        public ScaleType scaleType;
        public boolean useDefaultControls = false;
        public boolean useTextureViewBacking = false;

        public AttributeContainer(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes;
            if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1891R.styleable.VideoView)) != null) {
                this.useDefaultControls = obtainStyledAttributes.getBoolean(C1891R.styleable.VideoView_stream_useDefaultControls, this.useDefaultControls);
                this.useTextureViewBacking = obtainStyledAttributes.getBoolean(C1891R.styleable.VideoView_stream_useTextureViewBacking, this.useTextureViewBacking);
                if (obtainStyledAttributes.hasValue(C1891R.styleable.VideoView_stream_videoScale)) {
                    this.scaleType = ScaleType.fromOrdinal(obtainStyledAttributes.getInt(C1891R.styleable.VideoView_stream_videoScale, -1));
                }
                if (obtainStyledAttributes.hasValue(C1891R.styleable.VideoView_stream_measureBasedOnAspectRatio)) {
                    this.measureBasedOnAspectRatio = Boolean.valueOf(obtainStyledAttributes.getBoolean(C1891R.styleable.VideoView_stream_measureBasedOnAspectRatio, false));
                }
                this.apiImplResourceId = this.useTextureViewBacking ? C1891R.C1897layout.stream_exomedia_default_exo_texture_video_view : C1891R.C1897layout.stream_exomedia_default_exo_surface_video_view;
                this.apiImplLegacyResourceId = this.useTextureViewBacking ? C1891R.C1897layout.stream_exomedia_default_native_texture_video_view : C1891R.C1897layout.stream_exomedia_default_native_surface_video_view;
                this.apiImplResourceId = obtainStyledAttributes.getResourceId(C1891R.styleable.VideoView_stream_videoViewApiImpl, this.apiImplResourceId);
                this.apiImplLegacyResourceId = obtainStyledAttributes.getResourceId(C1891R.styleable.VideoView_stream_videoViewApiImplLegacy, this.apiImplLegacyResourceId);
                obtainStyledAttributes.recycle();
            }
        }
    }
}
