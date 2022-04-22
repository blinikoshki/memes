package editor.mediaselection.giphygifs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.network.core.pagination.OffsetBasedPaginationInfo;
import com.memes.network.giphy.api.model.GiphyGif;
import editor.core.AdapterUpdate;
import editor.core.NicoViewModel;
import editor.mediaselection.suggestions.MediaCategorySuggestion;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u001cJ\u0006\u0010\u001d\u001a\u00020\u001aJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001cJ\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001cJ\u0010\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\"\u001a\u00020\u001aJ\u0006\u0010#\u001a\u00020\u001aJ\u0006\u0010$\u001a\u00020\u001aJ\u0011\u0010%\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0014\u0010'\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\u001cR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006("}, mo26107d2 = {"Leditor/mediaselection/giphygifs/GiphyGifsViewModel;", "Leditor/core/NicoViewModel;", "()V", "_contentVisibilityLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "_giphyGifsLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "Leditor/core/AdapterUpdate;", "Lcom/memes/network/giphy/api/model/GiphyGif;", "_queryTextUpdateLiveData", "", "_suggestionsLiveData", "", "Leditor/mediaselection/suggestions/MediaCategorySuggestion;", "currentPage", "", "currentQuery", "giphyExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "newQuery", "paginationInfo", "Lcom/memes/network/core/pagination/OffsetBasedPaginationInfo;", "searchJob", "Lkotlinx/coroutines/Job;", "fetchSearchSuggestions", "", "giphyGifs", "Landroidx/lifecycle/LiveData;", "loadNextPage", "onContentVisibilityChanged", "onQueryTextUpdateAvailable", "queryTextChanged", "query", "refresh", "resetPagination", "search", "searchInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suggestions", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GiphyGifsViewModel.kt */
public final class GiphyGifsViewModel extends NicoViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<ContentVisibilityAction> _contentVisibilityLiveData = new MutableLiveData<>();
    private final SingleLiveEvent<AdapterUpdate<GiphyGif>> _giphyGifsLiveData = new SingleLiveEvent<>();
    private final MutableLiveData<String> _queryTextUpdateLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<List<MediaCategorySuggestion>> _suggestionsLiveData = new SingleLiveEvent<>();
    private int currentPage;
    /* access modifiers changed from: private */
    public String currentQuery;
    private final CoroutineExceptionHandler giphyExceptionHandler = new GiphyGifsViewModel$$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this);
    /* access modifiers changed from: private */
    public String newQuery;
    private OffsetBasedPaginationInfo paginationInfo;
    private Job searchJob;

    public final LiveData<List<MediaCategorySuggestion>> suggestions() {
        return this._suggestionsLiveData;
    }

    public final LiveData<AdapterUpdate<GiphyGif>> giphyGifs() {
        return this._giphyGifsLiveData;
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

    public final void fetchSearchSuggestions() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.giphyExceptionHandler, (CoroutineStart) null, new GiphyGifsViewModel$fetchSearchSuggestions$1(this, (Continuation) null), 2, (Object) null);
    }

    public final void search() {
        Job job = this.searchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.searchJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.giphyExceptionHandler, (CoroutineStart) null, new GiphyGifsViewModel$search$1(this, (Continuation) null), 2, (Object) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object searchInternal(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof editor.mediaselection.giphygifs.GiphyGifsViewModel$searchInternal$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            editor.mediaselection.giphygifs.GiphyGifsViewModel$searchInternal$1 r0 = (editor.mediaselection.giphygifs.GiphyGifsViewModel$searchInternal$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            editor.mediaselection.giphygifs.GiphyGifsViewModel$searchInternal$1 r0 = new editor.mediaselection.giphygifs.GiphyGifsViewModel$searchInternal$1
            r0.<init>(r12, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r5) goto L_0x0031
            java.lang.Object r0 = r0.L$0
            editor.mediaselection.giphygifs.GiphyGifsViewModel r0 = (editor.mediaselection.giphygifs.GiphyGifsViewModel) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00a8
        L_0x0031:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.String r13 = r12.currentQuery
            java.lang.String r2 = r12.newQuery
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r2)
            r13 = r13 ^ r5
            if (r13 == 0) goto L_0x004e
            java.lang.String r13 = r12.newQuery
            r12.currentQuery = r13
            r12.resetPagination()
        L_0x004e:
            com.memes.network.core.pagination.OffsetBasedPaginationInfo r13 = r12.paginationInfo
            if (r13 == 0) goto L_0x005b
            boolean r13 = r13.canFetchNextPage()
            if (r13 != 0) goto L_0x005b
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x005b:
            com.memes.network.core.pagination.OffsetBasedPaginationInfo r13 = r12.paginationInfo
            if (r13 != 0) goto L_0x0064
            androidx.lifecycle.MutableLiveData<com.memes.commons.contentlayout.ContentVisibilityAction> r13 = r12._contentVisibilityLiveData
            editor.core.NicoViewModel.showProgress$default(r12, r13, r4, r3, r4)
        L_0x0064:
            java.lang.String r13 = r12.currentQuery
            r2 = r13
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0074
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            if (r2 == 0) goto L_0x0072
            goto L_0x0074
        L_0x0072:
            r2 = 0
            goto L_0x0075
        L_0x0074:
            r2 = 1
        L_0x0075:
            if (r2 == 0) goto L_0x0079
            java.lang.String r13 = "trending"
        L_0x0079:
            r7 = r13
            androidx.lifecycle.MutableLiveData<java.lang.String> r13 = r12._queryTextUpdateLiveData
            r13.setValue(r7)
            com.memes.network.giphy.api.model.GiphyPostsRequest r13 = new com.memes.network.giphy.api.model.GiphyPostsRequest
            r8 = 0
            com.memes.network.core.pagination.OffsetBasedPaginationInfo r2 = r12.paginationInfo
            if (r2 == 0) goto L_0x008d
            java.lang.String r2 = r2.getOffset()
            if (r2 == 0) goto L_0x008d
            goto L_0x008f
        L_0x008d:
            java.lang.String r2 = "0"
        L_0x008f:
            r9 = r2
            r10 = 2
            r11 = 0
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            com.memes.network.NetworkProxy r2 = com.memes.network.NetworkProxy.INSTANCE
            com.memes.network.giphy.api.GiphyDataSource r2 = r2.fromGiphy()
            r0.L$0 = r12
            r0.label = r5
            java.lang.Object r13 = r2.searchGifs(r13, r0)
            if (r13 != r1) goto L_0x00a7
            return r1
        L_0x00a7:
            r0 = r12
        L_0x00a8:
            com.memes.network.core.UniversalResult r13 = (com.memes.network.core.UniversalResult) r13
            boolean r1 = r13.isError()
            if (r1 == 0) goto L_0x00ce
            boolean r1 = r13.isSessionExpired()
            if (r1 == 0) goto L_0x00c2
            androidx.lifecycle.MutableLiveData<com.memes.commons.contentlayout.ContentVisibilityAction> r1 = r0._contentVisibilityLiveData
            java.lang.String r13 = r13.getMessage()
            r0.showLoginError(r1, r13)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x00c2:
            androidx.lifecycle.MutableLiveData<com.memes.commons.contentlayout.ContentVisibilityAction> r1 = r0._contentVisibilityLiveData
            java.lang.String r13 = r13.getMessage()
            r0.showError(r1, r13)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x00ce:
            boolean r1 = r13.hasNoItems()
            if (r1 == 0) goto L_0x00dc
            androidx.lifecycle.MutableLiveData<com.memes.commons.contentlayout.ContentVisibilityAction> r13 = r0._contentVisibilityLiveData
            editor.core.NicoViewModel.showContentNotAvailable$default(r0, r13, r4, r3, r4)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x00dc:
            com.memes.commons.util.SingleLiveEvent<editor.core.AdapterUpdate<com.memes.network.giphy.api.model.GiphyGif>> r1 = r0._giphyGifsLiveData
            editor.core.AdapterUpdate r2 = new editor.core.AdapterUpdate
            int r3 = r0.currentPage
            java.util.List r4 = r13.getItems()
            r2.<init>(r3, r4)
            r1.setValue(r2)
            int r1 = r0.currentPage
            int r1 = r1 + r5
            r0.currentPage = r1
            com.memes.network.core.pagination.PaginationInfo r13 = r13.getPagination()
            java.lang.String r1 = "null cannot be cast to non-null type com.memes.network.core.pagination.OffsetBasedPaginationInfo"
            java.util.Objects.requireNonNull(r13, r1)
            com.memes.network.core.pagination.OffsetBasedPaginationInfo r13 = (com.memes.network.core.pagination.OffsetBasedPaginationInfo) r13
            r0.paginationInfo = r13
            androidx.lifecycle.MutableLiveData<com.memes.commons.contentlayout.ContentVisibilityAction> r13 = r0._contentVisibilityLiveData
            r0.showContent(r13)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.mediaselection.giphygifs.GiphyGifsViewModel.searchInternal(kotlin.coroutines.Continuation):java.lang.Object");
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
