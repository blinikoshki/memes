package editor.editor.equipment.media;

import android.content.Context;
import android.view.LayoutInflater;
import com.memes.editor.databinding.NMediaViewBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/editor/databinding/NMediaViewBinding;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaLayerView.kt */
final class MediaLayerView$binding$2 extends Lambda implements Function0<NMediaViewBinding> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MediaLayerView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaLayerView$binding$2(MediaLayerView mediaLayerView, Context context) {
        super(0);
        this.this$0 = mediaLayerView;
        this.$context = context;
    }

    public final NMediaViewBinding invoke() {
        return NMediaViewBinding.inflate(LayoutInflater.from(this.$context), this.this$0);
    }
}
