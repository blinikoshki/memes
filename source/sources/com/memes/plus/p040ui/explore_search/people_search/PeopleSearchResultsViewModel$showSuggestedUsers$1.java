package com.memes.plus.p040ui.explore_search.people_search;

import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.plus.data.storage.InstantListStorage;
import com.memes.plus.p040ui.explore_search.people_search.suggestions.RecentlySearchedPerson;
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
@DebugMetadata(mo26807c = "com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsViewModel$showSuggestedUsers$1", mo26808f = "PeopleSearchResultsViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsViewModel$showSuggestedUsers$1 */
/* compiled from: PeopleSearchResultsViewModel.kt */
final class PeopleSearchResultsViewModel$showSuggestedUsers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PeopleSearchResultsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PeopleSearchResultsViewModel$showSuggestedUsers$1(PeopleSearchResultsViewModel peopleSearchResultsViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = peopleSearchResultsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new PeopleSearchResultsViewModel$showSuggestedUsers$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PeopleSearchResultsViewModel$showSuggestedUsers$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List arrayList = new ArrayList();
            boolean z = true;
            if (!this.this$0.suggestedUsers.isEmpty()) {
                CatalogueHeader catalogueHeader = new CatalogueHeader();
                catalogueHeader.setHeaderTitle("Suggested Users");
                Unit unit = Unit.INSTANCE;
                arrayList.add(catalogueHeader);
                arrayList.addAll(this.this$0.suggestedUsers);
            }
            Collection mutableList = CollectionsKt.toMutableList(InstantListStorage.INSTANCE.all(this.this$0.storageRepository, InstantListStorage.RECENTLY_SEARCHED_USERS, RecentlySearchedPerson.class));
            if (mutableList != null && !mutableList.isEmpty()) {
                z = false;
            }
            if (!z) {
                CatalogueHeader catalogueHeader2 = new CatalogueHeader();
                catalogueHeader2.setHeaderTitle("Recent Searches");
                Unit unit2 = Unit.INSTANCE;
                arrayList.add(catalogueHeader2);
                arrayList.addAll(mutableList);
            }
            this.this$0.getResultsLiveData().setValue(new AdapterUpdate(0, arrayList));
            PeopleSearchResultsViewModel peopleSearchResultsViewModel = this.this$0;
            peopleSearchResultsViewModel.showContent(peopleSearchResultsViewModel.getContentVisibilityLiveData());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
