package p015io.getstream.chat.android.livedata.repository.domain.message;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import p015io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H@"}, mo26107d2 = {"selectMessagesEntitiesForChannel", "", "cid", "", "pagination", "Lio/getstream/chat/android/livedata/request/AnyChannelPaginationRequest;", "continuation", "Lkotlin/coroutines/Continuation;", "", "Lio/getstream/chat/android/livedata/repository/domain/message/MessageEntity;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl", mo26808f = "MessageRepository.kt", mo26809i = {0, 0, 0}, mo26810l = {47, 54, 57, 60, 63, 67}, mo26811m = "selectMessagesEntitiesForChannel", mo26812n = {"this", "cid", "pagination"}, mo26813s = {"L$0", "L$1", "L$2"})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.message.MessageRepositoryImpl$selectMessagesEntitiesForChannel$1 */
/* compiled from: MessageRepository.kt */
final class MessageRepositoryImpl$selectMessagesEntitiesForChannel$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageRepositoryImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageRepositoryImpl$selectMessagesEntitiesForChannel$1(MessageRepositoryImpl messageRepositoryImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = messageRepositoryImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.selectMessagesEntitiesForChannel((String) null, (AnyChannelPaginationRequest) null, this);
    }
}
