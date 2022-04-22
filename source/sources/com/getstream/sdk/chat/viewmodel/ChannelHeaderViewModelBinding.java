package com.getstream.sdk.chat.viewmodel;

import android.content.Context;
import android.text.format.DateUtils;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.utils.extensions.DateKt;
import com.getstream.sdk.chat.utils.extensions.MemberUtils;
import com.getstream.sdk.chat.view.ChannelHeaderView;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0007\u001a\u001a\u0010\b\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000e"}, mo26107d2 = {"bindView", "", "Lcom/getstream/sdk/chat/viewmodel/ChannelHeaderViewModel;", "view", "Lcom/getstream/sdk/chat/view/ChannelHeaderView;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "bind", "lastActive", "", "", "Lio/getstream/chat/android/client/models/Member;", "context", "Landroid/content/Context;", "stream-chat-android_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: ChannelHeaderViewModelBinding.kt */
public final class ChannelHeaderViewModelBinding {
    public static final void bind(ChannelHeaderViewModel channelHeaderViewModel, ChannelHeaderView channelHeaderView, LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(channelHeaderViewModel, "$this$bindView");
        Intrinsics.checkNotNullParameter(channelHeaderView, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        channelHeaderViewModel.getMembers().observe(lifecycleOwner, new ChannelHeaderViewModelBinding$bindView$1(channelHeaderView));
        channelHeaderViewModel.getChannelState().observe(lifecycleOwner, new ChannelHeaderViewModelBinding$bindView$2(channelHeaderView));
        channelHeaderViewModel.getAnyOtherUsersOnline().observe(lifecycleOwner, new ChannelHeaderViewModelBinding$bindView$3(channelHeaderView));
    }

    /* access modifiers changed from: private */
    public static final String lastActive(List<Member> list, Context context) {
        String str;
        Date lastActive$default = MemberUtils.getLastActive$default(list, (User) null, 1, (Object) null);
        int i = C1673R.string.stream_channel_header_active;
        Object[] objArr = new Object[1];
        if (DateKt.isInLastMinute(lastActive$default)) {
            str = context.getString(C1673R.string.stream_channel_header_active_now);
        } else {
            str = DateUtils.getRelativeTimeSpanString(lastActive$default.getTime()).toString();
        }
        objArr[0] = str;
        String string = context.getString(i, objArr);
        Intrinsics.checkNotNullExpressionValue(string, "getLastActive().let {\n  …        }\n        )\n    }");
        return string;
    }
}
