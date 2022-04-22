package p015io.getstream.chat.android.livedata.usecase;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import p015io.getstream.chat.android.client.call.Call;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H§\u0002¨\u0006\u0006"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/GetTotalUnreadCount;", "", "invoke", "Lio/getstream/chat/android/client/call/Call;", "Landroidx/lifecycle/LiveData;", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.GetTotalUnreadCount */
/* compiled from: GetTotalUnreadCountImpl.kt */
public interface GetTotalUnreadCount {
    Call<LiveData<Integer>> invoke();
}
