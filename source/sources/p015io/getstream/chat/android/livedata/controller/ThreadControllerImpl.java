package p015io.getstream.chat.android.livedata.controller;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.livedata.ChatDomainImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001a0 H\u0016J'\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0 0)2\b\b\u0002\u0010*\u001a\u00020+H@ø\u0001\u0000¢\u0006\u0002\u0010,R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R \u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0 0\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u001a\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0 0#X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0 0#X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/controller/ThreadControllerImpl;", "Lio/getstream/chat/android/livedata/controller/ThreadController;", "threadId", "", "channelControllerImpl", "Lio/getstream/chat/android/livedata/controller/ChannelControllerImpl;", "client", "Lio/getstream/chat/android/client/ChatClient;", "domain", "Lio/getstream/chat/android/livedata/ChatDomainImpl;", "(Ljava/lang/String;Lio/getstream/chat/android/livedata/controller/ChannelControllerImpl;Lio/getstream/chat/android/client/ChatClient;Lio/getstream/chat/android/livedata/ChatDomainImpl;)V", "_endOfOlderMessages", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_loadingOlderMessages", "getChannelControllerImpl", "()Lio/getstream/chat/android/livedata/controller/ChannelControllerImpl;", "getClient", "()Lio/getstream/chat/android/client/ChatClient;", "getDomain", "()Lio/getstream/chat/android/livedata/ChatDomainImpl;", "endOfOlderMessages", "Landroidx/lifecycle/LiveData;", "getEndOfOlderMessages", "()Landroidx/lifecycle/LiveData;", "firstMessage", "Lio/getstream/chat/android/client/models/Message;", "loadingOlderMessages", "getLoadingOlderMessages", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "messages", "", "getMessages", "sortedVisibleMessages", "Lkotlinx/coroutines/flow/Flow;", "getThreadId", "()Ljava/lang/String;", "threadMessages", "getMessagesSorted", "loadOlderMessages", "Lio/getstream/chat/android/client/utils/Result;", "limit", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.controller.ThreadControllerImpl */
/* compiled from: ThreadControllerImpl.kt */
public final class ThreadControllerImpl implements ThreadController {
    private final MutableStateFlow<Boolean> _endOfOlderMessages;
    private final MutableStateFlow<Boolean> _loadingOlderMessages;
    private final ChannelControllerImpl channelControllerImpl;
    private final ChatClient client;
    private final ChatDomainImpl domain;
    private final LiveData<Boolean> endOfOlderMessages;
    private Message firstMessage;
    private final LiveData<Boolean> loadingOlderMessages;
    private final TaggedLogger logger = ChatLogger.Companion.get("ThreadController");
    private final LiveData<List<Message>> messages;
    private final Flow<List<Message>> sortedVisibleMessages;
    private final String threadId;
    private final Flow<List<Message>> threadMessages;

    public ThreadControllerImpl(String str, ChannelControllerImpl channelControllerImpl2, ChatClient chatClient, ChatDomainImpl chatDomainImpl) {
        Intrinsics.checkNotNullParameter(str, "threadId");
        Intrinsics.checkNotNullParameter(channelControllerImpl2, "channelControllerImpl");
        Intrinsics.checkNotNullParameter(chatClient, "client");
        Intrinsics.checkNotNullParameter(chatDomainImpl, "domain");
        this.threadId = str;
        this.channelControllerImpl = channelControllerImpl2;
        this.client = chatClient;
        this.domain = chatDomainImpl;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._loadingOlderMessages = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._endOfOlderMessages = MutableStateFlow2;
        Flow<List<Message>> threadControllerImpl$$special$$inlined$map$1 = new ThreadControllerImpl$$special$$inlined$map$1(channelControllerImpl2.getUnfilteredMessages(), this);
        this.threadMessages = threadControllerImpl$$special$$inlined$map$1;
        Flow<List<Message>> threadControllerImpl$$special$$inlined$map$2 = new ThreadControllerImpl$$special$$inlined$map$2(threadControllerImpl$$special$$inlined$map$1, this);
        this.sortedVisibleMessages = threadControllerImpl$$special$$inlined$map$2;
        this.messages = FlowLiveDataConversions.asLiveData$default((Flow) threadControllerImpl$$special$$inlined$map$2, (CoroutineContext) null, 0, 3, (Object) null);
        this.loadingOlderMessages = FlowLiveDataConversions.asLiveData$default((Flow) MutableStateFlow, (CoroutineContext) null, 0, 3, (Object) null);
        this.endOfOlderMessages = FlowLiveDataConversions.asLiveData$default((Flow) MutableStateFlow2, (CoroutineContext) null, 0, 3, (Object) null);
    }

    public String getThreadId() {
        return this.threadId;
    }

    public final ChannelControllerImpl getChannelControllerImpl() {
        return this.channelControllerImpl;
    }

    public final ChatClient getClient() {
        return this.client;
    }

    public final ChatDomainImpl getDomain() {
        return this.domain;
    }

    public LiveData<List<Message>> getMessages() {
        return this.messages;
    }

    public LiveData<Boolean> getLoadingOlderMessages() {
        return this.loadingOlderMessages;
    }

    public LiveData<Boolean> getEndOfOlderMessages() {
        return this.endOfOlderMessages;
    }

    public List<Message> getMessagesSorted() {
        List<Message> value = getMessages().getValue();
        return value != null ? value : CollectionsKt.emptyList();
    }

    public static /* synthetic */ Object loadOlderMessages$default(ThreadControllerImpl threadControllerImpl, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 30;
        }
        return threadControllerImpl.loadOlderMessages(i, continuation);
    }

    public final Object loadOlderMessages(int i, Continuation<? super Result<List<Message>>> continuation) {
        if (this._loadingOlderMessages.getValue().booleanValue()) {
            this.logger.logI("already loading messages for this thread, ignoring the load more requests.");
            return new Result(new ChatError("already loading messages for this thread, ignoring the load more requests.", (Throwable) null, 2, (DefaultConstructorMarker) null));
        }
        boolean z = true;
        this._loadingOlderMessages.setValue(Boxing.boxBoolean(true));
        Result<List<Message>> loadOlderThreadMessages$stream_chat_android_offline_release = this.channelControllerImpl.loadOlderThreadMessages$stream_chat_android_offline_release(getThreadId(), i, this.firstMessage);
        if (loadOlderThreadMessages$stream_chat_android_offline_release.isSuccess()) {
            MutableStateFlow<Boolean> mutableStateFlow = this._endOfOlderMessages;
            if (loadOlderThreadMessages$stream_chat_android_offline_release.data().size() >= i) {
                z = false;
            }
            mutableStateFlow.setValue(Boxing.boxBoolean(z));
            Message message = (Message) CollectionsKt.firstOrNull(CollectionsKt.sortedWith(loadOlderThreadMessages$stream_chat_android_offline_release.data(), new ThreadControllerImpl$loadOlderMessages$$inlined$sortedBy$1()));
            if (message == null) {
                message = this.firstMessage;
            }
            this.firstMessage = message;
        }
        this._loadingOlderMessages.setValue(Boxing.boxBoolean(false));
        return loadOlderThreadMessages$stream_chat_android_offline_release;
    }
}
