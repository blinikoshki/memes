package com.giphy.sdk.p013ui.pagination;

import androidx.arch.core.util.Function;
import com.giphy.sdk.core.models.Media;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "Lcom/giphy/sdk/ui/pagination/Listing;", "Lcom/giphy/sdk/core/models/Media;", "it", "Lcom/giphy/sdk/ui/pagination/GifQueryParams;", "kotlin.jvm.PlatformType", "apply"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.pagination.GifsViewModel$repoResult$1 */
/* compiled from: GifsViewModel.kt */
final class GifsViewModel$repoResult$1<I, O> implements Function<X, Y> {
    final /* synthetic */ GifsViewModel this$0;

    GifsViewModel$repoResult$1(GifsViewModel gifsViewModel) {
        this.this$0 = gifsViewModel;
    }

    public final Listing<Media> apply(GifQueryParams gifQueryParams) {
        GifDataRepository access$getRepository$p = this.this$0.repository;
        Intrinsics.checkExpressionValueIsNotNull(gifQueryParams, "it");
        return access$getRepository$p.loadData(gifQueryParams, 25);
    }
}
