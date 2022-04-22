package p015io.getstream.chat.android.livedata.repository.domain.message;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@"}, mo26107d2 = {"insert", "", "messageEntity", "Lio/getstream/chat/android/livedata/repository/domain/message/MessageEntity;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.repository.domain.message.MessageDao", mo26808f = "MessageDao.kt", mo26809i = {0, 0, 1, 1}, mo26810l = {25, 26, 27}, mo26811m = "insert$suspendImpl", mo26812n = {"this", "messageEntity", "this", "messageEntity"}, mo26813s = {"L$0", "L$1", "L$0", "L$1"})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.message.MessageDao$insert$5 */
/* compiled from: MessageDao.kt */
final class MessageDao$insert$5 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageDao this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageDao$insert$5(MessageDao messageDao, Continuation continuation) {
        super(continuation);
        this.this$0 = messageDao;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MessageDao.insert$suspendImpl(this.this$0, (MessageEntity) null, (Continuation) this);
    }
}
