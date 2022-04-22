package com.memes.plus.util;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.memes.plus.custom.rv_item_visibility_awarance.ItemVisibilityScrollListener;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, mo26107d2 = {"com/memes/plus/util/ExtKt$addVisibilityTracker$1", "Lcom/memes/plus/custom/rv_item_visibility_awarance/ItemVisibilityScrollListener;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Ext.kt */
public final class ExtKt$addVisibilityTracker$1 extends ItemVisibilityScrollListener {
    final /* synthetic */ LinearLayoutManager $layoutManager;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExtKt$addVisibilityTracker$1(LinearLayoutManager linearLayoutManager, LinearLayoutManager linearLayoutManager2) {
        super(linearLayoutManager2);
        this.$layoutManager = linearLayoutManager;
    }
}
