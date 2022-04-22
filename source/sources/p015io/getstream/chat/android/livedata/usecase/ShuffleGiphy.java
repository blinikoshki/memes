package p015io.getstream.chat.android.livedata.usecase;

import kotlin.Metadata;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H§\u0002¨\u0006\u0006"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/ShuffleGiphy;", "", "invoke", "Lio/getstream/chat/android/client/call/Call;", "Lio/getstream/chat/android/client/models/Message;", "message", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.ShuffleGiphy */
/* compiled from: ShuffleGiphyImpl.kt */
public interface ShuffleGiphy {
    Call<Message> invoke(Message message);
}
