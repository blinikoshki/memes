package editor.custom.blockingprogressdialog;

import android.content.Context;
import android.content.DialogInterface;
import com.appsflyer.internal.referrer.Payload;
import com.kaopiz.kprogresshud.KProgressHUD;
import editor.custom.blockingprogressdialog.BlockingProgressState;
import editor.util.StyledAlertDialog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, mo26107d2 = {"Leditor/custom/blockingprogressdialog/BlockingProgressDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "progressHUD", "Lcom/kaopiz/kprogresshud/KProgressHUD;", "getProgressHUD", "()Lcom/kaopiz/kprogresshud/KProgressHUD;", "progressHUD$delegate", "Lkotlin/Lazy;", "apply", "", "state", "Leditor/custom/blockingprogressdialog/BlockingProgressState;", "hideDialog", "showDialog", "message", "", "showError", "error", "showProgress", "progress", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BlockingProgressDialog.kt */
public final class BlockingProgressDialog {
    /* access modifiers changed from: private */
    public final Context context;
    private final Lazy progressHUD$delegate = LazyKt.lazy(new BlockingProgressDialog$progressHUD$2(this));

    private final KProgressHUD getProgressHUD() {
        return (KProgressHUD) this.progressHUD$delegate.getValue();
    }

    public BlockingProgressDialog(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final void apply(BlockingProgressState blockingProgressState) {
        Intrinsics.checkNotNullParameter(blockingProgressState, "state");
        if (blockingProgressState instanceof BlockingProgressState.Visible) {
            showDialog(((BlockingProgressState.Visible) blockingProgressState).getMessage());
        } else if (blockingProgressState instanceof BlockingProgressState.Hidden) {
            hideDialog();
        } else if (blockingProgressState instanceof BlockingProgressState.Progress) {
            BlockingProgressState.Progress progress = (BlockingProgressState.Progress) blockingProgressState;
            showProgress(progress.getProgress(), progress.getMessage());
        } else if (blockingProgressState instanceof BlockingProgressState.Error) {
            showError(((BlockingProgressState.Error) blockingProgressState).getError());
        }
    }

    private final void showDialog(String str) {
        getProgressHUD().setStyle(KProgressHUD.Style.SPIN_INDETERMINATE);
        getProgressHUD().setLabel(str);
        getProgressHUD().setDetailsLabel((String) null);
        getProgressHUD().show();
    }

    private final void hideDialog() {
        getProgressHUD().setStyle(KProgressHUD.Style.SPIN_INDETERMINATE);
        getProgressHUD().dismiss();
    }

    private final void showProgress(int i, String str) {
        if (i >= 0 && 100 >= i) {
            getProgressHUD().setStyle(KProgressHUD.Style.PIE_DETERMINATE);
            getProgressHUD().setProgress(i);
        } else {
            getProgressHUD().setStyle(KProgressHUD.Style.SPIN_INDETERMINATE);
        }
        getProgressHUD().setDetailsLabel(str);
    }

    private final void showError(String str) {
        hideDialog();
        StyledAlertDialog.INSTANCE.builder(this.context).setTitle((CharSequence) "Error").setMessage((CharSequence) str).setPositiveButton((CharSequence) Payload.RESPONSE_OK, (DialogInterface.OnClickListener) null).show();
    }
}
