package com.memes.plus.p040ui.welcome;

import android.app.Activity;
import androidx.lifecycle.Observer;
import com.memes.commons.util.ActivityStarter;
import com.memes.plus.p040ui.auth.auth_prompt.AuthPromptActivity;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.welcome.WelcomeActivity$onCreate$1 */
/* compiled from: WelcomeActivity.kt */
final class WelcomeActivity$onCreate$1<T> implements Observer<Boolean> {
    final /* synthetic */ WelcomeActivity this$0;

    WelcomeActivity$onCreate$1(WelcomeActivity welcomeActivity) {
        this.this$0 = welcomeActivity;
    }

    public final void onChanged(Boolean bool) {
        ActivityStarter.Companion.mo57312of(AuthPromptActivity.Companion.getStartIntent(this.this$0)).finishAffinity().startFrom((Activity) this.this$0);
    }
}
