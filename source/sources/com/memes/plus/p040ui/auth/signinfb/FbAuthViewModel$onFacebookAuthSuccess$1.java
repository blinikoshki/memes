package com.memes.plus.p040ui.auth.signinfb;

import com.facebook.login.LoginResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.ui.auth.signinfb.FbAuthViewModel$onFacebookAuthSuccess$1", mo26808f = "FbAuthViewModel.kt", mo26809i = {1}, mo26810l = {154, 164}, mo26811m = "invokeSuspend", mo26812n = {"fbProfile"}, mo26813s = {"L$0"})
/* renamed from: com.memes.plus.ui.auth.signinfb.FbAuthViewModel$onFacebookAuthSuccess$1 */
/* compiled from: FbAuthViewModel.kt */
final class FbAuthViewModel$onFacebookAuthSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LoginResult $result;
    Object L$0;
    int label;
    final /* synthetic */ FbAuthViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FbAuthViewModel$onFacebookAuthSuccess$1(FbAuthViewModel fbAuthViewModel, LoginResult loginResult, Continuation continuation) {
        super(2, continuation);
        this.this$0 = fbAuthViewModel;
        this.$result = loginResult;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new FbAuthViewModel$onFacebookAuthSuccess$1(this.this$0, this.$result, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FbAuthViewModel$onFacebookAuthSuccess$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 == r4) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            java.lang.Object r0 = r5.L$0
            com.memes.plus.ui.auth.signinfb.FbProfile r0 = (com.memes.plus.p040ui.auth.signinfb.FbProfile) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0075
        L_0x0017:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0039
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r6)
            com.memes.plus.ui.auth.signinfb.FbAuthViewModel r6 = r5.this$0
            r1 = 0
            com.memes.commons.viewmodel.BaseViewModel.showBlockingProgressDialog$default(r6, r1, r4, r1)
            com.memes.plus.ui.auth.signinfb.FbAuthViewModel r6 = r5.this$0
            com.facebook.login.LoginResult r1 = r5.$result
            r5.label = r4
            java.lang.Object r6 = r6.fetchFbProfile(r1, r5)
            if (r6 != r0) goto L_0x0039
            return r0
        L_0x0039:
            com.memes.plus.ui.auth.signinfb.FbProfile r6 = (com.memes.plus.p040ui.auth.signinfb.FbProfile) r6
            if (r6 == 0) goto L_0x00b5
            java.lang.String r1 = r6.getLocalUserId()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x004e
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            if (r1 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r1 = 0
            goto L_0x004f
        L_0x004e:
            r1 = 1
        L_0x004f:
            if (r1 != 0) goto L_0x00b5
            java.lang.String r1 = r6.getName()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0062
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            if (r1 == 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r1 = 0
            goto L_0x0063
        L_0x0062:
            r1 = 1
        L_0x0063:
            if (r1 == 0) goto L_0x0066
            goto L_0x00b5
        L_0x0066:
            com.memes.plus.ui.auth.signinfb.FbAuthViewModel r1 = r5.this$0
            r5.L$0 = r6
            r5.label = r2
            java.lang.Object r1 = r1.fetchExistingAccountEmailIfExists(r6, r5)
            if (r1 != r0) goto L_0x0073
            return r0
        L_0x0073:
            r0 = r6
            r6 = r1
        L_0x0075:
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x0081
            com.memes.plus.ui.auth.signinfb.FbAuthViewModel r1 = r5.this$0
            r1.signIn(r0, r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0081:
            com.memes.plus.ui.auth.signinfb.FbAuthViewModel r6 = r5.this$0
            r6.hideBlockingProgressDialog()
            com.memes.plus.ui.auth.signinfb.FbAuthViewModel r6 = r5.this$0
            r6.fbProfile = r0
            java.lang.String r6 = r0.getEmail()
            r1 = r6
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x009a
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            if (r1 == 0) goto L_0x009b
        L_0x009a:
            r3 = 1
        L_0x009b:
            if (r3 == 0) goto L_0x00ad
            com.memes.plus.ui.auth.signinfb.FbAuthViewModel r6 = r5.this$0
            com.memes.commons.util.SingleLiveEvent r6 = r6._emailInputRequired
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            r6.setValue(r0)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x00ad:
            com.memes.plus.ui.auth.signinfb.FbAuthViewModel r1 = r5.this$0
            r1.signIn(r0, r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x00b5:
            com.memes.plus.ui.auth.signinfb.FbAuthViewModel r6 = r5.this$0
            r0 = 2131886421(0x7f120155, float:1.940742E38)
            r6.toast((int) r0)
            com.memes.plus.ui.auth.signinfb.FbAuthViewModel r6 = r5.this$0
            r6.fail()
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.auth.signinfb.FbAuthViewModel$onFacebookAuthSuccess$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
