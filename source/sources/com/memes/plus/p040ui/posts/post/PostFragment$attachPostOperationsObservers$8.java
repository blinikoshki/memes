package com.memes.plus.p040ui.posts.post;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.memes.commons.media.MediaScannerUtility;
import com.memes.plus.p040ui.posts.postfile.PostFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "postFile", "Lcom/memes/plus/ui/posts/postfile/PostFile;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post.PostFragment$attachPostOperationsObservers$8 */
/* compiled from: PostFragment.kt */
final class PostFragment$attachPostOperationsObservers$8<T> implements Observer<PostFile> {
    final /* synthetic */ PostFragment this$0;

    PostFragment$attachPostOperationsObservers$8(PostFragment postFragment) {
        this.this$0 = postFragment;
    }

    public final void onChanged(PostFile postFile) {
        File file = postFile.getFile();
        Context context = this.this$0.getContext();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            new MediaScannerUtility(applicationContext).scan(file);
            return;
        }
        Timber.m303e("safeContext() prevented a null-context call.", new Object[0]);
    }
}
