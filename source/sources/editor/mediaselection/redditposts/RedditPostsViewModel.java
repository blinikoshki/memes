package editor.mediaselection.redditposts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.network.core.pagination.OffsetBasedPaginationInfo;
import com.memes.network.reddit.api.model.RedditPost;
import editor.core.AdapterUpdate;
import editor.core.NicoViewModel;
import editor.mediaselection.suggestions.MediaCategorySuggestion;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001fJ\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001fJ\u0010\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u0007J\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u001fJ\u0006\u0010$\u001a\u00020\u001cJ\u0006\u0010%\u001a\u00020\u001cJ\u0006\u0010&\u001a\u00020\u001cJ\u0011\u0010'\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u0007J\u0014\u0010+\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\u001fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, mo26107d2 = {"Leditor/mediaselection/redditposts/RedditPostsViewModel;", "Leditor/core/NicoViewModel;", "()V", "_contentVisibilityLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "_queryTextUpdateLiveData", "", "_redditPostsLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "Leditor/core/AdapterUpdate;", "Lcom/memes/network/reddit/api/model/RedditPost;", "_subredditsLiveData", "", "Leditor/mediaselection/suggestions/MediaCategorySuggestion;", "currentPage", "", "currentQuery", "currentSubreddit", "newQuery", "newSubreddit", "paginationInfo", "Lcom/memes/network/core/pagination/OffsetBasedPaginationInfo;", "redditExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "searchJob", "Lkotlinx/coroutines/Job;", "fetchSubreddits", "", "loadNextPage", "onContentVisibilityChanged", "Landroidx/lifecycle/LiveData;", "onQueryTextUpdateAvailable", "queryTextChanged", "query", "redditPosts", "refresh", "resetPagination", "search", "searchInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "subredditSelectionChanged", "subreddit", "subreddits", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RedditPostsViewModel.kt */
public final class RedditPostsViewModel extends NicoViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEFAULT_SUBREDDIT = "memes";
    /* access modifiers changed from: private */
    public final MutableLiveData<ContentVisibilityAction> _contentVisibilityLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> _queryTextUpdateLiveData = new MutableLiveData<>();
    private final SingleLiveEvent<AdapterUpdate<RedditPost>> _redditPostsLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<List<MediaCategorySuggestion>> _subredditsLiveData = new SingleLiveEvent<>();
    private int currentPage;
    private String currentQuery;
    /* access modifiers changed from: private */
    public String currentSubreddit = DEFAULT_SUBREDDIT;
    private String newQuery;
    /* access modifiers changed from: private */
    public String newSubreddit = DEFAULT_SUBREDDIT;
    private OffsetBasedPaginationInfo paginationInfo;
    private final CoroutineExceptionHandler redditExceptionHandler = new C4833x437cce1d(CoroutineExceptionHandler.Key, this);
    private Job searchJob;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Leditor/mediaselection/redditposts/RedditPostsViewModel$Companion;", "", "()V", "DEFAULT_SUBREDDIT", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: RedditPostsViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final LiveData<List<MediaCategorySuggestion>> subreddits() {
        return this._subredditsLiveData;
    }

    public final LiveData<AdapterUpdate<RedditPost>> redditPosts() {
        return this._redditPostsLiveData;
    }

    public final LiveData<String> onQueryTextUpdateAvailable() {
        return this._queryTextUpdateLiveData;
    }

    public final LiveData<ContentVisibilityAction> onContentVisibilityChanged() {
        return this._contentVisibilityLiveData;
    }

    public final void queryTextChanged(String str) {
        this.newQuery = str;
        resetPagination();
    }

    public final void subredditSelectionChanged(String str) {
        Intrinsics.checkNotNullParameter(str, "subreddit");
        this.newSubreddit = str;
        String str2 = null;
        this.currentQuery = str2;
        this.newQuery = str2;
        resetPagination();
        search();
    }

    public final void fetchSubreddits() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.redditExceptionHandler, (CoroutineStart) null, new RedditPostsViewModel$fetchSubreddits$1(this, (Continuation) null), 2, (Object) null);
    }

    public final void search() {
        Job job = this.searchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.searchJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.redditExceptionHandler, (CoroutineStart) null, new RedditPostsViewModel$search$1(this, (Continuation) null), 2, (Object) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object searchInternal(kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof editor.mediaselection.redditposts.RedditPostsViewModel$searchInternal$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            editor.mediaselection.redditposts.RedditPostsViewModel$searchInternal$1 r0 = (editor.mediaselection.redditposts.RedditPostsViewModel$searchInternal$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            editor.mediaselection.redditposts.RedditPostsViewModel$searchInternal$1 r0 = new editor.mediaselection.redditposts.RedditPostsViewModel$searchInternal$1
            r0.<init>(r13, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r5) goto L_0x0031
            java.lang.Object r0 = r0.L$0
            editor.mediaselection.redditposts.RedditPostsViewModel r0 = (editor.mediaselection.redditposts.RedditPostsViewModel) r0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00a7
        L_0x0031:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.String r14 = r13.currentQuery
            java.lang.String r2 = r13.newQuery
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r2)
            r14 = r14 ^ r5
            if (r14 == 0) goto L_0x004e
            java.lang.String r14 = r13.newQuery
            r13.currentQuery = r14
            r13.resetPagination()
        L_0x004e:
            java.lang.String r14 = r13.currentSubreddit
            java.lang.String r2 = r13.newSubreddit
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r2)
            r14 = r14 ^ r5
            if (r14 == 0) goto L_0x0060
            java.lang.String r14 = r13.newSubreddit
            r13.currentSubreddit = r14
            r13.resetPagination()
        L_0x0060:
            com.memes.network.core.pagination.OffsetBasedPaginationInfo r14 = r13.paginationInfo
            if (r14 == 0) goto L_0x006d
            boolean r14 = r14.canFetchNextPage()
            if (r14 != 0) goto L_0x006d
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x006d:
            com.memes.network.core.pagination.OffsetBasedPaginationInfo r14 = r13.paginationInfo
            if (r14 != 0) goto L_0x0076
            androidx.lifecycle.MutableLiveData<com.memes.commons.contentlayout.ContentVisibilityAction> r14 = r13._contentVisibilityLiveData
            editor.core.NicoViewModel.showProgress$default(r13, r14, r4, r3, r4)
        L_0x0076:
            androidx.lifecycle.MutableLiveData<java.lang.String> r14 = r13._queryTextUpdateLiveData
            java.lang.String r2 = r13.currentQuery
            r14.setValue(r2)
            com.memes.network.reddit.api.model.RedditPostsRequest r14 = new com.memes.network.reddit.api.model.RedditPostsRequest
            java.lang.String r7 = r13.currentSubreddit
            java.lang.String r8 = r13.currentQuery
            r9 = 0
            com.memes.network.core.pagination.OffsetBasedPaginationInfo r2 = r13.paginationInfo
            if (r2 == 0) goto L_0x008e
            java.lang.String r2 = r2.getOffset()
            r10 = r2
            goto L_0x008f
        L_0x008e:
            r10 = r4
        L_0x008f:
            r11 = 4
            r12 = 0
            r6 = r14
            r6.<init>(r7, r8, r9, r10, r11, r12)
            com.memes.network.NetworkProxy r2 = com.memes.network.NetworkProxy.INSTANCE
            com.memes.network.reddit.api.RedditDataSource r2 = r2.fromReddit()
            r0.L$0 = r13
            r0.label = r5
            java.lang.Object r14 = r2.fetchPosts(r14, r0)
            if (r14 != r1) goto L_0x00a6
            return r1
        L_0x00a6:
            r0 = r13
        L_0x00a7:
            com.memes.network.core.UniversalResult r14 = (com.memes.network.core.UniversalResult) r14
            boolean r1 = r14.isError()
            if (r1 == 0) goto L_0x00cd
            boolean r1 = r14.isSessionExpired()
            if (r1 == 0) goto L_0x00c1
            androidx.lifecycle.MutableLiveData<com.memes.commons.contentlayout.ContentVisibilityAction> r1 = r0._contentVisibilityLiveData
            java.lang.String r14 = r14.getMessage()
            r0.showLoginError(r1, r14)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x00c1:
            androidx.lifecycle.MutableLiveData<com.memes.commons.contentlayout.ContentVisibilityAction> r1 = r0._contentVisibilityLiveData
            java.lang.String r14 = r14.getMessage()
            r0.showError(r1, r14)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x00cd:
            boolean r1 = r14.hasNoItems()
            if (r1 == 0) goto L_0x00db
            androidx.lifecycle.MutableLiveData<com.memes.commons.contentlayout.ContentVisibilityAction> r14 = r0._contentVisibilityLiveData
            editor.core.NicoViewModel.showContentNotAvailable$default(r0, r14, r4, r3, r4)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x00db:
            com.memes.commons.util.SingleLiveEvent<editor.core.AdapterUpdate<com.memes.network.reddit.api.model.RedditPost>> r1 = r0._redditPostsLiveData
            editor.core.AdapterUpdate r2 = new editor.core.AdapterUpdate
            int r3 = r0.currentPage
            java.util.List r4 = r14.getItems()
            r2.<init>(r3, r4)
            r1.setValue(r2)
            int r1 = r0.currentPage
            int r1 = r1 + r5
            r0.currentPage = r1
            com.memes.network.core.pagination.PaginationInfo r14 = r14.getPagination()
            java.lang.String r1 = "null cannot be cast to non-null type com.memes.network.core.pagination.OffsetBasedPaginationInfo"
            java.util.Objects.requireNonNull(r14, r1)
            com.memes.network.core.pagination.OffsetBasedPaginationInfo r14 = (com.memes.network.core.pagination.OffsetBasedPaginationInfo) r14
            r0.paginationInfo = r14
            androidx.lifecycle.MutableLiveData<com.memes.commons.contentlayout.ContentVisibilityAction> r14 = r0._contentVisibilityLiveData
            r0.showContent(r14)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.mediaselection.redditposts.RedditPostsViewModel.searchInternal(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void loadNextPage() {
        search();
    }

    public final void resetPagination() {
        this.currentPage = 0;
        this.paginationInfo = null;
    }

    public final void refresh() {
        resetPagination();
        search();
    }
}
