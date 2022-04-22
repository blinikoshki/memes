package com.giphy.sdk.p013ui.views;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GifsRecyclerView$configureWithLifecycleOwner$adapter$2$3 */
/* compiled from: GifsRecyclerView.kt */
final class GifsRecyclerView$configureWithLifecycleOwner$adapter$2$3 extends FunctionReference implements Function0<Unit> {
    GifsRecyclerView$configureWithLifecycleOwner$adapter$2$3(GifsRecyclerView gifsRecyclerView) {
        super(0, gifsRecyclerView);
    }

    public final String getName() {
        return "onCurrentListChanged";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(GifsRecyclerView.class);
    }

    public final String getSignature() {
        return "onCurrentListChanged()V";
    }

    public final void invoke() {
        ((GifsRecyclerView) this.receiver).onCurrentListChanged();
    }
}
