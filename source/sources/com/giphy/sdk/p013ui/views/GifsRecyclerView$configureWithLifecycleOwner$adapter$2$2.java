package com.giphy.sdk.p013ui.views;

import com.giphy.sdk.core.models.Media;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001b\u0010\u0002\u001a\u0017\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00072\u0015\u0010\b\u001a\u00110\t¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n¢\u0006\u0002\b\u000b"}, mo26107d2 = {"<anonymous>", "", "p1", "", "Lcom/giphy/sdk/core/models/Media;", "Lkotlin/ParameterName;", "name", "gifs", "p2", "", "position", "invoke"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GifsRecyclerView$configureWithLifecycleOwner$adapter$2$2 */
/* compiled from: GifsRecyclerView.kt */
final class GifsRecyclerView$configureWithLifecycleOwner$adapter$2$2 extends FunctionReference implements Function2<List<? extends Media>, Integer, Unit> {
    GifsRecyclerView$configureWithLifecycleOwner$adapter$2$2(GifsRecyclerView gifsRecyclerView) {
        super(2, gifsRecyclerView);
    }

    public final String getName() {
        return "onGifLongClickListener";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(GifsRecyclerView.class);
    }

    public final String getSignature() {
        return "onGifLongClickListener(Ljava/util/List;I)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((List<Media>) (List) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(List<Media> list, int i) {
        Intrinsics.checkParameterIsNotNull(list, "p1");
        ((GifsRecyclerView) this.receiver).onGifLongClickListener(list, i);
    }
}
