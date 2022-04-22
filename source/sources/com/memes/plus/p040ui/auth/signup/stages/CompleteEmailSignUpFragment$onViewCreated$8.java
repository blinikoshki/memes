package com.memes.plus.p040ui.auth.signup.stages;

import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "path", "", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signup.stages.CompleteEmailSignUpFragment$onViewCreated$8 */
/* compiled from: CompleteEmailSignUpFragment.kt */
final class CompleteEmailSignUpFragment$onViewCreated$8<T> implements Observer<String> {
    final /* synthetic */ CompleteEmailSignUpFragment this$0;

    CompleteEmailSignUpFragment$onViewCreated$8(CompleteEmailSignUpFragment completeEmailSignUpFragment) {
        this.this$0 = completeEmailSignUpFragment;
    }

    public final void onChanged(String str) {
        this.this$0.loadProfilePicture(str);
    }
}
