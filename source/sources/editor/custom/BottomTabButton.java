package editor.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NBottomTabButtonBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0014R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R#\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo26107d2 = {"Leditor/custom/BottomTabButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/memes/editor/databinding/NBottomTabButtonBinding;", "getBinding", "()Lcom/memes/editor/databinding/NBottomTabButtonBinding;", "binding$delegate", "Lkotlin/Lazy;", "icon", "Landroid/graphics/drawable/Drawable;", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "text", "", "onFinishInflate", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BottomTabButton.kt */
public final class BottomTabButton extends FrameLayout {
    private final Lazy binding$delegate = LazyKt.lazy(new BottomTabButton$binding$2(this));
    private Drawable icon;
    private final Lazy layoutInflater$delegate;
    private String text;

    private final NBottomTabButtonBinding getBinding() {
        return (NBottomTabButtonBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomTabButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.layoutInflater$delegate = LazyKt.lazy(new BottomTabButton$layoutInflater$2(context));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4175R.styleable.BottomTabButton, 0, 0);
            try {
                this.text = obtainStyledAttributes.getString(C4175R.styleable.BottomTabButton_btb_text);
                this.icon = obtainStyledAttributes.getDrawable(C4175R.styleable.BottomTabButton_btb_icon);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        getBinding();
        super.onFinishInflate();
        TextView textView = getBinding().textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        textView.setText(this.text);
        getBinding().iconImageView.setImageDrawable(this.icon);
    }
}
