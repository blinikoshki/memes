package com.memes.chat.util.usecases;

import com.memes.chat.util.Strings;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.channel.ChannelClient;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ChannelInfo;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.client.utils.SyncStatus;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/UpdateChannelUseCase;", "", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "(Lio/getstream/chat/android/client/ChatClient;)V", "execute", "Lio/getstream/chat/android/client/models/Channel;", "request", "Lcom/memes/chat/util/usecases/UpdateChannelUseCase$Request;", "(Lcom/memes/chat/util/usecases/UpdateChannelUseCase$Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateChannel", "currentUser", "Lio/getstream/chat/android/client/models/User;", "Request", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: UpdateChannelUseCase.kt */
public final class UpdateChannelUseCase {
    /* access modifiers changed from: private */
    public final ChatClient chatClient;

    public UpdateChannelUseCase(ChatClient chatClient2) {
        Intrinsics.checkNotNullParameter(chatClient2, "chatClient");
        this.chatClient = chatClient2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/UpdateChannelUseCase$Request;", "", "channel", "Lio/getstream/chat/android/client/models/Channel;", "newChannelName", "", "newChannelImage", "(Lio/getstream/chat/android/client/models/Channel;Ljava/lang/String;Ljava/lang/String;)V", "getChannel", "()Lio/getstream/chat/android/client/models/Channel;", "getNewChannelImage", "()Ljava/lang/String;", "getNewChannelName", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: UpdateChannelUseCase.kt */
    public static final class Request {
        private final Channel channel;
        private final String newChannelImage;
        private final String newChannelName;

        public Request(Channel channel2, String str, String str2) {
            Intrinsics.checkNotNullParameter(channel2, "channel");
            this.channel = channel2;
            this.newChannelName = str;
            this.newChannelImage = str2;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final String getNewChannelName() {
            return this.newChannelName;
        }

        public final String getNewChannelImage() {
            return this.newChannelImage;
        }
    }

    public final Object execute(Request request, Continuation<? super Channel> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new UpdateChannelUseCase$execute$2(this, request, (Continuation) null), continuation);
    }

    /* access modifiers changed from: private */
    public final Channel updateChannel(User user, Request request) {
        Map<String, Object> extraData = request.getChannel().getExtraData();
        String newChannelName = request.getNewChannelName();
        if (newChannelName != null) {
            if (!StringsKt.isBlank(newChannelName)) {
                extraData.put("name", newChannelName);
            } else {
                throw new RuntimeException(Strings.INSTANCE.channelRenameTextNotValid());
            }
        }
        String newChannelImage = request.getNewChannelImage();
        if (newChannelImage != null) {
            extraData.put("image", newChannelImage);
        }
        ChannelClient channel = this.chatClient.channel(request.getChannel().getCid());
        Message message = r3;
        Message message2 = new Message(ContentUtils.getName(user) + " updated channel information", (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (List) null, (List) null, 0, (Map) null, (Map) null, (SyncStatus) null, (String) null, (List) null, (List) null, (Date) null, (Date) null, (Date) null, (Date) null, (Date) null, (User) null, (Map) null, false, false, (Map) null, false, (ChannelInfo) null, (Message) null, (String) null, false, (Date) null, (Date) null, (User) null, (List) null, -2, 7, (DefaultConstructorMarker) null);
        Result<Channel> execute = channel.update(message, extraData).execute();
        if (!execute.isError()) {
            return execute.data();
        }
        throw new RuntimeException(Strings.INSTANCE.errorRenamingChannel(execute.error()));
    }
}
