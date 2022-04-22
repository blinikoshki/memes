package com.memes.plus.p040ui.posts.post_tags_dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.network.core.ResultState;
import com.memes.plus.C4199R;
import com.memes.plus.databinding.PostTaggedUsersDialogLayoutBinding;
import editor.util.ExtKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0016\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\u0006\u0010\u000f\u001a\u00020\u0002J\u001a\u0010\"\u001a\u00020\u00192\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0%0$R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersDialogCallBack;", "()V", "_binding", "Lcom/memes/plus/databinding/PostTaggedUsersDialogLayoutBinding;", "adapter", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersAdapter;", "getAdapter", "()Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lcom/memes/plus/databinding/PostTaggedUsersDialogLayoutBinding;", "callback", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "", "onViewCreated", "view", "onViewProfilePageTapped", "taggedUser", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUser;", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "update", "resultState", "Lcom/memes/network/core/ResultState;", "", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post_tags_dialog.PostTaggedUsersDialogFragment */
/* compiled from: PostTaggedUsersDialogFragment.kt */
public final class PostTaggedUsersDialogFragment extends DialogFragment implements PostTaggedUsersDialogCallBack {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "tagged-users-dialog";
    private PostTaggedUsersDialogLayoutBinding _binding;
    private final Lazy adapter$delegate = LazyKt.lazy(new PostTaggedUsersDialogFragment$adapter$2(this));
    private PostTaggedUsersDialogCallBack callback;

    private final PostTaggedUsersAdapter getAdapter() {
        return (PostTaggedUsersAdapter) this.adapter$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersDialogFragment$Companion;", "", "()V", "TAG", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.post_tags_dialog.PostTaggedUsersDialogFragment$Companion */
    /* compiled from: PostTaggedUsersDialogFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final PostTaggedUsersDialogLayoutBinding getBinding() {
        PostTaggedUsersDialogLayoutBinding postTaggedUsersDialogLayoutBinding = this._binding;
        Intrinsics.checkNotNull(postTaggedUsersDialogLayoutBinding);
        return postTaggedUsersDialogLayoutBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this._binding = PostTaggedUsersDialogLayoutBinding.inflate(layoutInflater, (ViewGroup) null, false);
        FrameLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = getBinding().tagsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.tagsRecyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = getBinding().tagsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.tagsRecyclerView");
        recyclerView2.setAdapter(getAdapter());
        getBinding().hideDialogView.setOnClickListener(new PostTaggedUsersDialogFragment$onViewCreated$1(this));
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(false);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setLayout(-1, -2);
            }
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setBackgroundDrawable(new ColorDrawable(0));
            }
            dialog.setOnShowListener(new PostTaggedUsersDialogFragment$onViewCreated$2(this));
        }
    }

    public void onPause() {
        super.onPause();
        dismiss();
    }

    public final void show(FragmentManager fragmentManager, PostTaggedUsersDialogCallBack postTaggedUsersDialogCallBack) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(postTaggedUsersDialogCallBack, "callback");
        if (!ExtKt.fragmentTagExists(fragmentManager, TAG)) {
            this.callback = postTaggedUsersDialogCallBack;
            show(fragmentManager, TAG);
        }
    }

    public final void update(ResultState<? extends List<PostTaggedUser>> resultState) {
        Intrinsics.checkNotNullParameter(resultState, "resultState");
        if (resultState instanceof ResultState.Success) {
            getAdapter().setItems((List) ((ResultState.Success) resultState).getData());
            getBinding().tagsRecyclerView.scrollToPosition(0);
            getBinding().contentLayout.showContent();
        } else if (resultState instanceof ResultState.Loading) {
            ContentLayout.showProgress$default(getBinding().contentLayout, (String) null, 1, (Object) null);
        } else if (resultState instanceof ResultState.Error) {
            ResultState.Error error = (ResultState.Error) resultState;
            if (error.getCanRetry()) {
                getBinding().contentLayout.showError(error.getMessage());
            } else {
                getBinding().contentLayout.showContentNotAvailable(error.getMessage());
            }
        }
        getBinding().hideDialogView.setText(C4199R.string.hide);
    }

    public void onViewProfilePageTapped(PostTaggedUser postTaggedUser) {
        Intrinsics.checkNotNullParameter(postTaggedUser, "taggedUser");
        PostTaggedUsersDialogCallBack postTaggedUsersDialogCallBack = this.callback;
        if (postTaggedUsersDialogCallBack != null) {
            postTaggedUsersDialogCallBack.onViewProfilePageTapped(postTaggedUser);
        }
        dismiss();
    }
}
