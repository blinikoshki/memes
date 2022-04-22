package com.memes.plus.p040ui.posts.post_basics;

import com.facebook.share.internal.ShareConstants;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.events.EventNotifier;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.posts.post_basics.post_report.PostReportResult;
import com.memes.plus.util.SmartSingleObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.reactivex.disposables.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u000f"}, mo26107d2 = {"com/memes/plus/ui/posts/post_basics/PostOperationsViewModel$reportPost$1", "Lcom/memes/plus/util/SmartSingleObserver;", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "", "onError", "", "message", "", "throwable", "", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "onSuccess", "universalResult", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post_basics.PostOperationsViewModel$reportPost$1 */
/* compiled from: PostOperationsViewModel.kt */
public final class PostOperationsViewModel$reportPost$1 extends SmartSingleObserver<UniversalResult<Object>> {
    final /* synthetic */ Post $post;
    final /* synthetic */ PostOperationsViewModel this$0;

    PostOperationsViewModel$reportPost$1(PostOperationsViewModel postOperationsViewModel, Post post) {
        this.this$0 = postOperationsViewModel;
        this.$post = post;
    }

    public void onSubscribe(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "d");
        this.this$0.addDisposable(disposable);
    }

    public void onSuccess(UniversalResult<Object> universalResult) {
        String str;
        Intrinsics.checkNotNullParameter(universalResult, "universalResult");
        if (!universalResult.isError()) {
            if (StringsKt.isBlank(universalResult.getMessage())) {
                str = "Post reported successfully";
            } else {
                str = universalResult.getMessage();
            }
            this.this$0._postReportLiveData.setValue(new PostReportResult(this.$post.getPostId(), str));
            EventNotifier.INSTANCE.notifyPostReported(this.$post);
        } else if (universalResult.isSessionExpired()) {
            PostOperationsViewModel postOperationsViewModel = this.this$0;
            postOperationsViewModel.showSessionExpiredDialog("Error: " + universalResult.getMessage());
        } else {
            PostOperationsViewModel postOperationsViewModel2 = this.this$0;
            postOperationsViewModel2.toast("Error: " + universalResult.getMessage());
        }
    }

    public void onError(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(th, "throwable");
        PostOperationsViewModel postOperationsViewModel = this.this$0;
        postOperationsViewModel.toast("Error: " + str);
    }
}
