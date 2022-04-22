package com.memes.plus.p040ui.posts.post_basics;

import com.facebook.share.internal.ShareConstants;
import com.memes.commons.media.MediaContentDownloader;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.posts.post_basics.post_options.PostOption;
import com.memes.plus.p040ui.posts.postfile.PostFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, mo26107d2 = {"com/memes/plus/ui/posts/post_basics/PostBasicsViewModel$downloadPost$1", "Lcom/memes/commons/media/MediaContentDownloader$Callback;", "onDownloadComplete", "", "file", "Ljava/io/File;", "onError", "message", "", "onProgressChanged", "progress", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post_basics.PostBasicsViewModel$downloadPost$1 */
/* compiled from: PostBasicsViewModel.kt */
public final class PostBasicsViewModel$downloadPost$1 implements MediaContentDownloader.Callback {
    final /* synthetic */ Post $post;
    final /* synthetic */ PostOption $selectedOption;
    final /* synthetic */ PostBasicsViewModel this$0;

    PostBasicsViewModel$downloadPost$1(PostBasicsViewModel postBasicsViewModel, PostOption postOption, Post post) {
        this.this$0 = postBasicsViewModel;
        this.$selectedOption = postOption;
        this.$post = post;
    }

    public void onProgressChanged(int i) {
        PostBasicsViewModel postBasicsViewModel = this.this$0;
        postBasicsViewModel.updateBlockingProgressDialogLabel("Processing... " + i + '%');
    }

    public void onDownloadComplete(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.this$0.hideBlockingProgressDialog();
        this.this$0.performActionAfterDownload(this.$selectedOption, new PostFile(this.$post, file));
    }

    public void onError(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.this$0.hideBlockingProgressDialog();
        this.this$0.toast(str);
    }
}
