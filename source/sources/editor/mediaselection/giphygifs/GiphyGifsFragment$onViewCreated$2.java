package editor.mediaselection.giphygifs;

import android.view.KeyEvent;
import android.widget.TextView;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, mo26107d2 = {"editor/mediaselection/giphygifs/GiphyGifsFragment$onViewCreated$2", "Landroid/widget/TextView$OnEditorActionListener;", "onEditorAction", "", "v", "Landroid/widget/TextView;", "actionId", "", "event", "Landroid/view/KeyEvent;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GiphyGifsFragment.kt */
public final class GiphyGifsFragment$onViewCreated$2 implements TextView.OnEditorActionListener {
    final /* synthetic */ GiphyGifsFragment this$0;

    GiphyGifsFragment$onViewCreated$2(GiphyGifsFragment giphyGifsFragment) {
        this.this$0 = giphyGifsFragment;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        this.this$0.performSearch();
        return true;
    }
}
