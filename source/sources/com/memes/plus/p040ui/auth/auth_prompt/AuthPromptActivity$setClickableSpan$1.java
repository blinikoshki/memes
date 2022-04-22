package com.memes.plus.p040ui.auth.auth_prompt;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo26107d2 = {"com/memes/plus/ui/auth/auth_prompt/AuthPromptActivity$setClickableSpan$1", "Lcom/memes/plus/ui/auth/auth_prompt/MagicalClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.auth_prompt.AuthPromptActivity$setClickableSpan$1 */
/* compiled from: AuthPromptActivity.kt */
public final class AuthPromptActivity$setClickableSpan$1 extends MagicalClickableSpan {
    final /* synthetic */ Function0 $callback;

    AuthPromptActivity$setClickableSpan$1(Function0 function0) {
        this.$callback = function0;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        this.$callback.invoke();
    }
}
