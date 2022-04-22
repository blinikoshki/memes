package com.memes.plus.p040ui.posts.post_basics;

import com.facebook.share.internal.ShareConstants;
import com.memes.commons.media.MediaContentDownloader;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.posts.post_basics.PostOperationsViewModel;
import com.memes.plus.p040ui.posts.postfile.PostFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f¸\u0006\u0000"}, mo26107d2 = {"com/memes/plus/ui/posts/post_basics/PostOperationsViewModel$downloadPostContent$2$callback$1", "Lcom/memes/commons/media/MediaContentDownloader$Callback;", "onDownloadComplete", "", "file", "Ljava/io/File;", "onError", "message", "", "onProgressChanged", "progress", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post_basics.PostOperationsViewModel$downloadPostContent$$inlined$suspendCoroutine$lambda$1 */
/* compiled from: PostOperationsViewModel.kt */
public final class C4324xd42b439e implements MediaContentDownloader.Callback {
    final /* synthetic */ Ref.IntRef $contentType$inlined;
    final /* synthetic */ Continuation $continuation;
    final /* synthetic */ Ref.ObjectRef $outputExtension$inlined;
    final /* synthetic */ Ref.ObjectRef $outputFile$inlined;
    final /* synthetic */ Post $post$inlined;
    final /* synthetic */ Ref.ObjectRef $postContentUrl$inlined;
    final /* synthetic */ PostOperationsViewModel this$0;

    C4324xd42b439e(Continuation continuation, PostOperationsViewModel postOperationsViewModel, Post post, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.IntRef intRef, Ref.ObjectRef objectRef3) {
        this.$continuation = continuation;
        this.this$0 = postOperationsViewModel;
        this.$post$inlined = post;
        this.$outputFile$inlined = objectRef;
        this.$outputExtension$inlined = objectRef2;
        this.$contentType$inlined = intRef;
        this.$postContentUrl$inlined = objectRef3;
    }

    public void onProgressChanged(int i) {
        PostOperationsViewModel postOperationsViewModel = this.this$0;
        postOperationsViewModel.updateBlockingProgressDialogLabel("Processing... " + i + '%');
    }

    public void onDownloadComplete(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.this$0.hideBlockingProgressDialog();
        PostOperationsViewModel.PostDownloadResult.Success success = new PostOperationsViewModel.PostDownloadResult.Success(new PostFile(this.$post$inlined, file));
        Continuation continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m1029constructorimpl(success));
    }

    public void onError(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.this$0.hideBlockingProgressDialog();
        PostOperationsViewModel.PostDownloadResult.Error error = new PostOperationsViewModel.PostDownloadResult.Error(str);
        Continuation continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m1029constructorimpl(error));
    }
}
