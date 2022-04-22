package com.giphy.sdk.p013ui.views;

import com.giphy.sdk.p013ui.pagination.GifsViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GifsRecyclerView$query$1 */
/* compiled from: GifsRecyclerView.kt */
final class GifsRecyclerView$query$1 extends MutablePropertyReference0 {
    GifsRecyclerView$query$1(GifsRecyclerView gifsRecyclerView) {
        super(gifsRecyclerView);
    }

    public String getName() {
        return "gifsViewModel";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(GifsRecyclerView.class);
    }

    public String getSignature() {
        return "getGifsViewModel()Lcom/giphy/sdk/ui/pagination/GifsViewModel;";
    }

    public Object get() {
        return GifsRecyclerView.access$getGifsViewModel$p((GifsRecyclerView) this.receiver);
    }

    public void set(Object obj) {
        ((GifsRecyclerView) this.receiver).gifsViewModel = (GifsViewModel) obj;
    }
}
