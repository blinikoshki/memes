package editor.editor.dashboard.drafts;

import com.memes.commons.output.OutputTargetGenerator;
import editor.contentport.ContentPortUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/contentport/ContentPortUtil;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorDraftsViewModel.kt */
final class EditorDraftsViewModel$portUtil$2 extends Lambda implements Function0<ContentPortUtil> {
    final /* synthetic */ OutputTargetGenerator $outputTargetGenerator;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorDraftsViewModel$portUtil$2(OutputTargetGenerator outputTargetGenerator) {
        super(0);
        this.$outputTargetGenerator = outputTargetGenerator;
    }

    public final ContentPortUtil invoke() {
        return new ContentPortUtil(this.$outputTargetGenerator);
    }
}
