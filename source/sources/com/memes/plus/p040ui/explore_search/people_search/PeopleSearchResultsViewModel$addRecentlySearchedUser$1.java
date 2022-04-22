package com.memes.plus.p040ui.explore_search.people_search;

import com.memes.plus.data.storage.InstantListStorage;
import com.memes.plus.p040ui.explore_search.people_search.suggestions.RecentlySearchedPerson;
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
@DebugMetadata(mo26807c = "com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsViewModel$addRecentlySearchedUser$1", mo26808f = "PeopleSearchResultsViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsViewModel$addRecentlySearchedUser$1 */
/* compiled from: PeopleSearchResultsViewModel.kt */
final class PeopleSearchResultsViewModel$addRecentlySearchedUser$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PeopleSearchResult $peopleSearchResult;
    int label;
    final /* synthetic */ PeopleSearchResultsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PeopleSearchResultsViewModel$addRecentlySearchedUser$1(PeopleSearchResultsViewModel peopleSearchResultsViewModel, PeopleSearchResult peopleSearchResult, Continuation continuation) {
        super(2, continuation);
        this.this$0 = peopleSearchResultsViewModel;
        this.$peopleSearchResult = peopleSearchResult;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new PeopleSearchResultsViewModel$addRecentlySearchedUser$1(this.this$0, this.$peopleSearchResult, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PeopleSearchResultsViewModel$addRecentlySearchedUser$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            InstantListStorage.INSTANCE.add(this.this$0.storageRepository, InstantListStorage.RECENTLY_SEARCHED_USERS, RecentlySearchedPerson.Companion.from(this.$peopleSearchResult), RecentlySearchedPerson.class);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}