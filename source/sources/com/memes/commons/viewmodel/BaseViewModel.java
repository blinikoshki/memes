package com.memes.commons.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.facebook.share.internal.ShareConstants;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.util.SingleLiveEvent;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u0012\u0010\u0019\u001a\u00020\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\tJ\u0014\u0010\u001b\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0004J \u0010\u001e\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\tJ \u0010\u001f\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\tJ\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\tH\u0007J \u0010!\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\tJ \u0010\"\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\tJ\u0010\u0010#\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\tJ\u0010\u0010$\u001a\u00020\u00182\b\b\u0001\u0010%\u001a\u00020\u0015J\u000e\u0010$\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\tJ\u000e\u0010&\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011¨\u0006'"}, mo26107d2 = {"Lcom/memes/commons/viewmodel/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "blockingProgressLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getBlockingProgressLiveData", "()Landroidx/lifecycle/MutableLiveData;", "blockingProgressMessageLiveData", "", "getBlockingProgressMessageLiveData", "informationDialogLiveData", "getInformationDialogLiveData$annotations", "getInformationDialogLiveData", "sessionExpiredLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "getSessionExpiredLiveData", "()Lcom/memes/commons/util/SingleLiveEvent;", "toastLiveData", "getToastLiveData", "toastResLiveData", "", "getToastResLiveData", "hideBlockingProgressDialog", "", "showBlockingProgressDialog", "message", "showContent", "contentLayoutLiveData", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "showContentNotAvailable", "showError", "showInformationDialog", "showLoginError", "showProgress", "showSessionExpiredDialog", "toast", "messageRes", "updateBlockingProgressDialogLabel", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BaseViewModel.kt */
public class BaseViewModel extends ViewModel {
    private final MutableLiveData<Boolean> blockingProgressLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> blockingProgressMessageLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> informationDialogLiveData = new MutableLiveData<>();
    private final SingleLiveEvent<String> sessionExpiredLiveData = new SingleLiveEvent<>();
    private final SingleLiveEvent<String> toastLiveData = new SingleLiveEvent<>();
    private final SingleLiveEvent<Integer> toastResLiveData = new SingleLiveEvent<>();

    @Deprecated(message = "dont use it please")
    public static /* synthetic */ void getInformationDialogLiveData$annotations() {
    }

    public final SingleLiveEvent<String> getSessionExpiredLiveData() {
        return this.sessionExpiredLiveData;
    }

    public final void showSessionExpiredDialog(String str) {
        this.sessionExpiredLiveData.setValue(str);
    }

    public final MutableLiveData<Boolean> getBlockingProgressLiveData() {
        return this.blockingProgressLiveData;
    }

    public final MutableLiveData<String> getBlockingProgressMessageLiveData() {
        return this.blockingProgressMessageLiveData;
    }

    public static /* synthetic */ void showBlockingProgressDialog$default(BaseViewModel baseViewModel, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "Please wait...";
            }
            baseViewModel.showBlockingProgressDialog(str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showBlockingProgressDialog");
    }

    public final void showBlockingProgressDialog(String str) {
        this.blockingProgressLiveData.setValue(true);
        this.blockingProgressMessageLiveData.setValue(str);
    }

    public final void hideBlockingProgressDialog() {
        this.blockingProgressLiveData.setValue(false);
    }

    public final void updateBlockingProgressDialogLabel(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.blockingProgressMessageLiveData.setValue(str);
    }

    public final MutableLiveData<String> getInformationDialogLiveData() {
        return this.informationDialogLiveData;
    }

    @Deprecated(message = "dont use it please")
    public final void showInformationDialog(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.informationDialogLiveData.setValue(str);
    }

    public static /* synthetic */ void showProgress$default(BaseViewModel baseViewModel, MutableLiveData mutableLiveData, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str = null;
            }
            baseViewModel.showProgress(mutableLiveData, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showProgress");
    }

    public final void showProgress(MutableLiveData<ContentVisibilityAction> mutableLiveData, String str) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "contentLayoutLiveData");
        mutableLiveData.setValue(ContentVisibilityAction.Companion.progress(str));
    }

    public static /* synthetic */ void showError$default(BaseViewModel baseViewModel, MutableLiveData mutableLiveData, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str = null;
            }
            baseViewModel.showError(mutableLiveData, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showError");
    }

    public final void showError(MutableLiveData<ContentVisibilityAction> mutableLiveData, String str) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "contentLayoutLiveData");
        mutableLiveData.setValue(ContentVisibilityAction.Companion.error(str));
    }

    public static /* synthetic */ void showLoginError$default(BaseViewModel baseViewModel, MutableLiveData mutableLiveData, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str = null;
            }
            baseViewModel.showLoginError(mutableLiveData, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoginError");
    }

    public final void showLoginError(MutableLiveData<ContentVisibilityAction> mutableLiveData, String str) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "contentLayoutLiveData");
        mutableLiveData.setValue(ContentVisibilityAction.Companion.loginError(str));
    }

    public static /* synthetic */ void showContentNotAvailable$default(BaseViewModel baseViewModel, MutableLiveData mutableLiveData, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str = null;
            }
            baseViewModel.showContentNotAvailable(mutableLiveData, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showContentNotAvailable");
    }

    public final void showContentNotAvailable(MutableLiveData<ContentVisibilityAction> mutableLiveData, String str) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "contentLayoutLiveData");
        mutableLiveData.setValue(ContentVisibilityAction.Companion.contentNotAvailable(str));
    }

    public final void showContent(MutableLiveData<ContentVisibilityAction> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "contentLayoutLiveData");
        mutableLiveData.setValue(ContentVisibilityAction.Companion.content());
    }

    public final SingleLiveEvent<String> getToastLiveData() {
        return this.toastLiveData;
    }

    public final void toast(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new BaseViewModel$toast$1(this, str, (Continuation) null), 3, (Object) null);
    }

    public final SingleLiveEvent<Integer> getToastResLiveData() {
        return this.toastResLiveData;
    }

    public final void toast(int i) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new BaseViewModel$toast$2(this, i, (Continuation) null), 3, (Object) null);
    }
}
