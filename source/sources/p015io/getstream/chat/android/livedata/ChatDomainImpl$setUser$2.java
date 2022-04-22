package p015io.getstream.chat.android.livedata;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import p015io.getstream.chat.android.livedata.model.SyncState;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/livedata/model/SyncState;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.ChatDomainImpl$setUser$2", mo26808f = "ChatDomainImpl.kt", mo26809i = {2, 3}, mo26810l = {253, 256, 261, 267}, mo26811m = "invokeSuspend", mo26812n = {"syncState", "syncState"}, mo26813s = {"L$0", "L$0"})
/* renamed from: io.getstream.chat.android.livedata.ChatDomainImpl$setUser$2 */
/* compiled from: ChatDomainImpl.kt */
final class ChatDomainImpl$setUser$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SyncState>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ChatDomainImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatDomainImpl$setUser$2(ChatDomainImpl chatDomainImpl, Continuation continuation) {
        super(2, continuation);
        this.this$0 = chatDomainImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new ChatDomainImpl$setUser$2(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChatDomainImpl$setUser$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0095 A[LOOP:0: B:22:0x008f->B:24:0x0095, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c0 A[LOOP:1: B:29:0x00ba->B:31:0x00c0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r6) goto L_0x0038
            if (r2 == r5) goto L_0x0032
            if (r2 == r4) goto L_0x0027
            if (r2 != r3) goto L_0x001f
            java.lang.Object r1 = r0.L$0
            io.getstream.chat.android.livedata.model.SyncState r1 = (p015io.getstream.chat.android.livedata.model.SyncState) r1
            kotlin.ResultKt.throwOnFailure(r18)
            goto L_0x0102
        L_0x001f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0027:
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.model.SyncState r2 = (p015io.getstream.chat.android.livedata.model.SyncState) r2
            kotlin.ResultKt.throwOnFailure(r18)
            r4 = r18
            goto L_0x00b4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r18)
            r2 = r18
            goto L_0x0067
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r18)
            goto L_0x004e
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r18)
            io.getstream.chat.android.livedata.ChatDomainImpl r2 = r0.this$0
            io.getstream.chat.android.livedata.repository.RepositoryFacade r2 = r2.getRepos$stream_chat_android_offline_release()
            r0.label = r6
            java.lang.Object r2 = r2.cacheChannelConfigs(r0)
            if (r2 != r1) goto L_0x004e
            return r1
        L_0x004e:
            io.getstream.chat.android.livedata.ChatDomainImpl r2 = r0.this$0
            io.getstream.chat.android.livedata.repository.RepositoryFacade r2 = r2.getRepos$stream_chat_android_offline_release()
            io.getstream.chat.android.livedata.ChatDomainImpl r6 = r0.this$0
            io.getstream.chat.android.client.models.User r6 = r6.getCurrentUser()
            java.lang.String r6 = r6.getId()
            r0.label = r5
            java.lang.Object r2 = r2.selectSyncState(r6, r0)
            if (r2 != r1) goto L_0x0067
            return r1
        L_0x0067:
            io.getstream.chat.android.livedata.model.SyncState r2 = (p015io.getstream.chat.android.livedata.model.SyncState) r2
            if (r2 == 0) goto L_0x006c
            goto L_0x0083
        L_0x006c:
            io.getstream.chat.android.livedata.model.SyncState r2 = new io.getstream.chat.android.livedata.model.SyncState
            io.getstream.chat.android.livedata.ChatDomainImpl r5 = r0.this$0
            io.getstream.chat.android.client.models.User r5 = r5.getCurrentUser()
            java.lang.String r6 = r5.getId()
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 30
            r12 = 0
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
        L_0x0083:
            java.util.List r5 = r2.getActiveChannelIds()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            io.getstream.chat.android.livedata.ChatDomainImpl r6 = r0.this$0
            java.util.Iterator r5 = r5.iterator()
        L_0x008f:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x009f
            java.lang.Object r7 = r5.next()
            java.lang.String r7 = (java.lang.String) r7
            r6.channel$stream_chat_android_offline_release((java.lang.String) r7)
            goto L_0x008f
        L_0x009f:
            io.getstream.chat.android.livedata.ChatDomainImpl r5 = r0.this$0
            io.getstream.chat.android.livedata.repository.RepositoryFacade r5 = r5.getRepos$stream_chat_android_offline_release()
            java.util.List r6 = r2.getActiveQueryIds()
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r4 = r5.selectQueriesChannelsByIds(r6, r0)
            if (r4 != r1) goto L_0x00b4
            return r1
        L_0x00b4:
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x00ba:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00d4
            java.lang.Object r5 = r4.next()
            io.getstream.chat.android.livedata.controller.QueryChannelsSpec r5 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsSpec) r5
            io.getstream.chat.android.livedata.ChatDomainImpl r6 = r0.this$0
            io.getstream.chat.android.client.utils.FilterObject r7 = r5.getFilter()
            io.getstream.chat.android.client.api.models.QuerySort r5 = r5.getSort()
            r6.queryChannels(r7, r5)
            goto L_0x00ba
        L_0x00d4:
            java.util.Date r10 = r2.getMarkedAllReadAt()
            if (r10 == 0) goto L_0x0103
            io.getstream.chat.android.client.events.MarkAllReadEvent r4 = new io.getstream.chat.android.client.events.MarkAllReadEvent
            r9 = 0
            io.getstream.chat.android.livedata.ChatDomainImpl r5 = r0.this$0
            io.getstream.chat.android.client.models.User r11 = r5.getCurrentUser()
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 57
            r16 = 0
            r8 = r4
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16)
            io.getstream.chat.android.livedata.ChatDomainImpl r5 = r0.this$0
            io.getstream.chat.android.livedata.EventHandlerImpl r5 = r5.getEventHandler$stream_chat_android_offline_release()
            io.getstream.chat.android.client.events.ChatEvent r4 = (p015io.getstream.chat.android.client.events.ChatEvent) r4
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r3 = r5.handleEvent$stream_chat_android_offline_release(r4, r0)
            if (r3 != r1) goto L_0x0101
            return r1
        L_0x0101:
            r1 = r2
        L_0x0102:
            r2 = r1
        L_0x0103:
            io.getstream.chat.android.livedata.ChatDomainImpl r1 = r0.this$0
            kotlinx.coroutines.flow.MutableStateFlow r1 = r1.syncStateFlow
            r1.setValue(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl$setUser$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
