package com.memes.chat.p036ui.channel.list.pages.p037private;

import com.memes.chat.p036ui.channel.list.pages.ChannelsFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Filters;
import p015io.getstream.chat.android.client.models.ModelFields;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.FilterObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0014J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/list/pages/private/PrivateChannelsFragment;", "Lcom/memes/chat/ui/channel/list/pages/ChannelsFragment;", "()V", "assignedFragmentTag", "", "getAssignedFragmentTag", "()Ljava/lang/String;", "channelType", "createFilter", "Lio/getstream/chat/android/client/utils/FilterObject;", "currentUser", "Lio/getstream/chat/android/client/models/User;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.list.pages.private.PrivateChannelsFragment */
/* compiled from: PrivateChannelsFragment.kt */
public final class PrivateChannelsFragment extends ChannelsFragment {
    /* access modifiers changed from: protected */
    public String channelType() {
        return "messaging";
    }

    public String getAssignedFragmentTag() {
        return "PrivateChannelsFragment";
    }

    /* access modifiers changed from: protected */
    public FilterObject createFilter(User user) {
        Intrinsics.checkNotNullParameter(user, "currentUser");
        return Filters.and(Filters.m1007eq("type", channelType()), Filters.m1008in((String) ModelFields.MEMBERS, (List<?>) CollectionsKt.listOf(user.getId())));
    }
}
