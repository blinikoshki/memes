package com.memes.plus.util;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.memes.plus.C4199R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u0019\u001a\u00020\tR\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo26107d2 = {"Lcom/memes/plus/util/MultiStateButton;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "<set-?>", "", "isOn", "()Z", "mDisabledColor", "", "mOffDrawable", "Landroid/graphics/drawable/Drawable;", "mOnDrawable", "mPressedColor", "init", "", "offDrawable", "pressedColor", "setEnabled", "enabled", "setState", "toggleState", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MultiStateButton.kt */
public final class MultiStateButton extends AppCompatImageView {
    private boolean isOn;
    private int mDisabledColor;
    private Drawable mOffDrawable;
    private Drawable mOnDrawable;
    /* access modifiers changed from: private */
    public int mPressedColor;

    public final boolean isOn() {
        return this.isOn;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiStateButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 23) {
            this.mDisabledColor = context.getResources().getColor(C4199R.C4201color.multiStateButtonDisabled, (Resources.Theme) null);
        } else {
            this.mDisabledColor = context.getResources().getColor(C4199R.C4201color.multiStateButtonDisabled);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C4199R.styleable.MultiStateButton, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyl…           0, 0\n        )");
        try {
            boolean z = obtainStyledAttributes.getBoolean(0, true);
            Drawable drawable = obtainStyledAttributes.getDrawable(1);
            if (Build.VERSION.SDK_INT >= 23) {
                i = obtainStyledAttributes.getColor(2, context.getResources().getColor(C4199R.C4201color.multiStateButtonPressed, (Resources.Theme) null));
            } else {
                i = obtainStyledAttributes.getColor(2, context.getResources().getColor(C4199R.C4201color.multiStateButtonPressed));
            }
            init(z, drawable, i);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiStateButton(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(this.isOn, (Drawable) null, this.mPressedColor);
    }

    private final void init(boolean z, Drawable drawable, int i) {
        Drawable drawable2 = getDrawable();
        this.mOnDrawable = drawable2;
        if (drawable == null) {
            drawable = drawable2;
        }
        this.mOffDrawable = drawable;
        this.mPressedColor = i;
        setOnTouchListener(new MultiStateButton$init$1(this));
        setState(z);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setClickable(z);
        if (z) {
            getDrawable().clearColorFilter();
        } else {
            getDrawable().setColorFilter(this.mDisabledColor, PorterDuff.Mode.SRC_IN);
        }
        invalidate();
        requestLayout();
    }

    public final void setState(boolean z) {
        this.isOn = z;
        setImageDrawable(z ? this.mOnDrawable : this.mOffDrawable);
        if (isEnabled()) {
            getDrawable().clearColorFilter();
        } else {
            getDrawable().setColorFilter(this.mDisabledColor, PorterDuff.Mode.SRC_IN);
        }
        invalidate();
        requestLayout();
    }

    public final boolean toggleState() {
        setState(!this.isOn);
        return this.isOn;
    }
}
