package editor.common.sheetfooter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.memes.editor.databinding.NFooterCloseOnlyBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0014\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, mo26107d2 = {"Leditor/common/sheetfooter/CloseOnlyFooter;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/memes/editor/databinding/NFooterCloseOnlyBinding;", "getBinding", "()Lcom/memes/editor/databinding/NFooterCloseOnlyBinding;", "binding$delegate", "Lkotlin/Lazy;", "onFinishInflate", "", "setOnCloseButtonClickListener", "listener", "Lkotlin/Function0;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CloseOnlyFooter.kt */
public final class CloseOnlyFooter extends FrameLayout {
    private final Lazy binding$delegate;

    private final NFooterCloseOnlyBinding getBinding() {
        return (NFooterCloseOnlyBinding) this.binding$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CloseOnlyFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding$delegate = LazyKt.lazy(new CloseOnlyFooter$binding$2(this, context));
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        getBinding();
        super.onFinishInflate();
    }

    public final void setOnCloseButtonClickListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        getBinding().closeView.setOnClickListener(new CloseOnlyFooter$setOnCloseButtonClickListener$1(function0));
    }
}
