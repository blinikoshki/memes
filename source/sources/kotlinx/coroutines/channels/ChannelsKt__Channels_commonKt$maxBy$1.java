package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\tHH"}, mo26107d2 = {"maxBy", "", "E", "R", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "selector", "Lkotlin/Function1;", "continuation", "Lkotlin/coroutines/Continuation;"}, mo26108k = 3, mo26109mv = {1, 4, 0})
@DebugMetadata(mo26807c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", mo26808f = "Channels.common.kt", mo26809i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, mo26810l = {1882, 1885}, mo26811m = "maxBy", mo26812n = {"$this$maxBy", "selector", "$this$consume$iv", "cause$iv", "$this$consume", "iterator", "$this$maxBy", "selector", "$this$consume$iv", "cause$iv", "$this$consume", "iterator", "maxElem", "maxValue"}, mo26813s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"})
/* compiled from: Channels.common.kt */
public final class ChannelsKt__Channels_commonKt$maxBy$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__Channels_commonKt$maxBy$1(Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt.maxBy((ReceiveChannel) null, (Function1) null, this);
    }
}