package com.giphy.sdk.p013ui.pagination;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.giphy.sdk.p013ui.C1800R;
import com.giphy.sdk.p013ui.views.GifView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/giphy/sdk/ui/pagination/NoContentItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.pagination.NoContentItemViewHolder */
/* compiled from: NoContentItemViewHolder.kt */
public final class NoContentItemViewHolder extends RecyclerView.ViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoContentItemViewHolder(View view) {
        super(view);
        Intrinsics.checkParameterIsNotNull(view, ViewHierarchyConstants.VIEW_KEY);
    }

    public final void bind() {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        RecyclerView.LayoutParams layoutParams2 = null;
        if (!(layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            layoutParams = null;
        }
        StaggeredGridLayoutManager.LayoutParams layoutParams3 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
        if (layoutParams3 != null) {
            layoutParams3.setFullSpan(true);
        }
        View view2 = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, "itemView");
        ViewGroup.LayoutParams layoutParams4 = view2.getLayoutParams();
        if (layoutParams4 instanceof RecyclerView.LayoutParams) {
            layoutParams2 = layoutParams4;
        }
        RecyclerView.LayoutParams layoutParams5 = layoutParams2;
        if (layoutParams5 != null) {
            layoutParams5.width = Resources.getSystem().getDisplayMetrics().widthPixels;
        }
        View view3 = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view3, "itemView");
        ((GifView) view3.findViewById(C1800R.C1803id.errorGif)).loadAsset(C1800R.C1802drawable.gph_no_results_sticker);
        View view4 = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view4, "itemView");
        TextView textView = (TextView) view4.findViewById(C1800R.C1803id.errorMessage);
        Intrinsics.checkExpressionValueIsNotNull(textView, "itemView.errorMessage");
        View view5 = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view5, "itemView");
        textView.setText(view5.getResources().getText(C1800R.string.gph_error_no_gifs_found));
    }
}
