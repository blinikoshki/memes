package com.memes.commons.enhancedtext.socialtext;

import android.graphics.RectF;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;

class AccurateMovementMethod extends LinkMovementMethod {
    private static AccurateMovementMethod instance;
    private TouchableSpan pressedSpan;
    private final RectF touchBounds = new RectF();

    AccurateMovementMethod() {
    }

    public static synchronized AccurateMovementMethod getInstance() {
        AccurateMovementMethod accurateMovementMethod;
        synchronized (AccurateMovementMethod.class) {
            if (instance == null) {
                instance = new AccurateMovementMethod();
            }
            accurateMovementMethod = instance;
        }
        return accurateMovementMethod;
    }

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            TouchableSpan touchedSpan = getTouchedSpan(textView, spannable, motionEvent);
            this.pressedSpan = touchedSpan;
            if (touchedSpan != null) {
                touchedSpan.setPressed(true);
                Selection.setSelection(spannable, spannable.getSpanStart(this.pressedSpan), spannable.getSpanEnd(this.pressedSpan));
            }
        } else if (action != 2) {
            TouchableSpan touchableSpan = this.pressedSpan;
            if (touchableSpan != null) {
                touchableSpan.setPressed(false);
                super.onTouchEvent(textView, spannable, motionEvent);
            }
            this.pressedSpan = null;
            Selection.removeSelection(spannable);
        } else {
            TouchableSpan touchedSpan2 = getTouchedSpan(textView, spannable, motionEvent);
            TouchableSpan touchableSpan2 = this.pressedSpan;
            if (!(touchableSpan2 == null || touchedSpan2 == touchableSpan2)) {
                touchableSpan2.setPressed(false);
                this.pressedSpan = null;
                Selection.removeSelection(spannable);
            }
        }
        return true;
    }

    private TouchableSpan getTouchedSpan(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
        int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
        int scrollX = x + textView.getScrollX();
        int scrollY = y + textView.getScrollY();
        Layout layout = textView.getLayout();
        int lineForVertical = layout.getLineForVertical(scrollY);
        float f = (float) scrollX;
        int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f);
        this.touchBounds.left = layout.getLineLeft(lineForVertical);
        this.touchBounds.top = (float) layout.getLineTop(lineForVertical);
        this.touchBounds.right = layout.getLineRight(lineForVertical);
        this.touchBounds.bottom = (float) layout.getLineBottom(lineForVertical);
        if (!this.touchBounds.contains(f, (float) scrollY)) {
            return null;
        }
        TouchableSpan[] touchableSpanArr = (TouchableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, TouchableSpan.class);
        if (touchableSpanArr.length > 0) {
            return touchableSpanArr[0];
        }
        return null;
    }
}
