package com.giphy.sdk.p013ui.list;

import androidx.recyclerview.widget.DiffUtil;
import com.giphy.sdk.core.models.Media;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\b"}, mo26107d2 = {"com/giphy/sdk/ui/list/GifsPagedListAdapter$Companion$POST_COMPARATOR$1", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/giphy/sdk/core/models/Media;", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.list.GifsPagedListAdapter$Companion$POST_COMPARATOR$1 */
/* compiled from: GifsPagedListAdapter.kt */
public final class GifsPagedListAdapter$Companion$POST_COMPARATOR$1 extends DiffUtil.ItemCallback<Media> {
    GifsPagedListAdapter$Companion$POST_COMPARATOR$1() {
    }

    public boolean areContentsTheSame(Media media, Media media2) {
        Intrinsics.checkParameterIsNotNull(media, "oldItem");
        Intrinsics.checkParameterIsNotNull(media2, "newItem");
        return Intrinsics.areEqual((Object) media.getId(), (Object) media2.getId());
    }

    public boolean areItemsTheSame(Media media, Media media2) {
        Intrinsics.checkParameterIsNotNull(media, "oldItem");
        Intrinsics.checkParameterIsNotNull(media2, "newItem");
        return Intrinsics.areEqual((Object) media, (Object) media2);
    }
}
