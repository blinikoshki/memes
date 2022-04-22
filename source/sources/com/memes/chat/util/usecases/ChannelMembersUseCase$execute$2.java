package com.memes.chat.util.usecases;

import com.memes.chat.util.Verifications;
import com.memes.chat.util.extensions.ChatErrorExtKt;
import com.memes.chat.util.usecases.ChannelMembersUseCase;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.controllers.ChannelController;
import p015io.getstream.chat.android.client.models.Filters;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.utils.FilterObject;
import p015io.getstream.chat.android.client.utils.Result;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "", "Lio/getstream/chat/android/client/models/Member;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.util.usecases.ChannelMembersUseCase$execute$2", mo26808f = "ChannelMembersUseCase.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: ChannelMembersUseCase.kt */
final class ChannelMembersUseCase$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Member>>, Object> {
    final /* synthetic */ ChannelMembersUseCase.Request $request;
    int label;
    final /* synthetic */ ChannelMembersUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelMembersUseCase$execute$2(ChannelMembersUseCase channelMembersUseCase, ChannelMembersUseCase.Request request, Continuation continuation) {
        super(2, continuation);
        this.this$0 = channelMembersUseCase;
        this.$request = request;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new ChannelMembersUseCase$execute$2(this.this$0, this.$request, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelMembersUseCase$execute$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.m300d("execute: " + this.$request, new Object[0]);
            Verifications.INSTANCE.requireSignedIn(this.this$0.chatClient);
            Verifications.INSTANCE.requireChannelId(this.$request.getChannelId());
            FilterObject eq = Filters.m1007eq("banned", Boxing.boxBoolean(false));
            int offset = this.$request.getOffset();
            int limit = this.$request.getLimit();
            QuerySort.Companion companion = QuerySort.Companion;
            Result execute = ChannelController.DefaultImpls.queryMembers$default(this.this$0.chatClient.channel(this.$request.getChannelId()), offset, limit, eq, new QuerySort().asc("name", Reflection.getOrCreateKotlinClass(Member.class)), (List) null, 16, (Object) null).execute();
            if (!execute.isError()) {
                return execute.data();
            }
            throw new RuntimeException(ChatErrorExtKt.displayableMessage(execute.error()));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
