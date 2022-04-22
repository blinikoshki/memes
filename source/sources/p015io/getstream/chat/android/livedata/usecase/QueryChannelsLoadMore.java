package p015io.getstream.chat.android.livedata.usecase;

import java.util.List;
import kotlin.Metadata;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.utils.FilterObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J?\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH§\u0002¨\u0006\r"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/QueryChannelsLoadMore;", "", "invoke", "Lio/getstream/chat/android/client/call/Call;", "", "Lio/getstream/chat/android/client/models/Channel;", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "sort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "limit", "", "messageLimit", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.QueryChannelsLoadMore */
/* compiled from: QueryChannelsLoadMoreImpl.kt */
public interface QueryChannelsLoadMore {
    Call<List<Channel>> invoke(FilterObject filterObject, QuerySort<Channel> querySort, int i, int i2);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.usecase.QueryChannelsLoadMore$DefaultImpls */
    /* compiled from: QueryChannelsLoadMoreImpl.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Call invoke$default(QueryChannelsLoadMore queryChannelsLoadMore, FilterObject filterObject, QuerySort querySort, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    i = 30;
                }
                if ((i3 & 8) != 0) {
                    i2 = 10;
                }
                return queryChannelsLoadMore.invoke(filterObject, querySort, i, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        }
    }
}
