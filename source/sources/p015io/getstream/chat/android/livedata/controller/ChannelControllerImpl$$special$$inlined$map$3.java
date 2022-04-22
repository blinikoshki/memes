package p015io.getstream.chat.android.livedata.controller;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.models.TypingEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, mo26107d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$3 */
/* compiled from: SafeCollector.common.kt */
public final class ChannelControllerImpl$$special$$inlined$map$3 implements Flow<TypingEvent> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ ChannelControllerImpl this$0;

    public ChannelControllerImpl$$special$$inlined$map$3(Flow flow, ChannelControllerImpl channelControllerImpl) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = channelControllerImpl;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Object collect = this.$this_unsafeTransform$inlined.collect(new FlowCollector<Map<String, ? extends ChatEvent>>() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$3.C49722.C49731
                    if (r0 == 0) goto L_0x0014
                    r0 = r9
                    io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$3$2$1 r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$3.C49722.C49731) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r9 = r0.label
                    int r9 = r9 - r2
                    r0.label = r9
                    goto L_0x0019
                L_0x0014:
                    io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$3$2$1 r0 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$3$2$1
                    r0.<init>(r7, r9)
                L_0x0019:
                    java.lang.Object r9 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0033
                    if (r2 != r3) goto L_0x002b
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L_0x00ac
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
                    java.util.Map r8 = (java.util.Map) r8
                    java.util.Collection r8 = r8.values()
                    java.lang.Iterable r8 = (java.lang.Iterable) r8
                    io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$3$2$lambda$1 r2 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$3$2$lambda$1
                    r2.<init>()
                    java.util.Comparator r2 = (java.util.Comparator) r2
                    java.util.List r8 = kotlin.collections.CollectionsKt.sortedWith(r8, r2)
                    java.lang.Iterable r8 = (java.lang.Iterable) r8
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.Collection r2 = (java.util.Collection) r2
                    java.util.Iterator r8 = r8.iterator()
                L_0x005b:
                    boolean r4 = r8.hasNext()
                    if (r4 == 0) goto L_0x0094
                    java.lang.Object r4 = r8.next()
                    io.getstream.chat.android.client.events.ChatEvent r4 = (p015io.getstream.chat.android.client.events.ChatEvent) r4
                    boolean r5 = r4 instanceof p015io.getstream.chat.android.client.events.TypingStartEvent
                    r6 = 0
                    if (r5 == 0) goto L_0x008e
                    io.getstream.chat.android.client.events.TypingStartEvent r4 = (p015io.getstream.chat.android.client.events.TypingStartEvent) r4
                    io.getstream.chat.android.client.models.User r4 = r4.getUser()
                    io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$3 r5 = r2
                    io.getstream.chat.android.livedata.controller.ChannelControllerImpl r5 = r5.this$0
                    io.getstream.chat.android.livedata.ChatDomainImpl r5 = r5.getDomainImpl()
                    io.getstream.chat.android.client.models.User r5 = r5.getCurrentUser()
                    boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
                    r5 = r5 ^ r3
                    java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                    boolean r5 = r5.booleanValue()
                    if (r5 == 0) goto L_0x008e
                    r6 = r4
                L_0x008e:
                    if (r6 == 0) goto L_0x005b
                    r2.add(r6)
                    goto L_0x005b
                L_0x0094:
                    java.util.List r2 = (java.util.List) r2
                    io.getstream.chat.android.client.models.TypingEvent r8 = new io.getstream.chat.android.client.models.TypingEvent
                    io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$3 r4 = r2
                    io.getstream.chat.android.livedata.controller.ChannelControllerImpl r4 = r4.this$0
                    java.lang.String r4 = r4.getChannelId()
                    r8.<init>(r4, r2)
                    r0.label = r3
                    java.lang.Object r8 = r9.emit(r8, r0)
                    if (r8 != r1) goto L_0x00ac
                    return r1
                L_0x00ac:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$3.C49722.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }
}
