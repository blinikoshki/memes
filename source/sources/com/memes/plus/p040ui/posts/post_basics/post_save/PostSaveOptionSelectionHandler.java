package com.memes.plus.p040ui.posts.post_basics.post_save;

import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.posts.post_basics.PostOperationsViewModel;
import com.memes.plus.p040ui.posts.post_basics.post_save.PostSaveOptionsBottomSheet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/post_save/PostSaveOptionSelectionHandler;", "Lcom/memes/plus/ui/posts/post_basics/post_save/PostSaveOptionsBottomSheet$Callback;", "postOperationsViewModel", "Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;", "post", "Lcom/memes/plus/ui/posts/Post;", "(Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;Lcom/memes/plus/ui/posts/Post;)V", "onRemovePostFromProfile", "", "onSavePostToGallery", "onSavePostToProfile", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post_basics.post_save.PostSaveOptionSelectionHandler */
/* compiled from: PostSaveOptionSelectionHandler.kt */
public final class PostSaveOptionSelectionHandler implements PostSaveOptionsBottomSheet.Callback {
    private final Post post;
    private final PostOperationsViewModel postOperationsViewModel;

    public PostSaveOptionSelectionHandler(PostOperationsViewModel postOperationsViewModel2, Post post2) {
        Intrinsics.checkNotNullParameter(postOperationsViewModel2, "postOperationsViewModel");
        Intrinsics.checkNotNullParameter(post2, "post");
        this.postOperationsViewModel = postOperationsViewModel2;
        this.post = post2;
    }

    public void onSavePostToGallery() {
        this.postOperationsViewModel.savePostToGallery(this.post);
    }

    public void onSavePostToProfile() {
        this.postOperationsViewModel.togglePostSave(this.post);
    }

    public void onRemovePostFromProfile() {
        this.postOperationsViewModel.togglePostSave(this.post);
    }
}
