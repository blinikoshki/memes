package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, mo26107d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo26108k = 1, mo26109mv = {1, 4, 0})
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 implements Flow<T> {
    final /* synthetic */ Function3 $action$inlined;
    final /* synthetic */ Flow $this_onCompletion$inlined;

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.$this_onCompletion$inlined = flow;
        this.$action$inlined = function3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector r10, kotlin.coroutines.Continuation r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.C22471
            if (r0 == 0) goto L_0x0014
            r0 = r11
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.C22471) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0082
            if (r2 == r5) goto L_0x0069
            if (r2 == r4) goto L_0x0050
            if (r2 != r3) goto L_0x0048
            java.lang.Object r10 = r0.L$4
            kotlinx.coroutines.flow.internal.SafeCollector r10 = (kotlinx.coroutines.flow.internal.SafeCollector) r10
            java.lang.Object r1 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            java.lang.Object r1 = r0.L$2
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0045 }
            goto L_0x00c5
        L_0x0045:
            r11 = move-exception
            goto L_0x00cd
        L_0x0048:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0050:
            java.lang.Object r10 = r0.L$4
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            java.lang.Object r1 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            java.lang.Object r1 = r0.L$2
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00f2
        L_0x0069:
            java.lang.Object r10 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
            java.lang.Object r2 = r0.L$2
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r6 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) r6
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x007d }
            goto L_0x009d
        L_0x007d:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L_0x00d6
        L_0x0082:
            kotlin.ResultKt.throwOnFailure(r11)
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            kotlinx.coroutines.flow.Flow r11 = r9.$this_onCompletion$inlined     // Catch:{ all -> 0x00d1 }
            r0.L$0 = r9     // Catch:{ all -> 0x00d1 }
            r0.L$1 = r10     // Catch:{ all -> 0x00d1 }
            r0.L$2 = r2     // Catch:{ all -> 0x00d1 }
            r0.L$3 = r10     // Catch:{ all -> 0x00d1 }
            r0.label = r5     // Catch:{ all -> 0x00d1 }
            java.lang.Object r11 = r11.collect(r10, r0)     // Catch:{ all -> 0x00d1 }
            if (r11 != r1) goto L_0x009b
            return r1
        L_0x009b:
            r6 = r9
            r5 = r10
        L_0x009d:
            kotlin.coroutines.CoroutineContext r11 = r0.getContext()
            kotlinx.coroutines.flow.internal.SafeCollector r4 = new kotlinx.coroutines.flow.internal.SafeCollector
            r4.<init>(r10, r11)
            kotlin.jvm.functions.Function3 r11 = r6.$action$inlined     // Catch:{ all -> 0x00cb }
            r7 = 0
            r0.L$0 = r6     // Catch:{ all -> 0x00cb }
            r0.L$1 = r5     // Catch:{ all -> 0x00cb }
            r0.L$2 = r2     // Catch:{ all -> 0x00cb }
            r0.L$3 = r10     // Catch:{ all -> 0x00cb }
            r0.L$4 = r4     // Catch:{ all -> 0x00cb }
            r0.label = r3     // Catch:{ all -> 0x00cb }
            r10 = 6
            kotlin.jvm.internal.InlineMarker.mark((int) r10)     // Catch:{ all -> 0x00cb }
            java.lang.Object r10 = r11.invoke(r4, r7, r0)     // Catch:{ all -> 0x00cb }
            r11 = 7
            kotlin.jvm.internal.InlineMarker.mark((int) r11)     // Catch:{ all -> 0x00cb }
            if (r10 != r1) goto L_0x00c4
            return r1
        L_0x00c4:
            r10 = r4
        L_0x00c5:
            r10.releaseIntercepted()
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00cb:
            r11 = move-exception
            r10 = r4
        L_0x00cd:
            r10.releaseIntercepted()
            throw r11
        L_0x00d1:
            r11 = move-exception
            r6 = r9
            r5 = r10
            r10 = r11
            r11 = r5
        L_0x00d6:
            kotlinx.coroutines.flow.ThrowingCollector r3 = new kotlinx.coroutines.flow.ThrowingCollector
            r3.<init>(r10)
            kotlinx.coroutines.flow.FlowCollector r3 = (kotlinx.coroutines.flow.FlowCollector) r3
            kotlin.jvm.functions.Function3 r7 = r6.$action$inlined
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r2
            r0.L$3 = r11
            r0.L$4 = r10
            r0.label = r4
            java.lang.Object r11 = kotlinx.coroutines.flow.FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(r3, r7, r10, r0)
            if (r11 != r1) goto L_0x00f2
            return r1
        L_0x00f2:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
