package editor.mediaselection.redditposts;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import editor.mediaselection.suggestions.MediaCategorySuggestion;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "suggestions", "", "Leditor/mediaselection/suggestions/MediaCategorySuggestion;", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: RedditPostsFragment.kt */
final class RedditPostsFragment$onViewCreated$7<T> implements Observer<List<? extends MediaCategorySuggestion>> {
    final /* synthetic */ RedditPostsFragment this$0;

    RedditPostsFragment$onViewCreated$7(RedditPostsFragment redditPostsFragment) {
        this.this$0 = redditPostsFragment;
    }

    public final void onChanged(List<MediaCategorySuggestion> list) {
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            RecyclerView recyclerView = RedditPostsFragment.access$getBinding$p(this.this$0).suggestionsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.suggestionsRecyclerView");
            recyclerView.setVisibility(8);
            return;
        }
        this.this$0.getSubredditSuggestionsAdapter().setItems(list);
        RecyclerView recyclerView2 = RedditPostsFragment.access$getBinding$p(this.this$0).suggestionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.suggestionsRecyclerView");
        recyclerView2.setVisibility(0);
    }
}
