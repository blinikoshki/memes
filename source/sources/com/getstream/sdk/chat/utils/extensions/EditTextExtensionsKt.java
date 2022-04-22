package com.getstream.sdk.chat.utils.extensions;

import android.widget.EditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0007¨\u0006\u0004"}, mo26107d2 = {"focusAndShowKeyboard", "", "Landroid/widget/EditText;", "showKeyboardIfFocused", "stream-chat-android-ui-common_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: EditTextExtensions.kt */
public final class EditTextExtensionsKt {
    @InternalStreamChatApi
    public static final void showKeyboardIfFocused(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "$this$showKeyboardIfFocused");
        if (editText.isFocused()) {
            editText.post(new EditTextExtensionsKt$showKeyboardIfFocused$1(editText));
        }
    }

    @InternalStreamChatApi
    public static final void focusAndShowKeyboard(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "$this$focusAndShowKeyboard");
        editText.requestFocus();
        if (editText.hasWindowFocus()) {
            showKeyboardIfFocused(editText);
        } else {
            editText.getViewTreeObserver().addOnWindowFocusChangeListener(new EditTextExtensionsKt$focusAndShowKeyboard$1(editText));
        }
    }
}
