package editor.mediaselection.redditposts;

import android.content.Context;
import android.widget.EditText;
import com.memes.commons.util.ExtensionsKt;
import editor.mediaselection.suggestions.MediaCategorySuggestion;
import editor.mediaselection.suggestions.MediaCategorySuggestionsAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/mediaselection/suggestions/MediaCategorySuggestionsAdapter;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: RedditPostsFragment.kt */
final class RedditPostsFragment$subredditSuggestionsAdapter$2 extends Lambda implements Function0<MediaCategorySuggestionsAdapter> {
    final /* synthetic */ RedditPostsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RedditPostsFragment$subredditSuggestionsAdapter$2(RedditPostsFragment redditPostsFragment) {
        super(0);
        this.this$0 = redditPostsFragment;
    }

    public final MediaCategorySuggestionsAdapter invoke() {
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new MediaCategorySuggestionsAdapter(requireContext, new Function1<MediaCategorySuggestion, Unit>(this) {
            final /* synthetic */ RedditPostsFragment$subredditSuggestionsAdapter$2 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((MediaCategorySuggestion) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(MediaCategorySuggestion mediaCategorySuggestion) {
                Intrinsics.checkNotNullParameter(mediaCategorySuggestion, "suggestion");
                EditText editText = RedditPostsFragment.access$getBinding$p(this.this$0.this$0).includedSearchLayout.searchEditText;
                Intrinsics.checkNotNullExpressionValue(editText, "binding.includedSearchLayout.searchEditText");
                ExtensionsKt.clearText(editText);
                this.this$0.this$0.getRedditPostsViewModel().subredditSelectionChanged(mediaCategorySuggestion.getTitle());
            }
        });
    }
}
