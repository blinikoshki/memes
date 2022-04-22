package p015io.getstream.chat.android.livedata.repository.domain.user;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\u0006H@"}, mo26107d2 = {"selectUsers", "", "userIds", "", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/models/User;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl", mo26808f = "UserRepository.kt", mo26809i = {0, 0}, mo26810l = {60}, mo26811m = "selectUsers", mo26812n = {"this", "cacheUsers"}, mo26813s = {"L$0", "L$1"})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectUsers$1 */
/* compiled from: UserRepository.kt */
final class UserRepositoryImpl$selectUsers$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserRepositoryImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserRepositoryImpl$selectUsers$1(UserRepositoryImpl userRepositoryImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = userRepositoryImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.selectUsers((List<String>) null, this);
    }
}
