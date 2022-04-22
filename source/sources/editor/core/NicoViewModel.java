package editor.core;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.facebook.share.internal.ShareConstants;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import editor.custom.blockingprogressdialog.BlockingProgressState;
import editor.custom.liveevent.LiveEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0010J\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0010J\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0010J\u0010\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\bJ\u0014\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0004J \u0010\u0019\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\bJ \u0010\u001a\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\bJ \u0010\u001d\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\bJ \u0010\u001e\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u001f\u001a\u00020\u00162\b\b\u0001\u0010 \u001a\u00020\nH\u0004J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\bH\u0004J\u0016\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\bR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, mo26107d2 = {"Leditor/core/NicoViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_blockingProgressState", "Landroidx/lifecycle/MutableLiveData;", "Leditor/custom/liveevent/LiveEvent;", "Leditor/custom/blockingprogressdialog/BlockingProgressState;", "_toastLiveData", "", "_toastResLiveData", "", "isProgressVisible", "", "hideBlockingProgress", "Lkotlinx/coroutines/Job;", "onBlockingProgressStateChanged", "Landroidx/lifecycle/LiveData;", "onShowToast", "onShowToastResource", "showBlockingProgress", "message", "showContent", "", "contentLayoutLiveData", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "showContentNotAvailable", "showError", "showErrorOnBlockingProgress", "error", "showLoginError", "showProgress", "toast", "messageRes", "updateBlockingProgress", "percentage", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NicoViewModel.kt */
public class NicoViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<LiveEvent<BlockingProgressState>> _blockingProgressState = new MutableLiveData<>();
    private final MutableLiveData<LiveEvent<String>> _toastLiveData = new MutableLiveData<>();
    private final MutableLiveData<LiveEvent<Integer>> _toastResLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public boolean isProgressVisible;

    public final LiveData<LiveEvent<String>> onShowToast() {
        return this._toastLiveData;
    }

    /* access modifiers changed from: protected */
    public final void toast(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this._toastLiveData.setValue(new LiveEvent(str));
    }

    public final LiveData<LiveEvent<Integer>> onShowToastResource() {
        return this._toastResLiveData;
    }

    /* access modifiers changed from: protected */
    public final void toast(int i) {
        this._toastResLiveData.setValue(new LiveEvent(Integer.valueOf(i)));
    }

    public final LiveData<LiveEvent<BlockingProgressState>> onBlockingProgressStateChanged() {
        return this._blockingProgressState;
    }

    public static /* synthetic */ Job showBlockingProgress$default(NicoViewModel nicoViewModel, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "Please wait..";
            }
            return nicoViewModel.showBlockingProgress(str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showBlockingProgress");
    }

    public final Job showBlockingProgress(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new NicoViewModel$showBlockingProgress$1(this, str, (Continuation) null), 3, (Object) null);
    }

    public final Job hideBlockingProgress() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new NicoViewModel$hideBlockingProgress$1(this, (Continuation) null), 3, (Object) null);
    }

    public final Job updateBlockingProgress(int i, String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new NicoViewModel$updateBlockingProgress$1(this, i, str, (Continuation) null), 3, (Object) null);
    }

    public final Job showErrorOnBlockingProgress(String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new NicoViewModel$showErrorOnBlockingProgress$1(this, str, (Continuation) null), 3, (Object) null);
    }

    public static /* synthetic */ void showProgress$default(NicoViewModel nicoViewModel, MutableLiveData mutableLiveData, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str = null;
            }
            nicoViewModel.showProgress(mutableLiveData, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showProgress");
    }

    public final void showProgress(MutableLiveData<ContentVisibilityAction> mutableLiveData, String str) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "contentLayoutLiveData");
        mutableLiveData.setValue(ContentVisibilityAction.Companion.progress(str));
    }

    public static /* synthetic */ void showError$default(NicoViewModel nicoViewModel, MutableLiveData mutableLiveData, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str = null;
            }
            nicoViewModel.showError(mutableLiveData, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showError");
    }

    public final void showError(MutableLiveData<ContentVisibilityAction> mutableLiveData, String str) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "contentLayoutLiveData");
        mutableLiveData.setValue(ContentVisibilityAction.Companion.error(str));
    }

    public static /* synthetic */ void showLoginError$default(NicoViewModel nicoViewModel, MutableLiveData mutableLiveData, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str = null;
            }
            nicoViewModel.showLoginError(mutableLiveData, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoginError");
    }

    public final void showLoginError(MutableLiveData<ContentVisibilityAction> mutableLiveData, String str) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "contentLayoutLiveData");
        mutableLiveData.setValue(ContentVisibilityAction.Companion.loginError(str));
    }

    public static /* synthetic */ void showContentNotAvailable$default(NicoViewModel nicoViewModel, MutableLiveData mutableLiveData, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str = null;
            }
            nicoViewModel.showContentNotAvailable(mutableLiveData, str);
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
}
