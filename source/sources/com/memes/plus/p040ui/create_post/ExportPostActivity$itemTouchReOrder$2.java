package com.memes.plus.p040ui.create_post;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Landroidx/recyclerview/widget/ItemTouchHelper;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.ExportPostActivity$itemTouchReOrder$2 */
/* compiled from: ExportPostActivity.kt */
final class ExportPostActivity$itemTouchReOrder$2 extends Lambda implements Function0<ItemTouchHelper> {
    final /* synthetic */ ExportPostActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExportPostActivity$itemTouchReOrder$2(ExportPostActivity exportPostActivity) {
        super(0);
        this.this$0 = exportPostActivity;
    }

    public final ItemTouchHelper invoke() {
        return new ItemTouchHelper(new ItemReorderTouchCallback(this) {
            final /* synthetic */ ExportPostActivity$itemTouchReOrder$2 this$0;

            {
                this.this$0 = r1;
            }

            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
                Intrinsics.checkNotNullParameter(viewHolder2, "target");
                int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
                int absoluteAdapterPosition2 = viewHolder2.getAbsoluteAdapterPosition();
                this.this$0.this$0.moveItem(absoluteAdapterPosition, absoluteAdapterPosition2);
                this.this$0.this$0.getSavedHashTagsAdapter().notifyItemMoved(absoluteAdapterPosition, absoluteAdapterPosition2);
                return true;
            }
        });
    }
}
