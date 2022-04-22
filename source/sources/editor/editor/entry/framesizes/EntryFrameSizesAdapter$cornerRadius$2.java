package editor.editor.entry.framesizes;

import com.memes.editor.C4175R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EntryFrameSizesAdapter.kt */
final class EntryFrameSizesAdapter$cornerRadius$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ EntryFrameSizesAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EntryFrameSizesAdapter$cornerRadius$2(EntryFrameSizesAdapter entryFrameSizesAdapter) {
        super(0);
        this.this$0 = entryFrameSizesAdapter;
    }

    public final float invoke() {
        return (float) this.this$0.context.getResources().getDimensionPixelSize(C4175R.dimen._4sdp);
    }
}
