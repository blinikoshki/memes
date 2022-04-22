package editor.mediaselection.redditposts;

import com.memes.commons.util.SingleLiveEvent;
import com.memes.editor.C4175R;
import com.memes.network.NetworkProxy;
import com.memes.network.core.UniversalResult;
import com.memes.network.reddit.api.RedditDataSource;
import editor.mediaselection.suggestions.MediaCategorySuggestion;
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
@DebugMetadata(mo26807c = "editor.mediaselection.redditposts.RedditPostsViewModel$fetchSubreddits$1", mo26808f = "RedditPostsViewModel.kt", mo26809i = {}, mo26810l = {85}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: RedditPostsViewModel.kt */
final class RedditPostsViewModel$fetchSubreddits$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RedditPostsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RedditPostsViewModel$fetchSubreddits$1(RedditPostsViewModel redditPostsViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = redditPostsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new RedditPostsViewModel$fetchSubreddits$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((RedditPostsViewModel$fetchSubreddits$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RedditDataSource fromReddit = NetworkProxy.INSTANCE.fromReddit();
            this.label = 1;
            obj = fromReddit.fetchSubreddits(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        UniversalResult universalResult = (UniversalResult) obj;
        if (!universalResult.isSuccess() || !universalResult.hasItems()) {
            this.this$0._subredditsLiveData.setValue(null);
        } else {
            List requireItems = universalResult.requireItems();
            if (!requireItems.contains(this.this$0.currentSubreddit)) {
                this.this$0.currentSubreddit = (String) CollectionsKt.first(requireItems);
                RedditPostsViewModel redditPostsViewModel = this.this$0;
                redditPostsViewModel.newSubreddit = redditPostsViewModel.currentSubreddit;
            }
            SingleLiveEvent access$get_subredditsLiveData$p = this.this$0._subredditsLiveData;
            Iterable<String> iterable = requireItems;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (String str : iterable) {
                arrayList.add(new MediaCategorySuggestion(C4175R.C4178drawable.icon_trending, str, Intrinsics.areEqual((Object) str, (Object) this.this$0.currentSubreddit)));
            }
            access$get_subredditsLiveData$p.setValue((List) arrayList);
        }
        RedditPostsViewModel redditPostsViewModel2 = this.this$0;
        redditPostsViewModel2.subredditSelectionChanged(redditPostsViewModel2.currentSubreddit);
        return Unit.INSTANCE;
    }
}
