package com.giphy.sdk.p013ui.pagination;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "Lcom/giphy/sdk/ui/pagination/ResponseState;", "it", "Lcom/giphy/sdk/ui/pagination/GifPagedDataSource;", "kotlin.jvm.PlatformType", "apply"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.pagination.GifDataRepository$loadData$4 */
/* compiled from: GifDataRepository.kt */
final class GifDataRepository$loadData$4<I, O> implements Function<X, LiveData<Y>> {
    public static final GifDataRepository$loadData$4 INSTANCE = new GifDataRepository$loadData$4();

    GifDataRepository$loadData$4() {
    }

    public final MutableLiveData<ResponseState> apply(GifPagedDataSource gifPagedDataSource) {
        return gifPagedDataSource.getResponseState();
    }
}
