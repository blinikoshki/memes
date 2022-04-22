package editor.mediaselection;

import androidx.lifecycle.Observer;
import editor.mediaselection.items.MediaSelectionItem;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "items", "", "Leditor/mediaselection/items/MediaSelectionItem;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionActivity.kt */
final class MediaSelectionActivity$onCreate$10<T> implements Observer<List<? extends MediaSelectionItem>> {
    final /* synthetic */ MediaSelectionActivity this$0;

    MediaSelectionActivity$onCreate$10(MediaSelectionActivity mediaSelectionActivity) {
        this.this$0 = mediaSelectionActivity;
    }

    public final void onChanged(List<? extends MediaSelectionItem> list) {
        for (MediaSelectionItem mediaSelectionItem : list) {
            if (this.this$0.config.getExitOnFirstSelection()) {
                this.this$0.getMediaImportViewModel().m2586import(mediaSelectionItem);
                return;
            }
            this.this$0.getMediaSelectionItemsAdapter().addItem(mediaSelectionItem);
            this.this$0.getColorsAdapter().setItemSelectedById(mediaSelectionItem.getIdentifier(), true);
            this.this$0.getGradientsAdapter().setItemSelectedById(mediaSelectionItem.getIdentifier(), true);
            this.this$0.getPatternsAdapter().setItemSelectedById(mediaSelectionItem.getIdentifier(), true);
            this.this$0.getGiphyGifsAdapter().setItemSelectedById(mediaSelectionItem.getIdentifier(), true);
            this.this$0.getPhotosAdapter().setItemSelectedById(mediaSelectionItem.getIdentifier(), true);
            this.this$0.getVideosAdapter().setItemSelectedById(mediaSelectionItem.getIdentifier(), true);
            this.this$0.getStockMemesAdapter().setItemSelectedById(mediaSelectionItem.getIdentifier(), true);
            this.this$0.getRedditPostsAdapter().setItemSelectedById(mediaSelectionItem.getIdentifier(), true);
        }
    }
}
