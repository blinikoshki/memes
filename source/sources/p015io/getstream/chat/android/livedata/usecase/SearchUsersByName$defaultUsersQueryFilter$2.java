package p015io.getstream.chat.android.livedata.usecase;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.Filters;
import p015io.getstream.chat.android.client.utils.FilterObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/utils/FilterObject;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.SearchUsersByName$defaultUsersQueryFilter$2 */
/* compiled from: SearchUsersByName.kt */
final class SearchUsersByName$defaultUsersQueryFilter$2 extends Lambda implements Function0<FilterObject> {
    final /* synthetic */ SearchUsersByName this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchUsersByName$defaultUsersQueryFilter$2(SearchUsersByName searchUsersByName) {
        super(0);
        this.this$0 = searchUsersByName;
    }

    public final FilterObject invoke() {
        return Filters.and(Filters.m1011ne("name", ""), Filters.m1011ne("id", this.this$0.chatDomainImpl.getCurrentUser().getId()));
    }
}
