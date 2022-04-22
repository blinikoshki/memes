package p015io.getstream.chat.android.livedata.controller;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, mo26107d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$1 */
/* compiled from: SafeCollector.common.kt */
public final class ThreadControllerImpl$$special$$inlined$map$1 implements Flow<List<? extends Message>> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ ThreadControllerImpl this$0;

    public ThreadControllerImpl$$special$$inlined$map$1(Flow flow, ThreadControllerImpl threadControllerImpl) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = threadControllerImpl;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Object collect = this.$this_unsafeTransform$inlined.collect(new FlowCollector<List<? extends Message>>() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r9, kotlin.coroutines.Continuation r10) {
                /*
                    r8 = this;
                    boolean r0 = r10 instanceof p015io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$1.C49852.C49861
                    if (r0 == 0) goto L_0x0014
                    r0 = r10
                    io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$1$2$1 r0 = (p015io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$1.C49852.C49861) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r10 = r0.label
                    int r10 = r10 - r2
                    r0.label = r10
                    goto L_0x0019
                L_0x0014:
                    io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$1$2$1 r0 = new io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$1$2$1
                    r0.<init>(r8, r10)
                L_0x0019:
                    java.lang.Object r10 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0032
                    if (r2 != r3) goto L_0x002a
                    kotlin.ResultKt.throwOnFailure(r10)
                    goto L_0x0097
                L_0x002a:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r10)
                    throw r9
                L_0x0032:
                    kotlin.ResultKt.throwOnFailure(r10)
                    kotlinx.coroutines.flow.FlowCollector r10 = r3
                    r2 = r0
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    java.util.List r9 = (java.util.List) r9
                    java.lang.Iterable r9 = (java.lang.Iterable) r9
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.Collection r2 = (java.util.Collection) r2
                    java.util.Iterator r9 = r9.iterator()
                L_0x0049:
                    boolean r4 = r9.hasNext()
                    if (r4 == 0) goto L_0x008c
                    java.lang.Object r4 = r9.next()
                    r5 = r4
                    io.getstream.chat.android.client.models.Message r5 = (p015io.getstream.chat.android.client.models.Message) r5
                    java.lang.String r6 = r5.getId()
                    io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$1 r7 = r2
                    io.getstream.chat.android.livedata.controller.ThreadControllerImpl r7 = r7.this$0
                    java.lang.String r7 = r7.getThreadId()
                    boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
                    if (r6 != 0) goto L_0x007d
                    java.lang.String r5 = r5.getParentId()
                    io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$1 r6 = r2
                    io.getstream.chat.android.livedata.controller.ThreadControllerImpl r6 = r6.this$0
                    java.lang.String r6 = r6.getThreadId()
                    boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
                    if (r5 == 0) goto L_0x007b
                    goto L_0x007d
                L_0x007b:
                    r5 = 0
                    goto L_0x007e
                L_0x007d:
                    r5 = 1
                L_0x007e:
                    java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                    boolean r5 = r5.booleanValue()
                    if (r5 == 0) goto L_0x0049
                    r2.add(r4)
                    goto L_0x0049
                L_0x008c:
                    java.util.List r2 = (java.util.List) r2
                    r0.label = r3
                    java.lang.Object r9 = r10.emit(r2, r0)
                    if (r9 != r1) goto L_0x0097
                    return r1
                L_0x0097:
                    kotlin.Unit r9 = kotlin.Unit.INSTANCE
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$1.C49852.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }
}
