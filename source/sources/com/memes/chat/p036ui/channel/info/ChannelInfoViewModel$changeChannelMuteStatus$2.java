package com.memes.chat.p036ui.channel.info;

import com.memes.chat.p036ui.channel.options.ChannelMuteStatus;
import com.memes.chat.util.usecases.ChannelMutingUseCase;
import com.memes.commons.viewmodel.BaseViewModel;
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
@DebugMetadata(mo26807c = "com.memes.chat.ui.channel.info.ChannelInfoViewModel$changeChannelMuteStatus$2", mo26808f = "ChannelInfoViewModel.kt", mo26809i = {}, mo26810l = {206}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.chat.ui.channel.info.ChannelInfoViewModel$changeChannelMuteStatus$2 */
/* compiled from: ChannelInfoViewModel.kt */
final class ChannelInfoViewModel$changeChannelMuteStatus$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChannelMuteStatus $channelMuteStatus;
    final /* synthetic */ boolean $isMuted;
    int label;
    final /* synthetic */ ChannelInfoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelInfoViewModel$changeChannelMuteStatus$2(ChannelInfoViewModel channelInfoViewModel, boolean z, ChannelMuteStatus channelMuteStatus, Continuation continuation) {
        super(2, continuation);
        this.this$0 = channelInfoViewModel;
        this.$isMuted = z;
        this.$channelMuteStatus = channelMuteStatus;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new ChannelInfoViewModel$changeChannelMuteStatus$2(this.this$0, this.$isMuted, this.$channelMuteStatus, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelInfoViewModel$changeChannelMuteStatus$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ChannelMutingUseCase.RequestType requestType;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BaseViewModel.showBlockingProgressDialog$default(this.this$0, (String) null, 1, (Object) null);
            if (this.$isMuted) {
                requestType = ChannelMutingUseCase.RequestType.MUTE;
            } else {
                requestType = ChannelMutingUseCase.RequestType.UNMUTE;
            }
            ChannelMutingUseCase.Request request = new ChannelMutingUseCase.Request(requestType, ChannelInfoViewModel.access$getChannelId$p(this.this$0));
            ChannelMutingUseCase access$getChannelMutingUseCase$p = this.this$0.getChannelMutingUseCase();
            this.label = 1;
            if (access$getChannelMutingUseCase$p.execute(request, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.hideBlockingProgressDialog();
        this.this$0.updateChannelMuteStatus(this.$channelMuteStatus);
        return Unit.INSTANCE;
    }
}
