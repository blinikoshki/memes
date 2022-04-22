package com.memes.plus.p040ui.auth.auth_prompt;

import android.app.Activity;
import com.memes.commons.util.ActivityStarter;
import com.memes.plus.AppConfig;
import com.memes.plus.p040ui.web_view.WebViewActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.auth_prompt.AuthPromptActivity$updateTermsConditionsTextWithSpans$1 */
/* compiled from: AuthPromptActivity.kt */
final class AuthPromptActivity$updateTermsConditionsTextWithSpans$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AuthPromptActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthPromptActivity$updateTermsConditionsTextWithSpans$1(AuthPromptActivity authPromptActivity) {
        super(0);
        this.this$0 = authPromptActivity;
    }

    public final void invoke() {
        ActivityStarter.Companion.mo57312of(WebViewActivity.Companion.getStartIntent(this.this$0, AppConfig.TERMS_URL)).startFrom((Activity) this.this$0);
    }
}
