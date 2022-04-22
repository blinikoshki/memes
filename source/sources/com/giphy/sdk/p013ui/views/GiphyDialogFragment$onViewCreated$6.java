package com.giphy.sdk.p013ui.views;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GiphyDialogFragment$onViewCreated$6 */
/* compiled from: GiphyDialogFragment.kt */
final class GiphyDialogFragment$onViewCreated$6 extends FunctionReference implements Function0<Unit> {
    GiphyDialogFragment$onViewCreated$6(GiphyDialogFragment giphyDialogFragment) {
        super(0, giphyDialogFragment);
    }

    public final String getName() {
        return "dismiss";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(GiphyDialogFragment.class);
    }

    public final String getSignature() {
        return "dismiss()V";
    }

    public final void invoke() {
        ((GiphyDialogFragment) this.receiver).dismiss();
    }
}
