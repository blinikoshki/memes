package editor.mediaselection.items;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/bumptech/glide/RequestManager;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionItemPreviewBottomSheet.kt */
final class MediaSelectionItemPreviewBottomSheet$glideRequestManager$2 extends Lambda implements Function0<RequestManager> {
    final /* synthetic */ MediaSelectionItemPreviewBottomSheet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaSelectionItemPreviewBottomSheet$glideRequestManager$2(MediaSelectionItemPreviewBottomSheet mediaSelectionItemPreviewBottomSheet) {
        super(0);
        this.this$0 = mediaSelectionItemPreviewBottomSheet;
    }

    public final RequestManager invoke() {
        return Glide.with(this.this$0.requireContext());
    }
}
