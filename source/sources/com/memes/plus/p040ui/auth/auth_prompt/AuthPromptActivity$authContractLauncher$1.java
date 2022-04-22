package com.memes.plus.p040ui.auth.auth_prompt;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.memes.commons.util.ActivityResultExtKt;
import com.memes.commons.util.ActivityStarter;
import com.memes.plus.p040ui.home.routing.HomeRouting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "result", "Landroidx/activity/result/ActivityResult;", "kotlin.jvm.PlatformType", "onActivityResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.auth_prompt.AuthPromptActivity$authContractLauncher$1 */
/* compiled from: AuthPromptActivity.kt */
final class AuthPromptActivity$authContractLauncher$1<O> implements ActivityResultCallback<ActivityResult> {
    final /* synthetic */ AuthPromptActivity this$0;

    AuthPromptActivity$authContractLauncher$1(AuthPromptActivity authPromptActivity) {
        this.this$0 = authPromptActivity;
    }

    public final void onActivityResult(ActivityResult activityResult) {
        Intrinsics.checkNotNullExpressionValue(activityResult, "result");
        if (ActivityResultExtKt.isOk(activityResult)) {
            this.this$0.setResult(activityResult.getResultCode(), activityResult.getData());
            ActivityStarter.Companion.finishWithRootCheck(this.this$0, HomeRouting.INSTANCE.getIntent(this.this$0));
        }
    }
}
