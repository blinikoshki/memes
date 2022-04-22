package editor.mediaselection.giphygifs;

import com.memes.commons.util.SingleLiveEvent;
import com.memes.editor.C4175R;
import com.memes.network.NetworkProxy;
import com.memes.network.core.UniversalResult;
import com.memes.network.giphy.api.GiphyDataSource;
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
@DebugMetadata(mo26807c = "editor.mediaselection.giphygifs.GiphyGifsViewModel$fetchSearchSuggestions$1", mo26808f = "GiphyGifsViewModel.kt", mo26809i = {}, mo26810l = {68}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: GiphyGifsViewModel.kt */
final class GiphyGifsViewModel$fetchSearchSuggestions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GiphyGifsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GiphyGifsViewModel$fetchSearchSuggestions$1(GiphyGifsViewModel giphyGifsViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = giphyGifsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new GiphyGifsViewModel$fetchSearchSuggestions$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((GiphyGifsViewModel$fetchSearchSuggestions$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GiphyDataSource fromGiphy = NetworkProxy.INSTANCE.fromGiphy();
            this.label = 1;
            obj = fromGiphy.fetchQuerySuggestions(this);
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
            this.this$0._suggestionsLiveData.setValue(null);
        } else {
            List requireItems = universalResult.requireItems();
            Iterable<String> iterable = requireItems;
            if (!CollectionsKt.contains(iterable, this.this$0.currentQuery)) {
                this.this$0.currentQuery = (String) CollectionsKt.first(requireItems);
                GiphyGifsViewModel giphyGifsViewModel = this.this$0;
                giphyGifsViewModel.newQuery = giphyGifsViewModel.currentQuery;
            }
            SingleLiveEvent access$get_suggestionsLiveData$p = this.this$0._suggestionsLiveData;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (String str : iterable) {
                arrayList.add(new MediaCategorySuggestion(C4175R.C4178drawable.icon_trending, str, Intrinsics.areEqual((Object) str, (Object) this.this$0.currentQuery)));
            }
            access$get_suggestionsLiveData$p.setValue((List) arrayList);
        }
        this.this$0.resetPagination();
        this.this$0.search();
        return Unit.INSTANCE;
    }
}
