package com.memes.commons.p039ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.memes.commons.C4144R;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\u00142\b\b\u0001\u0010\"\u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u001cH\u0002R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR#\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\u000f0\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011¨\u0006'"}, mo26107d2 = {"Lcom/memes/commons/ui/IconTextHorizontalButton;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "iconView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIconView", "()Landroid/widget/ImageView;", "iconView$delegate", "Lkotlin/Lazy;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView$delegate", "setAutoSizeTextEnabled", "", "enabled", "", "setIcon", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "setIconSize", "iconSize", "", "setIconTextGap", "gapSize", "setIconTintColor", "iconTintColor", "setText", "textRes", "text", "", "setTextAppearance", "textAppearance", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.commons.ui.IconTextHorizontalButton */
/* compiled from: IconTextHorizontalButton.kt */
public final class IconTextHorizontalButton extends LinearLayout {
    private final Lazy iconView$delegate;
    private final Lazy textView$delegate;

    private final ImageView getIconView() {
        return (ImageView) this.iconView$delegate.getValue();
    }

    private final TextView getTextView() {
        return (TextView) this.textView$delegate.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IconTextHorizontalButton(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconTextHorizontalButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.iconView$delegate = LazyKt.lazy(new IconTextHorizontalButton$iconView$2(this));
        this.textView$delegate = LazyKt.lazy(new IconTextHorizontalButton$textView$2(this));
        setGravity(17);
        LinearLayout.inflate(context, C4144R.C4150layout.icon_text_horizontal_button, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4144R.styleable.IconTextHorizontalButton, 0, 0);
        try {
            String string = obtainStyledAttributes.getString(C4144R.styleable.IconTextHorizontalButton_ithb_Text);
            if (string == null) {
                string = "Button";
            }
            setText(string);
            int resourceId = obtainStyledAttributes.getResourceId(C4144R.styleable.IconTextHorizontalButton_ithb_TextAppearance, 0);
            if (resourceId != 0) {
                setTextAppearance(resourceId);
            }
            setAutoSizeTextEnabled(obtainStyledAttributes.getBoolean(C4144R.styleable.IconTextHorizontalButton_ithb_TextSizeAuto, false));
            Drawable drawable = obtainStyledAttributes.getDrawable(C4144R.styleable.IconTextHorizontalButton_ithb_Icon);
            if (drawable != null) {
                setIcon(drawable);
            }
            int color = obtainStyledAttributes.getColor(C4144R.styleable.IconTextHorizontalButton_ithb_IconTint, 0);
            if (color != 0) {
                setIconTintColor(color);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C4144R.styleable.IconTextHorizontalButton_ithb_IconSize, 0);
            if (dimensionPixelSize != 0) {
                setIconSize(dimensionPixelSize);
            }
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(C4144R.styleable.IconTextHorizontalButton_ithb_IconTextGap, 0);
            if (dimensionPixelSize2 != 0) {
                setIconTextGap(dimensionPixelSize2);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextView textView = getTextView();
        Intrinsics.checkNotNullExpressionValue(textView, "textView");
        textView.setText(str);
    }

    public final void setText(int i) {
        getTextView().setText(i);
    }

    private final void setTextAppearance(int i) {
        TextViewCompat.setTextAppearance(getTextView(), i);
    }

    private final void setAutoSizeTextEnabled(boolean z) {
        if (z) {
            TextViewCompat.setAutoSizeTextTypeWithDefaults(getTextView(), 1);
        } else {
            TextViewCompat.setAutoSizeTextTypeWithDefaults(getTextView(), 0);
        }
    }

    private final void setIcon(Drawable drawable) {
        getIconView().setImageDrawable(drawable);
    }

    private final void setIconTintColor(int i) {
        ImageView iconView = getIconView();
        Intrinsics.checkNotNullExpressionValue(iconView, "iconView");
        iconView.setImageTintList(ColorStateList.valueOf(i));
    }

    private final void setIconSize(int i) {
        ImageView iconView = getIconView();
        Intrinsics.checkNotNullExpressionValue(iconView, "iconView");
        View view = iconView;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
        layoutParams3.width = i;
        layoutParams3.height = i;
        view.setLayoutParams(layoutParams2);
    }

    private final void setIconTextGap(int i) {
        TextView textView = getTextView();
        Intrinsics.checkNotNullExpressionValue(textView, "textView");
        View view = textView;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        ((LinearLayout.LayoutParams) layoutParams2).setMargins(i, 0, 0, 0);
        view.setLayoutParams(layoutParams2);
    }
}
