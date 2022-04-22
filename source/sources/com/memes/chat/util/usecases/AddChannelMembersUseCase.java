package com.memes.chat.util.usecases;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/AddChannelMembersUseCase;", "", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "(Lio/getstream/chat/android/client/ChatClient;)V", "execute", "Lio/getstream/chat/android/client/models/Channel;", "request", "Lcom/memes/chat/util/usecases/AddChannelMembersUseCase$Request;", "(Lcom/memes/chat/util/usecases/AddChannelMembersUseCase$Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Request", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AddChannelMembersUseCase.kt */
public final class AddChannelMembersUseCase {
    /* access modifiers changed from: private */
    public final ChatClient chatClient;

    public AddChannelMembersUseCase(ChatClient chatClient2) {
        Intrinsics.checkNotNullParameter(chatClient2, "chatClient");
        this.chatClient = chatClient2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/AddChannelMembersUseCase$Request;", "", "channelId", "", "newChannelMemberIds", "", "(Ljava/lang/String;Ljava/util/List;)V", "getChannelId", "()Ljava/lang/String;", "getNewChannelMemberIds", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: AddChannelMembersUseCase.kt */
    public static final class Request {
        private final String channelId;
        private final List<String> newChannelMemberIds;

        public static /* synthetic */ Request copy$default(Request request, String str, List<String> list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = request.channelId;
            }
            if ((i & 2) != 0) {
                list = request.newChannelMemberIds;
            }
            return request.copy(str, list);
        }

        public final String component1() {
            return this.channelId;
        }

        public final List<String> component2() {
            return this.newChannelMemberIds;
        }

        public final Request copy(String str, List<String> list) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intrinsics.checkNotNullParameter(list, "newChannelMemberIds");
            return new Request(str, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Request)) {
                return false;
            }
            Request request = (Request) obj;
            return Intrinsics.areEqual((Object) this.channelId, (Object) request.channelId) && Intrinsics.areEqual((Object) this.newChannelMemberIds, (Object) request.newChannelMemberIds);
        }

        public int hashCode() {
            String str = this.channelId;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            List<String> list = this.newChannelMemberIds;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Request(channelId=" + this.channelId + ", newChannelMemberIds=" + this.newChannelMemberIds + ")";
        }

        public Request(String str, List<String> list) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intrinsics.checkNotNullParameter(list, "newChannelMemberIds");
            this.channelId = str;
            this.newChannelMemberIds = list;
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final List<String> getNewChannelMemberIds() {
            return this.newChannelMemberIds;
        }
    }

    public final Object execute(Request request, Continuation<? super Channel> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AddChannelMembersUseCase$execute$2(this, request, (Continuation) null), continuation);
    }
}
