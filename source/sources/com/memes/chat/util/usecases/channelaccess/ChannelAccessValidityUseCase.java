package com.memes.chat.util.usecases.channelaccess;

import com.memes.chat.util.exceptions.ChannelAccessException;
import com.memes.chat.util.extensions.ChatErrorExtKt;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.api.models.QueryChannelsRequest;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Filters;
import p015io.getstream.chat.android.client.models.ModelFields;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.Result;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessValidityUseCase;", "", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "(Lio/getstream/chat/android/client/ChatClient;)V", "execute", "Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessResult;", "request", "Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessValidityUseCase$Request;", "(Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessValidityUseCase$Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryFetchChannel", "Lio/getstream/chat/android/client/models/Channel;", "Request", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChannelAccessValidityUseCase.kt */
public final class ChannelAccessValidityUseCase {
    private final ChatClient chatClient;

    public ChannelAccessValidityUseCase(ChatClient chatClient2) {
        Intrinsics.checkNotNullParameter(chatClient2, "chatClient");
        this.chatClient = chatClient2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessValidityUseCase$Request;", "", "channelId", "", "targetUserId", "(Ljava/lang/String;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getTargetUserId", "component1", "component2", "copy", "equals", "", "other", "getBrokenChannelId", "getBrokenChannelType", "hashCode", "", "toString", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChannelAccessValidityUseCase.kt */
    public static final class Request {
        private final String channelId;
        private final String targetUserId;

        public static /* synthetic */ Request copy$default(Request request, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = request.channelId;
            }
            if ((i & 2) != 0) {
                str2 = request.targetUserId;
            }
            return request.copy(str, str2);
        }

        public final String component1() {
            return this.channelId;
        }

        public final String component2() {
            return this.targetUserId;
        }

        public final Request copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "channelId");
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
            return Intrinsics.areEqual((Object) this.channelId, (Object) request.channelId) && Intrinsics.areEqual((Object) this.targetUserId, (Object) request.targetUserId);
        }

        public int hashCode() {
            String str = this.channelId;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.targetUserId;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Request(channelId=" + this.channelId + ", targetUserId=" + this.targetUserId + ")";
        }

        public Request(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            this.channelId = str;
            this.targetUserId = str2;
        }

        public final String getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Request(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }

        public final String getTargetUserId() {
            return this.targetUserId;
        }

        public final String getBrokenChannelId() {
            int indexOf$default = StringsKt.indexOf$default((CharSequence) this.channelId, ":", 0, false, 6, (Object) null);
            String str = this.channelId;
            int length = str.length();
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String substring = str.substring(indexOf$default + 1, length);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public final String getBrokenChannelType() {
            int indexOf$default = StringsKt.indexOf$default((CharSequence) this.channelId, ":", 0, false, 6, (Object) null);
            String str = this.channelId;
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String substring = str.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
    }

    public final Object execute(Request request, Continuation<? super ChannelAccessResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ChannelAccessValidityUseCase$execute$2(this, request, (Continuation) null), continuation);
    }

    /* access modifiers changed from: private */
    public final Channel tryFetchChannel(Request request) {
        String str;
        Timber.m300d("execute: " + request, new Object[0]);
        if (!StringsKt.isBlank(request.getChannelId())) {
            CharSequence targetUserId = request.getTargetUserId();
            if (!(targetUserId == null || StringsKt.isBlank(targetUserId))) {
                str = request.getTargetUserId();
            } else {
                User currentUser = this.chatClient.getCurrentUser();
                if (currentUser == null || (str = currentUser.getId()) == null) {
                    throw new ChannelAccessException("Chat user is not logged in.");
                }
            }
            Result<List<Channel>> execute = this.chatClient.queryChannels(new QueryChannelsRequest(Filters.and(Filters.m1007eq("id", request.getBrokenChannelId()), Filters.m1007eq("type", request.getBrokenChannelType()), Filters.m1008in((String) ModelFields.MEMBERS, (List<?>) CollectionsKt.listOf(str))), 0, 1, new QuerySort().asc("last_message_at"), 0, 0, 48, (DefaultConstructorMarker) null)).execute();
            if (execute.isSuccess()) {
                Channel channel = (Channel) CollectionsKt.firstOrNull(execute.data());
                if (Intrinsics.areEqual((Object) channel != null ? channel.getCid() : null, (Object) request.getChannelId())) {
                    return channel;
                }
                throw new ChannelAccessException("You are not a part of this chat.");
            }
            throw new RuntimeException(ChatErrorExtKt.displayableMessage(execute.error()));
        }
        throw new ChannelAccessException("Invalid Target Channel ID");
    }
}
