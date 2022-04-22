package p015io.getstream.chat.android.livedata.usecase;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/utils/Result;", "", "Lio/getstream/chat/android/client/models/User;", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.usecase.SearchUsersByName$invoke$1", mo26808f = "SearchUsersByName.kt", mo26809i = {}, mo26810l = {45, 47}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.livedata.usecase.SearchUsersByName$invoke$1 */
/* compiled from: SearchUsersByName.kt */
final class SearchUsersByName$invoke$1 extends SuspendLambda implements Function1<Continuation<? super Result<List<? extends User>>>, Object> {
    final /* synthetic */ int $offset;
    final /* synthetic */ String $querySearch;
    final /* synthetic */ int $userLimit;
    final /* synthetic */ boolean $userPresence;
    int label;
    final /* synthetic */ SearchUsersByName this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchUsersByName$invoke$1(SearchUsersByName searchUsersByName, String str, int i, int i2, boolean z, Continuation continuation) {
        super(1, continuation);
        this.this$0 = searchUsersByName;
        this.$querySearch = str;
        this.$offset = i;
        this.$userLimit = i2;
        this.$userPresence = z;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new SearchUsersByName$invoke$1(this.this$0, this.$querySearch, this.$offset, this.$userLimit, this.$userPresence, continuation);
    }

    public final Object invoke(Object obj) {
        return ((SearchUsersByName$invoke$1) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.chatDomainImpl.isOnline()) {
                SearchUsersByName searchUsersByName = this.this$0;
                String str = this.$querySearch;
                int i2 = this.$offset;
                int i3 = this.$userLimit;
                boolean z = this.$userPresence;
                this.label = 1;
                obj = searchUsersByName.performOnlineSearch(str, i2, i3, z, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                SearchUsersByName searchUsersByName2 = this.this$0;
                String str2 = this.$querySearch;
                int i4 = this.$offset;
                int i5 = this.$userLimit;
                this.label = 2;
                obj = searchUsersByName2.performOfflineSearch(str2, i4, i5, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (Result) obj;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return (Result) obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return (Result) obj;
    }
}
