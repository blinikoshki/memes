package com.memes.chat.util.usecases;

import com.memes.chat.util.extensions.ChatErrorExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0002\f\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/ChannelMutingUseCase;", "", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "(Lio/getstream/chat/android/client/ChatClient;)V", "execute", "", "request", "Lcom/memes/chat/util/usecases/ChannelMutingUseCase$Request;", "(Lcom/memes/chat/util/usecases/ChannelMutingUseCase$Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "muteChannel", "unmuteChannel", "Request", "RequestType", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChannelMutingUseCase.kt */
public final class ChannelMutingUseCase {
    /* access modifiers changed from: private */
    public final ChatClient chatClient;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/ChannelMutingUseCase$RequestType;", "", "(Ljava/lang/String;I)V", "MUTE", "UNMUTE", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChannelMutingUseCase.kt */
    public enum RequestType {
        MUTE,
        UNMUTE
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RequestType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[RequestType.MUTE.ordinal()] = 1;
            iArr[RequestType.UNMUTE.ordinal()] = 2;
        }
    }

    public ChannelMutingUseCase(ChatClient chatClient2) {
        Intrinsics.checkNotNullParameter(chatClient2, "chatClient");
        this.chatClient = chatClient2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/ChannelMutingUseCase$Request;", "", "type", "Lcom/memes/chat/util/usecases/ChannelMutingUseCase$RequestType;", "channelId", "", "(Lcom/memes/chat/util/usecases/ChannelMutingUseCase$RequestType;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getType", "()Lcom/memes/chat/util/usecases/ChannelMutingUseCase$RequestType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChannelMutingUseCase.kt */
    public static final class Request {
        private final String channelId;
        private final RequestType type;

        public static /* synthetic */ Request copy$default(Request request, RequestType requestType, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                requestType = request.type;
            }
            if ((i & 2) != 0) {
                str = request.channelId;
            }
            return request.copy(requestType, str);
        }

        public final RequestType component1() {
            return this.type;
        }

        public final String component2() {
            return this.channelId;
        }

        public final Request copy(RequestType requestType, String str) {
            Intrinsics.checkNotNullParameter(requestType, "type");
            Intrinsics.checkNotNullParameter(str, "channelId");
            return new Request(requestType, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Request)) {
                return false;
            }
            Request request = (Request) obj;
            return Intrinsics.areEqual((Object) this.type, (Object) request.type) && Intrinsics.areEqual((Object) this.channelId, (Object) request.channelId);
        }

        public int hashCode() {
            RequestType requestType = this.type;
            int i = 0;
            int hashCode = (requestType != null ? requestType.hashCode() : 0) * 31;
            String str = this.channelId;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Request(type=" + this.type + ", channelId=" + this.channelId + ")";
        }

        public Request(RequestType requestType, String str) {
            Intrinsics.checkNotNullParameter(requestType, "type");
            Intrinsics.checkNotNullParameter(str, "channelId");
            this.type = requestType;
            this.channelId = str;
        }

        public final RequestType getType() {
            return this.type;
        }

        public final String getChannelId() {
            return this.channelId;
        }
    }

    public final Object execute(Request request, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ChannelMutingUseCase$execute$2(this, request, (Continuation) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void muteChannel(Request request) {
        Result<Unit> execute = this.chatClient.channel(request.getChannelId()).mute().execute();
        if (execute.isError()) {
            throw new RuntimeException(ChatErrorExtKt.displayableMessage(execute.error()));
        }
    }

    /* access modifiers changed from: private */
    public final void unmuteChannel(Request request) {
        Result<Unit> execute = this.chatClient.channel(request.getChannelId()).unmute().execute();
        if (execute.isError()) {
            throw new RuntimeException(ChatErrorExtKt.displayableMessage(execute.error()));
        }
    }
}
