package com.memes.plus.p040ui.auth.signup.stages;

import android.app.Activity;
import android.view.View;
import com.memes.commons.util.SoftKeyboardUtil;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signup.stages.CompleteEmailSignUpFragment$onViewCreated$6 */
/* compiled from: CompleteEmailSignUpFragment.kt */
final class CompleteEmailSignUpFragment$onViewCreated$6 implements View.OnClickListener {
    final /* synthetic */ CompleteEmailSignUpFragment this$0;

    CompleteEmailSignUpFragment$onViewCreated$6(CompleteEmailSignUpFragment completeEmailSignUpFragment) {
        this.this$0 = completeEmailSignUpFragment;
    }

    public final void onClick(View view) {
        SoftKeyboardUtil.INSTANCE.hideKeyboard((Activity) this.this$0.requireActivity());
        this.this$0.getSignUpViewModel().completeSignUp();
    }
}
