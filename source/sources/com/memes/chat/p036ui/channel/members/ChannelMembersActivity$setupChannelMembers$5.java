package com.memes.chat.p036ui.channel.members;

import androidx.lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.internal.NativeProtocol;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "action", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.ChannelMembersActivity$setupChannelMembers$5 */
/* compiled from: ChannelMembersActivity.kt */
final class ChannelMembersActivity$setupChannelMembers$5<T> implements Observer<ContentVisibilityAction> {
    final /* synthetic */ ChannelMembersActivity this$0;

    ChannelMembersActivity$setupChannelMembers$5(ChannelMembersActivity channelMembersActivity) {
        this.this$0 = channelMembersActivity;
    }

    public final void onChanged(ContentVisibilityAction contentVisibilityAction) {
        if (contentVisibilityAction.getAction() == 1210) {
            SwipeRefreshLayout swipeRefreshLayout = this.this$0.getBinding().swipeRefreshLayout;
            Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "binding.swipeRefreshLayout");
            if (swipeRefreshLayout.isRefreshing()) {
                return;
            }
        }
        SwipeRefreshLayout swipeRefreshLayout2 = this.this$0.getBinding().swipeRefreshLayout;
        Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout2, "binding.swipeRefreshLayout");
        swipeRefreshLayout2.setRefreshing(false);
        ContentLayout contentLayout = this.this$0.getBinding().contentLayout;
        Intrinsics.checkNotNullExpressionValue(contentVisibilityAction, NativeProtocol.WEB_DIALOG_ACTION);
        contentLayout.apply(contentVisibilityAction);
    }
}
