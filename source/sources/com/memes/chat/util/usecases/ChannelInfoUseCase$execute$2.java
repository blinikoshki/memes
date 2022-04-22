package com.memes.chat.util.usecases;

import com.memes.chat.util.Verifications;
import com.memes.chat.util.extensions.ChannelExtKt;
import com.memes.chat.util.extensions.ChatErrorExtKt;
import com.memes.chat.util.usecases.ChannelInfoUseCase;
import java.util.Iterator;
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
import p015io.getstream.chat.android.client.api.models.QueryChannelRequest;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.Result;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/models/Channel;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.util.usecases.ChannelInfoUseCase$execute$2", mo26808f = "ChannelInfoUseCase.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: ChannelInfoUseCase.kt */
final class ChannelInfoUseCase$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Channel>, Object> {
    final /* synthetic */ ChannelInfoUseCase.Request $request;
    int label;
    final /* synthetic */ ChannelInfoUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelInfoUseCase$execute$2(ChannelInfoUseCase channelInfoUseCase, ChannelInfoUseCase.Request request, Continuation continuation) {
        super(2, continuation);
        this.this$0 = channelInfoUseCase;
        this.$request = request;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new ChannelInfoUseCase$execute$2(this.this$0, this.$request, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelInfoUseCase$execute$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            boolean z = false;
            Timber.m300d("execute: " + this.$request, new Object[0]);
            User requireSignedIn = Verifications.INSTANCE.requireSignedIn(this.this$0.chatClient);
            Verifications.INSTANCE.requireChannelId(this.$request.getChannelId());
            Result<Channel> execute = this.this$0.chatClient.channel(this.$request.getChannelId()).query(new QueryChannelRequest()).execute();
            if (!execute.isError()) {
                Channel data = execute.data();
                if (!ChannelExtKt.isGlobal(data)) {
                    Iterator<Member> it = data.getMembers().iterator();
                    int i = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i = -1;
                            break;
                        } else if (Boxing.boxBoolean(Intrinsics.areEqual((Object) it.next().getUserId(), (Object) requireSignedIn.getId())).booleanValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i != -1) {
                        z = true;
                    }
                    if (!z) {
                        throw new IllegalStateException("You're no longer a member of this chat.");
                    }
                }
                return data;
            }
            throw new RuntimeException(ChatErrorExtKt.displayableMessage(execute.error()));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
