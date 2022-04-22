package editor.common.nudge;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.common.nudge.NudgeViewModel$createNudgeJob$1", mo26808f = "NudgeViewModel.kt", mo26809i = {0}, mo26810l = {96}, mo26811m = "invokeSuspend", mo26812n = {"$this$launch"}, mo26813s = {"L$0"})
/* compiled from: NudgeViewModel.kt */
final class NudgeViewModel$createNudgeJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NudgeDirection $direction;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NudgeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NudgeViewModel$createNudgeJob$1(NudgeViewModel nudgeViewModel, NudgeDirection nudgeDirection, Continuation continuation) {
        super(2, continuation);
        this.this$0 = nudgeViewModel;
        this.$direction = nudgeDirection;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        NudgeViewModel$createNudgeJob$1 nudgeViewModel$createNudgeJob$1 = new NudgeViewModel$createNudgeJob$1(this.this$0, this.$direction, continuation);
        nudgeViewModel$createNudgeJob$1.L$0 = obj;
        return nudgeViewModel$createNudgeJob$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((NudgeViewModel$createNudgeJob$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x001c
            if (r1 != r2) goto L_0x0014
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r6
            goto L_0x003c
        L_0x0014:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001c:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            r1 = r7
            r7 = r6
        L_0x0025:
            boolean r3 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
            if (r3 == 0) goto L_0x006b
            editor.common.nudge.NudgeViewModel r3 = r7.this$0
            long r3 = r3.nudgeIntervalMillis
            r7.L$0 = r1
            r7.label = r2
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r3, r7)
            if (r3 != r0) goto L_0x003c
            return r0
        L_0x003c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "~> nudged to "
            r3.append(r4)
            editor.common.nudge.NudgeDirection r4 = r7.$direction
            r3.append(r4)
            r4 = 32
            r3.append(r4)
            long r4 = java.lang.System.currentTimeMillis()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]
            timber.log.Timber.m300d(r3, r4)
            editor.common.nudge.NudgeViewModel r3 = r7.this$0
            editor.common.nudge.NudgeDirection r4 = r7.$direction
            r5 = 1090519040(0x41000000, float:8.0)
            r3.nudge(r4, r5)
            goto L_0x0025
        L_0x006b:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.common.nudge.NudgeViewModel$createNudgeJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
