package p015io.getstream.chat.android.livedata.controller;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ChannelUserRead;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.TypingEvent;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.livedata.ChannelData;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001EJ\b\u0010?\u001a\u00020@H&J\u0012\u0010A\u001a\u0004\u0018\u00010!2\u0006\u0010B\u001a\u00020\bH&J\b\u0010C\u001a\u00020DH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0012\u0010\r\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006R\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0006R\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006R\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0006R\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0006R\u001e\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0006R\u001e\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u001d0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0006R\u0018\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0006R\u0018\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0006R\u001e\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u001d0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0006R\u001a\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0006R\u001e\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u001d0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0006R\u0012\u0010/\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u001a\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0006R\u0018\u00104\u001a\b\u0012\u0004\u0012\u0002050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0006R\u001a\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0006R\u0018\u0010:\u001a\b\u0012\u0004\u0012\u0002080\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0006R\u001e\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0\u001d0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0006¨\u0006F"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/controller/ChannelController;", "", "channelData", "Landroidx/lifecycle/LiveData;", "Lio/getstream/chat/android/livedata/ChannelData;", "getChannelData", "()Landroidx/lifecycle/LiveData;", "channelId", "", "getChannelId", "()Ljava/lang/String;", "channelType", "getChannelType", "cid", "getCid", "endOfNewerMessages", "", "getEndOfNewerMessages", "endOfOlderMessages", "getEndOfOlderMessages", "hidden", "getHidden", "loading", "getLoading", "loadingNewerMessages", "getLoadingNewerMessages", "loadingOlderMessages", "getLoadingOlderMessages", "members", "", "Lio/getstream/chat/android/client/models/Member;", "getMembers", "messages", "Lio/getstream/chat/android/client/models/Message;", "getMessages", "messagesState", "Lio/getstream/chat/android/livedata/controller/ChannelController$MessagesState;", "getMessagesState", "muted", "getMuted", "oldMessages", "getOldMessages", "read", "Lio/getstream/chat/android/client/models/ChannelUserRead;", "getRead", "reads", "getReads", "recoveryNeeded", "getRecoveryNeeded", "()Z", "repliedMessage", "getRepliedMessage", "typing", "Lio/getstream/chat/android/client/models/TypingEvent;", "getTyping", "unreadCount", "", "getUnreadCount", "watcherCount", "getWatcherCount", "watchers", "Lio/getstream/chat/android/client/models/User;", "getWatchers", "clean", "", "getMessage", "messageId", "toChannel", "Lio/getstream/chat/android/client/models/Channel;", "MessagesState", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.controller.ChannelController */
/* compiled from: ChannelController.kt */
public interface ChannelController {
    void clean();

    LiveData<ChannelData> getChannelData();

    String getChannelId();

    String getChannelType();

    String getCid();

    LiveData<Boolean> getEndOfNewerMessages();

    LiveData<Boolean> getEndOfOlderMessages();

    LiveData<Boolean> getHidden();

    LiveData<Boolean> getLoading();

    LiveData<Boolean> getLoadingNewerMessages();

    LiveData<Boolean> getLoadingOlderMessages();

    LiveData<List<Member>> getMembers();

    Message getMessage(String str);

    LiveData<List<Message>> getMessages();

    LiveData<MessagesState> getMessagesState();

    LiveData<Boolean> getMuted();

    LiveData<List<Message>> getOldMessages();

    LiveData<ChannelUserRead> getRead();

    LiveData<List<ChannelUserRead>> getReads();

    boolean getRecoveryNeeded();

    LiveData<Message> getRepliedMessage();

    LiveData<TypingEvent> getTyping();

    LiveData<Integer> getUnreadCount();

    LiveData<Integer> getWatcherCount();

    LiveData<List<User>> getWatchers();

    Channel toChannel();

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/controller/ChannelController$MessagesState;", "", "()V", "Loading", "NoQueryActive", "OfflineNoResults", "Result", "Lio/getstream/chat/android/livedata/controller/ChannelController$MessagesState$NoQueryActive;", "Lio/getstream/chat/android/livedata/controller/ChannelController$MessagesState$Loading;", "Lio/getstream/chat/android/livedata/controller/ChannelController$MessagesState$OfflineNoResults;", "Lio/getstream/chat/android/livedata/controller/ChannelController$MessagesState$Result;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.controller.ChannelController$MessagesState */
    /* compiled from: ChannelController.kt */
    public static abstract class MessagesState {
        private MessagesState() {
        }

        public /* synthetic */ MessagesState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/controller/ChannelController$MessagesState$NoQueryActive;", "Lio/getstream/chat/android/livedata/controller/ChannelController$MessagesState;", "()V", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.livedata.controller.ChannelController$MessagesState$NoQueryActive */
        /* compiled from: ChannelController.kt */
        public static final class NoQueryActive extends MessagesState {
            public static final NoQueryActive INSTANCE = new NoQueryActive();

            private NoQueryActive() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/controller/ChannelController$MessagesState$Loading;", "Lio/getstream/chat/android/livedata/controller/ChannelController$MessagesState;", "()V", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.livedata.controller.ChannelController$MessagesState$Loading */
        /* compiled from: ChannelController.kt */
        public static final class Loading extends MessagesState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/controller/ChannelController$MessagesState$OfflineNoResults;", "Lio/getstream/chat/android/livedata/controller/ChannelController$MessagesState;", "()V", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.livedata.controller.ChannelController$MessagesState$OfflineNoResults */
        /* compiled from: ChannelController.kt */
        public static final class OfflineNoResults extends MessagesState {
            public static final OfflineNoResults INSTANCE = new OfflineNoResults();

            private OfflineNoResults() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/controller/ChannelController$MessagesState$Result;", "Lio/getstream/chat/android/livedata/controller/ChannelController$MessagesState;", "messages", "", "Lio/getstream/chat/android/client/models/Message;", "(Ljava/util/List;)V", "getMessages", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.livedata.controller.ChannelController$MessagesState$Result */
        /* compiled from: ChannelController.kt */
        public static final class Result extends MessagesState {
            private final List<Message> messages;

            public static /* synthetic */ Result copy$default(Result result, List<Message> list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = result.messages;
                }
                return result.copy(list);
            }

            public final List<Message> component1() {
                return this.messages;
            }

            public final Result copy(List<Message> list) {
                Intrinsics.checkNotNullParameter(list, "messages");
                return new Result(list);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof Result) && Intrinsics.areEqual((Object) this.messages, (Object) ((Result) obj).messages);
                }
                return true;
            }

            public int hashCode() {
                List<Message> list = this.messages;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "Result(messages=" + this.messages + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Result(List<Message> list) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(list, "messages");
                this.messages = list;
            }

            public final List<Message> getMessages() {
                return this.messages;
            }
        }
    }
}
