package com.memes.plus.p040ui.auth.signup;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.ui.auth.signup.SignUpViewModel$performIdentityValidation$1", mo26808f = "SignUpViewModel.kt", mo26809i = {}, mo26810l = {120, 126}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.plus.ui.auth.signup.SignUpViewModel$performIdentityValidation$1 */
/* compiled from: SignUpViewModel.kt */
final class SignUpViewModel$performIdentityValidation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SignUpViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignUpViewModel$performIdentityValidation$1(SignUpViewModel signUpViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = signUpViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new SignUpViewModel$performIdentityValidation$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SignUpViewModel$performIdentityValidation$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0055
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0036
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r5)
            com.memes.plus.ui.auth.signup.SignUpViewModel r5 = r4.this$0
            r1 = 0
            com.memes.commons.viewmodel.BaseViewModel.showBlockingProgressDialog$default(r5, r1, r3, r1)
            com.memes.plus.ui.auth.signup.SignUpViewModel r5 = r4.this$0
            java.lang.String r1 = r5.email
            r4.label = r3
            java.lang.Object r5 = r5.isEmailValid(r1, r4)
            if (r5 != r0) goto L_0x0036
            return r0
        L_0x0036:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x0046
            com.memes.plus.ui.auth.signup.SignUpViewModel r5 = r4.this$0
            r5.hideBlockingProgressDialog()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0046:
            com.memes.plus.ui.auth.signup.SignUpViewModel r5 = r4.this$0
            java.lang.String r1 = r5.username
            r4.label = r2
            java.lang.Object r5 = r5.isUsernameValid(r1, r4)
            if (r5 != r0) goto L_0x0055
            return r0
        L_0x0055:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x0065
            com.memes.plus.ui.auth.signup.SignUpViewModel r5 = r4.this$0
            r5.hideBlockingProgressDialog()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0065:
            com.memes.plus.ui.auth.signup.SignUpViewModel r5 = r4.this$0
            java.lang.String r0 = r5.password
            boolean r5 = r5.isPasswordValid(r0)
            if (r5 != 0) goto L_0x0079
            com.memes.plus.ui.auth.signup.SignUpViewModel r5 = r4.this$0
            r5.hideBlockingProgressDialog()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0079:
            com.memes.plus.ui.auth.signup.SignUpViewModel r5 = r4.this$0
            r5.hideBlockingProgressDialog()
            com.memes.plus.ui.auth.signup.SignUpViewModel r5 = r4.this$0
            com.memes.commons.util.SingleLiveEvent r5 = r5._signUpStageChanged
            com.memes.plus.ui.auth.signup.stages.SignUpStage r0 = com.memes.plus.p040ui.auth.signup.stages.SignUpStage.PROFILE_INPUT
            r5.setValue(r0)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.auth.signup.SignUpViewModel$performIdentityValidation$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
