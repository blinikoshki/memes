package com.memes.chat.p036ui.channel.messages;

import com.memes.chat.util.extensions.ChatErrorExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.Result;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "result", "Lio/getstream/chat/android/client/utils/Result;", "", "Lio/getstream/chat/android/client/models/User;", "onResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.messages.ChannelMessagesViewModel$watchUserIfDirectMessaging$1 */
/* compiled from: ChannelMessagesViewModel.kt */
final class ChannelMessagesViewModel$watchUserIfDirectMessaging$1<T> implements Call.Callback<List<? extends User>> {
    final /* synthetic */ ChannelMessagesViewModel this$0;

    ChannelMessagesViewModel$watchUserIfDirectMessaging$1(ChannelMessagesViewModel channelMessagesViewModel) {
        this.this$0 = channelMessagesViewModel;
    }

    public final void onResult(Result<List<User>> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.isSuccess()) {
            this.this$0._otherUser.setValue(CollectionsKt.first(result.data()));
            return;
        }
        Timber.m303e("watchUserIfDirectMessaging: " + ChatErrorExtKt.displayableMessage(result.error()), new Object[0]);
    }
}
