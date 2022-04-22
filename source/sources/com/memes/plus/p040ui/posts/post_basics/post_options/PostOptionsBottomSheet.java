package com.memes.plus.p040ui.posts.post_basics.post_options;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.network.memes.MemesSession;
import com.memes.plus.C4199R;
import com.memes.plus.databinding.PostOptionsBottomSheetBinding;
import com.memes.plus.p040ui.posts.Post;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/post_options/PostOptionsBottomSheet;", "Landroidx/fragment/app/DialogFragment;", "post", "Lcom/memes/plus/ui/posts/Post;", "callback", "Lcom/memes/plus/ui/posts/post_basics/post_options/PostOptionsBottomSheet$Callback;", "(Lcom/memes/plus/ui/posts/Post;Lcom/memes/plus/ui/posts/post_basics/post_options/PostOptionsBottomSheet$Callback;)V", "binding", "Lcom/memes/plus/databinding/PostOptionsBottomSheetBinding;", "getBinding", "()Lcom/memes/plus/databinding/PostOptionsBottomSheetBinding;", "setBinding", "(Lcom/memes/plus/databinding/PostOptionsBottomSheetBinding;)V", "getCallback", "()Lcom/memes/plus/ui/posts/post_basics/post_options/PostOptionsBottomSheet$Callback;", "getPost", "()Lcom/memes/plus/ui/posts/Post;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "Callback", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post_basics.post_options.PostOptionsBottomSheet */
/* compiled from: PostOptionsBottomSheet.kt */
public final class PostOptionsBottomSheet extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int ENABLE_NOTIFICATIONS = 463;
    public static final String TAG = "PostOptionsBottomSheet";
    public PostOptionsBottomSheetBinding binding;
    private final Callback callback;
    private final Post post;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/post_options/PostOptionsBottomSheet$Callback;", "", "onPostOptionSelected", "", "post", "Lcom/memes/plus/ui/posts/Post;", "option", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.post_basics.post_options.PostOptionsBottomSheet$Callback */
    /* compiled from: PostOptionsBottomSheet.kt */
    public interface Callback {
        void onPostOptionSelected(Post post, int i);
    }

    public final Post getPost() {
        return this.post;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public PostOptionsBottomSheet(Post post2, Callback callback2) {
        Intrinsics.checkNotNullParameter(post2, "post");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.post = post2;
        this.callback = callback2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/post_options/PostOptionsBottomSheet$Companion;", "", "()V", "ENABLE_NOTIFICATIONS", "", "TAG", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.post_basics.post_options.PostOptionsBottomSheet$Companion */
    /* compiled from: PostOptionsBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final PostOptionsBottomSheetBinding getBinding() {
        PostOptionsBottomSheetBinding postOptionsBottomSheetBinding = this.binding;
        if (postOptionsBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return postOptionsBottomSheetBinding;
    }

    public final void setBinding(PostOptionsBottomSheetBinding postOptionsBottomSheetBinding) {
        Intrinsics.checkNotNullParameter(postOptionsBottomSheetBinding, "<set-?>");
        this.binding = postOptionsBottomSheetBinding;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, C4199R.C4207style.CustomBottomSheetDialogTheme);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        PostOptionsBottomSheetBinding inflate = PostOptionsBottomSheetBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "PostOptionsBottomSheetBi…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return inflate.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        if (!this.post.getIamfollowing() || MemesSession.INSTANCE.isOf(this.post.getUserId())) {
            PostOptionsBottomSheetBinding postOptionsBottomSheetBinding = this.binding;
            if (postOptionsBottomSheetBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = postOptionsBottomSheetBinding.unfollowTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.unfollowTextView");
            textView.setVisibility(8);
            PostOptionsBottomSheetBinding postOptionsBottomSheetBinding2 = this.binding;
            if (postOptionsBottomSheetBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView2 = postOptionsBottomSheetBinding2.toggleNotificationsTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.toggleNotificationsTextView");
            textView2.setVisibility(8);
        } else {
            PostOptionsBottomSheetBinding postOptionsBottomSheetBinding3 = this.binding;
            if (postOptionsBottomSheetBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView3 = postOptionsBottomSheetBinding3.unfollowTextView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.unfollowTextView");
            textView3.setVisibility(0);
            PostOptionsBottomSheetBinding postOptionsBottomSheetBinding4 = this.binding;
            if (postOptionsBottomSheetBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView4 = postOptionsBottomSheetBinding4.toggleNotificationsTextView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.toggleNotificationsTextView");
            textView4.setVisibility(0);
            PostOptionsBottomSheetBinding postOptionsBottomSheetBinding5 = this.binding;
            if (postOptionsBottomSheetBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            postOptionsBottomSheetBinding5.toggleNotificationsTextView.setText(this.post.getNotificationsEnabled() ? C4199R.string.turn_off_post_notifications : C4199R.string.turn_on_post_notifications);
        }
        PostOptionsBottomSheetBinding postOptionsBottomSheetBinding6 = this.binding;
        if (postOptionsBottomSheetBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        postOptionsBottomSheetBinding6.toggleNotificationsTextView.setOnClickListener(new PostOptionsBottomSheet$onViewCreated$1(this));
    }
}
