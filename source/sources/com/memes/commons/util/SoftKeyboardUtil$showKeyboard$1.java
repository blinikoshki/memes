package com.memes.commons.util;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: SoftKeyboardUtil.kt */
final class SoftKeyboardUtil$showKeyboard$1 implements Runnable {
    final /* synthetic */ EditText $editText;

    SoftKeyboardUtil$showKeyboard$1(EditText editText) {
        this.$editText = editText;
    }

    public final void run() {
        this.$editText.requestFocus();
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        Context context = this.$editText.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "editText.context");
        InputMethodManager access$getInputMethodManager = softKeyboardUtil.getInputMethodManager(context);
        if (access$getInputMethodManager != null) {
            access$getInputMethodManager.showSoftInput(this.$editText, 1);
        }
    }
}
