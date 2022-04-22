package com.giphy.sdk.p013ui.list;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.enums.RenditionType;
import com.giphy.sdk.p013ui.views.GifView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0006R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, mo26107d2 = {"Lcom/giphy/sdk/ui/list/GifViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "isGifLoaded", "", "()Z", "isLocked", "view", "Lcom/giphy/sdk/ui/views/GifView;", "getView", "()Lcom/giphy/sdk/ui/views/GifView;", "setData", "", "gifData", "Lcom/giphy/sdk/core/models/Media;", "placeholderColor", "", "renditionType", "Lcom/giphy/sdk/core/models/enums/RenditionType;", "setLocked", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.list.GifViewHolder */
/* compiled from: GifViewHolder.kt */
public final class GifViewHolder extends RecyclerView.ViewHolder {
    private boolean isLocked;
    private final GifView view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GifViewHolder(View view2) {
        super(view2);
        Intrinsics.checkParameterIsNotNull(view2, "itemView");
        this.view = (GifView) view2;
    }

    public final GifView getView() {
        return this.view;
    }

    public final boolean isGifLoaded() {
        return this.view.getLoaded();
    }

    public static /* synthetic */ void setData$default(GifViewHolder gifViewHolder, Media media, int i, RenditionType renditionType, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            renditionType = null;
        }
        gifViewHolder.setData(media, i, renditionType);
    }

    public final void setData(Media media, int i, RenditionType renditionType) {
        Intrinsics.checkParameterIsNotNull(media, "gifData");
        this.view.setMedia(media, renditionType, Integer.valueOf(i));
        if (this.isLocked) {
            this.view.setLocked();
        } else {
            this.view.removeLock();
        }
    }

    public final void setLocked(boolean z) {
        this.isLocked = z;
    }
}
