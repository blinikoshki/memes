package editor.editor.entry.framesizes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import editor.common.assetsprovider.AssetsProvider;
import editor.core.NicoViewModel;
import editor.optionsui.frame.frameresize.FrameSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u000eR\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Leditor/editor/entry/framesizes/EntryFrameSizesViewModel;", "Leditor/core/NicoViewModel;", "assetsProvider", "Leditor/common/assetsprovider/AssetsProvider;", "(Leditor/common/assetsprovider/AssetsProvider;)V", "_frameSizes", "Landroidx/lifecycle/MutableLiveData;", "", "Leditor/optionsui/frame/frameresize/FrameSize;", "_frameSizesExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "loadFrameSizes", "", "onFrameSizesAvailable", "Landroidx/lifecycle/LiveData;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EntryFrameSizesViewModel.kt */
public final class EntryFrameSizesViewModel extends NicoViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<List<FrameSize>> _frameSizes = new MutableLiveData<>();
    private final CoroutineExceptionHandler _frameSizesExceptionHandler = new C4716x915cdebb(CoroutineExceptionHandler.Key, this);
    /* access modifiers changed from: private */
    public final AssetsProvider assetsProvider;

    public EntryFrameSizesViewModel(AssetsProvider assetsProvider2) {
        Intrinsics.checkNotNullParameter(assetsProvider2, "assetsProvider");
        this.assetsProvider = assetsProvider2;
        loadFrameSizes();
    }

    public final LiveData<List<FrameSize>> onFrameSizesAvailable() {
        return this._frameSizes;
    }

    public final void loadFrameSizes() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this._frameSizesExceptionHandler, (CoroutineStart) null, new EntryFrameSizesViewModel$loadFrameSizes$1(this, (Continuation) null), 2, (Object) null);
    }
}
