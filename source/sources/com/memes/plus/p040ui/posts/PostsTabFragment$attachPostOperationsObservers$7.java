package com.memes.plus.p040ui.posts;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.memes.plus.p040ui.posts.postfile.PostFile;
import com.memes.plus.util.ShareFileUtil;
import java.io.File;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "postFile", "Lcom/memes/plus/ui/posts/postfile/PostFile;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostsTabFragment$attachPostOperationsObservers$7 */
/* compiled from: PostsTabFragment.kt */
final class PostsTabFragment$attachPostOperationsObservers$7<T> implements Observer<PostFile> {
    final /* synthetic */ PostsTabFragment this$0;

    PostsTabFragment$attachPostOperationsObservers$7(PostsTabFragment postsTabFragment) {
        this.this$0 = postsTabFragment;
    }

    public final void onChanged(PostFile postFile) {
        File file = postFile.getFile();
        Context context = this.this$0.getContext();
        if (context != null) {
            new ShareFileUtil(context).share(new ShareFileUtil.ShareFileRequest(file, (String) null, 2, (DefaultConstructorMarker) null));
        } else {
            Timber.m303e("safeContext() prevented a null-context call.", new Object[0]);
        }
    }
}
