package p015io.getstream.chat.android.livedata.controller;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import p015io.getstream.chat.android.client.models.ChannelUserRead;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, mo26107d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$4 */
/* compiled from: SafeCollector.common.kt */
public final class ChannelControllerImpl$$special$$inlined$map$4 implements Flow<List<? extends ChannelUserRead>> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;

    public ChannelControllerImpl$$special$$inlined$map$4(Flow flow) {
        this.$this_unsafeTransform$inlined = flow;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Object collect = this.$this_unsafeTransform$inlined.collect(new FlowCollector<Map<String, ? extends ChannelUserRead>>() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$4.C49742.C49751
                    if (r0 == 0) goto L_0x0014
                    r0 = r6
                    io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$4$2$1 r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$4.C49742.C49751) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r6 = r0.label
                    int r6 = r6 - r2
                    r0.label = r6
                    goto L_0x0019
                L_0x0014:
                    io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$4$2$1 r0 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$4$2$1
                    r0.<init>(r4, r6)
                L_0x0019:
                    java.lang.Object r6 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0032
                    if (r2 != r3) goto L_0x002a
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L_0x0056
                L_0x002a:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0032:
                    kotlin.ResultKt.throwOnFailure(r6)
                    kotlinx.coroutines.flow.FlowCollector r6 = r3
                    r2 = r0
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    java.util.Map r5 = (java.util.Map) r5
                    java.util.Collection r5 = r5.values()
                    java.lang.Iterable r5 = (java.lang.Iterable) r5
                    io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$4$2$lambda$1 r2 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$4$2$lambda$1
                    r2.<init>()
                    java.util.Comparator r2 = (java.util.Comparator) r2
                    java.util.List r5 = kotlin.collections.CollectionsKt.sortedWith(r5, r2)
                    r0.label = r3
                    java.lang.Object r5 = r6.emit(r5, r0)
                    if (r5 != r1) goto L_0x0056
                    return r1
                L_0x0056:
                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$$special$$inlined$map$4.C49742.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }
}
