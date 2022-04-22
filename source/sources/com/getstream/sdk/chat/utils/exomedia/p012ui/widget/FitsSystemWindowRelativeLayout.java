package com.getstream.sdk.chat.utils.exomedia.p012ui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.RelativeLayout;

/* renamed from: com.getstream.sdk.chat.utils.exomedia.ui.widget.FitsSystemWindowRelativeLayout */
public class FitsSystemWindowRelativeLayout extends RelativeLayout {
    private Rect originalPadding;

    public FitsSystemWindowRelativeLayout(Context context) {
        super(context);
        setup();
    }

    public FitsSystemWindowRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setup();
    }

    public FitsSystemWindowRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setup();
    }

    public FitsSystemWindowRelativeLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setup();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (navBarCanMove()) {
            setup();
        }
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        updatePadding(rect);
        return false;
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        fitSystemWindows(new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()));
        return windowInsets;
    }

    private void setup() {
        if (Build.VERSION.SDK_INT >= 14) {
            setFitsSystemWindows(true);
        }
        if (this.originalPadding == null) {
            this.originalPadding = new Rect(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        updatePadding(new Rect());
    }

    private void updatePadding(Rect rect) {
        setPadding(this.originalPadding.left + rect.left, this.originalPadding.top + rect.top, this.originalPadding.right + rect.right, this.originalPadding.bottom + rect.bottom);
    }

    private boolean navBarCanMove() {
        return getResources().getConfiguration().smallestScreenWidthDp <= 600;
    }
}
