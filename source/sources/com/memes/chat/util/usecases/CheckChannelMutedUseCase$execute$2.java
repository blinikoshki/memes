package com.memes.chat.util.usecases;

import com.memes.chat.util.Verifications;
import com.memes.chat.util.extensions.ChatErrorExtKt;
import com.memes.chat.util.usecases.CheckChannelMutedUseCase;
import java.util.Iterator;
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
import kotlinx.coroutines.CoroutineScope;
import p015io.getstream.chat.android.client.api.models.QueryChannelsRequest;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Filters;
import p015io.getstream.chat.android.client.utils.Result;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.util.usecases.CheckChannelMutedUseCase$execute$2", mo26808f = "CheckChannelMutedUseCase.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: CheckChannelMutedUseCase.kt */
final class CheckChannelMutedUseCase$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ CheckChannelMutedUseCase.Request $request;
    int label;
    final /* synthetic */ CheckChannelMutedUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckChannelMutedUseCase$execute$2(CheckChannelMutedUseCase checkChannelMutedUseCase, CheckChannelMutedUseCase.Request request, Continuation continuation) {
        super(2, continuation);
        this.this$0 = checkChannelMutedUseCase;
        this.$request = request;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new CheckChannelMutedUseCase$execute$2(this.this$0, this.$request, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CheckChannelMutedUseCase$execute$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            boolean z = false;
            Timber.m300d("execute: " + this.$request, new Object[0]);
            Verifications.INSTANCE.requireSignedIn(this.this$0.chatClient);
            Verifications.INSTANCE.requireChannelId(this.$request.getChannelId());
            Result<List<Channel>> execute = this.this$0.chatClient.queryChannels(new QueryChannelsRequest(Filters.and(Filters.m1007eq("cid", this.$request.getChannelId()), Filters.m1007eq("muted", Boxing.boxBoolean(true))), 0, 1, (QuerySort) null, 0, 0, 56, (DefaultConstructorMarker) null)).execute();
            if (!execute.isError()) {
                List data = execute.data();
                if (data.isEmpty()) {
                    return Boxing.boxBoolean(false);
                }
                Iterator it = data.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it.next();
                    if (Boxing.boxBoolean(Intrinsics.areEqual((Object) ((Channel) obj2).getCid(), (Object) this.$request.getChannelId())).booleanValue()) {
                        break;
                    }
                }
                if (obj2 != null) {
                    z = true;
                }
                return Boxing.boxBoolean(z);
            }
            throw new RuntimeException("Error: " + ChatErrorExtKt.displayableMessage(execute.error()));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
