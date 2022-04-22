package editor.tools.videotrim;

import android.graphics.Bitmap;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.media.MediaContent;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.util.UriResolverHelper;
import editor.core.NicoViewModel;
import editor.ffmpeg.core.MultimediaFramework;
import editor.ffmpeg.core.callback.MultimediaFrameworkErrorNotifier;
import editor.ffmpeg.core.callback.OnMultimediaProgressListener;
import editor.tools.videotrim.timeline.BitmapTimelineCallback;
import editor.util.FfmpegCommandUtil;
import java.io.File;
import java.util.Formatter;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001SB%\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0018\u0010+\u001a\u00020,2\u0006\u0010%\u001a\u00020$2\u0006\u0010-\u001a\u00020$H\u0002J\u000e\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u000200J\u0010\u00101\u001a\u00020,2\u0006\u0010/\u001a\u000200H\u0016J\u001c\u00102\u001a\u00020,2\b\u00103\u001a\u0004\u0018\u00010\u001b2\b\u00104\u001a\u0004\u0018\u00010\u001bH\u0016J\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001306J\u001a\u00107\u001a\u00020,2\u0006\u00108\u001a\u0002002\b\u00109\u001a\u0004\u0018\u00010\u001bH\u0016J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001606J\u0018\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u0002002\u0006\u0010=\u001a\u000200H\u0016J\u0012\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u001806J\u0018\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u0002002\u0006\u0010A\u001a\u000200H\u0016J\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001b06J\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001306J\u0010\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u00020\u001bH\u0016J\u0010\u0010F\u001a\u00020,2\u0006\u0010G\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u00020,2\u0006\u0010J\u001a\u000200H\u0016J\u0010\u0010K\u001a\u00020,2\u0006\u0010E\u001a\u00020\u001bH\u0016J\u0010\u0010L\u001a\u00020,2\b\u0010M\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010N\u001a\u00020,J\u000e\u0010O\u001a\u00020,2\u0006\u0010/\u001a\u00020$J\u0006\u0010P\u001a\u00020,J\u0006\u0010Q\u001a\u00020,J\u0006\u0010R\u001a\u00020,R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, mo26107d2 = {"Leditor/tools/videotrim/VideoTrimViewModel;", "Leditor/core/NicoViewModel;", "Lcom/memes/commons/util/UriResolverHelper$Callback;", "Leditor/tools/videotrim/VideoPlaybackListener;", "Leditor/tools/videotrim/TrimControlsListener;", "Leditor/tools/videotrim/timeline/BitmapTimelineCallback;", "Leditor/ffmpeg/core/callback/OnMultimediaProgressListener;", "Leditor/ffmpeg/core/callback/MultimediaFrameworkErrorNotifier;", "uriResolverHelper", "Lcom/memes/commons/util/UriResolverHelper;", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "ffmpegFramework", "Leditor/ffmpeg/core/MultimediaFramework;", "thumbnailRetriever", "Leditor/tools/videotrim/VideoThumbnailRetriever;", "(Lcom/memes/commons/util/UriResolverHelper;Lcom/memes/commons/output/OutputTargetGenerator;Leditor/ffmpeg/core/MultimediaFramework;Leditor/tools/videotrim/VideoThumbnailRetriever;)V", "_inputTargetLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "Ljava/io/File;", "_playbackProgressLiveData", "Landroidx/lifecycle/MutableLiveData;", "Ljava/lang/Void;", "_timelineBitmapsLiveData", "", "Landroid/graphics/Bitmap;", "_trimmerErrorLiveData", "", "_trimmerOutputLiveData", "commandUtil", "Leditor/util/FfmpegCommandUtil;", "getCommandUtil", "()Leditor/util/FfmpegCommandUtil;", "commandUtil$delegate", "Lkotlin/Lazy;", "endTrimMillis", "", "inputDuration", "inputFile", "isPlaybackProgressTrackingEnabled", "", "maxTrimDurationMillis", "startTrimMillis", "adjustTrimBoundsToSatisfyAllowedTrimInterval", "", "trimDuration", "millisToReadableDuration", "millis", "", "onCurrentPlaybackProgressChanged", "onFrameworkErrorNotificationReceived", "message", "errorLog", "onInputTargetAvailable", "Landroidx/lifecycle/LiveData;", "onMultimediaTaskProgressAvailable", "progress", "preparedMessage", "onPlaybackProgressChanged", "onRequestTimelineBitmaps", "count", "size", "onTimelineBitmapsAvailable", "onTrimRangeChanged", "startMillis", "endMillis", "onTrimmerError", "onTrimmerOutputAvailable", "onUriResolveError", "error", "onUriResolved", "content", "Lcom/memes/commons/media/MediaContent;", "onVideoPlaybackDurationAvailable", "durationMillis", "onVideoPlaybackFailed", "resolveVideoContentUri", "possibleUriStr", "selectVideo", "setMaxTrimDurationMillis", "startPlaybackProgressTracking", "stopPlaybackProgressTracking", "trimVideo", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: VideoTrimViewModel.kt */
public final class VideoTrimViewModel extends NicoViewModel implements UriResolverHelper.Callback, VideoPlaybackListener, TrimControlsListener, BitmapTimelineCallback, OnMultimediaProgressListener, MultimediaFrameworkErrorNotifier {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String ERROR_NO_ACCESS = "We are unable to access selected file. Please try again after moving this file to another folder.";
    private static final String ERROR_TRIMMER_FAILED = "We are unable to trim or play selected file. Please try another file.";
    public static final int MIN_TRIM_INTERVAL = 3000;
    private final SingleLiveEvent<File> _inputTargetLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<Void> _playbackProgressLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<List<Bitmap>> _timelineBitmapsLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<String> _trimmerErrorLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<File> _trimmerOutputLiveData = new SingleLiveEvent<>();
    private final Lazy commandUtil$delegate = LazyKt.lazy(new VideoTrimViewModel$commandUtil$2(this));
    /* access modifiers changed from: private */
    public long endTrimMillis = 15000;
    /* access modifiers changed from: private */
    public final MultimediaFramework ffmpegFramework;
    /* access modifiers changed from: private */
    public long inputDuration;
    /* access modifiers changed from: private */
    public File inputFile;
    /* access modifiers changed from: private */
    public boolean isPlaybackProgressTrackingEnabled;
    private long maxTrimDurationMillis = 15000;
    /* access modifiers changed from: private */
    public final OutputTargetGenerator outputTargetGenerator;
    /* access modifiers changed from: private */
    public long startTrimMillis;
    /* access modifiers changed from: private */
    public final VideoThumbnailRetriever thumbnailRetriever;
    /* access modifiers changed from: private */
    public final UriResolverHelper uriResolverHelper;

    /* access modifiers changed from: private */
    public final FfmpegCommandUtil getCommandUtil() {
        return (FfmpegCommandUtil) this.commandUtil$delegate.getValue();
    }

    public void onCurrentPlaybackProgressChanged(int i) {
    }

    public VideoTrimViewModel(UriResolverHelper uriResolverHelper2, OutputTargetGenerator outputTargetGenerator2, MultimediaFramework multimediaFramework, VideoThumbnailRetriever videoThumbnailRetriever) {
        Intrinsics.checkNotNullParameter(uriResolverHelper2, "uriResolverHelper");
        Intrinsics.checkNotNullParameter(outputTargetGenerator2, "outputTargetGenerator");
        Intrinsics.checkNotNullParameter(multimediaFramework, "ffmpegFramework");
        Intrinsics.checkNotNullParameter(videoThumbnailRetriever, "thumbnailRetriever");
        this.uriResolverHelper = uriResolverHelper2;
        this.outputTargetGenerator = outputTargetGenerator2;
        this.ffmpegFramework = multimediaFramework;
        this.thumbnailRetriever = videoThumbnailRetriever;
        multimediaFramework.setOnProgressListener(this);
        multimediaFramework.setFrameworkErrorNotifier(this);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo26107d2 = {"Leditor/tools/videotrim/VideoTrimViewModel$Companion;", "", "()V", "ERROR_NO_ACCESS", "", "ERROR_TRIMMER_FAILED", "MIN_TRIM_INTERVAL", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: VideoTrimViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final LiveData<File> onInputTargetAvailable() {
        return this._inputTargetLiveData;
    }

    public final LiveData<List<Bitmap>> onTimelineBitmapsAvailable() {
        return this._timelineBitmapsLiveData;
    }

    public final LiveData<Void> onPlaybackProgressChanged() {
        return this._playbackProgressLiveData;
    }

    public final LiveData<File> onTrimmerOutputAvailable() {
        return this._trimmerOutputLiveData;
    }

    public final LiveData<String> onTrimmerError() {
        return this._trimmerErrorLiveData;
    }

    public final void setMaxTrimDurationMillis(long j) {
        this.maxTrimDurationMillis = j;
        this.endTrimMillis = j;
    }

    public final void resolveVideoContentUri(String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new VideoTrimViewModel$resolveVideoContentUri$1(this, str, (Continuation) null), 3, (Object) null);
    }

    public final void startPlaybackProgressTracking() {
        this.isPlaybackProgressTrackingEnabled = true;
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new VideoTrimViewModel$startPlaybackProgressTracking$1(this, (Continuation) null), 3, (Object) null);
    }

    public final void stopPlaybackProgressTracking() {
        this.isPlaybackProgressTrackingEnabled = false;
    }

    public final void selectVideo() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new VideoTrimViewModel$selectVideo$1(this, (Continuation) null), 3, (Object) null);
    }

    public final void trimVideo() {
        File file = this.inputFile;
        if (file == null) {
            this._trimmerErrorLiveData.setValue("Failed to trim this file. Reason: Input video not found.");
        } else if (this.startTrimMillis > this.endTrimMillis - ((long) 3000)) {
            this._trimmerErrorLiveData.setValue("Failed to trim this file. Reason: Invalid trim bounds.");
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new VideoTrimViewModel$trimVideo$1(this, file, (Continuation) null), 3, (Object) null);
        }
    }

    public final String millisToReadableDuration(int i) {
        Formatter formatter;
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        if (i5 > 0) {
            formatter = new Formatter().format("%d:%02d:%02d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)});
        } else {
            formatter = new Formatter().format("%02d:%02d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3)});
        }
        String formatter2 = formatter.toString();
        Intrinsics.checkNotNullExpressionValue(formatter2, "formatter.toString()");
        return formatter2;
    }

    /* access modifiers changed from: private */
    public final void adjustTrimBoundsToSatisfyAllowedTrimInterval(long j, long j2) {
        long j3 = this.maxTrimDurationMillis;
        if (j2 > j3) {
            this.endTrimMillis = this.startTrimMillis + j3;
            return;
        }
        long j4 = (long) 3000;
        if (j2 < j4) {
            long j5 = this.endTrimMillis;
            long j6 = j4 - j2;
            boolean z = true;
            if (j - j5 > j6) {
                this.endTrimMillis = j5 + j6;
                return;
            }
            long j7 = this.startTrimMillis;
            if (j7 <= j6) {
                z = false;
            }
            if (z) {
                this.startTrimMillis = j7 - j6;
            }
        }
    }

    public void onUriResolved(MediaContent mediaContent) {
        Intrinsics.checkNotNullParameter(mediaContent, "content");
        hideBlockingProgress();
        File asFile = mediaContent.asFile();
        this.inputFile = asFile;
        this._inputTargetLiveData.setValue(asFile);
    }

    public void onUriResolveError(String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        hideBlockingProgress();
        this._trimmerErrorLiveData.setValue(ERROR_NO_ACCESS);
    }

    public void onVideoPlaybackDurationAvailable(int i) {
        this.inputDuration = (long) i;
    }

    public void onVideoPlaybackFailed(String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this._trimmerErrorLiveData.setValue(ERROR_TRIMMER_FAILED);
    }

    public void onTrimRangeChanged(int i, int i2) {
        this.startTrimMillis = (long) i;
        this.endTrimMillis = (long) i2;
    }

    public void onRequestTimelineBitmaps(int i, int i2) {
        File file = this.inputFile;
        if (file != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), new C4935x2a4bef7(CoroutineExceptionHandler.Key, this), (CoroutineStart) null, new VideoTrimViewModel$onRequestTimelineBitmaps$1(this, file, i, i2, (Continuation) null), 2, (Object) null);
        }
    }

    public void onMultimediaTaskProgressAvailable(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('%');
        updateBlockingProgress(i, sb.toString());
    }

    public void onFrameworkErrorNotificationReceived(String str, String str2) {
        Timber.m303e(str2, new Object[0]);
    }
}
