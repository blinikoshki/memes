package editor.common.sheetfooter;

import android.content.Context;
import android.view.LayoutInflater;
import com.memes.editor.databinding.NFooterCloseOnlyBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/editor/databinding/NFooterCloseOnlyBinding;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: CloseOnlyFooter.kt */
final class CloseOnlyFooter$binding$2 extends Lambda implements Function0<NFooterCloseOnlyBinding> {
    final /* synthetic */ Context $context;
    final /* synthetic */ CloseOnlyFooter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloseOnlyFooter$binding$2(CloseOnlyFooter closeOnlyFooter, Context context) {
        super(0);
        this.this$0 = closeOnlyFooter;
        this.$context = context;
    }

    public final NFooterCloseOnlyBinding invoke() {
        return NFooterCloseOnlyBinding.inflate(LayoutInflater.from(this.$context), this.this$0, true);
    }
}
