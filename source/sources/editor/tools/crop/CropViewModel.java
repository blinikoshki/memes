package editor.tools.crop;

import android.graphics.Rect;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.media.MediaContent;
import com.memes.commons.output.OutputTargetGenerator;
import editor.common.assetsprovider.AssetsProvider;
import editor.core.NicoViewModel;
import editor.editor.equipment.media.content.CropSpec;
import editor.ffmpeg.core.MultimediaFramework;
import editor.ffmpeg.core.callback.MultimediaFrameworkErrorNotifier;
import editor.ffmpeg.core.callback.OnMultimediaProgressListener;
import editor.util.FfmpegCommandUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0+J\u0012\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0+J\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00120+J\u0010\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020#H\u0002J\u0010\u00100\u001a\u00020%2\u0006\u0010/\u001a\u00020#H\u0002J\u0010\u00101\u001a\u00020%2\u0006\u0010/\u001a\u00020#H\u0002J\u001c\u00102\u001a\u00020%2\b\u00103\u001a\u0004\u0018\u00010\r2\b\u00104\u001a\u0004\u0018\u00010\rH\u0016J\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00140+J\u001a\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020)2\b\u00108\u001a\u0004\u0018\u00010\rH\u0016J\b\u00109\u001a\u00020%H\u0002J\u000e\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020\u0012J\u0012\u0010<\u001a\u00020%2\b\u0010/\u001a\u0004\u0018\u00010#H\u0002R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\u001f\u0010 R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006="}, mo26107d2 = {"Leditor/tools/crop/CropViewModel;", "Leditor/core/NicoViewModel;", "Leditor/ffmpeg/core/callback/OnMultimediaProgressListener;", "Leditor/ffmpeg/core/callback/MultimediaFrameworkErrorNotifier;", "ffmpegFramework", "Leditor/ffmpeg/core/MultimediaFramework;", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "assetsProvider", "Leditor/common/assetsprovider/AssetsProvider;", "(Leditor/ffmpeg/core/MultimediaFramework;Lcom/memes/commons/output/OutputTargetGenerator;Leditor/common/assetsprovider/AssetsProvider;)V", "_cropError", "Landroidx/lifecycle/MutableLiveData;", "", "_cropOptions", "", "Leditor/tools/crop/CropOption;", "_cropOutput", "Leditor/editor/equipment/media/content/CropSpec;", "_imageSourceChanged", "Ljava/io/File;", "commandUtil", "Leditor/util/FfmpegCommandUtil;", "getCommandUtil", "()Leditor/util/FfmpegCommandUtil;", "commandUtil$delegate", "Lkotlin/Lazy;", "cropOptionsList", "", "frameworkExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getFrameworkExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "frameworkExceptionHandler$delegate", "mediaContent", "Lcom/memes/commons/media/MediaContent;", "crop", "", "rect", "Landroid/graphics/Rect;", "rotation", "", "cropError", "Landroidx/lifecycle/LiveData;", "cropOptions", "cropOutput", "notifyGifSource", "content", "notifyPhotoSource", "notifyVideoSource", "onFrameworkErrorNotificationReceived", "message", "errorLog", "onImageSourceChanged", "onMultimediaTaskProgressAvailable", "progress", "preparedMessage", "showCropOptions", "submitCropSpec", "cropSpec", "submitSourceMediaContent", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CropViewModel.kt */
public final class CropViewModel extends NicoViewModel implements OnMultimediaProgressListener, MultimediaFrameworkErrorNotifier {
    /* access modifiers changed from: private */
    public final MutableLiveData<String> _cropError = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<List<CropOption>> _cropOptions = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<CropSpec> _cropOutput = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<File> _imageSourceChanged = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final AssetsProvider assetsProvider;
    private final Lazy commandUtil$delegate = LazyKt.lazy(new CropViewModel$commandUtil$2(this));
    /* access modifiers changed from: private */
    public final List<CropOption> cropOptionsList = new ArrayList();
    /* access modifiers changed from: private */
    public final MultimediaFramework ffmpegFramework;
    private final Lazy frameworkExceptionHandler$delegate = LazyKt.lazy(new CropViewModel$frameworkExceptionHandler$2(this));
    private MediaContent mediaContent;
    /* access modifiers changed from: private */
    public final OutputTargetGenerator outputTargetGenerator;

    /* access modifiers changed from: private */
    public final FfmpegCommandUtil getCommandUtil() {
        return (FfmpegCommandUtil) this.commandUtil$delegate.getValue();
    }

    private final CoroutineExceptionHandler getFrameworkExceptionHandler() {
        return (CoroutineExceptionHandler) this.frameworkExceptionHandler$delegate.getValue();
    }

    public CropViewModel(MultimediaFramework multimediaFramework, OutputTargetGenerator outputTargetGenerator2, AssetsProvider assetsProvider2) {
        Intrinsics.checkNotNullParameter(multimediaFramework, "ffmpegFramework");
        Intrinsics.checkNotNullParameter(outputTargetGenerator2, "outputTargetGenerator");
        Intrinsics.checkNotNullParameter(assetsProvider2, "assetsProvider");
        this.ffmpegFramework = multimediaFramework;
        this.outputTargetGenerator = outputTargetGenerator2;
        this.assetsProvider = assetsProvider2;
        multimediaFramework.setOnProgressListener(this);
        multimediaFramework.setFrameworkErrorNotifier(this);
    }

    public final LiveData<File> onImageSourceChanged() {
        return this._imageSourceChanged;
    }

    public final LiveData<List<CropOption>> cropOptions() {
        return this._cropOptions;
    }

    public final LiveData<CropSpec> cropOutput() {
        return this._cropOutput;
    }

    public final LiveData<String> cropError() {
        return this._cropError;
    }

    private final void showCropOptions() {
        if (!this.cropOptionsList.isEmpty()) {
            this._cropOptions.setValue(this.cropOptionsList);
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new CropViewModel$showCropOptions$1(this, (Continuation) null), 3, (Object) null);
        }
    }

    public final void submitCropSpec(CropSpec cropSpec) {
        Intrinsics.checkNotNullParameter(cropSpec, "cropSpec");
        submitSourceMediaContent(cropSpec.getContent());
    }

    private final void submitSourceMediaContent(MediaContent mediaContent2) {
        if (mediaContent2 == null) {
            this._cropError.setValue("Unable to load source file.");
        } else if (!mediaContent2.asFile().exists()) {
            this._cropError.setValue("source file doesn't exist.");
        } else {
            this.mediaContent = mediaContent2;
            if (mediaContent2.isPhoto()) {
                notifyPhotoSource(mediaContent2);
            } else if (mediaContent2.isGif()) {
                notifyGifSource(mediaContent2);
            } else if (mediaContent2.isVideo() || mediaContent2.isGifVideo()) {
                notifyVideoSource(mediaContent2);
            } else {
                this._cropError.setValue("Unable to determine content-type for cropping this media.");
                return;
            }
            showCropOptions();
        }
    }

    private final void notifyPhotoSource(MediaContent mediaContent2) {
        this._imageSourceChanged.setValue(mediaContent2.asFile());
    }

    private final void notifyGifSource(MediaContent mediaContent2) {
        this._imageSourceChanged.setValue(mediaContent2.asFile());
    }

    private final void notifyVideoSource(MediaContent mediaContent2) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), getFrameworkExceptionHandler(), (CoroutineStart) null, new CropViewModel$notifyVideoSource$1(this, mediaContent2, (Continuation) null), 2, (Object) null);
    }

    public final void crop(Rect rect, int i) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        MediaContent mediaContent2 = this.mediaContent;
        if (mediaContent2 == null) {
            this._cropError.setValue("Failed to find source media to crop. Please try again.");
            return;
        }
        File asFile = mediaContent2.asFile();
        if (!asFile.exists()) {
            this._cropError.setValue("Failed to crop this media.");
            return;
        }
        rect.right = RangesKt.coerceAtMost(rect.right, mediaContent2.width());
        rect.bottom = RangesKt.coerceAtMost(rect.bottom, mediaContent2.height());
        CropBounds cropBounds = new CropBounds(rect, mediaContent2.width(), mediaContent2.height(), i);
        if (!cropBounds.isCropBoundsSameAsSource() || cropBounds.isRotated()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), getFrameworkExceptionHandler(), (CoroutineStart) null, new CropViewModel$crop$1(this, asFile, mediaContent2, cropBounds, (Continuation) null), 2, (Object) null);
            return;
        }
        this._cropOutput.setValue(new CropSpec(mediaContent2, cropBounds));
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
