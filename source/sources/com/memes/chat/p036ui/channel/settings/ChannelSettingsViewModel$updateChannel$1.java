package com.memes.chat.p036ui.channel.settings;

import com.memes.chat.util.usecases.UpdateChannelUseCase;
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
@DebugMetadata(mo26807c = "com.memes.chat.ui.channel.settings.ChannelSettingsViewModel$updateChannel$1", mo26808f = "ChannelSettingsViewModel.kt", mo26809i = {}, mo26810l = {150, 158}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.chat.ui.channel.settings.ChannelSettingsViewModel$updateChannel$1 */
/* compiled from: ChannelSettingsViewModel.kt */
final class ChannelSettingsViewModel$updateChannel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelName;
    int label;
    final /* synthetic */ ChannelSettingsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelSettingsViewModel$updateChannel$1(ChannelSettingsViewModel channelSettingsViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = channelSettingsViewModel;
        this.$channelName = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new ChannelSettingsViewModel$updateChannel$1(this.this$0, this.$channelName, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelSettingsViewModel$updateChannel$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.showBlockingProgressDialog("Updating Information..");
            ChannelSettingsViewModel channelSettingsViewModel = this.this$0;
            this.label = 1;
            obj = channelSettingsViewModel.fetchChannelImageUrl(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            Channel channel = (Channel) obj;
            this.this$0.setChannel(channel);
            this.this$0.hideBlockingProgressDialog();
            this.this$0._channelUpdated.setValue(channel);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        UpdateChannelUseCase.Request request = new UpdateChannelUseCase.Request(ChannelSettingsViewModel.access$getChannel$p(this.this$0), this.$channelName, (String) obj);
        UpdateChannelUseCase access$getUpdateChannelUseCase$p = this.this$0.updateChannelUseCase;
        this.label = 2;
        obj = access$getUpdateChannelUseCase$p.execute(request, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        Channel channel2 = (Channel) obj;
        this.this$0.setChannel(channel2);
        this.this$0.hideBlockingProgressDialog();
        this.this$0._channelUpdated.setValue(channel2);
        return Unit.INSTANCE;
    }
}
