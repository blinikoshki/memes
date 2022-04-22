package com.memes.chat.util.usecases;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/RemoveChannelMemberUseCase;", "", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "(Lio/getstream/chat/android/client/ChatClient;)V", "execute", "Lio/getstream/chat/android/client/models/Channel;", "request", "Lcom/memes/chat/util/usecases/RemoveChannelMemberUseCase$Request;", "(Lcom/memes/chat/util/usecases/RemoveChannelMemberUseCase$Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Request", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RemoveChannelMemberUseCase.kt */
public final class RemoveChannelMemberUseCase {
    /* access modifiers changed from: private */
    public final ChatClient chatClient;

    public RemoveChannelMemberUseCase(ChatClient chatClient2) {
        Intrinsics.checkNotNullParameter(chatClient2, "chatClient");
        this.chatClient = chatClient2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/RemoveChannelMemberUseCase$Request;", "", "channelId", "", "targetMemberId", "(Ljava/lang/String;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getTargetMemberId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: RemoveChannelMemberUseCase.kt */
    public static final class Request {
        private final String channelId;
        private final String targetMemberId;

        public static /* synthetic */ Request copy$default(Request request, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = request.channelId;
            }
            if ((i & 2) != 0) {
                str2 = request.targetMemberId;
            }
            return request.copy(str, str2);
        }

        public final String component1() {
            return this.channelId;
        }

        public final String component2() {
            return this.targetMemberId;
        }

        public final Request copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intrinsics.checkNotNullParameter(str2, "targetMemberId");
            return new Request(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Request)) {
                return false;
            }
            Request request = (Request) obj;
            return Intrinsics.areEqual((Object) this.channelId, (Object) request.channelId) && Intrinsics.areEqual((Object) this.targetMemberId, (Object) request.targetMemberId);
        }

        public int hashCode() {
            String str = this.channelId;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.targetMemberId;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Request(channelId=" + this.channelId + ", targetMemberId=" + this.targetMemberId + ")";
        }

        public Request(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intrinsics.checkNotNullParameter(str2, "targetMemberId");
            this.channelId = str;
            this.targetMemberId = str2;
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final String getTargetMemberId() {
            return this.targetMemberId;
        }
    }

    public final Object execute(Request request, Continuation<? super Channel> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new RemoveChannelMemberUseCase$execute$2(this, request, (Continuation) null), continuation);
    }
}
