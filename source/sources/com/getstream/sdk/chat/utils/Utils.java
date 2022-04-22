package com.getstream.sdk.chat.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.widget.TextView;
import java.io.File;
import java.util.Locale;

public class Utils {
    public static final Locale locale = new Locale("en", "US", "POSIX");

    public static boolean isSVGImage(String str) {
        return TextUtils.isEmpty(str) || str.contains("random_svg");
    }

    public static String getApplicationName(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.labelRes;
        return i == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i);
    }

    public static void showSoftKeyboard(Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (!inputMethodManager.isAcceptingText()) {
            inputMethodManager.toggleSoftInput(2, 0);
        }
    }

    public static void hideSoftKeyboard(Context context) {
        View currentFocus = context instanceof Activity ? ((Activity) context).getCurrentFocus() : null;
        if (currentFocus == null) {
            currentFocus = new View(context);
        }
        hideSoftKeyboard(currentFocus);
    }

    public static void showSoftKeyboard(View view) {
        showSoftKeyboard(view.getContext());
    }

    public static void hideSoftKeyboard(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static int dpToPx(int i) {
        return (int) (((float) i) * Resources.getSystem().getDisplayMetrics().density);
    }

    public static String getMimeType(File file) {
        return getMimeType(file.getPath());
    }

    public static String getMimeType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        return fileExtensionFromUrl != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl) : "";
    }

    public static abstract class TextViewLinkHandler extends LinkMovementMethod {
        public abstract void onLinkClick(String str);

        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1) {
                return super.onTouchEvent(textView, spannable, motionEvent);
            }
            int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x + textView.getScrollX();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(y + textView.getScrollY()), (float) scrollX);
            URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, URLSpan.class);
            if (uRLSpanArr.length != 0) {
                onLinkClick(uRLSpanArr[0].getURL());
            }
            return true;
        }
    }
}
