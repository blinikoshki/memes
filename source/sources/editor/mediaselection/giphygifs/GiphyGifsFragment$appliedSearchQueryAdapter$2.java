package editor.mediaselection.giphygifs;

import android.content.Context;
import editor.mediaselection.suggestions.MediaCategorySuggestionsAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/mediaselection/suggestions/MediaCategorySuggestionsAdapter;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: GiphyGifsFragment.kt */
final class GiphyGifsFragment$appliedSearchQueryAdapter$2 extends Lambda implements Function0<MediaCategorySuggestionsAdapter> {
    final /* synthetic */ GiphyGifsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GiphyGifsFragment$appliedSearchQueryAdapter$2(GiphyGifsFragment giphyGifsFragment) {
        super(0);
        this.this$0 = giphyGifsFragment;
    }

    public final MediaCategorySuggestionsAdapter invoke() {
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new MediaCategorySuggestionsAdapter(requireContext, C48071.INSTANCE);
    }
}
