package com.getstream.sdk.chat.utils.extensions;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditTextExtensions.kt */
final class EditTextExtensionsKt$showKeyboardIfFocused$1 implements Runnable {
    final /* synthetic */ EditText $this_showKeyboardIfFocused;

    EditTextExtensionsKt$showKeyboardIfFocused$1(EditText editText) {
        this.$this_showKeyboardIfFocused = editText;
    }

    public final void run() {
        Object systemService = this.$this_showKeyboardIfFocused.getContext().getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(this.$this_showKeyboardIfFocused, 1);
    }
}
