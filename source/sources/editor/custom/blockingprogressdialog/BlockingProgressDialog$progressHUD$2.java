package editor.custom.blockingprogressdialog;

import com.kaopiz.kprogresshud.KProgressHUD;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "Lcom/kaopiz/kprogresshud/KProgressHUD;", "kotlin.jvm.PlatformType", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: BlockingProgressDialog.kt */
final class BlockingProgressDialog$progressHUD$2 extends Lambda implements Function0<KProgressHUD> {
    final /* synthetic */ BlockingProgressDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BlockingProgressDialog$progressHUD$2(BlockingProgressDialog blockingProgressDialog) {
        super(0);
        this.this$0 = blockingProgressDialog;
    }

    public final KProgressHUD invoke() {
        return KProgressHUD.create(this.this$0.context).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setCancellable(false).setAnimationSpeed(2).setAutoDismiss(false).setDimAmount(0.5f);
    }
}
