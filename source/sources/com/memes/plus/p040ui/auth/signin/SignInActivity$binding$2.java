package com.memes.plus.p040ui.auth.signin;

import com.memes.plus.databinding.AuthSignInActivityBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/databinding/AuthSignInActivityBinding;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signin.SignInActivity$binding$2 */
/* compiled from: SignInActivity.kt */
final class SignInActivity$binding$2 extends Lambda implements Function0<AuthSignInActivityBinding> {
    final /* synthetic */ SignInActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignInActivity$binding$2(SignInActivity signInActivity) {
        super(0);
        this.this$0 = signInActivity;
    }

    public final AuthSignInActivityBinding invoke() {
        return AuthSignInActivityBinding.inflate(this.this$0.getLayoutInflater());
    }
}
