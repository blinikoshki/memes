package com.memes.plus.p040ui.auth.auth_prompt;

import android.view.View;
import com.memes.plus.p040ui.auth.signin.SignInActivity;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.auth_prompt.AuthPromptActivity$onCreate$4 */
/* compiled from: AuthPromptActivity.kt */
final class AuthPromptActivity$onCreate$4 implements View.OnClickListener {
    final /* synthetic */ AuthPromptActivity this$0;

    AuthPromptActivity$onCreate$4(AuthPromptActivity authPromptActivity) {
        this.this$0 = authPromptActivity;
    }

    public final void onClick(View view) {
        this.this$0.authContractLauncher.launch(SignInActivity.Companion.getStartIntent$default(SignInActivity.Companion, this.this$0, false, 2, (Object) null));
    }
}
