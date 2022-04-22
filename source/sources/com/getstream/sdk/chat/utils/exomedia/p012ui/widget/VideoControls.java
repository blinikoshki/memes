package com.getstream.sdk.chat.utils.exomedia.p012ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.getstream.sdk.chat.utils.exomedia.listener.VideoControlsButtonListener;
import com.getstream.sdk.chat.utils.exomedia.listener.VideoControlsSeekListener;
import com.getstream.sdk.chat.utils.exomedia.listener.VideoControlsVisibilityListener;
import com.getstream.sdk.chat.utils.exomedia.util.Repeater;
import com.getstream.sdk.chat.utils.exomedia.util.ResourceUtil;
import com.getstream.sdk.chat.utils.exomedia.util.TimeFormatUtil;
import java.util.LinkedList;
import java.util.List;
import p015io.getstream.chat.android.p016ui.common.C1891R;

/* renamed from: com.getstream.sdk.chat.utils.exomedia.ui.widget.VideoControls */
public abstract class VideoControls extends RelativeLayout implements VideoControlsCore {
    protected static final long CONTROL_VISIBILITY_ANIMATION_LENGTH = 300;
    public static final int DEFAULT_CONTROL_HIDE_DELAY = 2000;
    protected VideoControlsButtonListener buttonsListener;
    protected boolean canViewHide = true;
    protected ViewGroup controlsContainer;
    protected TextView currentTimeTextView;
    protected TextView descriptionTextView;
    protected SparseBooleanArray enabledViews = new SparseBooleanArray();
    protected TextView endTimeTextView;
    protected long hideDelay = 2000;
    protected boolean hideEmptyTextContainer = true;
    protected InternalListener internalListener = new InternalListener();
    protected boolean isLoading = false;
    protected boolean isVisible = true;
    private long lastUpdatedPosition;
    protected ProgressBar loadingProgressBar;
    protected ImageButton nextButton;
    protected Drawable pauseDrawable;
    protected Drawable playDrawable;
    protected ImageButton playPauseButton;
    protected ImageButton previousButton;
    protected Repeater progressPollRepeater = new Repeater();
    protected VideoControlsSeekListener seekListener;
    protected TextView subTitleTextView;
    protected ViewGroup textContainer;
    protected TextView titleTextView;
    protected VideoView videoView;
    protected Handler visibilityHandler = new Handler();
    protected VideoControlsVisibilityListener visibilityListener;

    public void addExtraView(View view) {
    }

    /* access modifiers changed from: protected */
    public abstract void animateVisibility(boolean z);

    /* access modifiers changed from: protected */
    public abstract int getLayoutResource();

    public void removeExtraView(View view) {
    }

    public void setFastForwardButtonEnabled(boolean z) {
    }

    public void setFastForwardButtonRemoved(boolean z) {
    }

    public void setFastForwardDrawable(Drawable drawable) {
    }

    public abstract void setPosition(long j);

    public void setRewindButtonEnabled(boolean z) {
    }

    public void setRewindButtonRemoved(boolean z) {
    }

    public void setRewindDrawable(Drawable drawable) {
    }

    public abstract void updateProgress(long j, long j2, int i);

    /* access modifiers changed from: protected */
    public abstract void updateTextContainerVisibility();

    public VideoControls(Context context) {
        super(context);
        setup(context);
    }

    public VideoControls(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setup(context);
    }

    public VideoControls(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setup(context);
    }

    public VideoControls(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setup(context);
    }

    /* access modifiers changed from: protected */
    public void updateCurrentTime(long j) {
        if (Math.abs(j - this.lastUpdatedPosition) >= 1000 || this.lastUpdatedPosition == 0) {
            this.lastUpdatedPosition = j;
            this.currentTimeTextView.setText(TimeFormatUtil.formatMs(j));
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.progressPollRepeater.setRepeatListener(new Repeater.RepeatListener() {
            public void onRepeat() {
                VideoControls.this.updateProgress();
            }
        });
        VideoView videoView2 = this.videoView;
        if (videoView2 != null && videoView2.isPlaying()) {
            updatePlaybackState(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.progressPollRepeater.stop();
        this.progressPollRepeater.setRepeatListener((Repeater.RepeatListener) null);
    }

    public void onAttachedToView(VideoView videoView2) {
        videoView2.addView(this);
        setVideoView(videoView2);
    }

    public void onDetachedFromView(VideoView videoView2) {
        videoView2.removeView(this);
        setVideoView((VideoView) null);
    }

    @Deprecated
    public void setVideoView(VideoView videoView2) {
        this.videoView = videoView2;
    }

    public void setSeekListener(VideoControlsSeekListener videoControlsSeekListener) {
        this.seekListener = videoControlsSeekListener;
    }

    public void setButtonListener(VideoControlsButtonListener videoControlsButtonListener) {
        this.buttonsListener = videoControlsButtonListener;
    }

    public void setVisibilityListener(VideoControlsVisibilityListener videoControlsVisibilityListener) {
        this.visibilityListener = videoControlsVisibilityListener;
    }

    public void updatePlaybackState(boolean z) {
        updatePlayPauseImage(z);
        this.progressPollRepeater.start();
        if (z) {
            hideDelayed();
        } else {
            show();
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.titleTextView.setText(charSequence);
        updateTextContainerVisibility();
    }

    public void setSubTitle(CharSequence charSequence) {
        this.subTitleTextView.setText(charSequence);
        updateTextContainerVisibility();
    }

    public void setDescription(CharSequence charSequence) {
        this.descriptionTextView.setText(charSequence);
        updateTextContainerVisibility();
    }

    public void setPlayPauseDrawables(Drawable drawable, Drawable drawable2) {
        this.playDrawable = drawable;
        this.pauseDrawable = drawable2;
        VideoView videoView2 = this.videoView;
        updatePlayPauseImage(videoView2 != null && videoView2.isPlaying());
    }

    public void setPreviousDrawable(Drawable drawable) {
        this.previousButton.setImageDrawable(drawable);
    }

    public void setNextDrawable(Drawable drawable) {
        this.nextButton.setImageDrawable(drawable);
    }

    public void updatePlayPauseImage(boolean z) {
        this.playPauseButton.setImageDrawable(z ? this.pauseDrawable : this.playDrawable);
    }

    public void setPreviousButtonEnabled(boolean z) {
        this.previousButton.setEnabled(z);
        this.enabledViews.put(C1891R.C1895id.exomedia_controls_previous_btn, z);
    }

    public void setNextButtonEnabled(boolean z) {
        this.nextButton.setEnabled(z);
        this.enabledViews.put(C1891R.C1895id.exomedia_controls_next_btn, z);
    }

    public void setPreviousButtonRemoved(boolean z) {
        this.previousButton.setVisibility(z ? 8 : 0);
    }

    public void setNextButtonRemoved(boolean z) {
        this.nextButton.setVisibility(z ? 8 : 0);
    }

    public List<View> getExtraViews() {
        return new LinkedList();
    }

    public void show() {
        this.visibilityHandler.removeCallbacksAndMessages((Object) null);
        clearAnimation();
        animateVisibility(true);
    }

    public void hide(boolean z) {
        if (z) {
            hideDelayed();
        } else {
            hide();
        }
    }

    public void hide() {
        if (this.canViewHide && !this.isLoading) {
            this.visibilityHandler.removeCallbacksAndMessages((Object) null);
            clearAnimation();
            animateVisibility(false);
        }
    }

    public void hideDelayed() {
        hideDelayed(this.hideDelay);
    }

    public void hideDelayed(long j) {
        this.hideDelay = j;
        if (j >= 0 && this.canViewHide && !this.isLoading) {
            this.visibilityHandler.postDelayed(new Runnable() {
                public void run() {
                    VideoControls.this.hide();
                }
            }, j);
        }
    }

    public void setHideDelay(long j) {
        this.hideDelay = j;
    }

    public void setCanHide(boolean z) {
        this.canViewHide = z;
    }

    public void setHideEmptyTextContainer(boolean z) {
        this.hideEmptyTextContainer = z;
        updateTextContainerVisibility();
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* access modifiers changed from: protected */
    public void retrieveViews() {
        this.currentTimeTextView = (TextView) findViewById(C1891R.C1895id.exomedia_controls_current_time);
        this.endTimeTextView = (TextView) findViewById(C1891R.C1895id.exomedia_controls_end_time);
        this.titleTextView = (TextView) findViewById(C1891R.C1895id.exomedia_controls_title);
        this.subTitleTextView = (TextView) findViewById(C1891R.C1895id.exomedia_controls_sub_title);
        this.descriptionTextView = (TextView) findViewById(C1891R.C1895id.exomedia_controls_description);
        this.playPauseButton = (ImageButton) findViewById(C1891R.C1895id.exomedia_controls_play_pause_btn);
        this.previousButton = (ImageButton) findViewById(C1891R.C1895id.exomedia_controls_previous_btn);
        this.nextButton = (ImageButton) findViewById(C1891R.C1895id.exomedia_controls_next_btn);
        this.loadingProgressBar = (ProgressBar) findViewById(C1891R.C1895id.exomedia_controls_video_loading);
        this.controlsContainer = (ViewGroup) findViewById(C1891R.C1895id.exomedia_controls_interactive_container);
        this.textContainer = (ViewGroup) findViewById(C1891R.C1895id.exomedia_controls_text_container);
    }

    /* access modifiers changed from: protected */
    public void registerListeners() {
        this.playPauseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VideoControls.this.onPlayPauseClick();
            }
        });
        this.previousButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VideoControls.this.onPreviousClick();
            }
        });
        this.nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VideoControls.this.onNextClick();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void updateButtonDrawables() {
        updateButtonDrawables(C1891R.C1893color.stream_exomedia_default_controls_button_selector);
    }

    /* access modifiers changed from: protected */
    public void updateButtonDrawables(int i) {
        this.playDrawable = ResourceUtil.tintList(getContext(), C1891R.C1894drawable.stream_exomedia_ic_play_arrow_white, i);
        this.pauseDrawable = ResourceUtil.tintList(getContext(), C1891R.C1894drawable.stream_exomedia_ic_pause_white, i);
        this.playPauseButton.setImageDrawable(this.playDrawable);
        this.previousButton.setImageDrawable(ResourceUtil.tintList(getContext(), C1891R.C1894drawable.stream_exomedia_ic_skip_previous_white, i));
        this.nextButton.setImageDrawable(ResourceUtil.tintList(getContext(), C1891R.C1894drawable.stream_exomedia_ic_skip_next_white, i));
    }

    /* access modifiers changed from: protected */
    public void onPlayPauseClick() {
        VideoControlsButtonListener videoControlsButtonListener = this.buttonsListener;
        if (videoControlsButtonListener == null || !videoControlsButtonListener.onPlayPauseClicked()) {
            this.internalListener.onPlayPauseClicked();
        }
    }

    /* access modifiers changed from: protected */
    public void onPreviousClick() {
        VideoControlsButtonListener videoControlsButtonListener = this.buttonsListener;
        if (videoControlsButtonListener == null || !videoControlsButtonListener.onPreviousClicked()) {
            this.internalListener.onPreviousClicked();
        }
    }

    /* access modifiers changed from: protected */
    public void onNextClick() {
        VideoControlsButtonListener videoControlsButtonListener = this.buttonsListener;
        if (videoControlsButtonListener == null || !videoControlsButtonListener.onNextClicked()) {
            this.internalListener.onNextClicked();
        }
    }

    /* access modifiers changed from: protected */
    public void setup(Context context) {
        View.inflate(context, getLayoutResource(), this);
        retrieveViews();
        registerListeners();
        updateButtonDrawables();
    }

    /* access modifiers changed from: protected */
    public boolean isTextContainerEmpty() {
        if (this.titleTextView.getText() != null && this.titleTextView.getText().length() > 0) {
            return false;
        }
        if (this.subTitleTextView.getText() != null && this.subTitleTextView.getText().length() > 0) {
            return false;
        }
        if (this.descriptionTextView.getText() == null || this.descriptionTextView.getText().length() <= 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged() {
        VideoControlsVisibilityListener videoControlsVisibilityListener = this.visibilityListener;
        if (videoControlsVisibilityListener != null) {
            if (this.isVisible) {
                videoControlsVisibilityListener.onControlsShown();
            } else {
                videoControlsVisibilityListener.onControlsHidden();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void updateProgress() {
        VideoView videoView2 = this.videoView;
        if (videoView2 != null) {
            updateProgress(videoView2.getCurrentPosition(), this.videoView.getDuration(), this.videoView.getBufferPercentage());
        }
    }

    /* renamed from: com.getstream.sdk.chat.utils.exomedia.ui.widget.VideoControls$InternalListener */
    protected class InternalListener implements VideoControlsSeekListener, VideoControlsButtonListener {
        protected boolean pausedForSeek = false;

        public boolean onFastForwardClicked() {
            return false;
        }

        public boolean onNextClicked() {
            return false;
        }

        public boolean onPreviousClicked() {
            return false;
        }

        public boolean onRewindClicked() {
            return false;
        }

        protected InternalListener() {
        }

        public boolean onPlayPauseClicked() {
            if (VideoControls.this.videoView == null) {
                return false;
            }
            if (VideoControls.this.videoView.isPlaying()) {
                VideoControls.this.videoView.pause();
                return true;
            }
            VideoControls.this.videoView.start();
            return true;
        }

        public boolean onSeekStarted() {
            if (VideoControls.this.videoView == null) {
                return false;
            }
            if (VideoControls.this.videoView.isPlaying()) {
                this.pausedForSeek = true;
                VideoControls.this.videoView.pause(true);
            }
            VideoControls.this.show();
            return true;
        }

        public boolean onSeekEnded(long j) {
            if (VideoControls.this.videoView == null) {
                return false;
            }
            VideoControls.this.videoView.seekTo(j);
            if (!this.pausedForSeek) {
                return true;
            }
            this.pausedForSeek = false;
            VideoControls.this.videoView.start();
            VideoControls.this.hideDelayed();
            return true;
        }
    }
}
