package editor.custom.overlayboundary;

import android.content.Context;
import android.view.LayoutInflater;
import com.memes.editor.databinding.NBoundaryLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "Lcom/memes/editor/databinding/NBoundaryLayoutBinding;", "V", "Landroid/view/View;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: BoundaryLayout.kt */
final class BoundaryLayout$binding$2 extends Lambda implements Function0<NBoundaryLayoutBinding> {
    final /* synthetic */ Context $context;
    final /* synthetic */ BoundaryLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoundaryLayout$binding$2(BoundaryLayout boundaryLayout, Context context) {
        super(0);
        this.this$0 = boundaryLayout;
        this.$context = context;
    }

    public final NBoundaryLayoutBinding invoke() {
        return NBoundaryLayoutBinding.inflate(LayoutInflater.from(this.$context), this.this$0);
    }
}
