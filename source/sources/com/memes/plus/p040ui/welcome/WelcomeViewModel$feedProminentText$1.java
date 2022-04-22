package com.memes.plus.p040ui.welcome;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.ui.welcome.WelcomeViewModel$feedProminentText$1", mo26808f = "WelcomeViewModel.kt", mo26809i = {0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 6}, mo26810l = {76, 78, 83, 85, 91, 100, 102}, mo26811m = "invokeSuspend", mo26812n = {"memeLine1", "memeLine2", "memeLine1", "memeLine2", "count", "memeLine1", "memeLine2", "memeLine1", "memeLine2", "count", "count", "count"}, mo26813s = {"L$0", "L$1", "L$0", "L$1", "I$2", "L$0", "L$1", "L$0", "L$1", "I$2", "I$2", "I$2"})
/* renamed from: com.memes.plus.ui.welcome.WelcomeViewModel$feedProminentText$1 */
/* compiled from: WelcomeViewModel.kt */
final class WelcomeViewModel$feedProminentText$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ WelcomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WelcomeViewModel$feedProminentText$1(WelcomeViewModel welcomeViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = welcomeViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new WelcomeViewModel$feedProminentText$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((WelcomeViewModel$feedProminentText$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00ba, code lost:
        r14 = r0;
        r13 = 0;
        r16 = r10;
        r10 = r10.length();
        r8 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00c5, code lost:
        if (r13 >= r10) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00c7, code lost:
        r15 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r13).intValue();
        r14.L$0 = r8;
        r14.L$1 = r2;
        r14.I$0 = r13;
        r14.I$1 = r10;
        r14.I$2 = r15;
        r14.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00e2, code lost:
        if (kotlinx.coroutines.DelayKt.delay(80, r14) != r1) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00e4, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00e5, code lost:
        r3 = r14;
        r14 = r2;
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00e8, code lost:
        r4 = r3.this$0._prominentTextChanged;
        java.util.Objects.requireNonNull(r8, "null cannot be cast to non-null type java.lang.String");
        r2 = r8.substring(0, r2 + 1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        r4.setValue(r2);
        r13 = r13 + 1;
        r2 = r14;
        r14 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0100, code lost:
        r14.L$0 = r8;
        r14.L$1 = r2;
        r14.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x010d, code lost:
        if (kotlinx.coroutines.DelayKt.delay(400, r14) != r1) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x010f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0110, code lost:
        r10 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0111, code lost:
        r15 = r2;
        r13 = r2.length();
        r2 = r14;
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0119, code lost:
        if (r14 >= r13) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x011b, code lost:
        r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r14).intValue();
        r2.L$0 = r10;
        r2.L$1 = r15;
        r2.I$0 = r14;
        r2.I$1 = r13;
        r2.I$2 = r3;
        r2.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0136, code lost:
        if (kotlinx.coroutines.DelayKt.delay(80, r2) != r1) goto L_0x0139;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0138, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0139, code lost:
        r4 = r2.this$0._prominentTextChanged;
        r8 = new java.lang.StringBuilder();
        r8.append(r10);
        java.util.Objects.requireNonNull(r15, "null cannot be cast to non-null type java.lang.String");
        r3 = r15.substring(0, r3 + 1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        r8.append(r3);
        r4.setValue(r8.toString());
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x015e, code lost:
        r5 = 10;
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0162, code lost:
        if (r6 >= r5) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0164, code lost:
        r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6).intValue();
        r2.L$0 = null;
        r2.L$1 = null;
        r2.I$0 = r6;
        r2.I$1 = r5;
        r2.I$2 = r4;
        r2.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0181, code lost:
        if (kotlinx.coroutines.DelayKt.delay(100, r2) != r1) goto L_0x0184;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0183, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0184, code lost:
        r4 = r4 + 1;
        r2.this$0._backgroundAlphaChanged.setValue(kotlin.coroutines.jvm.internal.Boxing.boxFloat(((float) r4) / 10.0f));
        r2.this$0._foregroundSheetColorChanged.setValue(new kotlin.Pair(r2.this$0.blurMimicColors1.get(r4), r2.this$0.blurMimicColors2.get(r4)));
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x01ba, code lost:
        r2.L$0 = null;
        r2.L$1 = null;
        r2.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x01c7, code lost:
        if (kotlinx.coroutines.DelayKt.delay(5000, r2) != r1) goto L_0x01ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01c9, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01ca, code lost:
        r5 = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01cc, code lost:
        if (r11 >= r5) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01ce, code lost:
        r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11).intValue();
        r2.I$0 = r11;
        r2.I$1 = r5;
        r2.I$2 = r3;
        r2.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01e7, code lost:
        if (kotlinx.coroutines.DelayKt.delay(100, r2) != r1) goto L_0x01ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01e9, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01ea, code lost:
        r10 = 10 - (r3 + 1);
        r2.this$0._backgroundAlphaChanged.setValue(kotlin.coroutines.jvm.internal.Boxing.boxFloat(((float) r10) / 10.0f));
        r2.this$0._foregroundSheetColorChanged.setValue(new kotlin.Pair(r2.this$0.blurMimicColors1.get(r10), r2.this$0.blurMimicColors2.get(r10)));
        r11 = r11 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0226, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r5 = 80
            java.lang.String r7 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            java.lang.String r9 = "null cannot be cast to non-null type java.lang.String"
            r11 = 0
            r12 = 1
            switch(r2) {
                case 0: goto L_0x0082;
                case 1: goto L_0x0076;
                case 2: goto L_0x0061;
                case 3: goto L_0x0053;
                case 4: goto L_0x003e;
                case 5: goto L_0x0031;
                case 6: goto L_0x002b;
                case 7: goto L_0x001b;
                default: goto L_0x0013;
            }
        L_0x0013:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x001b:
            int r2 = r0.I$2
            int r5 = r0.I$1
            int r6 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r18)
            r3 = r2
            r11 = r6
            r6 = 100
            r2 = r0
            goto L_0x01ea
        L_0x002b:
            kotlin.ResultKt.throwOnFailure(r18)
            r2 = r0
            goto L_0x01ca
        L_0x0031:
            int r2 = r0.I$2
            int r5 = r0.I$1
            int r6 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r18)
            r4 = r2
            r2 = r0
            goto L_0x0184
        L_0x003e:
            int r2 = r0.I$2
            int r13 = r0.I$1
            int r14 = r0.I$0
            java.lang.Object r15 = r0.L$1
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r10 = r0.L$0
            java.lang.String r10 = (java.lang.String) r10
            kotlin.ResultKt.throwOnFailure(r18)
            r3 = r2
            r2 = r0
            goto L_0x0139
        L_0x0053:
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r10 = r0.L$0
            java.lang.String r10 = (java.lang.String) r10
            kotlin.ResultKt.throwOnFailure(r18)
            r14 = r0
            goto L_0x0111
        L_0x0061:
            int r2 = r0.I$2
            int r10 = r0.I$1
            int r13 = r0.I$0
            java.lang.Object r14 = r0.L$1
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r15 = r0.L$0
            java.lang.String r15 = (java.lang.String) r15
            kotlin.ResultKt.throwOnFailure(r18)
            r3 = r0
            r8 = r15
            goto L_0x00e8
        L_0x0076:
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r10 = r0.L$0
            java.lang.String r10 = (java.lang.String) r10
            kotlin.ResultKt.throwOnFailure(r18)
            goto L_0x00ba
        L_0x0082:
            kotlin.ResultKt.throwOnFailure(r18)
            java.lang.String r10 = "Me: i'm going to start eating healthy"
            java.lang.String r2 = "\nAlso me:"
            com.memes.plus.ui.welcome.WelcomeViewModel r13 = r0.this$0
            com.memes.commons.util.SingleLiveEvent r13 = r13._foregroundSheetColorChanged
            kotlin.Pair r14 = new kotlin.Pair
            com.memes.plus.ui.welcome.WelcomeViewModel r15 = r0.this$0
            java.util.List r15 = r15.blurMimicColors1
            java.lang.Object r15 = r15.get(r11)
            com.memes.plus.ui.welcome.WelcomeViewModel r8 = r0.this$0
            java.util.List r8 = r8.blurMimicColors2
            java.lang.Object r8 = r8.get(r11)
            r14.<init>(r15, r8)
            r13.setValue(r14)
            r13 = 1000(0x3e8, double:4.94E-321)
            r0.L$0 = r10
            r0.L$1 = r2
            r0.label = r12
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r13, r0)
            if (r8 != r1) goto L_0x00ba
            return r1
        L_0x00ba:
            int r8 = r10.length()
            r14 = r0
            r13 = 0
            r16 = r10
            r10 = r8
            r8 = r16
        L_0x00c5:
            if (r13 >= r10) goto L_0x0100
            java.lang.Integer r15 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r13)
            java.lang.Number r15 = (java.lang.Number) r15
            int r15 = r15.intValue()
            r14.L$0 = r8
            r14.L$1 = r2
            r14.I$0 = r13
            r14.I$1 = r10
            r14.I$2 = r15
            r3 = 2
            r14.label = r3
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r5, r14)
            if (r3 != r1) goto L_0x00e5
            return r1
        L_0x00e5:
            r3 = r14
            r14 = r2
            r2 = r15
        L_0x00e8:
            com.memes.plus.ui.welcome.WelcomeViewModel r4 = r3.this$0
            com.memes.commons.util.SingleLiveEvent r4 = r4._prominentTextChanged
            int r2 = r2 + r12
            java.util.Objects.requireNonNull(r8, r9)
            java.lang.String r2 = r8.substring(r11, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            r4.setValue(r2)
            int r13 = r13 + r12
            r2 = r14
            r14 = r3
            goto L_0x00c5
        L_0x0100:
            r3 = 400(0x190, double:1.976E-321)
            r14.L$0 = r8
            r14.L$1 = r2
            r10 = 3
            r14.label = r10
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r3, r14)
            if (r3 != r1) goto L_0x0110
            return r1
        L_0x0110:
            r10 = r8
        L_0x0111:
            int r3 = r2.length()
            r15 = r2
            r13 = r3
            r2 = r14
            r14 = 0
        L_0x0119:
            if (r14 >= r13) goto L_0x015e
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r14)
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            r2.L$0 = r10
            r2.L$1 = r15
            r2.I$0 = r14
            r2.I$1 = r13
            r2.I$2 = r3
            r4 = 4
            r2.label = r4
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r5, r2)
            if (r4 != r1) goto L_0x0139
            return r1
        L_0x0139:
            com.memes.plus.ui.welcome.WelcomeViewModel r4 = r2.this$0
            com.memes.commons.util.SingleLiveEvent r4 = r4._prominentTextChanged
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r10)
            int r3 = r3 + r12
            java.util.Objects.requireNonNull(r15, r9)
            java.lang.String r3 = r15.substring(r11, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            r8.append(r3)
            java.lang.String r3 = r8.toString()
            r4.setValue(r3)
            int r14 = r14 + r12
            goto L_0x0119
        L_0x015e:
            r5 = 10
            r6 = 0
        L_0x0161:
            r3 = 0
            if (r6 >= r5) goto L_0x01ba
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r2.L$0 = r3
            r2.L$1 = r3
            r2.I$0 = r6
            r2.I$1 = r5
            r2.I$2 = r4
            r3 = 5
            r2.label = r3
            r7 = 100
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r7, r2)
            if (r3 != r1) goto L_0x0184
            return r1
        L_0x0184:
            com.memes.plus.ui.welcome.WelcomeViewModel r3 = r2.this$0
            com.memes.commons.util.SingleLiveEvent r3 = r3._backgroundAlphaChanged
            int r4 = r4 + r12
            float r7 = (float) r4
            r8 = 1092616192(0x41200000, float:10.0)
            float r7 = r7 / r8
            java.lang.Float r7 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r7)
            r3.setValue(r7)
            com.memes.plus.ui.welcome.WelcomeViewModel r3 = r2.this$0
            com.memes.commons.util.SingleLiveEvent r3 = r3._foregroundSheetColorChanged
            kotlin.Pair r7 = new kotlin.Pair
            com.memes.plus.ui.welcome.WelcomeViewModel r8 = r2.this$0
            java.util.List r8 = r8.blurMimicColors1
            java.lang.Object r8 = r8.get(r4)
            com.memes.plus.ui.welcome.WelcomeViewModel r9 = r2.this$0
            java.util.List r9 = r9.blurMimicColors2
            java.lang.Object r4 = r9.get(r4)
            r7.<init>(r8, r4)
            r3.setValue(r7)
            int r6 = r6 + r12
            goto L_0x0161
        L_0x01ba:
            r4 = 5000(0x1388, double:2.4703E-320)
            r2.L$0 = r3
            r2.L$1 = r3
            r3 = 6
            r2.label = r3
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r4, r2)
            if (r3 != r1) goto L_0x01ca
            return r1
        L_0x01ca:
            r5 = 10
        L_0x01cc:
            if (r11 >= r5) goto L_0x0224
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            r2.I$0 = r11
            r2.I$1 = r5
            r2.I$2 = r3
            r4 = 7
            r2.label = r4
            r6 = 100
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r6, r2)
            if (r4 != r1) goto L_0x01ea
            return r1
        L_0x01ea:
            com.memes.plus.ui.welcome.WelcomeViewModel r4 = r2.this$0
            com.memes.commons.util.SingleLiveEvent r4 = r4._backgroundAlphaChanged
            int r3 = r3 + r12
            r8 = 10
            int r10 = 10 - r3
            float r3 = (float) r10
            r9 = 1092616192(0x41200000, float:10.0)
            float r3 = r3 / r9
            java.lang.Float r3 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r3)
            r4.setValue(r3)
            com.memes.plus.ui.welcome.WelcomeViewModel r3 = r2.this$0
            com.memes.commons.util.SingleLiveEvent r3 = r3._foregroundSheetColorChanged
            kotlin.Pair r4 = new kotlin.Pair
            com.memes.plus.ui.welcome.WelcomeViewModel r13 = r2.this$0
            java.util.List r13 = r13.blurMimicColors1
            java.lang.Object r13 = r13.get(r10)
            com.memes.plus.ui.welcome.WelcomeViewModel r14 = r2.this$0
            java.util.List r14 = r14.blurMimicColors2
            java.lang.Object r10 = r14.get(r10)
            r4.<init>(r13, r10)
            r3.setValue(r4)
            int r11 = r11 + r12
            goto L_0x01cc
        L_0x0224:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.welcome.WelcomeViewModel$feedProminentText$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
