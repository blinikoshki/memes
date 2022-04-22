package p015io.getstream.chat.android.livedata;

import com.facebook.share.internal.ShareConstants;
import com.google.firebase.messaging.Constants;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt;
import p015io.getstream.chat.android.livedata.repository.RepositoryFacade;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001!BK\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\tJ \u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000bJ\u0014\u0010\u0018\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aJ\u0011\u0010\u001b\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u0006J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, mo26107d2 = {"Lio/getstream/chat/android/livedata/EventBatchUpdate;", "", "domainImpl", "Lio/getstream/chat/android/livedata/ChatDomainImpl;", "channelMap", "", "", "Lio/getstream/chat/android/client/models/Channel;", "messageMap", "Lio/getstream/chat/android/client/models/Message;", "userMap", "Lio/getstream/chat/android/client/models/User;", "(Lio/getstream/chat/android/livedata/ChatDomainImpl;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "addChannel", "", "channel", "addMessage", "message", "addMessageData", "cid", "isNewMessage", "", "addUser", "newUser", "addUsers", "newUsers", "", "execute", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentChannel", "cId", "getCurrentMessage", "messageId", "Builder", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.EventBatchUpdate */
/* compiled from: EventBatchUpdate.kt */
public final class EventBatchUpdate {
    private final Map<String, Channel> channelMap;
    private final ChatDomainImpl domainImpl;
    private final Map<String, Message> messageMap;
    private final Map<String, User> userMap;

    private EventBatchUpdate(ChatDomainImpl chatDomainImpl, Map<String, Channel> map, Map<String, Message> map2, Map<String, User> map3) {
        this.domainImpl = chatDomainImpl;
        this.channelMap = map;
        this.messageMap = map2;
        this.userMap = map3;
    }

    public /* synthetic */ EventBatchUpdate(ChatDomainImpl chatDomainImpl, Map map, Map map2, Map map3, DefaultConstructorMarker defaultConstructorMarker) {
        this(chatDomainImpl, map, map2, map3);
    }

    public static /* synthetic */ void addMessageData$default(EventBatchUpdate eventBatchUpdate, String str, Message message, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        eventBatchUpdate.addMessageData(str, message, z);
    }

    public final void addMessageData(String str, Message message, boolean z) {
        Intrinsics.checkNotNullParameter(str, "cid");
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        addMessage(message);
        Channel currentChannel = getCurrentChannel(str);
        if (currentChannel != null) {
            ClientExtensionsKt.updateLastMessage(currentChannel, message);
            String id = this.domainImpl.getCurrentUser().getId();
            if (z && ClientExtensionsKt.shouldIncrementUnreadCount(message, id)) {
                ClientExtensionsKt.incrementUnreadCount(currentChannel, id);
            }
        }
    }

    public final void addChannel(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        addUsers(ClientExtensionsKt.users(channel));
        Map<String, Channel> map = this.channelMap;
        Pair pair = TuplesKt.m181to(channel.getCid(), channel);
        map.put(pair.getFirst(), pair.getSecond());
    }

    public final Channel getCurrentChannel(String str) {
        Intrinsics.checkNotNullParameter(str, "cId");
        return this.channelMap.get(str);
    }

    public final Message getCurrentMessage(String str) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return this.messageMap.get(str);
    }

    public final void addMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        addUsers(ClientExtensionsKt.users(message));
        Map<String, Message> map = this.messageMap;
        Pair pair = TuplesKt.m181to(message.getId(), message);
        map.put(pair.getFirst(), pair.getSecond());
    }

    public final void addUsers(List<User> list) {
        Intrinsics.checkNotNullParameter(list, "newUsers");
        Map<String, User> map = this.userMap;
        Iterable iterable = list;
        Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(((User) next).getId(), next);
        }
        map.putAll(linkedHashMap);
    }

    public final void addUser(User user) {
        Intrinsics.checkNotNullParameter(user, "newUser");
        Map<String, User> map = this.userMap;
        Pair pair = TuplesKt.m181to(user.getId(), user);
        map.put(pair.getFirst(), pair.getSecond());
    }

    public final Object execute(Continuation<? super Unit> continuation) {
        this.userMap.remove(this.domainImpl.getCurrentUser().getId());
        Object storeStateForChannels$stream_chat_android_offline_release$default = RepositoryFacade.m1016xb6c4b435(this.domainImpl.getRepos$stream_chat_android_offline_release(), (Collection) null, CollectionsKt.toList(this.userMap.values()), this.channelMap.values(), CollectionsKt.toList(this.messageMap.values()), true, continuation, 1, (Object) null);
        if (storeStateForChannels$stream_chat_android_offline_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return storeStateForChannels$stream_chat_android_offline_release$default;
        }
        return Unit.INSTANCE;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u0014\u0010\t\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0005J\u0014\u0010\u000e\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\rJ\u0014\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\rJ\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/EventBatchUpdate$Builder;", "", "()V", "channelsToFetch", "", "", "messagesToFetch", "users", "Lio/getstream/chat/android/client/models/User;", "addToFetchChannels", "", "cId", "cIds", "", "addToFetchMessages", "id", "ids", "addUsers", "usersToAdd", "build", "Lio/getstream/chat/android/livedata/EventBatchUpdate;", "domainImpl", "Lio/getstream/chat/android/livedata/ChatDomainImpl;", "(Lio/getstream/chat/android/livedata/ChatDomainImpl;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.EventBatchUpdate$Builder */
    /* compiled from: EventBatchUpdate.kt */
    public static final class Builder {
        private final Set<String> channelsToFetch = new LinkedHashSet();
        private final Set<String> messagesToFetch = new LinkedHashSet();
        private final Set<User> users = new LinkedHashSet();

        public final void addToFetchChannels(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "cIds");
            CollectionsKt.addAll(this.channelsToFetch, list);
        }

        public final void addToFetchChannels(String str) {
            Intrinsics.checkNotNullParameter(str, "cId");
            this.channelsToFetch.add(str);
        }

        public final void addToFetchMessages(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "ids");
            CollectionsKt.addAll(this.messagesToFetch, list);
        }

        public final void addToFetchMessages(String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            this.messagesToFetch.add(str);
        }

        public final void addUsers(List<User> list) {
            Intrinsics.checkNotNullParameter(list, "usersToAdd");
            CollectionsKt.addAll(this.users, list);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0090 A[LOOP:0: B:19:0x008a->B:21:0x0090, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00b9 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00ba  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00dc A[LOOP:1: B:27:0x00d6->B:29:0x00dc, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0114 A[LOOP:2: B:31:0x010e->B:33:0x0114, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object build(p015io.getstream.chat.android.livedata.ChatDomainImpl r14, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.livedata.EventBatchUpdate> r15) {
            /*
                r13 = this;
                boolean r0 = r15 instanceof p015io.getstream.chat.android.livedata.EventBatchUpdate$Builder$build$1
                if (r0 == 0) goto L_0x0014
                r0 = r15
                io.getstream.chat.android.livedata.EventBatchUpdate$Builder$build$1 r0 = (p015io.getstream.chat.android.livedata.EventBatchUpdate$Builder$build$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L_0x0014
                int r15 = r0.label
                int r15 = r15 - r2
                r0.label = r15
                goto L_0x0019
            L_0x0014:
                io.getstream.chat.android.livedata.EventBatchUpdate$Builder$build$1 r0 = new io.getstream.chat.android.livedata.EventBatchUpdate$Builder$build$1
                r0.<init>(r13, r15)
            L_0x0019:
                java.lang.Object r15 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                r5 = 16
                r6 = 10
                if (r2 == 0) goto L_0x0053
                if (r2 == r4) goto L_0x0047
                if (r2 != r3) goto L_0x003f
                java.lang.Object r14 = r0.L$2
                java.util.Map r14 = (java.util.Map) r14
                java.lang.Object r1 = r0.L$1
                io.getstream.chat.android.livedata.ChatDomainImpl r1 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r1
                java.lang.Object r0 = r0.L$0
                io.getstream.chat.android.livedata.EventBatchUpdate$Builder r0 = (p015io.getstream.chat.android.livedata.EventBatchUpdate.Builder) r0
                kotlin.ResultKt.throwOnFailure(r15)
                r8 = r1
                goto L_0x00bd
            L_0x003f:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r15)
                throw r14
            L_0x0047:
                java.lang.Object r14 = r0.L$1
                io.getstream.chat.android.livedata.ChatDomainImpl r14 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r14
                java.lang.Object r2 = r0.L$0
                io.getstream.chat.android.livedata.EventBatchUpdate$Builder r2 = (p015io.getstream.chat.android.livedata.EventBatchUpdate.Builder) r2
                kotlin.ResultKt.throwOnFailure(r15)
                goto L_0x0070
            L_0x0053:
                kotlin.ResultKt.throwOnFailure(r15)
                io.getstream.chat.android.livedata.repository.RepositoryFacade r15 = r14.getRepos$stream_chat_android_offline_release()
                java.util.Set<java.lang.String> r2 = r13.messagesToFetch
                java.lang.Iterable r2 = (java.lang.Iterable) r2
                java.util.List r2 = kotlin.collections.CollectionsKt.toList(r2)
                r0.L$0 = r13
                r0.L$1 = r14
                r0.label = r4
                java.lang.Object r15 = r15.selectMessages(r2, r0)
                if (r15 != r1) goto L_0x006f
                return r1
            L_0x006f:
                r2 = r13
            L_0x0070:
                java.lang.Iterable r15 = (java.lang.Iterable) r15
                int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r15, r6)
                int r4 = kotlin.collections.MapsKt.mapCapacity(r4)
                int r4 = kotlin.ranges.RangesKt.coerceAtLeast((int) r4, (int) r5)
                java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
                r7.<init>(r4)
                r4 = r7
                java.util.Map r4 = (java.util.Map) r4
                java.util.Iterator r15 = r15.iterator()
            L_0x008a:
                boolean r7 = r15.hasNext()
                if (r7 == 0) goto L_0x009f
                java.lang.Object r7 = r15.next()
                r8 = r7
                io.getstream.chat.android.client.models.Message r8 = (p015io.getstream.chat.android.client.models.Message) r8
                java.lang.String r8 = r8.getId()
                r4.put(r8, r7)
                goto L_0x008a
            L_0x009f:
                io.getstream.chat.android.livedata.repository.RepositoryFacade r15 = r14.getRepos$stream_chat_android_offline_release()
                java.util.Set<java.lang.String> r7 = r2.channelsToFetch
                java.lang.Iterable r7 = (java.lang.Iterable) r7
                java.util.List r7 = kotlin.collections.CollectionsKt.toList(r7)
                r0.L$0 = r2
                r0.L$1 = r14
                r0.L$2 = r4
                r0.label = r3
                java.lang.Object r15 = r15.selectChannels(r7, r0)
                if (r15 != r1) goto L_0x00ba
                return r1
            L_0x00ba:
                r8 = r14
                r0 = r2
                r14 = r4
            L_0x00bd:
                java.lang.Iterable r15 = (java.lang.Iterable) r15
                int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r15, r6)
                int r1 = kotlin.collections.MapsKt.mapCapacity(r1)
                int r1 = kotlin.ranges.RangesKt.coerceAtLeast((int) r1, (int) r5)
                java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
                r2.<init>(r1)
                java.util.Map r2 = (java.util.Map) r2
                java.util.Iterator r15 = r15.iterator()
            L_0x00d6:
                boolean r1 = r15.hasNext()
                if (r1 == 0) goto L_0x00eb
                java.lang.Object r1 = r15.next()
                r3 = r1
                io.getstream.chat.android.client.models.Channel r3 = (p015io.getstream.chat.android.client.models.Channel) r3
                java.lang.String r3 = r3.getCid()
                r2.put(r3, r1)
                goto L_0x00d6
            L_0x00eb:
                java.util.Map r9 = kotlin.collections.MapsKt.toMutableMap(r2)
                java.util.Map r10 = kotlin.collections.MapsKt.toMutableMap(r14)
                java.util.Set<io.getstream.chat.android.client.models.User> r14 = r0.users
                java.lang.Iterable r14 = (java.lang.Iterable) r14
                int r15 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r14, r6)
                int r15 = kotlin.collections.MapsKt.mapCapacity(r15)
                int r15 = kotlin.ranges.RangesKt.coerceAtLeast((int) r15, (int) r5)
                java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
                r0.<init>(r15)
                java.util.Map r0 = (java.util.Map) r0
                java.util.Iterator r14 = r14.iterator()
            L_0x010e:
                boolean r15 = r14.hasNext()
                if (r15 == 0) goto L_0x0123
                java.lang.Object r15 = r14.next()
                r1 = r15
                io.getstream.chat.android.client.models.User r1 = (p015io.getstream.chat.android.client.models.User) r1
                java.lang.String r1 = r1.getId()
                r0.put(r1, r15)
                goto L_0x010e
            L_0x0123:
                java.util.Map r11 = kotlin.collections.MapsKt.toMutableMap(r0)
                r12 = 0
                io.getstream.chat.android.livedata.EventBatchUpdate r14 = new io.getstream.chat.android.livedata.EventBatchUpdate
                r7 = r14
                r7.<init>(r8, r9, r10, r11, r12)
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.EventBatchUpdate.Builder.build(io.getstream.chat.android.livedata.ChatDomainImpl, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
