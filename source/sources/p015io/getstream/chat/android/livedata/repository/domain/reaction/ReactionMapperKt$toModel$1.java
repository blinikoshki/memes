package p015io.getstream.chat.android.livedata.repository.domain.reaction;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u000221\u0010\u0003\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tH@"}, mo26107d2 = {"toModel", "", "Lio/getstream/chat/android/livedata/repository/domain/reaction/ReactionEntity;", "getUser", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "userId", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/models/User;", "continuation", "Lio/getstream/chat/android/client/models/Reaction;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.repository.domain.reaction.ReactionMapperKt", mo26808f = "ReactionMapper.kt", mo26809i = {0}, mo26810l = {23}, mo26811m = "toModel", mo26812n = {"$this$toModel"}, mo26813s = {"L$0"})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.reaction.ReactionMapperKt$toModel$1 */
/* compiled from: ReactionMapper.kt */
final class ReactionMapperKt$toModel$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    ReactionMapperKt$toModel$1(Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReactionMapperKt.toModel((ReactionEntity) null, (Function2<? super String, ? super Continuation<? super User>, ? extends Object>) null, this);
    }
}
