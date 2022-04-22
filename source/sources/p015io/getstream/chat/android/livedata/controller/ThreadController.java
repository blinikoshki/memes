package p015io.getstream.chat.android.livedata.controller;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u001e\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/controller/ThreadController;", "", "endOfOlderMessages", "Landroidx/lifecycle/LiveData;", "", "getEndOfOlderMessages", "()Landroidx/lifecycle/LiveData;", "loadingOlderMessages", "getLoadingOlderMessages", "messages", "", "Lio/getstream/chat/android/client/models/Message;", "getMessages", "threadId", "", "getThreadId", "()Ljava/lang/String;", "getMessagesSorted", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.controller.ThreadController */
/* compiled from: ThreadController.kt */
public interface ThreadController {
    LiveData<Boolean> getEndOfOlderMessages();

    LiveData<Boolean> getLoadingOlderMessages();

    LiveData<List<Message>> getMessages();

    List<Message> getMessagesSorted();

    String getThreadId();
}
