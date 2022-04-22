package com.memes.commons.enhancedtext.autofit;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.memes.commons.util.SoftKeyboardUtil;
import org.apache.commons.lang3.StringUtils;

public class AutoFitEditTextUtil {
    public static void setNormalization(View view, AutoFitEditText autoFitEditText) {
        if (!(view instanceof AutoFitEditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return AutoFitEditTextUtil.lambda$setNormalization$0(AutoFitEditText.this, view, motionEvent);
                }
            });
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i < viewGroup.getChildCount()) {
                    setNormalization(viewGroup.getChildAt(i), autoFitEditText);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    static /* synthetic */ boolean lambda$setNormalization$0(AutoFitEditText autoFitEditText, View view, MotionEvent motionEvent) {
        SoftKeyboardUtil.INSTANCE.hideKeyboard((EditText) autoFitEditText);
        if (autoFitEditText.get_minTextSize() == null || autoFitEditText.getTextSize() >= autoFitEditText.get_minTextSize().floatValue()) {
            return false;
        }
        autoFitEditText.setText(autoFitEditText.getText().toString().replace(StringUtils.f466LF, ""));
        return false;
    }
}
