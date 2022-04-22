package editor.custom;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import com.memes.commons.outlineprovider.ViewCornerOutlineProvider;
import com.memes.commons.outlineprovider.ViewCornerOutlineProviderKt;
import com.memes.editor.C4175R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\fJ\b\u0010\u0011\u001a\u00020\u000fH\u0014J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\fJ\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0006\u0010\u0016\u001a\u00020\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo26107d2 = {"Leditor/custom/ItemSelectorView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cornerRadius", "", "highlightColorTint", "Landroid/content/res/ColorStateList;", "highlighted", "", "normalColorTint", "highlight", "", "isHighlighted", "onFinishInflate", "setHighlighted", "shouldHighlight", "setSelected", "selected", "unhighlight", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ItemSelectorView.kt */
public final class ItemSelectorView extends FrameLayout {
    private float cornerRadius = ((float) getResources().getDimensionPixelSize(C4175R.dimen._2sdp));
    private ColorStateList highlightColorTint;
    private boolean highlighted;
    private ColorStateList normalColorTint;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemSelectorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ColorStateList valueOf = ColorStateList.valueOf(-1);
        Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(Color.WHITE)");
        this.normalColorTint = valueOf;
        ColorStateList valueOf2 = ColorStateList.valueOf(SupportMenu.CATEGORY_MASK);
        Intrinsics.checkNotNullExpressionValue(valueOf2, "ColorStateList.valueOf(Color.RED)");
        this.highlightColorTint = valueOf2;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4175R.styleable.ItemSelectorView, 0, 0);
            try {
                ColorStateList valueOf3 = ColorStateList.valueOf(obtainStyledAttributes.getColor(C4175R.styleable.ItemSelectorView_isv_normalTint, this.normalColorTint.getDefaultColor()));
                Intrinsics.checkNotNullExpressionValue(valueOf3, "ColorStateList.valueOf(normalColor)");
                this.normalColorTint = valueOf3;
                ColorStateList valueOf4 = ColorStateList.valueOf(obtainStyledAttributes.getColor(C4175R.styleable.ItemSelectorView_isv_highlightTint, this.highlightColorTint.getDefaultColor()));
                Intrinsics.checkNotNullExpressionValue(valueOf4, "ColorStateList.valueOf(highlightColor)");
                this.highlightColorTint = valueOf4;
                this.cornerRadius = obtainStyledAttributes.getDimension(C4175R.styleable.ItemSelectorView_isv_cornerRadius, this.cornerRadius);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        float dimensionPixelSize = (float) getResources().getDimensionPixelSize(C4175R.dimen._2sdp);
        ViewCornerOutlineProviderKt.roundCorners$default((View) this, dimensionPixelSize, (ViewCornerOutlineProvider.CornerType) null, 2, (Object) null);
        View childAt = getChildAt(0);
        if (childAt != null) {
            ViewCornerOutlineProviderKt.roundCorners$default(childAt, dimensionPixelSize, (ViewCornerOutlineProvider.CornerType) null, 2, (Object) null);
        }
        setHighlighted(isHighlighted());
    }

    public final boolean isHighlighted() {
        return this.highlighted;
    }

    public final void setHighlighted(boolean z) {
        if (z) {
            highlight();
        } else {
            unhighlight();
        }
    }

    public final void highlight() {
        setBackground(ContextCompat.getDrawable(getContext(), C4175R.C4178drawable.n_filter_item_rounded_ripple));
        setBackgroundTintList(this.highlightColorTint);
        this.highlighted = true;
    }

    public final void unhighlight() {
        setBackground(ContextCompat.getDrawable(getContext(), C4175R.C4178drawable.n_filter_item_rounded_ripple));
        setBackgroundTintList(this.normalColorTint);
        this.highlighted = false;
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        setHighlighted(z);
    }
}
