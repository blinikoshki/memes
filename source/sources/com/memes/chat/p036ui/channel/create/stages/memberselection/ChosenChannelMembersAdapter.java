package com.memes.chat.p036ui.channel.create.stages.memberselection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.memes.chat.databinding.AddedChannelMemberItemBinding;
import com.memes.commons.recycleradapter.BaseRecyclerAdapter;
import com.memes.commons.recycleradapter.BaseViewHolder;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\b\u0012\u00060\u0004R\u00020\u00000\u0001:\u0002\u0016\u0017B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003J$\u0010\r\u001a\u00060\u0004R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u000b2\n\u0010\u0015\u001a\u00060\u0002j\u0002`\u0003R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/stages/memberselection/ChosenChannelMembersAdapter;", "Lcom/memes/commons/recycleradapter/BaseRecyclerAdapter;", "Lio/getstream/chat/android/client/models/User;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMember;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChosenChannelMembersAdapter$ChannelMemberViewHolder;", "context", "Landroid/content/Context;", "callback", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChosenChannelMembersAdapter$Callback;", "(Landroid/content/Context;Lcom/memes/chat/ui/channel/create/stages/memberselection/ChosenChannelMembersAdapter$Callback;)V", "addChannelMember", "", "member", "createItemViewHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "removeChannelMember", "targetMember", "Callback", "ChannelMemberViewHolder", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.ChosenChannelMembersAdapter */
/* compiled from: ChosenChannelMembersAdapter.kt */
public final class ChosenChannelMembersAdapter extends BaseRecyclerAdapter<User, ChannelMemberViewHolder> {
    /* access modifiers changed from: private */
    public final Callback callback;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H&¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/stages/memberselection/ChosenChannelMembersAdapter$Callback;", "", "onChannelMemberRemoved", "", "channelMember", "Lio/getstream/chat/android/client/models/User;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMember;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.ChosenChannelMembersAdapter$Callback */
    /* compiled from: ChosenChannelMembersAdapter.kt */
    public interface Callback {
        void onChannelMemberRemoved(User user);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChosenChannelMembersAdapter(Context context, Callback callback2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
    }

    public ChannelMemberViewHolder createItemViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        AddedChannelMemberItemBinding inflate = AddedChannelMemberItemBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "AddedChannelMemberItemBi…(inflater, parent, false)");
        return new ChannelMemberViewHolder(this, inflate);
    }

    public final void addChannelMember(User user) {
        Intrinsics.checkNotNullParameter(user, "member");
        addItem(user);
    }

    public final void removeChannelMember(User user) {
        Intrinsics.checkNotNullParameter(user, "targetMember");
        Iterator it = getItems().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual((Object) ((User) it.next()).getId(), (Object) user.getId())) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            removeItemAt(i);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/stages/memberselection/ChosenChannelMembersAdapter$ChannelMemberViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lio/getstream/chat/android/client/models/User;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMember;", "binding", "Lcom/memes/chat/databinding/AddedChannelMemberItemBinding;", "(Lcom/memes/chat/ui/channel/create/stages/memberselection/ChosenChannelMembersAdapter;Lcom/memes/chat/databinding/AddedChannelMemberItemBinding;)V", "channelMember", "setItem", "", "item", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.ChosenChannelMembersAdapter$ChannelMemberViewHolder */
    /* compiled from: ChosenChannelMembersAdapter.kt */
    public final class ChannelMemberViewHolder extends BaseViewHolder<User> {
        private final AddedChannelMemberItemBinding binding;
        /* access modifiers changed from: private */
        public User channelMember;
        final /* synthetic */ ChosenChannelMembersAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ChannelMemberViewHolder(com.memes.chat.p036ui.channel.create.stages.memberselection.ChosenChannelMembersAdapter r2, com.memes.chat.databinding.AddedChannelMemberItemBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.this$0 = r2
                android.widget.LinearLayout r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.view.View r2 = (android.view.View) r2
                r1.<init>(r2)
                r1.binding = r3
                android.widget.ImageView r2 = r3.removeImageView
                com.memes.chat.ui.channel.create.stages.memberselection.ChosenChannelMembersAdapter$ChannelMemberViewHolder$1 r3 = new com.memes.chat.ui.channel.create.stages.memberselection.ChosenChannelMembersAdapter$ChannelMemberViewHolder$1
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.chat.p036ui.channel.create.stages.memberselection.ChosenChannelMembersAdapter.ChannelMemberViewHolder.<init>(com.memes.chat.ui.channel.create.stages.memberselection.ChosenChannelMembersAdapter, com.memes.chat.databinding.AddedChannelMemberItemBinding):void");
        }

        public static final /* synthetic */ User access$getChannelMember$p(ChannelMemberViewHolder channelMemberViewHolder) {
            User user = channelMemberViewHolder.channelMember;
            if (user == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelMember");
            }
            return user;
        }

        public void setItem(User user) {
            Intrinsics.checkNotNullParameter(user, "item");
            this.channelMember = user;
            TextView textView = this.binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
            User user2 = this.channelMember;
            if (user2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelMember");
            }
            textView.setText(ContentUtils.getName(user2));
        }
    }
}
