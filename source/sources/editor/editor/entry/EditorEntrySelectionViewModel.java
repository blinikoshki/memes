package editor.editor.entry;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import editor.common.assetsprovider.AssetsProvider;
import editor.core.NicoViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0014\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\u0011J\u0014\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo26107d2 = {"Leditor/editor/entry/EditorEntrySelectionViewModel;", "Leditor/core/NicoViewModel;", "assetsProvider", "Leditor/common/assetsprovider/AssetsProvider;", "(Leditor/common/assetsprovider/AssetsProvider;)V", "_cellWireframeExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "_cellWireframes", "Landroidx/lifecycle/MutableLiveData;", "", "Ljava/lang/Void;", "_trendingTemplates", "_trendingTemplatesExceptionHandler", "loadCellWireframes", "Lkotlinx/coroutines/Job;", "loadTrendingTemplates", "onCellWireframesAvailable", "Landroidx/lifecycle/LiveData;", "onTrendingTemplatesAvailable", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorEntrySelectionViewModel.kt */
public final class EditorEntrySelectionViewModel extends NicoViewModel {
    private final CoroutineExceptionHandler _cellWireframeExceptionHandler = new C4712x178d3dac(CoroutineExceptionHandler.Key, this);
    /* access modifiers changed from: private */
    public final MutableLiveData<List<Void>> _cellWireframes = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<List<Void>> _trendingTemplates = new MutableLiveData<>();
    private final CoroutineExceptionHandler _trendingTemplatesExceptionHandler = new C4711x178d3dab(CoroutineExceptionHandler.Key, this);
    private final AssetsProvider assetsProvider;

    public EditorEntrySelectionViewModel(AssetsProvider assetsProvider2) {
        Intrinsics.checkNotNullParameter(assetsProvider2, "assetsProvider");
        this.assetsProvider = assetsProvider2;
        loadTrendingTemplates();
        loadCellWireframes();
    }

    public final LiveData<List<Void>> onTrendingTemplatesAvailable() {
        return this._trendingTemplates;
    }

    public final LiveData<List<Void>> onCellWireframesAvailable() {
        return this._cellWireframes;
    }

    public final Job loadTrendingTemplates() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this._trendingTemplatesExceptionHandler, (CoroutineStart) null, new EditorEntrySelectionViewModel$loadTrendingTemplates$1(this, (Continuation) null), 2, (Object) null);
    }

    public final Job loadCellWireframes() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this._cellWireframeExceptionHandler, (CoroutineStart) null, new EditorEntrySelectionViewModel$loadCellWireframes$1(this, (Continuation) null), 2, (Object) null);
    }
}
