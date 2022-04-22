package editor.custom.optionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NSmallOptionButtonBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u001a2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u001b\u001a\u00020\u001a2\b\b\u0001\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010\u001e\u001a\u00020\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0 J\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0016H\u0016J\u0010\u0010$\u001a\u00020\u001a2\b\b\u0001\u0010%\u001a\u00020\u001dJ\u0010\u0010$\u001a\u00020\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0006\u0010&\u001a\u00020\u001aR\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R#\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, mo26107d2 = {"Leditor/custom/optionbutton/SmallOptionButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/memes/editor/databinding/NSmallOptionButtonBinding;", "getBinding", "()Lcom/memes/editor/databinding/NSmallOptionButtonBinding;", "binding$delegate", "Lkotlin/Lazy;", "icon", "Landroid/graphics/drawable/Drawable;", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "selectable", "", "title", "", "onFinishInflate", "", "setIcon", "iconRes", "", "setOnOptionButtonClickListener", "listener", "Lkotlin/Function0;", "setSelectable", "setSelected", "selected", "setTitle", "titleRes", "toggleSelection", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SmallOptionButton.kt */
public final class SmallOptionButton extends FrameLayout {
    private final Lazy binding$delegate = LazyKt.lazy(new SmallOptionButton$binding$2(this));
    private Drawable icon;
    private final Lazy layoutInflater$delegate;
    private boolean selectable;
    private String title;

    private final NSmallOptionButtonBinding getBinding() {
        return (NSmallOptionButtonBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmallOptionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.layoutInflater$delegate = LazyKt.lazy(new SmallOptionButton$layoutInflater$2(context));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4175R.styleable.SmallOptionButton, 0, 0);
            try {
                String string = obtainStyledAttributes.getString(C4175R.styleable.SmallOptionButton_sob_title);
                if (string == null) {
                    string = this.title;
                }
                this.title = string;
                Drawable drawable = obtainStyledAttributes.getDrawable(C4175R.styleable.SmallOptionButton_sob_icon);
                if (drawable == null) {
                    drawable = this.icon;
                }
                this.icon = drawable;
                this.selectable = obtainStyledAttributes.getBoolean(C4175R.styleable.SmallOptionButton_sob_selectable, this.selectable);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        getBinding();
        super.onFinishInflate();
        setTitle(this.title);
        setIcon(this.icon);
    }

    public final void setTitle(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            TextView textView = getBinding().optionTitleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.optionTitleView");
            textView.setVisibility(4);
        }
        TextView textView2 = getBinding().optionTitleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.optionTitleView");
        textView2.setText(charSequence);
        TextView textView3 = getBinding().optionTitleView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.optionTitleView");
        textView3.setVisibility(0);
    }

    public final void setTitle(int i) {
        getBinding().optionTitleView.setText(i);
    }

    public final void setIcon(int i) {
        getBinding().optionIconView.setImageResource(i);
    }

    public final void setIcon(Drawable drawable) {
        getBinding().optionIconView.setImageDrawable(drawable);
    }

    public final void setSelectable(boolean z) {
        this.selectable = z;
    }

    public void setSelected(boolean z) {
        if (this.selectable) {
            AppCompatImageView appCompatImageView = getBinding().optionIconView;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.optionIconView");
            appCompatImageView.setSelected(z);
            TextView textView = getBinding().optionTitleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.optionTitleView");
            textView.setSelected(z);
            return;
        }
        super.setSelected(z);
    }

    public final void toggleSelection() {
        if (this.selectable) {
            AppCompatImageView appCompatImageView = getBinding().optionIconView;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.optionIconView");
            AppCompatImageView appCompatImageView2 = getBinding().optionIconView;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "binding.optionIconView");
            appCompatImageView.setSelected(!appCompatImageView2.isSelected());
            TextView textView = getBinding().optionTitleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.optionTitleView");
            TextView textView2 = getBinding().optionTitleView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.optionTitleView");
            textView.setSelected(!textView2.isSelected());
        }
    }

    public final void setOnOptionButtonClickListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        getBinding().optionIconView.setOnClickListener(new SmallOptionButton$setOnOptionButtonClickListener$1(function0));
    }
}
