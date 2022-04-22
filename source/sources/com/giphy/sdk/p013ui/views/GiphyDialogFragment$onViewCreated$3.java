package com.giphy.sdk.p013ui.views;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GiphyDialogFragment$onViewCreated$3 */
/* compiled from: GiphyDialogFragment.kt */
final class GiphyDialogFragment$onViewCreated$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GiphyDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GiphyDialogFragment$onViewCreated$3(GiphyDialogFragment giphyDialogFragment) {
        super(0);
        this.this$0 = giphyDialogFragment;
    }

    public final void invoke() {
        this.this$0.getDialog().onBackPressed();
    }
}
