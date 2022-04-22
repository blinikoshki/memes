package editor.trash;

import android.content.Context;
import android.util.AttributeSet;
import editor.common.sheetheader.TitleWithResetHeader;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/common/sheetheader/TitleWithResetHeader;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: HeaderFooterSheet.kt */
final class HeaderFooterSheet$titleWithBackHeader$2 extends Lambda implements Function0<TitleWithResetHeader> {
    final /* synthetic */ Context $context;
    final /* synthetic */ HeaderFooterSheet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HeaderFooterSheet$titleWithBackHeader$2(HeaderFooterSheet headerFooterSheet, Context context) {
        super(0);
        this.this$0 = headerFooterSheet;
        this.$context = context;
    }

    public final TitleWithResetHeader invoke() {
        TitleWithResetHeader titleWithResetHeader = new TitleWithResetHeader(this.$context, (AttributeSet) null);
        titleWithResetHeader.setTitle(this.this$0.title);
        return titleWithResetHeader;
    }
}
