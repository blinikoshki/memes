package com.memes.plus.p040ui.posts.post_basics;

import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.posts.post_basics.PostOperationsViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.ui.posts.post_basics.PostOperationsViewModel$savePostToGallery$1", mo26808f = "PostOperationsViewModel.kt", mo26809i = {}, mo26810l = {510}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.plus.ui.posts.post_basics.PostOperationsViewModel$savePostToGallery$1 */
/* compiled from: PostOperationsViewModel.kt */
final class PostOperationsViewModel$savePostToGallery$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Post $post;
    int label;
    final /* synthetic */ PostOperationsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostOperationsViewModel$savePostToGallery$1(PostOperationsViewModel postOperationsViewModel, Post post, Continuation continuation) {
        super(2, continuation);
        this.this$0 = postOperationsViewModel;
        this.$post = post;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new PostOperationsViewModel$savePostToGallery$1(this.this$0, this.$post, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PostOperationsViewModel$savePostToGallery$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PostOperationsViewModel postOperationsViewModel = this.this$0;
            Post post = this.$post;
            this.label = 1;
            obj = postOperationsViewModel.downloadPostContent(post, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PostOperationsViewModel.PostDownloadResult postDownloadResult = (PostOperationsViewModel.PostDownloadResult) obj;
        if (postDownloadResult instanceof PostOperationsViewModel.PostDownloadResult.Success) {
            this.this$0._postContentDownloadLiveData.setValue(((PostOperationsViewModel.PostDownloadResult.Success) postDownloadResult).getPostFile());
            this.this$0.toast("Meme Saved Successfully.");
        } else if (postDownloadResult instanceof PostOperationsViewModel.PostDownloadResult.Error) {
            this.this$0.toast(((PostOperationsViewModel.PostDownloadResult.Error) postDownloadResult).getMessage());
        }
        return Unit.INSTANCE;
    }
}
