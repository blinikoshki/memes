package com.getstream.sdk.chat.utils.extensions;

import android.view.ViewTreeObserver;
import android.widget.EditText;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo26107d2 = {"com/getstream/sdk/chat/utils/extensions/EditTextExtensionsKt$focusAndShowKeyboard$1", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "onWindowFocusChanged", "", "hasFocus", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditTextExtensions.kt */
public final class EditTextExtensionsKt$focusAndShowKeyboard$1 implements ViewTreeObserver.OnWindowFocusChangeListener {
    final /* synthetic */ EditText $this_focusAndShowKeyboard;

    EditTextExtensionsKt$focusAndShowKeyboard$1(EditText editText) {
        this.$this_focusAndShowKeyboard = editText;
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            EditTextExtensionsKt.showKeyboardIfFocused(this.$this_focusAndShowKeyboard);
            this.$this_focusAndShowKeyboard.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
        }
    }
}
