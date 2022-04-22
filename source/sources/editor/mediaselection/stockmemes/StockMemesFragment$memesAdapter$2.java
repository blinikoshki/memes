package editor.mediaselection.stockmemes;

import android.content.Context;
import com.memes.network.memes.api.model.stockmemes.StockMeme;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/mediaselection/stockmemes/StockMemesAdapter;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: StockMemesFragment.kt */
final class StockMemesFragment$memesAdapter$2 extends Lambda implements Function0<StockMemesAdapter> {
    final /* synthetic */ StockMemesFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StockMemesFragment$memesAdapter$2(StockMemesFragment stockMemesFragment) {
        super(0);
        this.this$0 = stockMemesFragment;
    }

    public final StockMemesAdapter invoke() {
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new StockMemesAdapter(requireContext, new Function2<StockMeme, Boolean, Boolean>(this) {
            final /* synthetic */ StockMemesFragment$memesAdapter$2 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(invoke((StockMeme) obj, ((Boolean) obj2).booleanValue()));
            }

            public final boolean invoke(StockMeme stockMeme, boolean z) {
                Intrinsics.checkNotNullParameter(stockMeme, "stockMeme");
                return StockMemesFragment.access$getStockMemeSelectedListener$p(this.this$0.this$0).onStockMemeSelected(stockMeme, z);
            }
        });
    }
}
