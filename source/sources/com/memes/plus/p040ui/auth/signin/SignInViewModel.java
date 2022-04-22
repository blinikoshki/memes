package com.memes.plus.p040ui.auth.signin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.network.memes.api.MemesDataSource;
import com.memes.plus.C4199R;
import com.memes.plus.data.storage.StorageRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u0013\u001a\u00020\u000fJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signin/SignInViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "memesDataSource", "Lcom/memes/network/memes/api/MemesDataSource;", "storageRepository", "Lcom/memes/plus/data/storage/StorageRepository;", "(Lcom/memes/network/memes/api/MemesDataSource;Lcom/memes/plus/data/storage/StorageRepository;)V", "_signInResult", "Lcom/memes/commons/util/SingleLiveEvent;", "", "identity", "password", "signInExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "identityChanged", "", "onSignInSuccessful", "Landroidx/lifecycle/LiveData;", "passwordChanged", "signIn", "Lkotlinx/coroutines/Job;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signin.SignInViewModel */
/* compiled from: SignInViewModel.kt */
public final class SignInViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final SingleLiveEvent<String> _signInResult = new SingleLiveEvent<>();
    private String identity;
    /* access modifiers changed from: private */
    public final MemesDataSource memesDataSource;
    private String password;
    private final CoroutineExceptionHandler signInExceptionHandler = new SignInViewModel$$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this);
    /* access modifiers changed from: private */
    public final StorageRepository storageRepository;

    public SignInViewModel(MemesDataSource memesDataSource2, StorageRepository storageRepository2) {
        Intrinsics.checkNotNullParameter(memesDataSource2, "memesDataSource");
        Intrinsics.checkNotNullParameter(storageRepository2, "storageRepository");
        this.memesDataSource = memesDataSource2;
        this.storageRepository = storageRepository2;
    }

    public final LiveData<String> onSignInSuccessful() {
        return this._signInResult;
    }

    public final void identityChanged(String str) {
        this.identity = str;
    }

    public final void passwordChanged(String str) {
        this.password = str;
    }

    public final void signIn() {
        String str = this.identity;
        CharSequence charSequence = str;
        boolean z = false;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            toast((int) C4199R.string.error_email_or_username_empty);
            return;
        }
        String str2 = this.password;
        CharSequence charSequence2 = str2;
        if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
            z = true;
        }
        if (z) {
            toast((int) C4199R.string.error_password_empty);
        } else {
            signIn(str, str2);
        }
    }

    private final Job signIn(String str, String str2) {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.signInExceptionHandler, (CoroutineStart) null, new SignInViewModel$signIn$1(this, str, str2, (Continuation) null), 2, (Object) null);
    }
}
