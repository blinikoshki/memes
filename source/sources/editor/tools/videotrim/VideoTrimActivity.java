package editor.tools.videotrim;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NVideoTrimmerActivityBinding;
import com.memes.editor.databinding.NVideoTrimmerUpgradePopupBinding;
import editor.core.NEditorPlanAwareActivity;
import editor.editor.plan.EditorPlan;
import editor.editor.plan.EditorPlanRequirement;
import editor.tools.videotrim.rangeseekbar.OnRangeSeekBarListener;
import editor.tools.videotrim.rangeseekbar.RangeSeekBarView;
import editor.tools.videotrim.rangeseekbar.ThumbType;
import editor.tools.videotrim.timeline.BitmapTimeLineView;
import java.io.File;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 C2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002CDB\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0012\u0010\u001f\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u0015H\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\u001dH\u0002J\b\u0010%\u001a\u00020\u0015H\u0002J\b\u0010&\u001a\u00020\u001dH\u0016J\u0012\u0010'\u001a\u00020\u001d2\b\u0010(\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010)\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u000eH\u0016J\b\u0010.\u001a\u00020\u001dH\u0014J\"\u0010/\u001a\u00020\u00152\b\u0010(\u001a\u0004\u0018\u00010\u00132\u0006\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000eH\u0016J\b\u00102\u001a\u00020\u001dH\u0014J\u0010\u00103\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u00104\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u00105\u001a\u00020\u001dH\u0002J\b\u00106\u001a\u00020\u001dH\u0002J\b\u00107\u001a\u00020\u001dH\u0002J\b\u00108\u001a\u00020\u001dH\u0002J\b\u00109\u001a\u00020\u001dH\u0002J\u0010\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u00020\u001dH\u0002J\u001a\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001a¨\u0006E"}, mo26107d2 = {"Leditor/tools/videotrim/VideoTrimActivity;", "Leditor/core/NEditorPlanAwareActivity;", "Leditor/tools/videotrim/TrimControlsListener;", "Landroid/media/MediaPlayer$OnPreparedListener;", "Landroid/media/MediaPlayer$OnErrorListener;", "Landroid/media/MediaPlayer$OnCompletionListener;", "()V", "binding", "Lcom/memes/editor/databinding/NVideoTrimmerActivityBinding;", "getBinding", "()Lcom/memes/editor/databinding/NVideoTrimmerActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "durationMillis", "", "endMillis", "maxTrimDurationMillis", "", "mediaPlayer", "Landroid/media/MediaPlayer;", "resetSeekBar", "", "startMillis", "viewModel", "Leditor/tools/videotrim/VideoTrimViewModel;", "getViewModel", "()Leditor/tools/videotrim/VideoTrimViewModel;", "viewModel$delegate", "calculatePlaybackProgress", "", "cancelAndExit", "enableSelectionMode", "showTrimOption", "enableTrimmingMode", "hideTrimDurationUpgradeUi", "initUi", "initViewModel", "isPlaying", "onBackPressed", "onCompletion", "mp", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCurrentPlaybackProgressChanged", "millis", "onDestroy", "onError", "what", "extra", "onPause", "onPrepared", "onTrimRangeChanged", "onVideoPlaybackStateToggleViewTapped", "pauseVideo", "refreshDurationLimit", "refreshSeekBarValues", "refreshUiForNewDuration", "setVideoSourceFile", "file", "Ljava/io/File;", "showTrimDurationUpgradeUi", "updateEditorPlan", "plan", "Leditor/editor/plan/EditorPlan;", "requirement", "Leditor/editor/plan/EditorPlanRequirement;", "Companion", "OnRangeSeekBarListenerWrapper", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: VideoTrimActivity.kt */
public abstract class VideoTrimActivity extends NEditorPlanAwareActivity implements TrimControlsListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_VIDEO_PATH = "intent_extra_video_path";
    private static final int MIN_TRIM_DURATION_MILLIS = 3000;
    private static final int MIN_TRIM_TARGET_DURATION = 4000;
    private final Lazy binding$delegate = LazyKt.lazy(new VideoTrimActivity$binding$2(this));
    /* access modifiers changed from: private */
    public int durationMillis;
    /* access modifiers changed from: private */
    public int endMillis;
    /* access modifiers changed from: private */
    public long maxTrimDurationMillis = 15000;
    private MediaPlayer mediaPlayer;
    private boolean resetSeekBar = true;
    /* access modifiers changed from: private */
    public int startMillis;
    private final Lazy viewModel$delegate = LazyKt.lazy(new VideoTrimActivity$viewModel$2(this));

    /* access modifiers changed from: private */
    public final NVideoTrimmerActivityBinding getBinding() {
        return (NVideoTrimmerActivityBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final VideoTrimViewModel getViewModel() {
        return (VideoTrimViewModel) this.viewModel$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo26107d2 = {"Leditor/tools/videotrim/VideoTrimActivity$Companion;", "", "()V", "EXTRA_VIDEO_PATH", "", "MIN_TRIM_DURATION_MILLIS", "", "MIN_TRIM_TARGET_DURATION", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: VideoTrimActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NVideoTrimmerActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModel(getViewModel());
        initUi();
        initViewModel();
        refreshDurationLimit();
    }

    private final void initUi() {
        int thumbWidth = getBinding().timelineSeekBarView.getThumbWidth();
        BitmapTimeLineView bitmapTimeLineView = getBinding().timelineView;
        Intrinsics.checkNotNullExpressionValue(bitmapTimeLineView, "binding.timelineView");
        View view = bitmapTimeLineView;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams layoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams.setMargins(thumbWidth, marginLayoutParams.topMargin, thumbWidth, marginLayoutParams.bottomMargin);
        view.setLayoutParams(layoutParams2);
        getBinding().timelineView.setCallback(getViewModel());
        getBinding().timelineSeekBarView.addOnRangeSeekBarListener(new OnRangeSeekBarListenerWrapper());
        getBinding().videoView.setOnPreparedListener(this);
        getBinding().videoView.setOnErrorListener(this);
        getBinding().videoView.setOnCompletionListener(this);
        getBinding().playbackStateToggleView.setOnClickListener(new VideoTrimActivity$initUi$2(this));
        getBinding().selectVideoButton.setOnClickListener(new VideoTrimActivity$initUi$3(this));
        getBinding().trimVideoButton.setOnClickListener(new VideoTrimActivity$initUi$4(this));
        getBinding().cancelButton.setOnClickListener(new VideoTrimActivity$initUi$5(this));
        getBinding().trimOptionsButton.setOnClickListener(new VideoTrimActivity$initUi$6(this));
        getBinding().cancelTrimButton.setOnClickListener(new VideoTrimActivity$initUi$7(this));
        getBinding().includedTrimDurationUpgradeLayout.trimDurationUpgradeButton.setOnClickListener(new VideoTrimActivity$initUi$8(this));
        enableSelectionMode$default(this, false, 1, (Object) null);
    }

    private final void initViewModel() {
        LifecycleOwner lifecycleOwner = this;
        getViewModel().onInputTargetAvailable().observe(lifecycleOwner, new VideoTrimActivity$initViewModel$1(this));
        getViewModel().onTimelineBitmapsAvailable().observe(lifecycleOwner, new VideoTrimActivity$initViewModel$2(this));
        getViewModel().onPlaybackProgressChanged().observe(lifecycleOwner, new VideoTrimActivity$initViewModel$3(this));
        getViewModel().onTrimmerOutputAvailable().observe(lifecycleOwner, new VideoTrimActivity$initViewModel$4(this));
        getViewModel().onTrimmerError().observe(lifecycleOwner, new VideoTrimActivity$initViewModel$5(this));
        Intent intent = getIntent();
        getViewModel().resolveVideoContentUri(intent != null ? intent.getStringExtra(EXTRA_VIDEO_PATH) : null);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        pauseVideo();
    }

    public void onBackPressed() {
        cancelAndExit();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        pauseVideo();
        getBinding().timelineView.clearBitmaps();
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public final void onVideoPlaybackStateToggleViewTapped() {
        VideoView videoView = getBinding().videoView;
        Intrinsics.checkNotNullExpressionValue(videoView, "binding.videoView");
        if (videoView.isPlaying()) {
            pauseVideo();
            return;
        }
        getBinding().playbackStateToggleView.setImageResource(C4175R.C4178drawable.icon_video_pause_circle);
        if (this.resetSeekBar) {
            this.resetSeekBar = false;
            getBinding().videoView.seekTo(this.startMillis);
        }
        getBinding().videoView.start();
        getViewModel().startPlaybackProgressTracking();
    }

    /* access modifiers changed from: private */
    public final void setVideoSourceFile(File file) {
        TextView textView = getBinding().playbackSizeTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.playbackSizeTextView");
        textView.setText(Formatter.formatShortFileSize(this, file.length()));
        getBinding().videoView.setVideoURI(Uri.fromFile(file));
        getBinding().videoView.requestFocus();
        getBinding().timelineView.refresh();
    }

    /* access modifiers changed from: private */
    public final void calculatePlaybackProgress() {
        if (this.durationMillis != 0) {
            VideoView videoView = getBinding().videoView;
            Intrinsics.checkNotNullExpressionValue(videoView, "binding.videoView");
            int currentPosition = videoView.getCurrentPosition();
            TextView textView = getBinding().playbackProgressTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.playbackProgressTextView");
            textView.setText(getViewModel().millisToReadableDuration(currentPosition));
            if (currentPosition < this.startMillis) {
                MediaPlayer mediaPlayer2 = this.mediaPlayer;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.setVolume(0.0f, 0.0f);
                }
                LinearLayout linearLayout = getBinding().playbackProgressContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.playbackProgressContainer");
                linearLayout.setVisibility(0);
                FrameLayout frameLayout = getBinding().videoContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.videoContainer");
                frameLayout.setVisibility(4);
                return;
            }
            try {
                MediaPlayer mediaPlayer3 = this.mediaPlayer;
                if (mediaPlayer3 != null) {
                    mediaPlayer3.setVolume(1.0f, 1.0f);
                }
            } catch (IllegalStateException e) {
                Timber.m303e("Exception when setting volume on MediaPlayer: " + e, new Object[0]);
            }
            LinearLayout linearLayout2 = getBinding().playbackProgressContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.playbackProgressContainer");
            linearLayout2.setVisibility(8);
            FrameLayout frameLayout2 = getBinding().videoContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.videoContainer");
            frameLayout2.setVisibility(0);
            if (currentPosition >= this.endMillis) {
                pauseVideo();
                this.resetSeekBar = true;
                return;
            }
            onCurrentPlaybackProgressChanged(currentPosition);
        }
    }

    private final void refreshDurationLimit() {
        this.maxTrimDurationMillis = hasPremiumEditorPlan() ? 60000 : 15000;
        getViewModel().setMaxTrimDurationMillis(this.maxTrimDurationMillis);
        refreshUiForNewDuration();
    }

    private final void refreshUiForNewDuration() {
        int i = this.durationMillis;
        long j = this.maxTrimDurationMillis;
        if (((long) i) >= j) {
            this.startMillis = 0;
            this.endMillis = (int) j;
        } else {
            this.startMillis = 0;
            this.endMillis = i;
        }
        refreshSeekBarValues();
        onCurrentPlaybackProgressChanged(0);
        onTrimRangeChanged(this.startMillis, this.endMillis);
        getBinding().videoView.seekTo(this.startMillis);
        pauseVideo();
        int i2 = this.durationMillis;
        if (i2 < MIN_TRIM_TARGET_DURATION) {
            enableSelectionMode(false);
        } else {
            long j2 = (long) MIN_TRIM_TARGET_DURATION;
            long j3 = this.maxTrimDurationMillis;
            long j4 = (long) i2;
            if (j2 <= j4 && j3 >= j4) {
                enableSelectionMode(true);
            } else {
                enableTrimmingMode();
                if (!hasPremiumEditorPlan()) {
                    showTrimDurationUpgradeUi();
                }
            }
        }
        if (hasPremiumEditorPlan()) {
            hideTrimDurationUpgradeUi();
        }
        getViewModel().onVideoPlaybackDurationAvailable(this.durationMillis);
    }

    /* access modifiers changed from: private */
    public final void refreshSeekBarValues() {
        if (getBinding().timelineSeekBarView.isReady()) {
            RangeSeekBarView rangeSeekBarView = getBinding().timelineSeekBarView;
            int i = this.durationMillis;
            rangeSeekBarView.setThumbValues((((float) this.startMillis) * 100.0f) / ((float) i), (((float) this.endMillis) * 100.0f) / ((float) i));
            RangeSeekBarView rangeSeekBarView2 = getBinding().timelineSeekBarView;
            int i2 = this.durationMillis;
            rangeSeekBarView2.setSeparationRange(300000.0f / ((float) i2), (((float) this.maxTrimDurationMillis) * 100.0f) / ((float) i2));
        }
    }

    static /* synthetic */ void enableSelectionMode$default(VideoTrimActivity videoTrimActivity, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            videoTrimActivity.enableSelectionMode(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enableSelectionMode");
    }

    /* access modifiers changed from: private */
    public final void enableSelectionMode(boolean z) {
        LinearLayout linearLayout = getBinding().selectionControlsBar;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.selectionControlsBar");
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = getBinding().trimControlsBar;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.trimControlsBar");
        linearLayout2.setVisibility(8);
        if (z) {
            Button button = getBinding().trimOptionsButton;
            Intrinsics.checkNotNullExpressionValue(button, "binding.trimOptionsButton");
            button.setVisibility(0);
        } else {
            Button button2 = getBinding().trimOptionsButton;
            Intrinsics.checkNotNullExpressionValue(button2, "binding.trimOptionsButton");
            button2.setVisibility(8);
        }
        LinearLayout linearLayout3 = getBinding().playbackInfoContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.playbackInfoContainer");
        linearLayout3.setVisibility(8);
        FrameLayout frameLayout = getBinding().timelineContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.timelineContainer");
        frameLayout.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void enableTrimmingMode() {
        LinearLayout linearLayout = getBinding().selectionControlsBar;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.selectionControlsBar");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = getBinding().trimControlsBar;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.trimControlsBar");
        linearLayout2.setVisibility(0);
        LinearLayout linearLayout3 = getBinding().playbackInfoContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.playbackInfoContainer");
        linearLayout3.setVisibility(0);
        FrameLayout frameLayout = getBinding().timelineContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.timelineContainer");
        frameLayout.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final boolean isPlaying() {
        VideoView videoView = getBinding().videoView;
        Intrinsics.checkNotNullExpressionValue(videoView, "binding.videoView");
        return videoView.isPlaying();
    }

    /* access modifiers changed from: private */
    public final void pauseVideo() {
        MediaPlayer mediaPlayer2;
        LinearLayout linearLayout = getBinding().playbackProgressContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.playbackProgressContainer");
        linearLayout.setVisibility(8);
        FrameLayout frameLayout = getBinding().videoContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.videoContainer");
        frameLayout.setVisibility(0);
        if (isPlaying() && (mediaPlayer2 = this.mediaPlayer) != null) {
            mediaPlayer2.setVolume(0.0f, 0.0f);
        }
        getViewModel().stopPlaybackProgressTracking();
        getBinding().videoView.pause();
        getBinding().playbackStateToggleView.setImageResource(C4175R.C4178drawable.icon_video_play_circle);
    }

    /* access modifiers changed from: private */
    public final void cancelAndExit() {
        setResult(0, (Intent) null);
        finish();
    }

    private final void showTrimDurationUpgradeUi() {
        NVideoTrimmerUpgradePopupBinding nVideoTrimmerUpgradePopupBinding = getBinding().includedTrimDurationUpgradeLayout;
        Intrinsics.checkNotNullExpressionValue(nVideoTrimmerUpgradePopupBinding, "binding.includedTrimDurationUpgradeLayout");
        LinearLayout root = nVideoTrimmerUpgradePopupBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.includedTrimDurationUpgradeLayout.root");
        root.setVisibility(0);
    }

    private final void hideTrimDurationUpgradeUi() {
        NVideoTrimmerUpgradePopupBinding nVideoTrimmerUpgradePopupBinding = getBinding().includedTrimDurationUpgradeLayout;
        Intrinsics.checkNotNullExpressionValue(nVideoTrimmerUpgradePopupBinding, "binding.includedTrimDurationUpgradeLayout");
        LinearLayout root = nVideoTrimmerUpgradePopupBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.includedTrimDurationUpgradeLayout.root");
        root.setVisibility(8);
    }

    public void onPrepared(MediaPlayer mediaPlayer2) {
        Intrinsics.checkNotNullParameter(mediaPlayer2, "mediaPlayer");
        this.mediaPlayer = mediaPlayer2;
        mediaPlayer2.setVolume(0.0f, 0.0f);
        float videoWidth = ((float) mediaPlayer2.getVideoWidth()) / ((float) mediaPlayer2.getVideoHeight());
        FrameLayout frameLayout = getBinding().videoContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.videoContainer");
        int width = frameLayout.getWidth();
        FrameLayout frameLayout2 = getBinding().videoContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.videoContainer");
        int height = frameLayout2.getHeight();
        float f = (float) width;
        float f2 = (float) height;
        VideoView videoView = getBinding().videoView;
        Intrinsics.checkNotNullExpressionValue(videoView, "binding.videoView");
        View view = videoView;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
        if (videoWidth > f / f2) {
            layoutParams3.width = width;
            layoutParams3.height = (int) (f / videoWidth);
        } else {
            layoutParams3.width = (int) (videoWidth * f2);
            layoutParams3.height = height;
        }
        view.setLayoutParams(layoutParams2);
        VideoView videoView2 = getBinding().videoView;
        Intrinsics.checkNotNullExpressionValue(videoView2, "binding.videoView");
        this.durationMillis = videoView2.getDuration();
        refreshUiForNewDuration();
    }

    public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
        getViewModel().onVideoPlaybackFailed("Failed to play video. This can be due to an interruption or corruption.");
        pauseVideo();
        return true;
    }

    public void onCompletion(MediaPlayer mediaPlayer2) {
        getBinding().videoView.seekTo(this.startMillis);
        getBinding().playbackStateToggleView.setImageResource(C4175R.C4178drawable.icon_video_play_circle);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, mo26107d2 = {"Leditor/tools/videotrim/VideoTrimActivity$OnRangeSeekBarListenerWrapper;", "Leditor/tools/videotrim/rangeseekbar/OnRangeSeekBarListener;", "(Leditor/tools/videotrim/VideoTrimActivity;)V", "onSeekRangeChanged", "", "view", "Leditor/tools/videotrim/rangeseekbar/RangeSeekBarView;", "type", "Leditor/tools/videotrim/rangeseekbar/ThumbType;", "value", "", "onSeekRangeCreated", "onSeekRangeStopped", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: VideoTrimActivity.kt */
    public final class OnRangeSeekBarListenerWrapper implements OnRangeSeekBarListener {

        @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ThumbType.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[ThumbType.START.ordinal()] = 1;
                iArr[ThumbType.END.ordinal()] = 2;
            }
        }

        public OnRangeSeekBarListenerWrapper() {
        }

        public void onSeekRangeCreated(RangeSeekBarView rangeSeekBarView) {
            Intrinsics.checkNotNullParameter(rangeSeekBarView, ViewHierarchyConstants.VIEW_KEY);
            VideoTrimActivity.this.refreshSeekBarValues();
        }

        public void onSeekRangeChanged(RangeSeekBarView rangeSeekBarView, ThumbType thumbType, float f) {
            Intrinsics.checkNotNullParameter(rangeSeekBarView, ViewHierarchyConstants.VIEW_KEY);
            Intrinsics.checkNotNullParameter(thumbType, "type");
            VideoTrimActivity.this.pauseVideo();
            int i = WhenMappings.$EnumSwitchMapping$0[thumbType.ordinal()];
            if (i == 1) {
                int roundToInt = MathKt.roundToInt((((float) VideoTrimActivity.this.durationMillis) * f) / ((float) 100));
                if (VideoTrimActivity.this.startMillis != roundToInt) {
                    VideoTrimActivity.this.startMillis = roundToInt;
                    VideoTrimActivity.this.getBinding().videoView.seekTo(VideoTrimActivity.this.startMillis);
                }
            } else if (i == 2) {
                VideoTrimActivity videoTrimActivity = VideoTrimActivity.this;
                videoTrimActivity.endMillis = MathKt.roundToInt((((float) videoTrimActivity.durationMillis) * f) / ((float) 100));
            } else {
                return;
            }
            VideoTrimActivity videoTrimActivity2 = VideoTrimActivity.this;
            videoTrimActivity2.onTrimRangeChanged(videoTrimActivity2.startMillis, VideoTrimActivity.this.endMillis);
        }

        public void onSeekRangeStopped(RangeSeekBarView rangeSeekBarView, ThumbType thumbType, float f) {
            Intrinsics.checkNotNullParameter(rangeSeekBarView, ViewHierarchyConstants.VIEW_KEY);
            Intrinsics.checkNotNullParameter(thumbType, "type");
            VideoTrimActivity.this.pauseVideo();
        }
    }

    public void onCurrentPlaybackProgressChanged(int i) {
        getViewModel().onCurrentPlaybackProgressChanged(i);
    }

    public void onTrimRangeChanged(int i, int i2) {
        String str = getViewModel().millisToReadableDuration(i) + " sec - " + getViewModel().millisToReadableDuration(i2) + " sec";
        TextView textView = getBinding().playbackSelectedRangeTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.playbackSelectedRangeTextView");
        textView.setText(str);
        getViewModel().onTrimRangeChanged(i, i2);
    }

    public void updateEditorPlan(EditorPlan editorPlan, EditorPlanRequirement editorPlanRequirement) {
        Intrinsics.checkNotNullParameter(editorPlan, "plan");
        super.updateEditorPlan(editorPlan, editorPlanRequirement);
        refreshDurationLimit();
    }
}
