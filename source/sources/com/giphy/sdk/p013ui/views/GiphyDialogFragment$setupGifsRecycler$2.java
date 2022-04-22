package com.giphy.sdk.p013ui.views;

import com.giphy.sdk.core.models.Media;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "p1", "Lcom/giphy/sdk/core/models/Media;", "Lkotlin/ParameterName;", "name", "media", "invoke"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GiphyDialogFragment$setupGifsRecycler$2 */
/* compiled from: GiphyDialogFragment.kt */
final class GiphyDialogFragment$setupGifsRecycler$2 extends FunctionReference implements Function1<Media, Unit> {
    GiphyDialogFragment$setupGifsRecycler$2(GiphyDialogFragment giphyDialogFragment) {
        super(1, giphyDialogFragment);
    }

    public final String getName() {
        return "onGifSelected";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(GiphyDialogFragment.class);
    }

    public final String getSignature() {
        return "onGifSelected(Lcom/giphy/sdk/core/models/Media;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Media) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Media media) {
        Intrinsics.checkParameterIsNotNull(media, "p1");
        ((GiphyDialogFragment) this.receiver).onGifSelected(media);
    }
}
