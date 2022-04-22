package com.memes.chat.p036ui.channel.members;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.memes.chat.databinding.ChannelMembersShowAllItemBinding;
import com.memes.commons.recycleradapter.BaseRecyclerAdapter;
import com.memes.commons.recycleradapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0019\u001aB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/members/ChannelMembersShowAllAdapter;", "Lcom/memes/commons/recycleradapter/BaseRecyclerAdapter;", "", "Lcom/memes/chat/ui/channel/members/ChannelMembersShowAllAdapter$ShowAllMembersViewHolder;", "context", "Landroid/content/Context;", "callback", "Lcom/memes/chat/ui/channel/members/ChannelMembersShowAllAdapter$Callback;", "(Landroid/content/Context;Lcom/memes/chat/ui/channel/members/ChannelMembersShowAllAdapter$Callback;)V", "isShowlAllItemVisible", "", "createItemViewHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "setShowlAllItemVisible", "visible", "Callback", "ShowAllMembersViewHolder", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.ChannelMembersShowAllAdapter */
/* compiled from: ChannelMembersShowAllAdapter.kt */
public final class ChannelMembersShowAllAdapter extends BaseRecyclerAdapter<Object, ShowAllMembersViewHolder> {
    /* access modifiers changed from: private */
    public final Callback callback;
    private boolean isShowlAllItemVisible;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/members/ChannelMembersShowAllAdapter$Callback;", "", "onShowAllMembersTapped", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.members.ChannelMembersShowAllAdapter$Callback */
    /* compiled from: ChannelMembersShowAllAdapter.kt */
    public interface Callback {
        void onShowAllMembersTapped();
    }

    public void onBindViewHolder(ShowAllMembersViewHolder showAllMembersViewHolder, int i) {
        Intrinsics.checkNotNullParameter(showAllMembersViewHolder, "holder");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelMembersShowAllAdapter(Context context, Callback callback2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
    }

    public ShowAllMembersViewHolder createItemViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ChannelMembersShowAllItemBinding inflate = ChannelMembersShowAllItemBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "ChannelMembersShowAllIte…(inflater, parent, false)");
        return new ShowAllMembersViewHolder(this, inflate);
    }

    public int getItemCount() {
        return this.isShowlAllItemVisible ? 1 : 0;
    }

    public final void setShowlAllItemVisible(boolean z) {
        this.isShowlAllItemVisible = z;
        notifyDataSetChanged();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/members/ChannelMembersShowAllAdapter$ShowAllMembersViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "", "binding", "Lcom/memes/chat/databinding/ChannelMembersShowAllItemBinding;", "(Lcom/memes/chat/ui/channel/members/ChannelMembersShowAllAdapter;Lcom/memes/chat/databinding/ChannelMembersShowAllItemBinding;)V", "setItem", "", "item", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.members.ChannelMembersShowAllAdapter$ShowAllMembersViewHolder */
    /* compiled from: ChannelMembersShowAllAdapter.kt */
    public final class ShowAllMembersViewHolder extends BaseViewHolder<Object> {
        private final ChannelMembersShowAllItemBinding binding;
        final /* synthetic */ ChannelMembersShowAllAdapter this$0;

        public void setItem(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "item");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ShowAllMembersViewHolder(com.memes.chat.p036ui.channel.members.ChannelMembersShowAllAdapter r2, com.memes.chat.databinding.ChannelMembersShowAllItemBinding r3) {
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
                android.widget.LinearLayout r2 = r3.getRoot()
                com.memes.chat.ui.channel.members.ChannelMembersShowAllAdapter$ShowAllMembersViewHolder$1 r3 = new com.memes.chat.ui.channel.members.ChannelMembersShowAllAdapter$ShowAllMembersViewHolder$1
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.chat.p036ui.channel.members.ChannelMembersShowAllAdapter.ShowAllMembersViewHolder.<init>(com.memes.chat.ui.channel.members.ChannelMembersShowAllAdapter, com.memes.chat.databinding.ChannelMembersShowAllItemBinding):void");
        }
    }
}
