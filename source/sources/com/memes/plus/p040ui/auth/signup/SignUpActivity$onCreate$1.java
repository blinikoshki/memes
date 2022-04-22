package com.memes.plus.p040ui.auth.signup;

import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.memes.plus.p040ui.auth.signup.stages.SignUpStage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "stage", "Lcom/memes/plus/ui/auth/signup/stages/SignUpStage;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signup.SignUpActivity$onCreate$1 */
/* compiled from: SignUpActivity.kt */
final class SignUpActivity$onCreate$1<T> implements Observer<SignUpStage> {
    final /* synthetic */ SignUpActivity this$0;

    SignUpActivity$onCreate$1(SignUpActivity signUpActivity) {
        this.this$0 = signUpActivity;
    }

    public final void onChanged(SignUpStage signUpStage) {
        int position = signUpStage.getPosition();
        ViewPager2 viewPager2 = this.this$0.getBinding().viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        viewPager2.setCurrentItem(position);
    }
}
