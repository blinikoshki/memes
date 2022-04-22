package com.memes.chat.p036ui.channel.members;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.memes.chat.C4059R;
import com.memes.chat.databinding.ChannelInfoChannelMemberItemBinding;
import com.memes.commons.recycleradapter.BaseRecyclerAdapter;
import com.memes.commons.recycleradapter.BaseViewHolder;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u001d\u001eB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002J$\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\nJ\u0016\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/members/ChannelMembersAdapter;", "Lcom/memes/commons/recycleradapter/BaseRecyclerAdapter;", "Lio/getstream/chat/android/client/models/Member;", "Lcom/memes/chat/ui/channel/members/ChannelMembersAdapter$ChannelMemberViewHolder;", "context", "Landroid/content/Context;", "callback", "Lcom/memes/chat/ui/channel/members/ChannelMembersAdapter$Callback;", "(Landroid/content/Context;Lcom/memes/chat/ui/channel/members/ChannelMembersAdapter$Callback;)V", "channelOwnerId", "", "isCurrentUserChannelOwner", "", "addChannelMember", "", "member", "createItemViewHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "removeChannelMemberById", "id", "setOwnerAndCurrentUser", "channelOwner", "Lio/getstream/chat/android/client/models/User;", "currentUser", "Callback", "ChannelMemberViewHolder", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.ChannelMembersAdapter */
/* compiled from: ChannelMembersAdapter.kt */
public final class ChannelMembersAdapter extends BaseRecyclerAdapter<Member, ChannelMemberViewHolder> {
    /* access modifiers changed from: private */
    public final Callback callback;
    /* access modifiers changed from: private */
    public String channelOwnerId;
    /* access modifiers changed from: private */
    public boolean isCurrentUserChannelOwner;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/members/ChannelMembersAdapter$Callback;", "", "onChannelMemberViewTapped", "", "channelMember", "Lio/getstream/chat/android/client/models/Member;", "onRemoveChannelMemberViewTapped", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.members.ChannelMembersAdapter$Callback */
    /* compiled from: ChannelMembersAdapter.kt */
    public interface Callback {
        void onChannelMemberViewTapped(Member member);

        void onRemoveChannelMemberViewTapped(Member member);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelMembersAdapter(Context context, Callback callback2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
    }

    public ChannelMemberViewHolder createItemViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ChannelInfoChannelMemberItemBinding inflate = ChannelInfoChannelMemberItemBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "ChannelInfoChannelMember…(inflater, parent, false)");
        return new ChannelMemberViewHolder(this, inflate);
    }

    public final void setOwnerAndCurrentUser(User user, User user2) {
        Intrinsics.checkNotNullParameter(user, "channelOwner");
        Intrinsics.checkNotNullParameter(user2, "currentUser");
        this.channelOwnerId = user.getId();
        this.isCurrentUserChannelOwner = Intrinsics.areEqual((Object) user2.getId(), (Object) user.getId());
    }

    public final void removeChannelMemberById(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        Iterator it = getItems().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual((Object) ((Member) it.next()).getUser().getId(), (Object) str)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            removeItemAt(i);
        }
    }

    public final void addChannelMember(Member member) {
        Intrinsics.checkNotNullParameter(member, "member");
        Iterator it = getItems().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual((Object) ((Member) it.next()).getUser().getId(), (Object) member.getUserId())) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            addItem(member);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/members/ChannelMembersAdapter$ChannelMemberViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lio/getstream/chat/android/client/models/Member;", "binding", "Lcom/memes/chat/databinding/ChannelInfoChannelMemberItemBinding;", "(Lcom/memes/chat/ui/channel/members/ChannelMembersAdapter;Lcom/memes/chat/databinding/ChannelInfoChannelMemberItemBinding;)V", "channelMember", "setItem", "", "item", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.members.ChannelMembersAdapter$ChannelMemberViewHolder */
    /* compiled from: ChannelMembersAdapter.kt */
    public final class ChannelMemberViewHolder extends BaseViewHolder<Member> {
        private final ChannelInfoChannelMemberItemBinding binding;
        /* access modifiers changed from: private */
        public Member channelMember;
        final /* synthetic */ ChannelMembersAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ChannelMemberViewHolder(com.memes.chat.p036ui.channel.members.ChannelMembersAdapter r4, com.memes.chat.databinding.ChannelInfoChannelMemberItemBinding r5) {
            /*
                r3 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                r3.this$0 = r4
                androidx.constraintlayout.widget.ConstraintLayout r4 = r5.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
                android.view.View r4 = (android.view.View) r4
                r3.<init>(r4)
                r3.binding = r5
                android.widget.TextView r4 = r5.removeTextView
                java.lang.String r0 = "binding.removeTextView"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
                android.view.View r4 = (android.view.View) r4
                int r0 = com.memes.chat.C4059R.dimen._4sdp
                r1 = 0
                r2 = 2
                com.memes.commons.outlineprovider.ViewCornerOutlineProviderKt.roundCorners$default((android.view.View) r4, (int) r0, (com.memes.commons.outlineprovider.ViewCornerOutlineProvider.CornerType) r1, (int) r2, (java.lang.Object) r1)
                androidx.constraintlayout.widget.ConstraintLayout r4 = r5.getRoot()
                com.memes.chat.ui.channel.members.ChannelMembersAdapter$ChannelMemberViewHolder$1 r0 = new com.memes.chat.ui.channel.members.ChannelMembersAdapter$ChannelMemberViewHolder$1
                r0.<init>(r3)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r4.setOnClickListener(r0)
                android.widget.TextView r4 = r5.removeTextView
                com.memes.chat.ui.channel.members.ChannelMembersAdapter$ChannelMemberViewHolder$2 r5 = new com.memes.chat.ui.channel.members.ChannelMembersAdapter$ChannelMemberViewHolder$2
                r5.<init>(r3)
                android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
                r4.setOnClickListener(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.chat.p036ui.channel.members.ChannelMembersAdapter.ChannelMemberViewHolder.<init>(com.memes.chat.ui.channel.members.ChannelMembersAdapter, com.memes.chat.databinding.ChannelInfoChannelMemberItemBinding):void");
        }

        public static final /* synthetic */ Member access$getChannelMember$p(ChannelMemberViewHolder channelMemberViewHolder) {
            Member member = channelMemberViewHolder.channelMember;
            if (member == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelMember");
            }
            return member;
        }

        public void setItem(Member member) {
            Intrinsics.checkNotNullParameter(member, "item");
            this.channelMember = member;
            TextView textView = this.binding.usernameTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.usernameTextView");
            Member member2 = this.channelMember;
            if (member2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelMember");
            }
            textView.setText(ContentUtils.getName(member2.getUser()));
            Member member3 = this.channelMember;
            if (member3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelMember");
            }
            this.binding.userAvatarView.loadUrl(ContentUtils.getImage(member3.getUser()), C4059R.C4062drawable.chat_user_avatar_placeholder_rounded);
            Member member4 = this.channelMember;
            if (member4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelMember");
            }
            String userId = member4.getUserId();
            if (!this.this$0.isCurrentUserChannelOwner || !(!Intrinsics.areEqual((Object) this.this$0.channelOwnerId, (Object) userId))) {
                TextView textView2 = this.binding.removeTextView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.removeTextView");
                textView2.setVisibility(8);
            } else {
                TextView textView3 = this.binding.removeTextView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.removeTextView");
                textView3.setVisibility(0);
            }
            if (Intrinsics.areEqual((Object) this.this$0.channelOwnerId, (Object) userId)) {
                TextView textView4 = this.binding.adminView;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.adminView");
                textView4.setVisibility(0);
                return;
            }
            TextView textView5 = this.binding.adminView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.adminView");
            textView5.setVisibility(8);
        }
    }
}
