package com.giphy.sdk.p013ui.views;

import android.view.View;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GPHMediaActionsView$copyLink$1 */
/* compiled from: GPHMediaActionsView.kt */
final class GPHMediaActionsView$copyLink$1 implements View.OnClickListener {
    final /* synthetic */ GPHMediaActionsView this$0;

    GPHMediaActionsView$copyLink$1(GPHMediaActionsView gPHMediaActionsView) {
        this.this$0 = gPHMediaActionsView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = (r0 = r0.getImages()).getOriginal();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r2) {
        /*
            r1 = this;
            com.giphy.sdk.ui.views.GPHMediaActionsView r2 = r1.this$0
            com.giphy.sdk.core.models.Media r0 = r2.getMedia()
            if (r0 == 0) goto L_0x0019
            com.giphy.sdk.core.models.Images r0 = r0.getImages()
            if (r0 == 0) goto L_0x0019
            com.giphy.sdk.core.models.Image r0 = r0.getOriginal()
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = r0.getGifUrl()
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            r2.saveToClipboard(r0)
            com.giphy.sdk.ui.views.GPHMediaActionsView r2 = r1.this$0
            r2.dismiss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.p013ui.views.GPHMediaActionsView$copyLink$1.onClick(android.view.View):void");
    }
}
