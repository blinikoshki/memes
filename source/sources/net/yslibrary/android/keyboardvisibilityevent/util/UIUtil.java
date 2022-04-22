package net.yslibrary.android.keyboardvisibilityevent.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public final class UIUtil {
    private UIUtil() {
        throw new AssertionError();
    }

    public static void showKeyboard(Context context, EditText editText) {
        if (context != null && editText != null) {
            getInputMethodManager(context).showSoftInput(editText, 1);
        }
    }

    public static void showKeyboardInDialog(Dialog dialog, EditText editText) {
        if (dialog != null && editText != null) {
            dialog.getWindow().setSoftInputMode(4);
            editText.requestFocus();
        }
    }

    public static void hideKeyboard(Context context, View view) {
        if (context != null && view != null) {
            getInputMethodManager(context).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void hideKeyboard(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        if (decorView != null) {
            hideKeyboard(activity, decorView);
        }
    }

    private static InputMethodManager getInputMethodManager(Context context) {
        return (InputMethodManager) context.getSystemService("input_method");
    }
}
