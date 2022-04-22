package com.giphy.sdk.p013ui.pagination;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import com.giphy.sdk.core.models.Media;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005 \u0006*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "Lcom/giphy/sdk/ui/pagination/NetworkState;", "it", "Lcom/giphy/sdk/ui/pagination/Listing;", "Lcom/giphy/sdk/core/models/Media;", "kotlin.jvm.PlatformType", "apply"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.pagination.GifsViewModel$networkState$1 */
/* compiled from: GifsViewModel.kt */
final class GifsViewModel$networkState$1<I, O> implements Function<X, LiveData<Y>> {
    public static final GifsViewModel$networkState$1 INSTANCE = new GifsViewModel$networkState$1();

    GifsViewModel$networkState$1() {
    }

    public final LiveData<NetworkState> apply(Listing<Media> listing) {
        return listing.getNetworkState();
    }
}
