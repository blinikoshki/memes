package com.memes.plus.p040ui.auth.auth_prompt;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/auth_prompt/MagicalClickableSpan;", "Landroid/text/style/ClickableSpan;", "()V", "updateDrawState", "", "paint", "Landroid/text/TextPaint;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.auth_prompt.MagicalClickableSpan */
/* compiled from: MagicalClickableSpan.kt */
public abstract class MagicalClickableSpan extends ClickableSpan {
    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "paint");
    }
}
