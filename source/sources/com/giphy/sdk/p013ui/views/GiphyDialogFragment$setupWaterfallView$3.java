package com.giphy.sdk.p013ui.views;

import com.giphy.sdk.p013ui.views.GPHMediaTypeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\u0007\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0002\b\t"}, mo26107d2 = {"<anonymous>", "", "p1", "Lcom/giphy/sdk/ui/views/GPHMediaTypeView$LayoutType;", "Lkotlin/ParameterName;", "name", "oldLayoutType", "p2", "newLayoutType", "invoke"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GiphyDialogFragment$setupWaterfallView$3 */
/* compiled from: GiphyDialogFragment.kt */
final class GiphyDialogFragment$setupWaterfallView$3 extends FunctionReference implements Function2<GPHMediaTypeView.LayoutType, GPHMediaTypeView.LayoutType, Unit> {
    GiphyDialogFragment$setupWaterfallView$3(GiphyDialogFragment giphyDialogFragment) {
        super(2, giphyDialogFragment);
    }

    public final String getName() {
        return "changeLayoutType";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(GiphyDialogFragment.class);
    }

    public final String getSignature() {
        return "changeLayoutType(Lcom/giphy/sdk/ui/views/GPHMediaTypeView$LayoutType;Lcom/giphy/sdk/ui/views/GPHMediaTypeView$LayoutType;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((GPHMediaTypeView.LayoutType) obj, (GPHMediaTypeView.LayoutType) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(GPHMediaTypeView.LayoutType layoutType, GPHMediaTypeView.LayoutType layoutType2) {
        Intrinsics.checkParameterIsNotNull(layoutType, "p1");
        Intrinsics.checkParameterIsNotNull(layoutType2, "p2");
        ((GiphyDialogFragment) this.receiver).changeLayoutType(layoutType, layoutType2);
    }
}
