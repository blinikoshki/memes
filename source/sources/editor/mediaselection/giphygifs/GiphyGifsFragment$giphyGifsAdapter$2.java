package editor.mediaselection.giphygifs;

import android.content.Context;
import com.memes.network.giphy.api.model.GiphyGif;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/mediaselection/giphygifs/GiphyGifsAdapter;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: GiphyGifsFragment.kt */
final class GiphyGifsFragment$giphyGifsAdapter$2 extends Lambda implements Function0<GiphyGifsAdapter> {
    final /* synthetic */ GiphyGifsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GiphyGifsFragment$giphyGifsAdapter$2(GiphyGifsFragment giphyGifsFragment) {
        super(0);
        this.this$0 = giphyGifsFragment;
    }

    public final GiphyGifsAdapter invoke() {
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new GiphyGifsAdapter(requireContext, new Function2<GiphyGif, Boolean, Boolean>(this) {
            final /* synthetic */ GiphyGifsFragment$giphyGifsAdapter$2 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(invoke((GiphyGif) obj, ((Boolean) obj2).booleanValue()));
            }

            public final boolean invoke(GiphyGif giphyGif, boolean z) {
                Intrinsics.checkNotNullParameter(giphyGif, "giphyGif");
                return GiphyGifsFragment.access$getGiphyGifSelectedListener$p(this.this$0.this$0).onGiphyGifSelected(giphyGif, z);
            }
        });
    }
}
