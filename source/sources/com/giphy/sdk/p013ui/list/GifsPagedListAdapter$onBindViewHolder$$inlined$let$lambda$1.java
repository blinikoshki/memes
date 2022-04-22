package com.giphy.sdk.p013ui.list;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.giphy.sdk.core.models.Media;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/giphy/sdk/ui/list/GifsPagedListAdapter$onBindViewHolder$1$2"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.list.GifsPagedListAdapter$onBindViewHolder$$inlined$let$lambda$1 */
/* compiled from: GifsPagedListAdapter.kt */
final class GifsPagedListAdapter$onBindViewHolder$$inlined$let$lambda$1 implements View.OnClickListener {
    final /* synthetic */ RecyclerView.ViewHolder $holder$inlined;
    final /* synthetic */ Media $media$inlined;
    final /* synthetic */ int $position$inlined;
    final /* synthetic */ GifsPagedListAdapter this$0;

    GifsPagedListAdapter$onBindViewHolder$$inlined$let$lambda$1(GifsPagedListAdapter gifsPagedListAdapter, RecyclerView.ViewHolder viewHolder, int i, Media media) {
        this.this$0 = gifsPagedListAdapter;
        this.$holder$inlined = viewHolder;
        this.$position$inlined = i;
        this.$media$inlined = media;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r0 = r0.snapshot();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r3) {
        /*
            r2 = this;
            com.giphy.sdk.ui.list.GifsPagedListAdapter r3 = r2.this$0
            kotlin.jvm.functions.Function2 r3 = r3.getOnGifClickListener()
            if (r3 == 0) goto L_0x002f
            com.giphy.sdk.ui.list.GifsPagedListAdapter r0 = r2.this$0
            androidx.paging.PagedList r0 = r0.getCurrentList()
            if (r0 == 0) goto L_0x001d
            java.util.List r0 = r0.snapshot()
            if (r0 == 0) goto L_0x001d
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r0)
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            if (r0 != 0) goto L_0x0023
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0023:
            int r1 = r2.$position$inlined
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r3 = r3.invoke(r0, r1)
            kotlin.Unit r3 = (kotlin.Unit) r3
        L_0x002f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.p013ui.list.GifsPagedListAdapter$onBindViewHolder$$inlined$let$lambda$1.onClick(android.view.View):void");
    }
}
