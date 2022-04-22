package editor.tools.filters;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.facebook.share.internal.ShareConstants;
import com.memes.commons.media.MediaFile;
import com.memes.commons.output.OutputTargetGenerator;
import editor.core.NicoViewModel;
import editor.gpu.command.GpuFramework;
import editor.gpu.command.GpuFrameworkProgressCallback;
import editor.gpu.gpuimage.GPUImageView;
import editor.tools.filters.conflation.FilterRequest;
import editor.tools.filters.conflation.FilterResult;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u001aJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001aJ\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0015\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010!J#\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H@ø\u0001\u0000¢\u0006\u0002\u0010'R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006("}, mo26107d2 = {"Leditor/tools/filters/FiltersViewModel;", "Leditor/core/NicoViewModel;", "Leditor/gpu/command/GpuFrameworkProgressCallback;", "gpuFramework", "Leditor/gpu/command/GpuFramework;", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "(Leditor/gpu/command/GpuFramework;Lcom/memes/commons/output/OutputTargetGenerator;)V", "_filterError", "Landroidx/lifecycle/MutableLiveData;", "", "_filterOutput", "Leditor/tools/filters/conflation/FilterResult;", "frameworkExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getFrameworkExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "frameworkExceptionHandler$delegate", "Lkotlin/Lazy;", "applyFilters", "", "gpuImageView", "Leditor/gpu/gpuimage/GPUImageView;", "request", "Leditor/tools/filters/conflation/FilterRequest;", "filterError", "Landroidx/lifecycle/LiveData;", "filterOutput", "onGpuFrameworkProgressAvailable", "progress", "", "writeImageEffects", "Lcom/memes/commons/media/MediaFile;", "(Leditor/gpu/gpuimage/GPUImageView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeVideoEffects", "Ljava/io/File;", "inputFile", "filter", "Leditor/tools/filters/MediaFilter;", "(Ljava/io/File;Leditor/tools/filters/MediaFilter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FiltersViewModel.kt */
public final class FiltersViewModel extends NicoViewModel implements GpuFrameworkProgressCallback {
    /* access modifiers changed from: private */
    public final MutableLiveData<String> _filterError = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<FilterResult> _filterOutput = new MutableLiveData<>();
    private final Lazy frameworkExceptionHandler$delegate = LazyKt.lazy(new FiltersViewModel$frameworkExceptionHandler$2(this));
    /* access modifiers changed from: private */
    public final GpuFramework gpuFramework;
    /* access modifiers changed from: private */
    public final OutputTargetGenerator outputTargetGenerator;

    private final CoroutineExceptionHandler getFrameworkExceptionHandler() {
        return (CoroutineExceptionHandler) this.frameworkExceptionHandler$delegate.getValue();
    }

    public FiltersViewModel(GpuFramework gpuFramework2, OutputTargetGenerator outputTargetGenerator2) {
        Intrinsics.checkNotNullParameter(gpuFramework2, "gpuFramework");
        Intrinsics.checkNotNullParameter(outputTargetGenerator2, "outputTargetGenerator");
        this.gpuFramework = gpuFramework2;
        this.outputTargetGenerator = outputTargetGenerator2;
        gpuFramework2.setOnProgressListener(this);
    }

    public final LiveData<FilterResult> filterOutput() {
        return this._filterOutput;
    }

    public final LiveData<String> filterError() {
        return this._filterError;
    }

    public final void applyFilters(GPUImageView gPUImageView, FilterRequest filterRequest) {
        Intrinsics.checkNotNullParameter(gPUImageView, "gpuImageView");
        Intrinsics.checkNotNullParameter(filterRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), getFrameworkExceptionHandler(), (CoroutineStart) null, new FiltersViewModel$applyFilters$1(this, filterRequest, gPUImageView, (Continuation) null), 2, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object writeImageEffects(GPUImageView gPUImageView, Continuation<? super MediaFile> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new FiltersViewModel$writeImageEffects$2(this, gPUImageView, (Continuation) null), continuation);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object writeVideoEffects(File file, MediaFilter mediaFilter, Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FiltersViewModel$writeVideoEffects$2(this, file, mediaFilter, (Continuation) null), continuation);
    }

    public void onGpuFrameworkProgressAvailable(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('%');
        updateBlockingProgress(i, sb.toString());
    }
}
