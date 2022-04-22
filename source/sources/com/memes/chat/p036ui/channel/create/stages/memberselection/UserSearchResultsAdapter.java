package com.memes.chat.p036ui.channel.create.stages.memberselection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.memes.chat.C4059R;
import com.memes.chat.databinding.ChatUserSearchResultItemBinding;
import com.memes.commons.recycleradapter.BaseRecyclerAdapter;
import com.memes.commons.recycleradapter.BaseViewHolder;
import com.memes.network.memes.source.remote.model.usersearch.UserSearchResult;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0018\u0019B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bJ\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/stages/memberselection/UserSearchResultsAdapter;", "Lcom/memes/commons/recycleradapter/BaseRecyclerAdapter;", "Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchResult;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/UserSearchResultsAdapter$UserSuggestionViewHolder;", "context", "Landroid/content/Context;", "onUserSearchResultTappedListener", "Lcom/memes/chat/ui/channel/create/stages/memberselection/UserSearchResultsAdapter$OnUserSearchResultTappedListener;", "(Landroid/content/Context;Lcom/memes/chat/ui/channel/create/stages/memberselection/UserSearchResultsAdapter$OnUserSearchResultTappedListener;)V", "selectedUserIdsSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "createItemViewHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "removeItemSelectionById", "", "id", "setSelectedItemById", "OnUserSearchResultTappedListener", "UserSuggestionViewHolder", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.UserSearchResultsAdapter */
/* compiled from: UserSearchResultsAdapter.kt */
public final class UserSearchResultsAdapter extends BaseRecyclerAdapter<UserSearchResult, UserSuggestionViewHolder> {
    /* access modifiers changed from: private */
    public final OnUserSearchResultTappedListener onUserSearchResultTappedListener;
    /* access modifiers changed from: private */
    public final HashSet<String> selectedUserIdsSet = new HashSet<>();

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/stages/memberselection/UserSearchResultsAdapter$OnUserSearchResultTappedListener;", "", "onUserSearchResultTapped", "", "userSearchResult", "Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchResult;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.UserSearchResultsAdapter$OnUserSearchResultTappedListener */
    /* compiled from: UserSearchResultsAdapter.kt */
    public interface OnUserSearchResultTappedListener {
        void onUserSearchResultTapped(UserSearchResult userSearchResult);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserSearchResultsAdapter(Context context, OnUserSearchResultTappedListener onUserSearchResultTappedListener2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onUserSearchResultTappedListener2, "onUserSearchResultTappedListener");
        this.onUserSearchResultTappedListener = onUserSearchResultTappedListener2;
    }

    public UserSuggestionViewHolder createItemViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ChatUserSearchResultItemBinding inflate = ChatUserSearchResultItemBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "ChatUserSearchResultItem…(inflater, parent, false)");
        return new UserSuggestionViewHolder(this, inflate);
    }

    public final void setSelectedItemById(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (!this.selectedUserIdsSet.contains(str)) {
            this.selectedUserIdsSet.add(str);
            int i = 0;
            Iterator it = getItems().iterator();
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual((Object) ((UserSearchResult) it.next()).chatUserId(), (Object) str)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                notifyItemChanged(i);
            }
        }
    }

    public final void removeItemSelectionById(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (this.selectedUserIdsSet.contains(str)) {
            this.selectedUserIdsSet.remove(str);
            int i = 0;
            Iterator it = getItems().iterator();
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual((Object) ((UserSearchResult) it.next()).chatUserId(), (Object) str)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                notifyItemChanged(i);
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/stages/memberselection/UserSearchResultsAdapter$UserSuggestionViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchResult;", "binding", "Lcom/memes/chat/databinding/ChatUserSearchResultItemBinding;", "(Lcom/memes/chat/ui/channel/create/stages/memberselection/UserSearchResultsAdapter;Lcom/memes/chat/databinding/ChatUserSearchResultItemBinding;)V", "userSearchResult", "setItem", "", "item", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.UserSearchResultsAdapter$UserSuggestionViewHolder */
    /* compiled from: UserSearchResultsAdapter.kt */
    public final class UserSuggestionViewHolder extends BaseViewHolder<UserSearchResult> {
        private final ChatUserSearchResultItemBinding binding;
        final /* synthetic */ UserSearchResultsAdapter this$0;
        /* access modifiers changed from: private */
        public UserSearchResult userSearchResult;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public UserSuggestionViewHolder(com.memes.chat.p036ui.channel.create.stages.memberselection.UserSearchResultsAdapter r2, com.memes.chat.databinding.ChatUserSearchResultItemBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.this$0 = r2
                androidx.constraintlayout.widget.ConstraintLayout r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.view.View r2 = (android.view.View) r2
                r1.<init>(r2)
                r1.binding = r3
                androidx.constraintlayout.widget.ConstraintLayout r2 = r3.getRoot()
                com.memes.chat.ui.channel.create.stages.memberselection.UserSearchResultsAdapter$UserSuggestionViewHolder$1 r3 = new com.memes.chat.ui.channel.create.stages.memberselection.UserSearchResultsAdapter$UserSuggestionViewHolder$1
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.chat.p036ui.channel.create.stages.memberselection.UserSearchResultsAdapter.UserSuggestionViewHolder.<init>(com.memes.chat.ui.channel.create.stages.memberselection.UserSearchResultsAdapter, com.memes.chat.databinding.ChatUserSearchResultItemBinding):void");
        }

        public static final /* synthetic */ UserSearchResult access$getUserSearchResult$p(UserSuggestionViewHolder userSuggestionViewHolder) {
            UserSearchResult userSearchResult2 = userSuggestionViewHolder.userSearchResult;
            if (userSearchResult2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userSearchResult");
            }
            return userSearchResult2;
        }

        public void setItem(UserSearchResult userSearchResult2) {
            Intrinsics.checkNotNullParameter(userSearchResult2, "item");
            this.userSearchResult = userSearchResult2;
            TextView textView = this.binding.usernameTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.usernameTextView");
            UserSearchResult userSearchResult3 = this.userSearchResult;
            if (userSearchResult3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userSearchResult");
            }
            textView.setText(userSearchResult3.getUserName());
            TextView textView2 = this.binding.fullNameTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.fullNameTextView");
            UserSearchResult userSearchResult4 = this.userSearchResult;
            if (userSearchResult4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userSearchResult");
            }
            textView2.setText(userSearchResult4.getFullName());
            UserSearchResult userSearchResult5 = this.userSearchResult;
            if (userSearchResult5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userSearchResult");
            }
            this.binding.userAvatarView.loadUrl(userSearchResult5.getProfileImageThumbUrl(), C4059R.C4062drawable.chat_user_avatar_placeholder_rounded);
            Iterable access$getSelectedUserIdsSet$p = this.this$0.selectedUserIdsSet;
            UserSearchResult userSearchResult6 = this.userSearchResult;
            if (userSearchResult6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userSearchResult");
            }
            boolean contains = CollectionsKt.contains(access$getSelectedUserIdsSet$p, userSearchResult6.chatUserId());
            AppCompatImageView appCompatImageView = this.binding.userSelectionIndicatorView;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.userSelectionIndicatorView");
            appCompatImageView.setSelected(contains);
        }
    }
}
