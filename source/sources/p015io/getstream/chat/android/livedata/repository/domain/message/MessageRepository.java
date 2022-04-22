package p015io.getstream.chat.android.livedata.repository.domain.message;

import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J)\u0010\u0011\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u000fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J%\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ)\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H¦@ø\u0001\u0000¢\u0006\u0002\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006!"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/message/MessageRepository;", "", "deleteChannelMessage", "", "message", "Lio/getstream/chat/android/client/models/Message;", "(Lio/getstream/chat/android/client/models/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteChannelMessagesBefore", "cid", "", "hideMessagesBefore", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMessage", "cache", "", "(Lio/getstream/chat/android/client/models/Message;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMessages", "messages", "", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectMessage", "messageId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectMessages", "messageIds", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectMessagesForChannel", "pagination", "Lio/getstream/chat/android/livedata/request/AnyChannelPaginationRequest;", "(Ljava/lang/String;Lio/getstream/chat/android/livedata/request/AnyChannelPaginationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectMessagesSyncNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.message.MessageRepository */
/* compiled from: MessageRepository.kt */
public interface MessageRepository {
    Object deleteChannelMessage(Message message, Continuation<? super Unit> continuation);

    Object deleteChannelMessagesBefore(String str, Date date, Continuation<? super Unit> continuation);

    Object insertMessage(Message message, boolean z, Continuation<? super Unit> continuation);

    Object insertMessages(List<Message> list, boolean z, Continuation<? super Unit> continuation);

    Object selectMessage(String str, Continuation<? super Message> continuation);

    Object selectMessages(List<String> list, Continuation<? super List<Message>> continuation);

    Object selectMessagesForChannel(String str, AnyChannelPaginationRequest anyChannelPaginationRequest, Continuation<? super List<Message>> continuation);

    Object selectMessagesSyncNeeded(Continuation<? super List<Message>> continuation);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.repository.domain.message.MessageRepository$DefaultImpls */
    /* compiled from: MessageRepository.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object insertMessages$default(MessageRepository messageRepository, List list, boolean z, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return messageRepository.insertMessages(list, z, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertMessages");
        }

        public static /* synthetic */ Object insertMessage$default(MessageRepository messageRepository, Message message, boolean z, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return messageRepository.insertMessage(message, z, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertMessage");
        }
    }
}
