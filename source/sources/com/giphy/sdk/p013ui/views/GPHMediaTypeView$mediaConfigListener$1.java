package com.giphy.sdk.p013ui.views;

import com.giphy.sdk.p013ui.GPHContentType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "it", "Lcom/giphy/sdk/ui/GPHContentType;", "invoke"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GPHMediaTypeView$mediaConfigListener$1 */
/* compiled from: GPHMediaTypeView.kt */
final class GPHMediaTypeView$mediaConfigListener$1 extends Lambda implements Function1<GPHContentType, Unit> {
    public static final GPHMediaTypeView$mediaConfigListener$1 INSTANCE = new GPHMediaTypeView$mediaConfigListener$1();

    GPHMediaTypeView$mediaConfigListener$1() {
        super(1);
    }

    public final void invoke(GPHContentType gPHContentType) {
        Intrinsics.checkParameterIsNotNull(gPHContentType, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GPHContentType) obj);
        return Unit.INSTANCE;
    }
}
