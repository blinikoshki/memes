package com.memes.chat.util.usecases;

import com.memes.chat.util.Verifications;
import com.memes.chat.util.usecases.CreateChannelUseCase;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.Result;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0003*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/utils/Result;", "Lio/getstream/chat/android/client/models/Channel;", "Lcom/memes/chat/util/CreateChannelResult;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.util.usecases.CreateChannelUseCase$execute$2", mo26808f = "CreateChannelUseCase.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: CreateChannelUseCase.kt */
final class CreateChannelUseCase$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<Channel>>, Object> {
    final /* synthetic */ CreateChannelUseCase.Request $request;
    int label;
    final /* synthetic */ CreateChannelUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateChannelUseCase$execute$2(CreateChannelUseCase createChannelUseCase, CreateChannelUseCase.Request request, Continuation continuation) {
        super(2, continuation);
        this.this$0 = createChannelUseCase;
        this.$request = request;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new CreateChannelUseCase$execute$2(this.this$0, this.$request, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CreateChannelUseCase$execute$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.m300d("execute: " + this.$request, new Object[0]);
            User requireSignedIn = Verifications.INSTANCE.requireSignedIn(this.this$0.chatClient);
            CreateChannelUseCase.Request request = this.$request;
            if (request instanceof CreateChannelUseCase.Request.SingleUserChatRequest) {
                return this.this$0.createSingleUserChannel(requireSignedIn, (CreateChannelUseCase.Request.SingleUserChatRequest) request);
            }
            if (request instanceof CreateChannelUseCase.Request.MultiUserChatRequest) {
                return this.this$0.createMultiUserChannel(requireSignedIn, (CreateChannelUseCase.Request.MultiUserChatRequest) request);
            }
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
