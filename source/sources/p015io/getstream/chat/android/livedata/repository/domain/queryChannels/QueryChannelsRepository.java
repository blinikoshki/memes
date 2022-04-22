package p015io.getstream.chat.android.livedata.repository.domain.queryChannels;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import p015io.getstream.chat.android.livedata.controller.QueryChannelsSpec;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsRepository;", "", "insertQueryChannels", "", "queryChannelsSpec", "Lio/getstream/chat/android/livedata/controller/QueryChannelsSpec;", "(Lio/getstream/chat/android/livedata/controller/QueryChannelsSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectQueriesChannelsByIds", "", "ids", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectQueryChannels", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsRepository */
/* compiled from: QueryChannelsRepository.kt */
public interface QueryChannelsRepository {
    Object insertQueryChannels(QueryChannelsSpec queryChannelsSpec, Continuation<? super Unit> continuation);

    Object selectById(String str, Continuation<? super QueryChannelsSpec> continuation);

    Object selectQueriesChannelsByIds(List<String> list, Continuation<? super List<QueryChannelsSpec>> continuation);

    Object selectQueryChannels(QueryChannelsSpec queryChannelsSpec, Continuation<? super QueryChannelsSpec> continuation);
}
