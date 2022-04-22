package editor.mediaselection.stockmemes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.network.core.pagination.PageBasedPaginationInfo;
import com.memes.network.memes.api.model.stockmemes.StockMeme;
import editor.core.AdapterUpdate;
import editor.core.NicoViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0015J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015J\u0010\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u0013J\u0011\u0010\u001d\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, mo26107d2 = {"Leditor/mediaselection/stockmemes/StockMemesViewModel;", "Leditor/core/NicoViewModel;", "()V", "_contentVisibilityLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "_memesLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "Leditor/core/AdapterUpdate;", "Lcom/memes/network/memes/api/model/stockmemes/StockMeme;", "_queryTextUpdateLiveData", "", "currentQuery", "memesExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "newQuery", "resultsPaginationInfo", "Lcom/memes/network/core/pagination/PageBasedPaginationInfo;", "loadNextPage", "", "memes", "Landroidx/lifecycle/LiveData;", "onContentVisibilityChanged", "onQueryTextUpdateAvailable", "queryTextChanged", "query", "refresh", "resetPagination", "search", "searchInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StockMemesViewModel.kt */
public final class StockMemesViewModel extends NicoViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<ContentVisibilityAction> _contentVisibilityLiveData = new MutableLiveData<>();
    private final SingleLiveEvent<AdapterUpdate<StockMeme>> _memesLiveData = new SingleLiveEvent<>();
    private final MutableLiveData<String> _queryTextUpdateLiveData = new MutableLiveData<>();
    private String currentQuery;
    private final CoroutineExceptionHandler memesExceptionHandler = new C4838xe40dfb25(CoroutineExceptionHandler.Key, this);
    private String newQuery;
    private PageBasedPaginationInfo resultsPaginationInfo;

    public final LiveData<AdapterUpdate<StockMeme>> memes() {
        return this._memesLiveData;
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

    public final void search() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.memesExceptionHandler, (CoroutineStart) null, new StockMemesViewModel$search$1(this, (Continuation) null), 2, (Object) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006c, code lost:
        r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10.getCurrentPage());
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object searchInternal(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof editor.mediaselection.stockmemes.StockMemesViewModel$searchInternal$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            editor.mediaselection.stockmemes.StockMemesViewModel$searchInternal$1 r0 = (editor.mediaselection.stockmemes.StockMemesViewModel$searchInternal$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            editor.mediaselection.stockmemes.StockMemesViewModel$searchInternal$1 r0 = new editor.mediaselection.stockmemes.StockMemesViewModel$searchInternal$1
            r0.<init>(r9, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003b
            if (r2 != r4) goto L_0x0033
            int r1 = r0.I$0
            java.lang.Object r0 = r0.L$0
            editor.mediaselection.stockmemes.StockMemesViewModel r0 = (editor.mediaselection.stockmemes.StockMemesViewModel) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00b2
        L_0x0033:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.String r10 = r9.currentQuery
            java.lang.String r2 = r9.newQuery
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r2)
            r10 = r10 ^ r4
            if (r10 == 0) goto L_0x0052
            java.lang.String r10 = r9.newQuery
            r9.currentQuery = r10
            r10 = r5
            com.memes.network.core.pagination.PageBasedPaginationInfo r10 = (com.memes.network.core.pagination.PageBasedPaginationInfo) r10
            r9.resultsPaginationInfo = r10
        L_0x0052:
            com.memes.network.core.pagination.PageBasedPaginationInfo r10 = r9.resultsPaginationInfo
            if (r10 == 0) goto L_0x005f
            boolean r10 = r10.canFetchNextPage()
            if (r10 != 0) goto L_0x005f
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x005f:
            com.memes.network.core.pagination.PageBasedPaginationInfo r10 = r9.resultsPaginationInfo
            if (r10 != 0) goto L_0x0068
            androidx.lifecycle.MutableLiveData<com.memes.commons.contentlayout.ContentVisibilityAction> r10 = r9._contentVisibilityLiveData
            editor.core.NicoViewModel.showProgress$default(r9, r10, r5, r3, r5)
        L_0x0068:
            com.memes.network.core.pagination.PageBasedPaginationInfo r10 = r9.resultsPaginationInfo
            if (r10 == 0) goto L_0x007b
            int r10 = r10.getCurrentPage()
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            if (r10 == 0) goto L_0x007b
            int r10 = r10.intValue()
            goto L_0x007c
        L_0x007b:
            r10 = 0
        L_0x007c:
            if (r10 != 0) goto L_0x0083
            androidx.lifecycle.MutableLiveData<com.memes.commons.contentlayout.ContentVisibilityAction> r2 = r9._contentVisibilityLiveData
            editor.core.NicoViewModel.showProgress$default(r9, r2, r5, r3, r5)
        L_0x0083:
            androidx.lifecycle.MutableLiveData<java.lang.String> r2 = r9._queryTextUpdateLiveData
            java.lang.String r6 = r9.currentQuery
            r2.setValue(r6)
            com.memes.network.memes.api.model.core.AuthenticationRequest r2 = new com.memes.network.memes.api.model.core.AuthenticationRequest
            java.lang.String r6 = "fakeuser"
            java.lang.String r7 = "faketoken"
            r2.<init>(r6, r7)
            com.memes.network.memes.api.model.stockmemes.StockMemesRequest r6 = new com.memes.network.memes.api.model.stockmemes.StockMemesRequest
            java.lang.String r7 = r9.currentQuery
            int r8 = r10 + 1
            r6.<init>(r7, r8)
            com.memes.network.NetworkProxy r7 = com.memes.network.NetworkProxy.INSTANCE
            com.memes.network.memes.api.MemesDataSource r7 = r7.fromMemes()
            r0.L$0 = r9
            r0.I$0 = r10
            r0.label = r4
            java.lang.Object r0 = r7.fetchStockMemes(r2, r6, r0)
            if (r0 != r1) goto L_0x00af
            return r1
        L_0x00af:
            r1 = r10
            r10 = r0
            r0 = r9
        L_0x00b2:
            com.memes.network.core.UniversalResult r10 = (com.memes.network.core.UniversalResult) r10
            boolean r2 = r10.isError()
            if (r2 == 0) goto L_0x00d8
            boolean r1 = r10.isSessionExpired()
            if (r1 == 0) goto L_0x00cc
            androidx.lifecycle.MutableLiveData<com.memes.commons.contentlayout.ContentVisibilityAction> r1 = r0._contentVisibilityLiveData
            java.lang.String r10 = r10.getMessage()
            r0.showLoginError(r1, r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00cc:
            androidx.lifecycle.MutableLiveData<com.memes.commons.contentlayout.ContentVisibilityAction> r1 = r0._contentVisibilityLiveData
            java.lang.String r10 = r10.getMessage()
            r0.showError(r1, r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00d8:
            boolean r2 = r10.hasNoItems()
            if (r2 == 0) goto L_0x00e6
            androidx.lifecycle.MutableLiveData<com.memes.commons.contentlayout.ContentVisibilityAction> r10 = r0._contentVisibilityLiveData
            editor.core.NicoViewModel.showContentNotAvailable$default(r0, r10, r5, r3, r5)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00e6:
            com.memes.commons.util.SingleLiveEvent<editor.core.AdapterUpdate<com.memes.network.memes.api.model.stockmemes.StockMeme>> r2 = r0._memesLiveData
            editor.core.AdapterUpdate r3 = new editor.core.AdapterUpdate
            java.util.List r4 = r10.getItems()
            r3.<init>(r1, r4)
            r2.setValue(r3)
            com.memes.network.core.pagination.PaginationInfo r10 = r10.getPagination()
            java.lang.String r1 = "null cannot be cast to non-null type com.memes.network.core.pagination.PageBasedPaginationInfo"
            java.util.Objects.requireNonNull(r10, r1)
            com.memes.network.core.pagination.PageBasedPaginationInfo r10 = (com.memes.network.core.pagination.PageBasedPaginationInfo) r10
            r0.resultsPaginationInfo = r10
            androidx.lifecycle.MutableLiveData<com.memes.commons.contentlayout.ContentVisibilityAction> r10 = r0._contentVisibilityLiveData
            r0.showContent(r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.mediaselection.stockmemes.StockMemesViewModel.searchInternal(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void loadNextPage() {
        search();
    }

    public final void resetPagination() {
        this.resultsPaginationInfo = null;
    }

    public final void refresh() {
        this.resultsPaginationInfo = null;
        search();
    }
}
