package com.memes.chat.p036ui.channel;

import com.memes.chat.util.usecases.channelaccess.ChannelAccessResult;
import com.memes.commons.util.SingleLiveEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.ui.channel.ChannelAccessValidator$validateAccess$1", mo26808f = "ChannelAccessValidator.kt", mo26809i = {}, mo26810l = {28}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.chat.ui.channel.ChannelAccessValidator$validateAccess$1 */
/* compiled from: ChannelAccessValidator.kt */
final class ChannelAccessValidator$validateAccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelId;
    Object L$0;
    int label;
    final /* synthetic */ ChannelAccessValidator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelAccessValidator$validateAccess$1(ChannelAccessValidator channelAccessValidator, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = channelAccessValidator;
        this.$channelId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new ChannelAccessValidator$validateAccess$1(this.this$0, this.$channelId, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelAccessValidator$validateAccess$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        SingleLiveEvent singleLiveEvent;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0._channelAccessResult.setValue(ChannelAccessResult.Loading.INSTANCE);
            SingleLiveEvent access$get_channelAccessResult$p = this.this$0._channelAccessResult;
            ChannelAccessValidator channelAccessValidator = this.this$0;
            String str = this.$channelId;
            this.L$0 = access$get_channelAccessResult$p;
            this.label = 1;
            Object checkChannelAccess = channelAccessValidator.checkChannelAccess(str, this);
            if (checkChannelAccess == coroutine_suspended) {
                return coroutine_suspended;
            }
            singleLiveEvent = access$get_channelAccessResult$p;
            obj = checkChannelAccess;
        } else if (i == 1) {
            singleLiveEvent = (SingleLiveEvent) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        singleLiveEvent.setValue(obj);
        return Unit.INSTANCE;
    }
}
