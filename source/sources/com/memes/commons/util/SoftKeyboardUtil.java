package com.memes.commons.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/commons/util/SoftKeyboardUtil;", "", "()V", "getInputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "context", "Landroid/content/Context;", "hideKeyboard", "", "activity", "Landroid/app/Activity;", "editText", "Landroid/widget/EditText;", "showKeyboard", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SoftKeyboardUtil.kt */
public final class SoftKeyboardUtil {
    public static final SoftKeyboardUtil INSTANCE = new SoftKeyboardUtil();

    private SoftKeyboardUtil() {
    }

    /* access modifiers changed from: private */
    public final InputMethodManager getInputMethodManager(Context context) {
        return (InputMethodManager) context.getSystemService("input_method");
    }

    public final void showKeyboard(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        editText.postDelayed(new SoftKeyboardUtil$showKeyboard$1(editText), 100);
    }

    public final void hideKeyboard(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        Context context = editText.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "editText.context");
        InputMethodManager inputMethodManager = getInputMethodManager(context);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    public final void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager;
        if (activity != null && (inputMethodManager = getInputMethodManager(activity)) != null) {
            View currentFocus = activity.getCurrentFocus();
            inputMethodManager.hideSoftInputFromWindow(currentFocus != null ? currentFocus.getWindowToken() : null, 0);
        }
    }
}
