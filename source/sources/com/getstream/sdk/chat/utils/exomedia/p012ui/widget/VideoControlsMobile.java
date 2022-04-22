package com.getstream.sdk.chat.utils.exomedia.p012ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import com.getstream.sdk.chat.utils.exomedia.p012ui.animation.BottomViewHideShowAnimation;
import com.getstream.sdk.chat.utils.exomedia.p012ui.animation.TopViewHideShowAnimation;
import com.getstream.sdk.chat.utils.exomedia.util.TimeFormatUtil;
import java.util.LinkedList;
import java.util.List;
import p015io.getstream.chat.android.p016ui.common.C1891R;

/* renamed from: com.getstream.sdk.chat.utils.exomedia.ui.widget.VideoControlsMobile */
public class VideoControlsMobile extends VideoControls {
    protected LinearLayout extraViewsContainer;
    protected SeekBar seekBar;
    protected boolean userInteracting = false;

    public VideoControlsMobile(Context context) {
        super(context);
    }

    public VideoControlsMobile(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoControlsMobile(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VideoControlsMobile(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public int getLayoutResource() {
        return C1891R.C1897layout.stream_exomedia_default_controls_mobile;
    }

    public void setPosition(long j) {
        this.currentTimeTextView.setText(TimeFormatUtil.formatMs(j));
        this.seekBar.setProgress((int) j);
    }

    public void setDuration(long j) {
        if (j != ((long) this.seekBar.getMax())) {
            this.endTimeTextView.setText(TimeFormatUtil.formatMs(j));
            this.seekBar.setMax((int) j);
        }
    }

    public void updateProgress(long j, long j2, int i) {
        if (!this.userInteracting) {
            SeekBar seekBar2 = this.seekBar;
            seekBar2.setSecondaryProgress((int) (((float) seekBar2.getMax()) * (((float) i) / 100.0f)));
            this.seekBar.setProgress((int) j);
            updateCurrentTime(j);
        }
    }

    /* access modifiers changed from: protected */
    public void retrieveViews() {
        super.retrieveViews();
        this.seekBar = (SeekBar) findViewById(C1891R.C1895id.exomedia_controls_video_seek);
        this.extraViewsContainer = (LinearLayout) findViewById(C1891R.C1895id.exomedia_controls_extra_container);
    }

    /* access modifiers changed from: protected */
    public void registerListeners() {
        super.registerListeners();
        this.seekBar.setOnSeekBarChangeListener(new SeekBarChanged());
    }

    public void addExtraView(View view) {
        this.extraViewsContainer.addView(view);
    }

    public void removeExtraView(View view) {
        this.extraViewsContainer.removeView(view);
    }

    public List<View> getExtraViews() {
        int childCount = this.extraViewsContainer.getChildCount();
        if (childCount <= 0) {
            return super.getExtraViews();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < childCount; i++) {
            linkedList.add(this.extraViewsContainer.getChildAt(i));
        }
        return linkedList;
    }

    public void hideDelayed(long j) {
        this.hideDelay = j;
        if (j >= 0 && this.canViewHide && !this.isLoading && !this.userInteracting) {
            this.visibilityHandler.postDelayed(new Runnable() {
                public void run() {
                    VideoControlsMobile.this.animateVisibility(false);
                }
            }, j);
        }
    }

    /* access modifiers changed from: protected */
    public void animateVisibility(boolean z) {
        if (this.isVisible != z) {
            if (!this.hideEmptyTextContainer || !isTextContainerEmpty()) {
                this.textContainer.startAnimation(new TopViewHideShowAnimation(this.textContainer, z, 300));
            }
            if (!this.isLoading) {
                this.controlsContainer.startAnimation(new BottomViewHideShowAnimation(this.controlsContainer, z, 300));
            }
            this.isVisible = z;
            onVisibilityChanged();
        }
    }

    /* access modifiers changed from: protected */
    public void updateTextContainerVisibility() {
        if (this.isVisible) {
            boolean isTextContainerEmpty = isTextContainerEmpty();
            if (this.hideEmptyTextContainer && isTextContainerEmpty && this.textContainer.getVisibility() == 0) {
                this.textContainer.clearAnimation();
                this.textContainer.startAnimation(new TopViewHideShowAnimation(this.textContainer, false, 300));
            } else if ((!this.hideEmptyTextContainer || !isTextContainerEmpty) && this.textContainer.getVisibility() != 0) {
                this.textContainer.clearAnimation();
                this.textContainer.startAnimation(new TopViewHideShowAnimation(this.textContainer, true, 300));
            }
        }
    }

    public void showLoading(boolean z) {
        if (!this.isLoading) {
            this.isLoading = true;
            this.loadingProgressBar.setVisibility(0);
            if (z) {
                this.controlsContainer.setVisibility(8);
            } else {
                this.playPauseButton.setEnabled(false);
                this.previousButton.setEnabled(false);
                this.nextButton.setEnabled(false);
            }
            show();
        }
    }

    public void finishLoading() {
        if (this.isLoading) {
            boolean z = false;
            this.isLoading = false;
            this.loadingProgressBar.setVisibility(8);
            this.controlsContainer.setVisibility(0);
            this.playPauseButton.setEnabled(true);
            this.previousButton.setEnabled(this.enabledViews.get(C1891R.C1895id.exomedia_controls_previous_btn, true));
            this.nextButton.setEnabled(this.enabledViews.get(C1891R.C1895id.exomedia_controls_next_btn, true));
            if (this.videoView != null && this.videoView.isPlaying()) {
                z = true;
            }
            updatePlaybackState(z);
        }
    }

    /* renamed from: com.getstream.sdk.chat.utils.exomedia.ui.widget.VideoControlsMobile$SeekBarChanged */
    protected class SeekBarChanged implements SeekBar.OnSeekBarChangeListener {
        private long seekToTime;

        protected SeekBarChanged() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                this.seekToTime = (long) i;
                if (VideoControlsMobile.this.currentTimeTextView != null) {
                    VideoControlsMobile.this.currentTimeTextView.setText(TimeFormatUtil.formatMs(this.seekToTime));
                }
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            VideoControlsMobile.this.userInteracting = true;
            if (VideoControlsMobile.this.seekListener == null || !VideoControlsMobile.this.seekListener.onSeekStarted()) {
                VideoControlsMobile.this.internalListener.onSeekStarted();
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            VideoControlsMobile.this.userInteracting = false;
            if (VideoControlsMobile.this.seekListener == null || !VideoControlsMobile.this.seekListener.onSeekEnded(this.seekToTime)) {
                VideoControlsMobile.this.internalListener.onSeekEnded(this.seekToTime);
            }
        }
    }
}
