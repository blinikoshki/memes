package p015io.getstream.chat.android.livedata.repository.builder;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006H@¢\u0006\u0004\b\u0007\u0010\b"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/models/Message;", "p1", "", "Lkotlin/ParameterName;", "name", "messageId", "invoke", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.builder.RepositoryFacadeBuilder$build$getMessage$1 */
/* compiled from: RepositoryFacadeBuilder.kt */
final /* synthetic */ class RepositoryFacadeBuilder$build$getMessage$1 extends FunctionReferenceImpl implements Function2<String, Continuation<? super Message>, Object>, SuspendFunction {
    RepositoryFacadeBuilder$build$getMessage$1(MessageRepository messageRepository) {
        super(2, messageRepository, MessageRepository.class, "selectMessage", "selectMessage(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(String str, Continuation<? super Message> continuation) {
        return ((MessageRepository) this.receiver).selectMessage(str, continuation);
    }
}
