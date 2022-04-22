package com.memes.commons.enhancedtext.socialtext;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

abstract class TouchableSpan extends ClickableSpan {
    private final int normalTextColor;
    private boolean pressed;
    private final int pressedTextColor;
    private final boolean underlineEnabled;

    public TouchableSpan(int i, int i2, boolean z) {
        this.normalTextColor = i;
        this.pressedTextColor = i2;
        this.underlineEnabled = z;
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.pressed ? this.pressedTextColor : this.normalTextColor);
        textPaint.setUnderlineText(this.underlineEnabled);
        textPaint.bgColor = 0;
    }

    /* access modifiers changed from: package-private */
    public void setPressed(boolean z) {
        this.pressed = z;
    }
}
