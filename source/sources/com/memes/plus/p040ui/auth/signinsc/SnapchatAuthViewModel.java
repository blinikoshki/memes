package com.memes.plus.p040ui.auth.signinsc;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.network.memes.api.MemesDataSource;
import com.memes.plus.data.storage.StorageRepository;
import com.memes.plus.p040ui.auth.signinsc.SnapchatAuthProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0012H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signinsc/SnapchatAuthViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "Lcom/memes/plus/ui/auth/signinsc/SnapchatAuthProvider$Callback;", "memesDataSource", "Lcom/memes/network/memes/api/MemesDataSource;", "storageRepository", "Lcom/memes/plus/data/storage/StorageRepository;", "(Lcom/memes/network/memes/api/MemesDataSource;Lcom/memes/plus/data/storage/StorageRepository;)V", "_signInComplete", "Lcom/memes/commons/util/SingleLiveEvent;", "", "snapchatAuthExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "onSignInComplete", "Landroidx/lifecycle/LiveData;", "onSnapchatSignInFailed", "", "error", "", "onSnapchatSignInProgress", "shouldShow", "onSnapchatSignInSuccess", "accessToken", "signIn", "snapchatAccessToken", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signinsc.SnapchatAuthViewModel */
/* compiled from: SnapchatAuthViewModel.kt */
public final class SnapchatAuthViewModel extends BaseViewModel implements SnapchatAuthProvider.Callback {
    /* access modifiers changed from: private */
    public final SingleLiveEvent<Boolean> _signInComplete = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final MemesDataSource memesDataSource;
    private final CoroutineExceptionHandler snapchatAuthExceptionHandler = new C4228x5bd2af68(CoroutineExceptionHandler.Key, this);
    /* access modifiers changed from: private */
    public final StorageRepository storageRepository;

    public SnapchatAuthViewModel(MemesDataSource memesDataSource2, StorageRepository storageRepository2) {
        Intrinsics.checkNotNullParameter(memesDataSource2, "memesDataSource");
        Intrinsics.checkNotNullParameter(storageRepository2, "storageRepository");
        this.memesDataSource = memesDataSource2;
        this.storageRepository = storageRepository2;
    }

    public final LiveData<Boolean> onSignInComplete() {
        return this._signInComplete;
    }

    private final void signIn(String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.snapchatAuthExceptionHandler, (CoroutineStart) null, new SnapchatAuthViewModel$signIn$1(this, str, (Continuation) null), 2, (Object) null);
    }

    public void onSnapchatSignInProgress(boolean z) {
        if (z) {
            BaseViewModel.showBlockingProgressDialog$default(this, (String) null, 1, (Object) null);
        } else {
            hideBlockingProgressDialog();
        }
    }

    public void onSnapchatSignInSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "accessToken");
        signIn(str);
    }

    public void onSnapchatSignInFailed(String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        hideBlockingProgressDialog();
        toast(str);
        this._signInComplete.setValue(false);
    }
}
