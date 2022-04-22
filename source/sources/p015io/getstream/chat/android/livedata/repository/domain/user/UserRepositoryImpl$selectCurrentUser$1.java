package p015io.getstream.chat.android.livedata.repository.domain.user;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H@"}, mo26107d2 = {"selectCurrentUser", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/models/User;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl", mo26808f = "UserRepository.kt", mo26809i = {0}, mo26810l = {49}, mo26811m = "selectCurrentUser", mo26812n = {"this"}, mo26813s = {"L$0"})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectCurrentUser$1 */
/* compiled from: UserRepository.kt */
final class UserRepositoryImpl$selectCurrentUser$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserRepositoryImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserRepositoryImpl$selectCurrentUser$1(UserRepositoryImpl userRepositoryImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = userRepositoryImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.selectCurrentUser(this);
    }
}
