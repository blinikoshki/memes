package editor.core;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import editor.custom.blockingprogressdialog.BlockingProgressDialog;
import editor.custom.blockingprogressdialog.BlockingProgressState;
import editor.custom.liveevent.LiveEventObserver;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0014J!\u0010\f\u001a\u00020\u000b2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, mo26107d2 = {"Leditor/core/NicoActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Leditor/core/NActivityHandle;", "()V", "blockingProgressDialog", "Leditor/custom/blockingprogressdialog/BlockingProgressDialog;", "getBlockingProgressDialog", "()Leditor/custom/blockingprogressdialog/BlockingProgressDialog;", "blockingProgressDialog$delegate", "Lkotlin/Lazy;", "onDestroy", "", "registerViewModel", "viewModels", "", "Leditor/core/NicoViewModel;", "([Leditor/core/NicoViewModel;)V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NicoActivity.kt */
public class NicoActivity extends AppCompatActivity implements NActivityHandle {
    private final Lazy blockingProgressDialog$delegate = LazyKt.lazy(new NicoActivity$blockingProgressDialog$2(this));

    /* access modifiers changed from: private */
    public final BlockingProgressDialog getBlockingProgressDialog() {
        return (BlockingProgressDialog) this.blockingProgressDialog$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        getBlockingProgressDialog().apply(BlockingProgressState.Hidden.INSTANCE);
        super.onDestroy();
    }

    public void registerViewModel(NicoViewModel... nicoViewModelArr) {
        Intrinsics.checkNotNullParameter(nicoViewModelArr, "viewModels");
        for (NicoViewModel nicoViewModel : nicoViewModelArr) {
            LifecycleOwner lifecycleOwner = this;
            nicoViewModel.onShowToast().observe(lifecycleOwner, new LiveEventObserver(new NicoActivity$registerViewModel$1(this)));
            nicoViewModel.onShowToastResource().observe(lifecycleOwner, new LiveEventObserver(new NicoActivity$registerViewModel$2(this)));
            nicoViewModel.onBlockingProgressStateChanged().observe(lifecycleOwner, new LiveEventObserver(new NicoActivity$registerViewModel$3(this)));
        }
    }
}
