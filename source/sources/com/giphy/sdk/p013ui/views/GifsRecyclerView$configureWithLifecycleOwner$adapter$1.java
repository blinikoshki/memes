package com.giphy.sdk.p013ui.views;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GifsRecyclerView$configureWithLifecycleOwner$adapter$1 */
/* compiled from: GifsRecyclerView.kt */
final class GifsRecyclerView$configureWithLifecycleOwner$adapter$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GifsRecyclerView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GifsRecyclerView$configureWithLifecycleOwner$adapter$1(GifsRecyclerView gifsRecyclerView) {
        super(0);
        this.this$0 = gifsRecyclerView;
    }

    public final void invoke() {
        GifsRecyclerView.access$getGifsViewModel$p(this.this$0).retry();
    }
}
