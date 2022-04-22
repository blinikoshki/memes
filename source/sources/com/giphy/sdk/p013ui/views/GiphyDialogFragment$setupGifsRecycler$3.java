package com.giphy.sdk.p013ui.views;

import android.view.View;
import com.giphy.sdk.core.models.Media;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0017\u0010\u0007\u001a\u0013\u0018\u00010\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0002\b\n"}, mo26107d2 = {"<anonymous>", "", "p1", "Lcom/giphy/sdk/core/models/Media;", "Lkotlin/ParameterName;", "name", "media", "p2", "Landroid/view/View;", "anchor", "invoke"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GiphyDialogFragment$setupGifsRecycler$3 */
/* compiled from: GiphyDialogFragment.kt */
final class GiphyDialogFragment$setupGifsRecycler$3 extends FunctionReference implements Function2<Media, View, Unit> {
    GiphyDialogFragment$setupGifsRecycler$3(GiphyDialogFragment giphyDialogFragment) {
        super(2, giphyDialogFragment);
    }

    public final String getName() {
        return "onGifPressed";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(GiphyDialogFragment.class);
    }

    public final String getSignature() {
        return "onGifPressed(Lcom/giphy/sdk/core/models/Media;Landroid/view/View;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Media) obj, (View) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(Media media, View view) {
        Intrinsics.checkParameterIsNotNull(media, "p1");
        ((GiphyDialogFragment) this.receiver).onGifPressed(media, view);
    }
}
