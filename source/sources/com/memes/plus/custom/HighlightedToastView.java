package com.memes.plus.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.memes.plus.databinding.HighlightedToastViewBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010\u0010\u001a\u00020\u000e2\b\b\u0001\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo26107d2 = {"Lcom/memes/plus/custom/HighlightedToastView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/memes/plus/databinding/HighlightedToastViewBinding;", "getBinding", "()Lcom/memes/plus/databinding/HighlightedToastViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "dismiss", "", "onFinishInflate", "show", "textRes", "", "text", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: HighlightedToastView.kt */
public final class HighlightedToastView extends FrameLayout {
    private final Lazy binding$delegate;

    private final HighlightedToastViewBinding getBinding() {
        return (HighlightedToastViewBinding) this.binding$delegate.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HighlightedToastView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HighlightedToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding$delegate = LazyKt.lazy(new HighlightedToastView$binding$2(this, context));
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        getBinding();
        super.onFinishInflate();
        getBinding().content.setOnClickListener(new HighlightedToastView$onFinishInflate$1(this));
    }

    public final void show(int i) {
        String string = getContext().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(textRes)");
        show(string);
    }

    public final void show(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextView textView = getBinding().textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        textView.setText(str);
        setVisibility(0);
    }

    public final void dismiss() {
        TextView textView = getBinding().textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        textView.setText("");
        setVisibility(8);
    }
}
