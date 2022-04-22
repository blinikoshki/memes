package p015io.getstream.chat.android.livedata.repository.builder;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.livedata.repository.domain.user.UserRepository;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/models/User;", "userId", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.repository.builder.RepositoryFacadeBuilder$build$getUser$1", mo26808f = "RepositoryFacadeBuilder.kt", mo26809i = {0}, mo26810l = {52}, mo26811m = "invokeSuspend", mo26812n = {"userId"}, mo26813s = {"L$0"})
/* renamed from: io.getstream.chat.android.livedata.repository.builder.RepositoryFacadeBuilder$build$getUser$1 */
/* compiled from: RepositoryFacadeBuilder.kt */
final class RepositoryFacadeBuilder$build$getUser$1 extends SuspendLambda implements Function2<String, Continuation<? super User>, Object> {
    final /* synthetic */ UserRepository $userRepository;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RepositoryFacadeBuilder$build$getUser$1(UserRepository userRepository, Continuation continuation) {
        super(2, continuation);
        this.$userRepository = userRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        RepositoryFacadeBuilder$build$getUser$1 repositoryFacadeBuilder$build$getUser$1 = new RepositoryFacadeBuilder$build$getUser$1(this.$userRepository, continuation);
        repositoryFacadeBuilder$build$getUser$1.L$0 = obj;
        return repositoryFacadeBuilder$build$getUser$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((RepositoryFacadeBuilder$build$getUser$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str2 = (String) this.L$0;
            UserRepository userRepository = this.$userRepository;
            this.L$0 = str2;
            this.label = 1;
            Object selectUser = userRepository.selectUser(str2, this);
            if (selectUser == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = str2;
            obj = selectUser;
        } else if (i == 1) {
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (obj != null) {
            return obj;
        }
        throw new IllegalArgumentException(("User with the userId: `" + str + "` has not been found").toString());
    }
}
