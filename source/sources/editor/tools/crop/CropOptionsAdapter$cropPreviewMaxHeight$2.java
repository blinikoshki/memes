package editor.tools.crop;

import com.memes.editor.C4175R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: CropOptionsAdapter.kt */
final class CropOptionsAdapter$cropPreviewMaxHeight$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ CropOptionsAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CropOptionsAdapter$cropPreviewMaxHeight$2(CropOptionsAdapter cropOptionsAdapter) {
        super(0);
        this.this$0 = cropOptionsAdapter;
    }

    public final int invoke() {
        return this.this$0.context.getResources().getDimensionPixelSize(C4175R.dimen._60sdp);
    }
}
