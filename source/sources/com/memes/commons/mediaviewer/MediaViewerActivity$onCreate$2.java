package com.memes.commons.mediaviewer;

import androidx.lifecycle.Observer;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.memes.commons.mediaviewer.types.MediaViewerItem;
import com.memes.commons.mediaviewer.types.MediaViewerItemTypesAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "items", "", "Lcom/memes/commons/mediaviewer/types/MediaViewerItem;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaViewerActivity.kt */
final class MediaViewerActivity$onCreate$2<T> implements Observer<List<? extends MediaViewerItem>> {
    final /* synthetic */ MediaViewerItemTypesAdapter $itemTypesAdapter;

    MediaViewerActivity$onCreate$2(MediaViewerItemTypesAdapter mediaViewerItemTypesAdapter) {
        this.$itemTypesAdapter = mediaViewerItemTypesAdapter;
    }

    public final void onChanged(List<? extends MediaViewerItem> list) {
        MediaViewerItemTypesAdapter mediaViewerItemTypesAdapter = this.$itemTypesAdapter;
        Intrinsics.checkNotNullExpressionValue(list, FirebaseAnalytics.Param.ITEMS);
        mediaViewerItemTypesAdapter.setItems(list);
    }
}
