package editor.mediaselection.giphygifs;

import androidx.lifecycle.Observer;
import com.memes.editor.C4175R;
import editor.mediaselection.suggestions.MediaCategorySuggestion;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "text", "", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: GiphyGifsFragment.kt */
final class GiphyGifsFragment$onViewCreated$6<T> implements Observer<String> {
    final /* synthetic */ GiphyGifsFragment this$0;

    GiphyGifsFragment$onViewCreated$6(GiphyGifsFragment giphyGifsFragment) {
        this.this$0 = giphyGifsFragment;
    }

    public final void onChanged(String str) {
        boolean z = false;
        Timber.m300d("~> suggestionsAdapter " + str + ": " + this.this$0.getSuggestionsAdapter().getItems(), new Object[0]);
        if (!this.this$0.getSuggestionsAdapter().setSelectedSuggestionText(str)) {
            CharSequence charSequence = str;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                z = true;
            }
            if (!z) {
                this.this$0.getAppliedSearchQueryAdapter().removeAllItems();
                this.this$0.getAppliedSearchQueryAdapter().addItem(new MediaCategorySuggestion(C4175R.C4178drawable.icon_magnifying_glass, str, true));
                GiphyGifsFragment.access$getBinding$p(this.this$0).suggestionsRecyclerView.post(new Runnable(this) {
                    final /* synthetic */ GiphyGifsFragment$onViewCreated$6 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void run() {
                        GiphyGifsFragment.access$getBinding$p(this.this$0.this$0).suggestionsRecyclerView.scrollToPosition(0);
                    }
                });
                return;
            }
        }
        this.this$0.getAppliedSearchQueryAdapter().removeAllItems();
    }
}
