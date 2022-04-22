package editor.common.sheetheader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.memes.editor.databinding.NHeaderTitleResetBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\b\b\u0001\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bR\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR#\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, mo26107d2 = {"Leditor/common/sheetheader/TitleWithResetHeader;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/memes/editor/databinding/NHeaderTitleResetBinding;", "getBinding", "()Lcom/memes/editor/databinding/NHeaderTitleResetBinding;", "binding$delegate", "Lkotlin/Lazy;", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "setOnResetButtonClickListener", "", "listener", "Lkotlin/Function0;", "setTitle", "titleRes", "", "title", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TitleWithResetHeader.kt */
public final class TitleWithResetHeader extends FrameLayout {
    private final Lazy binding$delegate = LazyKt.lazy(new TitleWithResetHeader$binding$2(this));
    private final Lazy layoutInflater$delegate;

    private final NHeaderTitleResetBinding getBinding() {
        return (NHeaderTitleResetBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TitleWithResetHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.layoutInflater$delegate = LazyKt.lazy(new TitleWithResetHeader$layoutInflater$2(context));
        getBinding();
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextView textView = getBinding().titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(str);
    }

    public final void setTitle(int i) {
        getBinding().titleView.setText(i);
    }

    public final void setOnResetButtonClickListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        getBinding().resetView.setOnClickListener(new TitleWithResetHeader$setOnResetButtonClickListener$1(function0));
    }
}
