package com.memes.plus.util;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.plus.custom.rv_item_visibility_awarance.ItemVisibilityScrollListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo26107d2 = {"addVisibilityTracker", "Lcom/memes/plus/custom/rv_item_visibility_awarance/ItemVisibilityScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "app_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: Ext.kt */
public final class ExtKt {
    public static final ItemVisibilityScrollListener addVisibilityTracker(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkNotNullParameter(recyclerView, "$this$addVisibilityTracker");
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        ExtKt$addVisibilityTracker$1 extKt$addVisibilityTracker$1 = new ExtKt$addVisibilityTracker$1(linearLayoutManager, linearLayoutManager);
        recyclerView.addOnScrollListener(extKt$addVisibilityTracker$1);
        return extKt$addVisibilityTracker$1;
    }
}
