package com.memes.plus.p040ui.posts.post_basics.post_save;

import androidx.fragment.app.FragmentManager;
import com.memes.commons.choices.Choice;
import com.memes.commons.choices.ChoicesBottomSheet;
import com.memes.plus.p040ui.posts.Post;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0002\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/post_save/PostSaveOptionsBottomSheet;", "Lcom/memes/commons/choices/ChoicesBottomSheet;", "Lcom/memes/commons/choices/ChoicesBottomSheet$Callback;", "()V", "callback", "Lcom/memes/plus/ui/posts/post_basics/post_save/PostSaveOptionsBottomSheet$Callback;", "onChoiceSelected", "", "choice", "Lcom/memes/commons/choices/Choice;", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "post", "Lcom/memes/plus/ui/posts/Post;", "Callback", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post_basics.post_save.PostSaveOptionsBottomSheet */
/* compiled from: PostSaveOptionsBottomSheet.kt */
public final class PostSaveOptionsBottomSheet extends ChoicesBottomSheet implements ChoicesBottomSheet.Callback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Choice REMOVE_FROM_PROFILE = Choice.Companion.create$default(Choice.Companion, "channel-remove-from-profile", "Remove from Profile", false, Choice.HighlightType.PRIMARY, 4, (Object) null);
    private static final Choice SAVE_TO_GALLERY = Choice.Companion.create$default(Choice.Companion, "channel-save-to-gallery", "Save To Gallery", false, Choice.HighlightType.PRIMARY, 4, (Object) null);
    private static final Choice SAVE_TO_PROFILE = Choice.Companion.create$default(Choice.Companion, "channel-save-to-profile", "Save To Profile", false, Choice.HighlightType.PRIMARY, 4, (Object) null);
    private Callback callback;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/post_save/PostSaveOptionsBottomSheet$Callback;", "", "onRemovePostFromProfile", "", "onSavePostToGallery", "onSavePostToProfile", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.post_basics.post_save.PostSaveOptionsBottomSheet$Callback */
    /* compiled from: PostSaveOptionsBottomSheet.kt */
    public interface Callback {
        void onRemovePostFromProfile();

        void onSavePostToGallery();

        void onSavePostToProfile();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/post_save/PostSaveOptionsBottomSheet$Companion;", "", "()V", "REMOVE_FROM_PROFILE", "Lcom/memes/commons/choices/Choice;", "SAVE_TO_GALLERY", "SAVE_TO_PROFILE", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.post_basics.post_save.PostSaveOptionsBottomSheet$Companion */
    /* compiled from: PostSaveOptionsBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void show(FragmentManager fragmentManager, Callback callback2, Post post) {
        List list;
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        Intrinsics.checkNotNullParameter(post, "post");
        if (post.getSaved()) {
            list = CollectionsKt.mutableListOf(SAVE_TO_GALLERY, REMOVE_FROM_PROFILE);
        } else {
            list = CollectionsKt.mutableListOf(SAVE_TO_GALLERY, SAVE_TO_PROFILE);
        }
        this.callback = callback2;
        show(fragmentManager, list, this);
    }

    public void onChoiceSelected(Choice choice) {
        Callback callback2;
        Intrinsics.checkNotNullParameter(choice, "choice");
        String id = choice.getId();
        if (Intrinsics.areEqual((Object) id, (Object) SAVE_TO_GALLERY.getId())) {
            Callback callback3 = this.callback;
            if (callback3 != null) {
                callback3.onSavePostToGallery();
            }
        } else if (Intrinsics.areEqual((Object) id, (Object) SAVE_TO_PROFILE.getId())) {
            Callback callback4 = this.callback;
            if (callback4 != null) {
                callback4.onSavePostToProfile();
            }
        } else if (Intrinsics.areEqual((Object) id, (Object) REMOVE_FROM_PROFILE.getId()) && (callback2 = this.callback) != null) {
            callback2.onRemovePostFromProfile();
        }
    }
}
