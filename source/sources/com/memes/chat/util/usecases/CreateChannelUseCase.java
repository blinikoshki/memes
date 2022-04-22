package com.memes.chat.util.usecases;

import com.memes.chat.util.Strings;
import com.memes.chat.util.Verifications;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0002J#\u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b2\u0006\u0010\u000b\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/CreateChannelUseCase;", "", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "(Lio/getstream/chat/android/client/ChatClient;)V", "createMultiUserChannel", "Lio/getstream/chat/android/client/utils/Result;", "Lio/getstream/chat/android/client/models/Channel;", "Lcom/memes/chat/util/CreateChannelResult;", "currentUser", "Lio/getstream/chat/android/client/models/User;", "request", "Lcom/memes/chat/util/usecases/CreateChannelUseCase$Request$MultiUserChatRequest;", "createSingleUserChannel", "Lcom/memes/chat/util/usecases/CreateChannelUseCase$Request$SingleUserChatRequest;", "execute", "Lcom/memes/chat/util/usecases/CreateChannelUseCase$Request;", "(Lcom/memes/chat/util/usecases/CreateChannelUseCase$Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Request", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CreateChannelUseCase.kt */
public final class CreateChannelUseCase {
    /* access modifiers changed from: private */
    public final ChatClient chatClient;

    public CreateChannelUseCase(ChatClient chatClient2) {
        Intrinsics.checkNotNullParameter(chatClient2, "chatClient");
        this.chatClient = chatClient2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\t\n¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/CreateChannelUseCase$Request;", "", "()V", "channelType", "", "getChannelType", "()Ljava/lang/String;", "MultiUserChatRequest", "SingleUserChatRequest", "Lcom/memes/chat/util/usecases/CreateChannelUseCase$Request$SingleUserChatRequest;", "Lcom/memes/chat/util/usecases/CreateChannelUseCase$Request$MultiUserChatRequest;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: CreateChannelUseCase.kt */
    public static abstract class Request {
        public abstract String getChannelType();

        private Request() {
        }

        public /* synthetic */ Request(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/CreateChannelUseCase$Request$SingleUserChatRequest;", "Lcom/memes/chat/util/usecases/CreateChannelUseCase$Request;", "user", "Lio/getstream/chat/android/client/models/User;", "(Lio/getstream/chat/android/client/models/User;)V", "channelType", "", "getChannelType", "()Ljava/lang/String;", "getUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: CreateChannelUseCase.kt */
        public static final class SingleUserChatRequest extends Request {
            private final String channelType = "messaging";
            private final User user;

            public static /* synthetic */ SingleUserChatRequest copy$default(SingleUserChatRequest singleUserChatRequest, User user2, int i, Object obj) {
                if ((i & 1) != 0) {
                    user2 = singleUserChatRequest.user;
                }
                return singleUserChatRequest.copy(user2);
            }

            public final User component1() {
                return this.user;
            }

            public final SingleUserChatRequest copy(User user2) {
                Intrinsics.checkNotNullParameter(user2, "user");
                return new SingleUserChatRequest(user2);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof SingleUserChatRequest) && Intrinsics.areEqual((Object) this.user, (Object) ((SingleUserChatRequest) obj).user);
                }
                return true;
            }

            public int hashCode() {
                User user2 = this.user;
                if (user2 != null) {
                    return user2.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "SingleUserChatRequest(user=" + this.user + ")";
            }

            public final User getUser() {
                return this.user;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SingleUserChatRequest(User user2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(user2, "user");
                this.user = user2;
            }

            public String getChannelType() {
                return this.channelType;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0003J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\u0006\u0010\u0019\u001a\u00020\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\t\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/CreateChannelUseCase$Request$MultiUserChatRequest;", "Lcom/memes/chat/util/usecases/CreateChannelUseCase$Request;", "name", "", "image", "users", "", "Lio/getstream/chat/android/client/models/User;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "channelType", "getChannelType", "()Ljava/lang/String;", "getImage", "getName", "getUsers", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "createId", "equals", "", "other", "", "hasMembers", "hashCode", "", "toString", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: CreateChannelUseCase.kt */
        public static final class MultiUserChatRequest extends Request {
            private final String channelType = "messaging";
            private final String image;
            private final String name;
            private final List<User> users;

            public static /* synthetic */ MultiUserChatRequest copy$default(MultiUserChatRequest multiUserChatRequest, String str, String str2, List<User> list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = multiUserChatRequest.name;
                }
                if ((i & 2) != 0) {
                    str2 = multiUserChatRequest.image;
                }
                if ((i & 4) != 0) {
                    list = multiUserChatRequest.users;
                }
                return multiUserChatRequest.copy(str, str2, list);
            }

            public final String component1() {
                return this.name;
            }

            public final String component2() {
                return this.image;
            }

            public final List<User> component3() {
                return this.users;
            }

            public final MultiUserChatRequest copy(String str, String str2, List<User> list) {
                Intrinsics.checkNotNullParameter(str, "name");
                Intrinsics.checkNotNullParameter(str2, "image");
                Intrinsics.checkNotNullParameter(list, "users");
                return new MultiUserChatRequest(str, str2, list);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MultiUserChatRequest)) {
                    return false;
                }
                MultiUserChatRequest multiUserChatRequest = (MultiUserChatRequest) obj;
                return Intrinsics.areEqual((Object) this.name, (Object) multiUserChatRequest.name) && Intrinsics.areEqual((Object) this.image, (Object) multiUserChatRequest.image) && Intrinsics.areEqual((Object) this.users, (Object) multiUserChatRequest.users);
            }

            public int hashCode() {
                String str = this.name;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.image;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                List<User> list = this.users;
                if (list != null) {
                    i = list.hashCode();
                }
                return hashCode2 + i;
            }

            public String toString() {
                return "MultiUserChatRequest(name=" + this.name + ", image=" + this.image + ", users=" + this.users + ")";
            }

            public final String getName() {
                return this.name;
            }

            public final String getImage() {
                return this.image;
            }

            public final List<User> getUsers() {
                return this.users;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MultiUserChatRequest(String str, String str2, List<User> list) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "name");
                Intrinsics.checkNotNullParameter(str2, "image");
                Intrinsics.checkNotNullParameter(list, "users");
                this.name = str;
                this.image = str2;
                this.users = list;
            }

            public String getChannelType() {
                return this.channelType;
            }

            public final String createId() {
                return "memes-muc-" + UUID.randomUUID();
            }

            public final boolean hasMembers() {
                return !this.users.isEmpty();
            }
        }
    }

    public final Object execute(Request request, Continuation<? super Result<Channel>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new CreateChannelUseCase$execute$2(this, request, (Continuation) null), continuation);
    }

    /* access modifiers changed from: private */
    public final Result<Channel> createSingleUserChannel(User user, Request.SingleUserChatRequest singleUserChatRequest) {
        return this.chatClient.createChannel(singleUserChatRequest.getChannelType(), (List<String>) CollectionsKt.listOf(user.getId(), Verifications.INSTANCE.requireUserId(singleUserChatRequest.getUser().getId())), (Map<String, ? extends Object>) new HashMap()).execute();
    }

    /* access modifiers changed from: private */
    public final Result<Channel> createMultiUserChannel(User user, Request.MultiUserChatRequest multiUserChatRequest) {
        if (multiUserChatRequest.hasMembers()) {
            String channelType = multiUserChatRequest.getChannelType();
            String createId = multiUserChatRequest.createId();
            List arrayList = new ArrayList();
            arrayList.add(user.getId());
            Iterable<User> users = multiUserChatRequest.getUsers();
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(users, 10));
            for (User id : users) {
                arrayList2.add(id.getId());
            }
            arrayList.addAll((List) arrayList2);
            HashMap hashMap = new HashMap();
            String name = multiUserChatRequest.getName();
            if (!StringsKt.isBlank(name)) {
                hashMap.put("name", name);
            }
            String image = multiUserChatRequest.getImage();
            if (!StringsKt.isBlank(image)) {
                hashMap.put("image", image);
            }
            return this.chatClient.createChannel(channelType, createId, arrayList, hashMap).execute();
        }
        throw new RuntimeException(Strings.INSTANCE.errorCreatingChannelWithoutMembers());
    }
}
