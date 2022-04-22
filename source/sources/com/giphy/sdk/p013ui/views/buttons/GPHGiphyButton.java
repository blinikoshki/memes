package com.giphy.sdk.p013ui.views.buttons;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageButton;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0012\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u0011\u001a\u00020\u0012H\u0003¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/buttons/GPHGiphyButton;", "Landroidx/appcompat/widget/AppCompatImageButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultCornerRadius", "value", "Lcom/giphy/sdk/ui/views/buttons/GPHGiphyButtonStyle;", "style", "getStyle", "()Lcom/giphy/sdk/ui/views/buttons/GPHGiphyButtonStyle;", "setStyle", "(Lcom/giphy/sdk/ui/views/buttons/GPHGiphyButtonStyle;)V", "roundCornersProvider", "com/giphy/sdk/ui/views/buttons/GPHGiphyButton$roundCornersProvider$1", "()Lcom/giphy/sdk/ui/views/buttons/GPHGiphyButton$roundCornersProvider$1;", "styleButton", "", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.buttons.GPHGiphyButton */
/* compiled from: GPHGiphyButton.kt */
public final class GPHGiphyButton extends AppCompatImageButton {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public int defaultCornerRadius;
    private GPHGiphyButtonStyle style;

    public GPHGiphyButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GPHGiphyButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GPHGiphyButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public GPHGiphyButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.defaultCornerRadius = 6;
        this.style = GPHGiphyButtonStyle.Companion.getDefaultSetting();
        styleButton();
    }

    public final GPHGiphyButtonStyle getStyle() {
        return this.style;
    }

    public final void setStyle(GPHGiphyButtonStyle gPHGiphyButtonStyle) {
        Intrinsics.checkParameterIsNotNull(gPHGiphyButtonStyle, "value");
        this.style = gPHGiphyButtonStyle;
        styleButton();
    }

    private final void styleButton() {
        Timber.m300d("styleButton", new Object[0]);
        setImageResource(this.style.getImage$ui_sdk_release());
        setBackgroundColor(this.style.getBackgroundColor$ui_sdk_release());
        setColorFilter(this.style.getTintColor$ui_sdk_release());
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(roundCornersProvider());
        }
    }

    private final GPHGiphyButton$roundCornersProvider$1 roundCornersProvider() {
        return new GPHGiphyButton$roundCornersProvider$1(this);
    }
}
