package com.memes.chat.p036ui.channel.info;

import com.memes.chat.util.usecases.ChannelInfoUseCase;
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
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.ui.channel.info.ChannelInfoViewModel$fetchChannel$1", mo26808f = "ChannelInfoViewModel.kt", mo26809i = {}, mo26810l = {89, 95}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.chat.ui.channel.info.ChannelInfoViewModel$fetchChannel$1 */
/* compiled from: ChannelInfoViewModel.kt */
final class ChannelInfoViewModel$fetchChannel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelId;
    int label;
    final /* synthetic */ ChannelInfoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelInfoViewModel$fetchChannel$1(ChannelInfoViewModel channelInfoViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = channelInfoViewModel;
        this.$channelId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new ChannelInfoViewModel$fetchChannel$1(this.this$0, this.$channelId, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelInfoViewModel$fetchChannel$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ChannelInfoViewModel channelInfoViewModel = this.this$0;
            channelInfoViewModel.showProgress(channelInfoViewModel._channelContentLVisibility, "Fetching Channel Details..");
            ChannelInfoViewModel channelInfoViewModel2 = this.this$0;
            this.label = 1;
            obj = channelInfoViewModel2.checkChannelAccess(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            Channel channel = (Channel) obj;
            this.this$0.fetchChannelMuteStatus(this.$channelId);
            this.this$0.hasFetchedChannelAtLeastOnce = true;
            this.this$0.channel = channel;
            this.this$0._channel.setValue(channel);
            ChannelInfoViewModel channelInfoViewModel3 = this.this$0;
            channelInfoViewModel3.showContent(channelInfoViewModel3._channelContentLVisibility);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!((Boolean) obj).booleanValue()) {
            return Unit.INSTANCE;
        }
        ChannelInfoUseCase.Request request = new ChannelInfoUseCase.Request(this.$channelId);
        ChannelInfoUseCase access$getChannelInfoUseCase$p = this.this$0.getChannelInfoUseCase();
        this.label = 2;
        obj = access$getChannelInfoUseCase$p.execute(request, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        Channel channel2 = (Channel) obj;
        this.this$0.fetchChannelMuteStatus(this.$channelId);
        this.this$0.hasFetchedChannelAtLeastOnce = true;
        this.this$0.channel = channel2;
        this.this$0._channel.setValue(channel2);
        ChannelInfoViewModel channelInfoViewModel32 = this.this$0;
        channelInfoViewModel32.showContent(channelInfoViewModel32._channelContentLVisibility);
        return Unit.INSTANCE;
    }
}
