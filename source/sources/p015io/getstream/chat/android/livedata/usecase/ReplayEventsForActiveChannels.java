package p015io.getstream.chat.android.livedata.usecase;

import java.util.List;
import kotlin.Metadata;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H§\u0002¨\u0006\b"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/ReplayEventsForActiveChannels;", "", "invoke", "Lio/getstream/chat/android/client/call/Call;", "", "Lio/getstream/chat/android/client/events/ChatEvent;", "cid", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.ReplayEventsForActiveChannels */
/* compiled from: ReplayEventsForActiveChannelsImpl.kt */
public interface ReplayEventsForActiveChannels {
    Call<List<ChatEvent>> invoke(String str);
}
