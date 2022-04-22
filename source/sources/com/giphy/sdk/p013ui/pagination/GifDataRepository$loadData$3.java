package com.giphy.sdk.p013ui.pagination;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.pagination.GifDataRepository$loadData$3 */
/* compiled from: GifDataRepository.kt */
final class GifDataRepository$loadData$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GifDataSourceFactory $sourceFactory;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GifDataRepository$loadData$3(GifDataSourceFactory gifDataSourceFactory) {
        super(0);
        this.$sourceFactory = gifDataSourceFactory;
    }

    public final void invoke() {
        GifPagedDataSource value = this.$sourceFactory.getSourceLiveData().getValue();
        if (value != null) {
            value.invalidate();
        }
    }
}
