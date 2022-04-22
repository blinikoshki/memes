package editor.mediaselection;

import androidx.fragment.app.FragmentManager;
import editor.mediaselection.items.MediaSelectionItem;
import editor.mediaselection.items.MediaSelectionItemPreviewBottomSheet;
import editor.mediaselection.items.MediaSelectionItemsAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/mediaselection/items/MediaSelectionItemsAdapter;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionActivity.kt */
final class MediaSelectionActivity$mediaSelectionItemsAdapter$2 extends Lambda implements Function0<MediaSelectionItemsAdapter> {
    final /* synthetic */ MediaSelectionActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaSelectionActivity$mediaSelectionItemsAdapter$2(MediaSelectionActivity mediaSelectionActivity) {
        super(0);
        this.this$0 = mediaSelectionActivity;
    }

    public final MediaSelectionItemsAdapter invoke() {
        return new MediaSelectionItemsAdapter(this.this$0, new MediaSelectionItemsAdapter.OnSelectedItemTappedListener(this) {
            final /* synthetic */ MediaSelectionActivity$mediaSelectionItemsAdapter$2 this$0;

            {
                this.this$0 = r1;
            }

            public final void onSelectedItemTapped(final MediaSelectionItem mediaSelectionItem) {
                Intrinsics.checkNotNullParameter(mediaSelectionItem, "item");
                MediaSelectionItemPreviewBottomSheet mediaSelectionItemPreviewBottomSheet = new MediaSelectionItemPreviewBottomSheet();
                FragmentManager supportFragmentManager = this.this$0.this$0.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                mediaSelectionItemPreviewBottomSheet.show(supportFragmentManager, mediaSelectionItem, new Function0<Unit>(this) {
                    final /* synthetic */ C47951 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        this.this$0.this$0.this$0.getViewModel().setItemSelected(mediaSelectionItem, false);
                    }
                });
            }
        });
    }
}
