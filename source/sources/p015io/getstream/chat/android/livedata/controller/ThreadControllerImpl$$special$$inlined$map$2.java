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
/* renamed from: io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$2 */
/* compiled from: SafeCollector.common.kt */
public final class ThreadControllerImpl$$special$$inlined$map$2 implements Flow<List<? extends Message>> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ ThreadControllerImpl this$0;

    public ThreadControllerImpl$$special$$inlined$map$2(Flow flow, ThreadControllerImpl threadControllerImpl) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = threadControllerImpl;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Object collect = this.$this_unsafeTransform$inlined.collect(new FlowCollector<List<? extends Message>>() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof p015io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$2.C49872.C49881
                    if (r0 == 0) goto L_0x0014
                    r0 = r9
                    io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$2$2$1 r0 = (p015io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$2.C49872.C49881) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r9 = r0.label
                    int r9 = r9 - r2
                    r0.label = r9
                    goto L_0x0019
                L_0x0014:
                    io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$2$2$1 r0 = new io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$2$2$1
                    r0.<init>(r7, r9)
                L_0x0019:
                    java.lang.Object r9 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0033
                    if (r2 != r3) goto L_0x002b
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L_0x00a1
                L_0x002b:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L_0x0033:
                    kotlin.ResultKt.throwOnFailure(r9)
                    kotlinx.coroutines.flow.FlowCollector r9 = r3
                    r2 = r0
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    java.util.List r8 = (java.util.List) r8
                    java.lang.Iterable r8 = (java.lang.Iterable) r8
                    io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$2$2$lambda$1 r2 = new io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$2$2$lambda$1
                    r2.<init>()
                    java.util.Comparator r2 = (java.util.Comparator) r2
                    java.util.List r8 = kotlin.collections.CollectionsKt.sortedWith(r8, r2)
                    java.lang.Iterable r8 = (java.lang.Iterable) r8
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.Collection r2 = (java.util.Collection) r2
                    java.util.Iterator r8 = r8.iterator()
                L_0x0057:
                    boolean r4 = r8.hasNext()
                    if (r4 == 0) goto L_0x0096
                    java.lang.Object r4 = r8.next()
                    r5 = r4
                    io.getstream.chat.android.client.models.Message r5 = (p015io.getstream.chat.android.client.models.Message) r5
                    io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$2 r6 = r2
                    io.getstream.chat.android.livedata.controller.ThreadControllerImpl r6 = r6.this$0
                    io.getstream.chat.android.livedata.controller.ChannelControllerImpl r6 = r6.getChannelControllerImpl()
                    java.util.Date r6 = r6.getHideMessagesBefore$stream_chat_android_offline_release()
                    if (r6 == 0) goto L_0x0087
                    io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$2 r6 = r2
                    io.getstream.chat.android.livedata.controller.ThreadControllerImpl r6 = r6.this$0
                    io.getstream.chat.android.livedata.controller.ChannelControllerImpl r6 = r6.getChannelControllerImpl()
                    java.util.Date r6 = r6.getHideMessagesBefore$stream_chat_android_offline_release()
                    boolean r5 = p015io.getstream.chat.android.livedata.extensions.MessageExtensionsKt.wasCreatedAfterOrAt(r5, r6)
                    if (r5 == 0) goto L_0x0085
                    goto L_0x0087
                L_0x0085:
                    r5 = 0
                    goto L_0x0088
                L_0x0087:
                    r5 = 1
                L_0x0088:
                    java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                    boolean r5 = r5.booleanValue()
                    if (r5 == 0) goto L_0x0057
                    r2.add(r4)
                    goto L_0x0057
                L_0x0096:
                    java.util.List r2 = (java.util.List) r2
                    r0.label = r3
                    java.lang.Object r8 = r9.emit(r2, r0)
                    if (r8 != r1) goto L_0x00a1
                    return r1
                L_0x00a1:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ThreadControllerImpl$$special$$inlined$map$2.C49872.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }
}
