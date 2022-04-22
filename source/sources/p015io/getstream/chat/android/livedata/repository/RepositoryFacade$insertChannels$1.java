package p015io.getstream.chat.android.livedata.repository;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H@"}, mo26107d2 = {"insertChannels", "", "channels", "", "Lio/getstream/chat/android/client/models/Channel;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.repository.RepositoryFacade", mo26808f = "RepositoryFacade.kt", mo26809i = {0, 0}, mo26810l = {81, 129}, mo26811m = "insertChannels", mo26812n = {"this", "channels"}, mo26813s = {"L$0", "L$1"})
/* renamed from: io.getstream.chat.android.livedata.repository.RepositoryFacade$insertChannels$1 */
/* compiled from: RepositoryFacade.kt */
final class RepositoryFacade$insertChannels$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RepositoryFacade this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RepositoryFacade$insertChannels$1(RepositoryFacade repositoryFacade, Continuation continuation) {
        super(continuation);
        this.this$0 = repositoryFacade;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.insertChannels((Collection<Channel>) null, this);
    }
}
