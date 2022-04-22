package com.memes.chat.util.usecases;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.models.Member;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/ChannelMembersUseCase;", "", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "(Lio/getstream/chat/android/client/ChatClient;)V", "execute", "", "Lio/getstream/chat/android/client/models/Member;", "request", "Lcom/memes/chat/util/usecases/ChannelMembersUseCase$Request;", "(Lcom/memes/chat/util/usecases/ChannelMembersUseCase$Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Request", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChannelMembersUseCase.kt */
public final class ChannelMembersUseCase {
    /* access modifiers changed from: private */
    public final ChatClient chatClient;

    public ChannelMembersUseCase(ChatClient chatClient2) {
        Intrinsics.checkNotNullParameter(chatClient2, "chatClient");
        this.chatClient = chatClient2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/ChannelMembersUseCase$Request;", "", "channelId", "", "offset", "", "limit", "(Ljava/lang/String;II)V", "getChannelId", "()Ljava/lang/String;", "getLimit", "()I", "getOffset", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChannelMembersUseCase.kt */
    public static final class Request {
        private final String channelId;
        private final int limit;
        private final int offset;

        public static /* synthetic */ Request copy$default(Request request, String str, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = request.channelId;
            }
            if ((i3 & 2) != 0) {
                i = request.offset;
            }
            if ((i3 & 4) != 0) {
                i2 = request.limit;
            }
            return request.copy(str, i, i2);
        }

        public final String component1() {
            return this.channelId;
        }

        public final int component2() {
            return this.offset;
        }

        public final int component3() {
            return this.limit;
        }

        public final Request copy(String str, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            return new Request(str, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Request)) {
                return false;
            }
            Request request = (Request) obj;
            return Intrinsics.areEqual((Object) this.channelId, (Object) request.channelId) && this.offset == request.offset && this.limit == request.limit;
        }

        public int hashCode() {
            String str = this.channelId;
            return ((((str != null ? str.hashCode() : 0) * 31) + this.offset) * 31) + this.limit;
        }

        public String toString() {
            return "Request(channelId=" + this.channelId + ", offset=" + this.offset + ", limit=" + this.limit + ")";
        }

        public Request(String str, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            this.channelId = str;
            this.offset = i;
            this.limit = i2;
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final int getLimit() {
            return this.limit;
        }
    }

    public final Object execute(Request request, Continuation<? super List<Member>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ChannelMembersUseCase$execute$2(this, request, (Continuation) null), continuation);
    }
}
