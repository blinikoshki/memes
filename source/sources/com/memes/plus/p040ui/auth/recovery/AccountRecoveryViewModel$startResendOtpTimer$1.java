package com.memes.plus.p040ui.auth.recovery;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.ui.auth.recovery.AccountRecoveryViewModel$startResendOtpTimer$1", mo26808f = "AccountRecoveryViewModel.kt", mo26809i = {0, 0}, mo26810l = {300}, mo26811m = "invokeSuspend", mo26812n = {"totalSeconds", "iterationIndex"}, mo26813s = {"I$0", "I$3"})
/* renamed from: com.memes.plus.ui.auth.recovery.AccountRecoveryViewModel$startResendOtpTimer$1 */
/* compiled from: AccountRecoveryViewModel.kt */
final class AccountRecoveryViewModel$startResendOtpTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int label;
    final /* synthetic */ AccountRecoveryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountRecoveryViewModel$startResendOtpTimer$1(AccountRecoveryViewModel accountRecoveryViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = accountRecoveryViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new AccountRecoveryViewModel$startResendOtpTimer$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AccountRecoveryViewModel$startResendOtpTimer$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L_0x0020
            if (r1 != r2) goto L_0x0018
            int r1 = r8.I$3
            int r3 = r8.I$2
            int r4 = r8.I$1
            int r5 = r8.I$0
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r8
            goto L_0x0072
        L_0x0018:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = 120(0x78, float:1.68E-43)
            r1 = 0
            r9 = r8
            r3 = 120(0x78, float:1.68E-43)
            r4 = 0
            r5 = 120(0x78, float:1.68E-43)
        L_0x002c:
            if (r4 >= r3) goto L_0x0082
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "iteration_index: "
            r6.append(r7)
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.io.PrintStream r7 = java.lang.System.out
            r7.println(r6)
            int r6 = r5 - r1
            com.memes.plus.ui.auth.recovery.AccountRecoveryViewModel r7 = r9.this$0
            java.lang.String r6 = r7.readableSecondsFormat(r6)
            com.memes.plus.ui.auth.recovery.AccountRecoveryViewModel r7 = r9.this$0
            com.memes.commons.util.SingleLiveEvent r7 = r7._resendOtpTimerText
            r7.setValue(r6)
            r6 = 1000(0x3e8, double:4.94E-321)
            r9.I$0 = r5
            r9.I$1 = r4
            r9.I$2 = r3
            r9.I$3 = r1
            r9.label = r2
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r6, r9)
            if (r6 != r0) goto L_0x0072
            return r0
        L_0x0072:
            int r6 = r5 + -1
            if (r1 != r6) goto L_0x0080
            com.memes.plus.ui.auth.recovery.AccountRecoveryViewModel r1 = r9.this$0
            com.memes.commons.util.SingleLiveEvent r1 = r1._resendOtpTimerText
            r6 = 0
            r1.setValue(r6)
        L_0x0080:
            int r4 = r4 + r2
            goto L_0x002c
        L_0x0082:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.auth.recovery.AccountRecoveryViewModel$startResendOtpTimer$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
