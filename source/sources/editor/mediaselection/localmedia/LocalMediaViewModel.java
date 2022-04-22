package editor.mediaselection.localmedia;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import editor.core.AdapterUpdate;
import editor.core.NicoViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo26107d2 = {"Leditor/mediaselection/localmedia/LocalMediaViewModel;", "Leditor/core/NicoViewModel;", "mediaProvider", "Leditor/mediaselection/localmedia/MediaProvider;", "(Leditor/mediaselection/localmedia/MediaProvider;)V", "_galleryExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "_resultsLiveData", "Landroidx/lifecycle/MutableLiveData;", "Leditor/core/AdapterUpdate;", "Leditor/mediaselection/localmedia/LocalMedia;", "contentVisibilityLiveData", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "getContentVisibilityLiveData", "()Landroidx/lifecycle/MutableLiveData;", "loadGalleryMedia", "", "onGetResultsLiveData", "Landroidx/lifecycle/LiveData;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: LocalMediaViewModel.kt */
public final class LocalMediaViewModel extends NicoViewModel {
    private final CoroutineExceptionHandler _galleryExceptionHandler = new C4827xff53ae39(CoroutineExceptionHandler.Key, this);
    /* access modifiers changed from: private */
    public MutableLiveData<AdapterUpdate<LocalMedia>> _resultsLiveData = new MutableLiveData<>();
    private final MutableLiveData<ContentVisibilityAction> contentVisibilityLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MediaProvider mediaProvider;

    public LocalMediaViewModel(MediaProvider mediaProvider2) {
        Intrinsics.checkNotNullParameter(mediaProvider2, "mediaProvider");
        this.mediaProvider = mediaProvider2;
    }

    public final LiveData<AdapterUpdate<LocalMedia>> onGetResultsLiveData() {
        return this._resultsLiveData;
    }

    public final MutableLiveData<ContentVisibilityAction> getContentVisibilityLiveData() {
        return this.contentVisibilityLiveData;
    }

    public final void loadGalleryMedia() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this._galleryExceptionHandler, (CoroutineStart) null, new LocalMediaViewModel$loadGalleryMedia$1(this, (Continuation) null), 2, (Object) null);
    }
}
