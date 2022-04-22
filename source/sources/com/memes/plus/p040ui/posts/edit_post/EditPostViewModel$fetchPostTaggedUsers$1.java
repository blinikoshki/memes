package com.memes.plus.p040ui.posts.edit_post;

import com.google.gson.Gson;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.data.source.memes.MemesRepository;
import com.memes.plus.p040ui.posts.post_tags_dialog.PostTaggedUser;
import com.memes.plus.p040ui.posts.post_tags_dialog.PostTaggedUsersRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.ui.posts.edit_post.EditPostViewModel$fetchPostTaggedUsers$1", mo26808f = "EditPostViewModel.kt", mo26809i = {}, mo26810l = {118}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.plus.ui.posts.edit_post.EditPostViewModel$fetchPostTaggedUsers$1 */
/* compiled from: EditPostViewModel.kt */
final class EditPostViewModel$fetchPostTaggedUsers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $postId;
    int label;
    final /* synthetic */ EditPostViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditPostViewModel$fetchPostTaggedUsers$1(EditPostViewModel editPostViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = editPostViewModel;
        this.$postId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new EditPostViewModel$fetchPostTaggedUsers$1(this.this$0, this.$postId, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((EditPostViewModel$fetchPostTaggedUsers$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$postId;
            if (str == null) {
                return Unit.INSTANCE;
            }
            PostTaggedUsersRequest postTaggedUsersRequest = new PostTaggedUsersRequest(str);
            MemesRepository access$getRepository$p = this.this$0.repository;
            this.label = 1;
            obj = access$getRepository$p.fetchPostTaggedUsers(postTaggedUsersRequest, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        UniversalResult universalResult = (UniversalResult) obj;
        if (universalResult.isError()) {
            if (!universalResult.isSessionExpired()) {
                return Unit.INSTANCE;
            }
            this.this$0.showSessionExpiredDialog(universalResult.getMessage());
            return Unit.INSTANCE;
        } else if (universalResult.hasNoItems()) {
            return Unit.INSTANCE;
        } else {
            Iterable<PostTaggedUser> requireItems = universalResult.requireItems();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(requireItems, 10));
            for (PostTaggedUser taggedPerson : requireItems) {
                arrayList.add(taggedPerson.toTaggedPerson());
            }
            this.this$0.taggedPeopleInputChanged(new Gson().toJson((Object) (List) arrayList));
            this.this$0.getPostTaggedUsersLiveData().setValue(universalResult.requireItems());
            return Unit.INSTANCE;
        }
    }
}
