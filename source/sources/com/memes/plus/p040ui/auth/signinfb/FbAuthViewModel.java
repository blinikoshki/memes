package com.memes.plus.p040ui.auth.signinfb;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.facebook.login.LoginResult;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.network.memes.api.MemesDataSource;
import com.memes.plus.C4199R;
import com.memes.plus.data.storage.StorageRepository;
import com.memes.plus.p040ui.auth.signinfb.FbAuthProvider;
import com.memes.plus.util.Constants;
import com.memes.plus.util.validation.Validations;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u001aJ\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0017H\u0016J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u001aJ\u0010\u0010!\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010\u0013J\u0018\u0010#\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u0013H\u0002J\b\u0010%\u001a\u00020\u0011H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signinfb/FbAuthViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "Lcom/memes/plus/ui/auth/signinfb/FbAuthProvider$Callback;", "memesDataSource", "Lcom/memes/network/memes/api/MemesDataSource;", "storageRepository", "Lcom/memes/plus/data/storage/StorageRepository;", "(Lcom/memes/network/memes/api/MemesDataSource;Lcom/memes/plus/data/storage/StorageRepository;)V", "_emailInputRequired", "Lcom/memes/commons/util/SingleLiveEvent;", "", "_signInComplete", "fbAuthExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "fbProfile", "Lcom/memes/plus/ui/auth/signinfb/FbProfile;", "fail", "", "fetchExistingAccountEmailIfExists", "", "(Lcom/memes/plus/ui/auth/signinfb/FbProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchFbProfile", "loginResult", "Lcom/facebook/login/LoginResult;", "(Lcom/facebook/login/LoginResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onEmailInputRequired", "Landroidx/lifecycle/LiveData;", "onFacebookAuthFailed", "wasCanceled", "error", "onFacebookAuthSuccess", "result", "onSignInComplete", "proceedSignInWithEmailInput", "emailInput", "signIn", "reliableEmail", "succeed", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signinfb.FbAuthViewModel */
/* compiled from: FbAuthViewModel.kt */
public final class FbAuthViewModel extends BaseViewModel implements FbAuthProvider.Callback {
    /* access modifiers changed from: private */
    public final SingleLiveEvent<Boolean> _emailInputRequired = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<Boolean> _signInComplete = new SingleLiveEvent<>();
    private final CoroutineExceptionHandler fbAuthExceptionHandler = new FbAuthViewModel$$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this);
    /* access modifiers changed from: private */
    public FbProfile fbProfile;
    /* access modifiers changed from: private */
    public final MemesDataSource memesDataSource;
    /* access modifiers changed from: private */
    public final StorageRepository storageRepository;

    public FbAuthViewModel(MemesDataSource memesDataSource2, StorageRepository storageRepository2) {
        Intrinsics.checkNotNullParameter(memesDataSource2, "memesDataSource");
        Intrinsics.checkNotNullParameter(storageRepository2, "storageRepository");
        this.memesDataSource = memesDataSource2;
        this.storageRepository = storageRepository2;
    }

    public final LiveData<Boolean> onSignInComplete() {
        return this._signInComplete;
    }

    public final LiveData<Boolean> onEmailInputRequired() {
        return this._emailInputRequired;
    }

    public final void proceedSignInWithEmailInput(String str) {
        int forEmail = Validations.INSTANCE.forEmail(str);
        if (forEmail != 5) {
            if (forEmail == 1) {
                toast((int) C4199R.string.error_email_empty);
            } else if (forEmail != 2) {
                toast(Constants.UNUSUAL_ERROR);
            } else {
                toast((int) C4199R.string.error_email_invalid);
            }
        } else if (str != null) {
            FbProfile fbProfile2 = this.fbProfile;
            if (fbProfile2 != null) {
                signIn(fbProfile2, str);
                return;
            }
            throw new RuntimeException("Email Input Received, but fb-profile not available.");
        } else {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    /* access modifiers changed from: private */
    public final void signIn(FbProfile fbProfile2, String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.fbAuthExceptionHandler, (CoroutineStart) null, new FbAuthViewModel$signIn$1(this, fbProfile2, str, (Continuation) null), 2, (Object) null);
    }

    private final void succeed() {
        this._signInComplete.setValue(true);
    }

    /* access modifiers changed from: private */
    public final void fail() {
        this._signInComplete.setValue(false);
    }

    public void onFacebookAuthSuccess(LoginResult loginResult) {
        Intrinsics.checkNotNullParameter(loginResult, "result");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.fbAuthExceptionHandler, (CoroutineStart) null, new FbAuthViewModel$onFacebookAuthSuccess$1(this, loginResult, (Continuation) null), 2, (Object) null);
    }

    public void onFacebookAuthFailed(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        toast(str);
        fail();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object fetchFbProfile(LoginResult loginResult, Continuation<? super FbProfile> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FbAuthViewModel$fetchFbProfile$2(loginResult, (Continuation) null), continuation);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object fetchExistingAccountEmailIfExists(FbProfile fbProfile2, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FbAuthViewModel$fetchExistingAccountEmailIfExists$2(this, fbProfile2, (Continuation) null), continuation);
    }
}
