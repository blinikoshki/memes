package com.memes.plus.p040ui.posts;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaType;
import com.memes.commons.util.ActivityStarter;
import com.memes.plus.p040ui.create_post.ExportPostActivity;
import com.memes.plus.p040ui.posts.postfile.PostFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "postFile", "Lcom/memes/plus/ui/posts/postfile/PostFile;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostsTabFragment$attachPostOperationsObservers$9 */
/* compiled from: PostsTabFragment.kt */
final class PostsTabFragment$attachPostOperationsObservers$9<T> implements Observer<PostFile> {
    final /* synthetic */ PostsTabFragment this$0;

    PostsTabFragment$attachPostOperationsObservers$9(PostsTabFragment postsTabFragment) {
        this.this$0 = postsTabFragment;
    }

    public final void onChanged(PostFile postFile) {
        int i;
        Post post = postFile.getPost();
        String requirePostId = post.requirePostId();
        File file = postFile.getFile();
        int contentType = post.contentType();
        if (contentType == 1) {
            i = MediaType.PHOTO;
        } else if (contentType == 2) {
            i = MediaType.VIDEO;
        } else {
            throw new RuntimeException("Unknown Media Type");
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        MediaContent mediaContent = new MediaContent(i, absolutePath, post.getWidth(), post.getHeight());
        Context context = this.this$0.getContext();
        if (context != null) {
            ActivityStarter.Companion.mo57312of(ExportPostActivity.Companion.getStartIntent(context, mediaContent, requirePostId)).startFrom((Fragment) this.this$0);
        } else {
            Timber.m303e("safeContext() prevented a null-context call.", new Object[0]);
        }
    }
}
