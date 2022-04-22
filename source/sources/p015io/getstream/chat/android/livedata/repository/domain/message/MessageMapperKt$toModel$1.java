package p015io.getstream.chat.android.livedata.repository.domain.message;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u000221\u0010\u0003\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000423\u0010\u000b\u001a/\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\tH@"}, mo26107d2 = {"toModel", "", "Lio/getstream/chat/android/livedata/repository/domain/message/MessageEntity;", "getUser", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "userId", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/models/User;", "getMessage", "messageId", "Lio/getstream/chat/android/client/models/Message;", "continuation"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.repository.domain.message.MessageMapperKt", mo26808f = "MessageMapper.kt", mo26809i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 5, 5}, mo26810l = {19, 36, 37, 38, 39, 40}, mo26811m = "toModel", mo26812n = {"$this$toModel", "getUser", "getMessage", "$this$with", "$this$toModel", "getUser", "getMessage", "$this$with", "destination$iv$iv", "getUser", "getMessage", "$this$with", "destination$iv$iv", "getUser", "getMessage", "$this$with", "destination$iv$iv", "getUser", "$this$with", "getUser", "destination$iv$iv"}, mo26813s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$8", "L$0", "L$1", "L$2", "L$7", "L$0", "L$1", "L$2", "L$7", "L$0", "L$1", "L$0", "L$5"})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.message.MessageMapperKt$toModel$1 */
/* compiled from: MessageMapper.kt */
final class MessageMapperKt$toModel$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
    Object L$15;
    Object L$16;
    Object L$17;
    Object L$18;
    Object L$19;
    Object L$2;
    Object L$20;
    Object L$21;
    Object L$22;
    Object L$23;
    Object L$24;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    MessageMapperKt$toModel$1(Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MessageMapperKt.toModel((MessageEntity) null, (Function2<? super String, ? super Continuation<? super User>, ? extends Object>) null, (Function2<? super String, ? super Continuation<? super Message>, ? extends Object>) null, this);
    }
}
