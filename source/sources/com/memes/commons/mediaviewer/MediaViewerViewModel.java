package com.memes.commons.mediaviewer;

import androidx.lifecycle.LiveData;
import com.memes.commons.mediaviewer.types.MediaViewerItem;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lcom/memes/commons/mediaviewer/MediaViewerViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "()V", "_items", "Lcom/memes/commons/util/SingleLiveEvent;", "", "Lcom/memes/commons/mediaviewer/types/MediaViewerItem;", "items", "Landroidx/lifecycle/LiveData;", "setPhotoPath", "", "photoPath", "", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaViewerViewModel.kt */
public final class MediaViewerViewModel extends BaseViewModel {
    private final SingleLiveEvent<List<MediaViewerItem>> _items = new SingleLiveEvent<>();

    public final LiveData<List<MediaViewerItem>> items() {
        return this._items;
    }

    public final void setPhotoPath(String str) {
        Intrinsics.checkNotNullParameter(str, "photoPath");
        this._items.setValue(CollectionsKt.listOf(new MediaViewerItem.Photo(str)));
    }
}
