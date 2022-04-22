package editor.common.sheetfooter;

import android.content.Context;
import android.view.LayoutInflater;
import com.memes.editor.databinding.NFooterCancelDoneBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/editor/databinding/NFooterCancelDoneBinding;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: CancelDoneFooter.kt */
final class CancelDoneFooter$binding$2 extends Lambda implements Function0<NFooterCancelDoneBinding> {
    final /* synthetic */ Context $context;
    final /* synthetic */ CancelDoneFooter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CancelDoneFooter$binding$2(CancelDoneFooter cancelDoneFooter, Context context) {
        super(0);
        this.this$0 = cancelDoneFooter;
        this.$context = context;
    }

    public final NFooterCancelDoneBinding invoke() {
        return NFooterCancelDoneBinding.inflate(LayoutInflater.from(this.$context), this.this$0, true);
    }
}
