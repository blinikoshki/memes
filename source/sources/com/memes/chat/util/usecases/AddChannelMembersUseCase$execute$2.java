package com.memes.chat.util.usecases;

import com.memes.chat.util.Verifications;
import com.memes.chat.util.extensions.ChatErrorExtKt;
import com.memes.chat.util.usecases.AddChannelMembersUseCase;
import java.util.Arrays;
import java.util.Objects;
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
import p015io.getstream.chat.android.client.utils.Result;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/models/Channel;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.util.usecases.AddChannelMembersUseCase$execute$2", mo26808f = "AddChannelMembersUseCase.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: AddChannelMembersUseCase.kt */
final class AddChannelMembersUseCase$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Channel>, Object> {
    final /* synthetic */ AddChannelMembersUseCase.Request $request;
    int label;
    final /* synthetic */ AddChannelMembersUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddChannelMembersUseCase$execute$2(AddChannelMembersUseCase addChannelMembersUseCase, AddChannelMembersUseCase.Request request, Continuation continuation) {
        super(2, continuation);
        this.this$0 = addChannelMembersUseCase;
        this.$request = request;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new AddChannelMembersUseCase$execute$2(this.this$0, this.$request, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AddChannelMembersUseCase$execute$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.m300d("execute: " + this.$request, new Object[0]);
            Verifications.INSTANCE.requireSignedIn(this.this$0.chatClient);
            Verifications.INSTANCE.requireChannelId(this.$request.getChannelId());
            if (!this.$request.getNewChannelMemberIds().isEmpty()) {
                Object[] array = this.$request.getNewChannelMemberIds().toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                String[] strArr = (String[]) array;
                Result<Channel> execute = this.this$0.chatClient.channel(this.$request.getChannelId()).addMembers((String[]) Arrays.copyOf(strArr, strArr.length)).execute();
                if (!execute.isError()) {
                    return execute.data();
                }
                throw new RuntimeException(ChatErrorExtKt.displayableMessage(execute.error()));
            }
            throw new RuntimeException("Unable to add 0 members to chat");
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
