package com.giphy.sdk.p013ui.views;

import android.content.Context;
import android.view.View;
import com.giphy.sdk.p013ui.GPHContentType;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/giphy/sdk/ui/views/GPHMediaTypeView$1$1"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GPHMediaTypeView$$special$$inlined$forEach$lambda$1 */
/* compiled from: GPHMediaTypeView.kt */
final class GPHMediaTypeView$$special$$inlined$forEach$lambda$1 implements View.OnClickListener {
    final /* synthetic */ Context $context$inlined;
    final /* synthetic */ List $mediaViews$inlined;
    final /* synthetic */ GPHMediaTypeView this$0;

    GPHMediaTypeView$$special$$inlined$forEach$lambda$1(GPHMediaTypeView gPHMediaTypeView, Context context, List list) {
        this.this$0 = gPHMediaTypeView;
        this.$context$inlined = context;
        this.$mediaViews$inlined = list;
    }

    public final void onClick(View view) {
        GPHMediaTypeView gPHMediaTypeView = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        Object tag = view.getTag();
        if (tag != null) {
            gPHMediaTypeView.setGphContentType((GPHContentType) tag);
            this.this$0.getMediaConfigListener().invoke(this.this$0.getGphContentType());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.giphy.sdk.ui.GPHContentType");
    }
}
