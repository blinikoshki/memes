package com.memes.commons.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, mo26107d2 = {"Lcom/memes/commons/util/ClipboardUtil;", "", "()V", "copy", "", "context", "Landroid/content/Context;", "text", "", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ClipboardUtil.kt */
public final class ClipboardUtil {
    public static final ClipboardUtil INSTANCE = new ClipboardUtil();

    private ClipboardUtil() {
    }

    public final boolean copy(Context context, String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return false;
        }
        ClipData newPlainText = ClipData.newPlainText("Text", charSequence);
        ClipboardManager clipboardManager = (ClipboardManager) (context != null ? context.getSystemService("clipboard") : null);
        if (clipboardManager == null) {
            return false;
        }
        clipboardManager.setPrimaryClip(newPlainText);
        return true;
    }
}
