package com.memes.chat.util.usecases;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import p015io.getstream.chat.android.client.ChatClient;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/ChannelDeletionUseCase;", "", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "(Lio/getstream/chat/android/client/ChatClient;)V", "execute", "", "request", "Lcom/memes/chat/util/usecases/ChannelDeletionUseCase$Request;", "(Lcom/memes/chat/util/usecases/ChannelDeletionUseCase$Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Request", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChannelDeletionUseCase.kt */
public final class ChannelDeletionUseCase {
    /* access modifiers changed from: private */
    public final ChatClient chatClient;

    public ChannelDeletionUseCase(ChatClient chatClient2) {
        Intrinsics.checkNotNullParameter(chatClient2, "chatClient");
        this.chatClient = chatClient2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/ChannelDeletionUseCase$Request;", "", "channelId", "", "(Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChannelDeletionUseCase.kt */
    public static final class Request {
        private final String channelId;

        public static /* synthetic */ Request copy$default(Request request, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = request.channelId;
            }
            return request.copy(str);
        }

        public final String component1() {
            return this.channelId;
        }

        public final Request copy(String str) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            return new Request(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Request) && Intrinsics.areEqual((Object) this.channelId, (Object) ((Request) obj).channelId);
            }
            return true;
        }

        public int hashCode() {
            String str = this.channelId;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Request(channelId=" + this.channelId + ")";
        }

        public Request(String str) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            this.channelId = str;
        }

        public final String getChannelId() {
            return this.channelId;
        }
    }

    public final Object execute(Request request, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ChannelDeletionUseCase$execute$2(this, request, (Continuation) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
