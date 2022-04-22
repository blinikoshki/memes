package editor.mediaselection.giphygifs;

import com.memes.network.giphy.api.model.GiphyGif;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "giphyGif", "Lcom/memes/network/giphy/api/model/GiphyGif;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: GiphyGifsFragment.kt */
final class GiphyGifsFragment$openGiphyDialog$1 extends Lambda implements Function1<GiphyGif, Unit> {
    final /* synthetic */ GiphyGifsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GiphyGifsFragment$openGiphyDialog$1(GiphyGifsFragment giphyGifsFragment) {
        super(1);
        this.this$0 = giphyGifsFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GiphyGif) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GiphyGif giphyGif) {
        if (giphyGif != null) {
            this.this$0.getGiphyGifsAdapter().setItemSelectedById(giphyGif.getIdentifier(), true);
            GiphyGifsFragment.access$getGiphyGifSelectedListener$p(this.this$0).onGiphyGifSelected(giphyGif, true);
        }
    }
}
