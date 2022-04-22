package com.memes.plus.p040ui.auth.login;

import com.facebook.login.widget.LoginButton;
import com.memes.plus.p040ui.auth.signinfb.FbAuthProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/auth/signinfb/FbAuthProvider;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.login.LoginActivity$fbSignInProvider$2 */
/* compiled from: LoginActivity.kt */
final class LoginActivity$fbSignInProvider$2 extends Lambda implements Function0<FbAuthProvider> {
    final /* synthetic */ LoginActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoginActivity$fbSignInProvider$2(LoginActivity loginActivity) {
        super(0);
        this.this$0 = loginActivity;
    }

    public final FbAuthProvider invoke() {
        LoginButton loginButton = this.this$0.getBinding().facebookLoginButton;
        Intrinsics.checkNotNullExpressionValue(loginButton, "binding.facebookLoginButton");
        return new FbAuthProvider(loginButton, this.this$0.getFbAuthViewModel());
    }
}
