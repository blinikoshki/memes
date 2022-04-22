package com.memes.plus.p040ui.auth.signin;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.memes.commons.util.ActivityStarter;
import com.memes.plus.p040ui.auth.signup.SignUpActivity;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signin.SignInActivity$onCreate$8 */
/* compiled from: SignInActivity.kt */
final class SignInActivity$onCreate$8 implements View.OnClickListener {
    final /* synthetic */ SignInActivity this$0;

    SignInActivity$onCreate$8(SignInActivity signInActivity) {
        this.this$0 = signInActivity;
    }

    public final void onClick(View view) {
        Intent intent = this.this$0.getIntent();
        boolean z = false;
        if (intent != null) {
            z = intent.getBooleanExtra("intent_extra_started_by_sign_up", false);
        }
        if (z) {
            this.this$0.finish();
            return;
        }
        ActivityStarter.Companion.mo57312of(SignUpActivity.Companion.getStartIntent(this.this$0, true)).startFrom((Activity) this.this$0);
    }
}
