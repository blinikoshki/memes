package com.memes.plus.p040ui.posts.post_tags_dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.memes.commons.recycleradapter.BaseRecyclerAdapter;
import com.memes.commons.recycleradapter.BaseViewHolder;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;
import com.memes.plus.databinding.PostTaggedUsersItemBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersAdapter;", "Lcom/memes/commons/recycleradapter/BaseRecyclerAdapter;", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUser;", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersAdapter$PostTaggedUserViewHolder;", "context", "Landroid/content/Context;", "callback", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersDialogCallBack;", "(Landroid/content/Context;Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersDialogCallBack;)V", "createItemViewHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "PostTaggedUserViewHolder", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post_tags_dialog.PostTaggedUsersAdapter */
/* compiled from: PostTaggedUsersAdapter.kt */
public final class PostTaggedUsersAdapter extends BaseRecyclerAdapter<PostTaggedUser, PostTaggedUserViewHolder> {
    /* access modifiers changed from: private */
    public final PostTaggedUsersDialogCallBack callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PostTaggedUsersAdapter(Context context, PostTaggedUsersDialogCallBack postTaggedUsersDialogCallBack) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(postTaggedUsersDialogCallBack, "callback");
        this.callback = postTaggedUsersDialogCallBack;
    }

    public PostTaggedUserViewHolder createItemViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        PostTaggedUsersItemBinding inflate = PostTaggedUsersItemBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "PostTaggedUsersItemBindi…(inflater, parent, false)");
        return new PostTaggedUserViewHolder(this, inflate);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersAdapter$PostTaggedUserViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUser;", "binding", "Lcom/memes/plus/databinding/PostTaggedUsersItemBinding;", "(Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersAdapter;Lcom/memes/plus/databinding/PostTaggedUsersItemBinding;)V", "user", "setItem", "", "item", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.post_tags_dialog.PostTaggedUsersAdapter$PostTaggedUserViewHolder */
    /* compiled from: PostTaggedUsersAdapter.kt */
    public final class PostTaggedUserViewHolder extends BaseViewHolder<PostTaggedUser> {
        private final PostTaggedUsersItemBinding binding;
        final /* synthetic */ PostTaggedUsersAdapter this$0;
        /* access modifiers changed from: private */
        public PostTaggedUser user;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public PostTaggedUserViewHolder(com.memes.plus.p040ui.posts.post_tags_dialog.PostTaggedUsersAdapter r2, com.memes.plus.databinding.PostTaggedUsersItemBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.this$0 = r2
                android.widget.FrameLayout r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.view.View r2 = (android.view.View) r2
                r1.<init>(r2)
                r1.binding = r3
                android.widget.TextView r2 = r3.viewProfileTextView
                com.memes.plus.ui.posts.post_tags_dialog.PostTaggedUsersAdapter$PostTaggedUserViewHolder$1 r3 = new com.memes.plus.ui.posts.post_tags_dialog.PostTaggedUsersAdapter$PostTaggedUserViewHolder$1
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.posts.post_tags_dialog.PostTaggedUsersAdapter.PostTaggedUserViewHolder.<init>(com.memes.plus.ui.posts.post_tags_dialog.PostTaggedUsersAdapter, com.memes.plus.databinding.PostTaggedUsersItemBinding):void");
        }

        public static final /* synthetic */ PostTaggedUser access$getUser$p(PostTaggedUserViewHolder postTaggedUserViewHolder) {
            PostTaggedUser postTaggedUser = postTaggedUserViewHolder.user;
            if (postTaggedUser == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            return postTaggedUser;
        }

        public void setItem(PostTaggedUser postTaggedUser) {
            Intrinsics.checkNotNullParameter(postTaggedUser, "item");
            this.user = postTaggedUser;
            TextView textView = this.binding.profileNameTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.profileNameTextView");
            PostTaggedUser postTaggedUser2 = this.user;
            if (postTaggedUser2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            textView.setText(postTaggedUser2.getFullName());
            TextView textView2 = this.binding.profileUsernameTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.profileUsernameTextView");
            PostTaggedUser postTaggedUser3 = this.user;
            if (postTaggedUser3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            textView2.setText(postTaggedUser3.getUserName());
            this.binding.profilePicView.setProUser(postTaggedUser.isProUser());
            UserAvatarView userAvatarView = this.binding.profilePicView;
            PostTaggedUser postTaggedUser4 = this.user;
            if (postTaggedUser4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            UserAvatarView.loadUrl$default(userAvatarView, postTaggedUser4.getProfileImageThumbUrl(), C4199R.C4202drawable.placeholder_profile, (Integer) null, 4, (Object) null);
        }
    }
}
