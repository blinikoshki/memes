package com.memes.plus.p040ui.auth.signup.stages;

import androidx.lifecycle.Observer;
import com.memes.plus.p040ui.auth.signup.selectgender.Gender;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "gender", "Lcom/memes/plus/ui/auth/signup/selectgender/Gender;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signup.stages.CompleteEmailSignUpFragment$onViewCreated$7 */
/* compiled from: CompleteEmailSignUpFragment.kt */
final class CompleteEmailSignUpFragment$onViewCreated$7<T> implements Observer<Gender> {
    final /* synthetic */ CompleteEmailSignUpFragment this$0;

    CompleteEmailSignUpFragment$onViewCreated$7(CompleteEmailSignUpFragment completeEmailSignUpFragment) {
        this.this$0 = completeEmailSignUpFragment;
    }

    public final void onChanged(Gender gender) {
        CompleteEmailSignUpFragment.access$getBinding$p(this.this$0).genderTextView.setText(gender.getDisplayTextRes());
    }
}
