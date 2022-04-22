package p015io.getstream.chat.android.livedata.usecase;

import kotlin.Metadata;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.utils.FilterObject;
import p015io.getstream.chat.android.livedata.controller.QueryChannelsController;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J9\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH§\u0002¨\u0006\r"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/QueryChannels;", "", "invoke", "Lio/getstream/chat/android/client/call/Call;", "Lio/getstream/chat/android/livedata/controller/QueryChannelsController;", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "sort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "Lio/getstream/chat/android/client/models/Channel;", "limit", "", "messageLimit", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.QueryChannels */
/* compiled from: QueryChannelsImpl.kt */
public interface QueryChannels {
    Call<QueryChannelsController> invoke(FilterObject filterObject, QuerySort<Channel> querySort, int i, int i2);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.usecase.QueryChannels$DefaultImpls */
    /* compiled from: QueryChannelsImpl.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Call invoke$default(QueryChannels queryChannels, FilterObject filterObject, QuerySort querySort, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    i = 30;
                }
                if ((i3 & 8) != 0) {
                    i2 = 1;
                }
                return queryChannels.invoke(filterObject, querySort, i, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        }
    }
}
