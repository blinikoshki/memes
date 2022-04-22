package p015io.getstream.chat.android.livedata.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\nH@"}, mo26107d2 = {"performOnlineSearch", "", "querySearch", "", "offset", "", "userLimit", "userPresence", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/utils/Result;", "", "Lio/getstream/chat/android/client/models/User;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.usecase.SearchUsersByName", mo26808f = "SearchUsersByName.kt", mo26809i = {}, mo26810l = {85}, mo26811m = "performOnlineSearch", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.livedata.usecase.SearchUsersByName$performOnlineSearch$1 */
/* compiled from: SearchUsersByName.kt */
final class SearchUsersByName$performOnlineSearch$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SearchUsersByName this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchUsersByName$performOnlineSearch$1(SearchUsersByName searchUsersByName, Continuation continuation) {
        super(continuation);
        this.this$0 = searchUsersByName;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.performOnlineSearch((String) null, 0, 0, false, this);
    }
}
