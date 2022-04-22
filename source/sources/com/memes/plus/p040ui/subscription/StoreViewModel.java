package com.memes.plus.p040ui.subscription;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.data.source.purchase.StoreInfo;
import com.memes.plus.data.source.purchase.StoreRepository;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0014R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/StoreViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "repository", "Lcom/memes/plus/data/source/purchase/StoreRepository;", "(Lcom/memes/plus/data/source/purchase/StoreRepository;)V", "_contentVisibilityLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "_storeInfoLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "Lcom/memes/plus/data/source/purchase/StoreInfo;", "storeInfoExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getStoreInfoExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "storeInfoExceptionHandler$delegate", "Lkotlin/Lazy;", "fetchStoreInfo", "", "onContentVisibilityChanged", "Landroidx/lifecycle/LiveData;", "onStoreInfoAvailable", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.StoreViewModel */
/* compiled from: StoreViewModel.kt */
public final class StoreViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<ContentVisibilityAction> _contentVisibilityLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<StoreInfo> _storeInfoLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final StoreRepository repository;
    private final Lazy storeInfoExceptionHandler$delegate = LazyKt.lazy(new StoreViewModel$storeInfoExceptionHandler$2(this));

    private final CoroutineExceptionHandler getStoreInfoExceptionHandler() {
        return (CoroutineExceptionHandler) this.storeInfoExceptionHandler$delegate.getValue();
    }

    public StoreViewModel(StoreRepository storeRepository) {
        Intrinsics.checkNotNullParameter(storeRepository, "repository");
        this.repository = storeRepository;
    }

    public final LiveData<StoreInfo> onStoreInfoAvailable() {
        return this._storeInfoLiveData;
    }

    public final LiveData<ContentVisibilityAction> onContentVisibilityChanged() {
        return this._contentVisibilityLiveData;
    }

    public final void fetchStoreInfo() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), getStoreInfoExceptionHandler(), (CoroutineStart) null, new StoreViewModel$fetchStoreInfo$1(this, (Continuation) null), 2, (Object) null);
    }
}
