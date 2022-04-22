package editor.mediaselection.redditposts;

import androidx.lifecycle.Observer;
import com.memes.network.reddit.api.model.RedditPost;
import editor.core.AdapterUpdate;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "update", "Leditor/core/AdapterUpdate;", "Lcom/memes/network/reddit/api/model/RedditPost;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: RedditPostsFragment.kt */
final class RedditPostsFragment$onViewCreated$8<T> implements Observer<AdapterUpdate<RedditPost>> {
    final /* synthetic */ RedditPostsFragment this$0;

    RedditPostsFragment$onViewCreated$8(RedditPostsFragment redditPostsFragment) {
        this.this$0 = redditPostsFragment;
    }

    public final void onChanged(AdapterUpdate<RedditPost> adapterUpdate) {
        this.this$0.getRedditPostsAdapter().applyAdapterUpdate(adapterUpdate);
        if (adapterUpdate.getPage() <= 0) {
            RedditPostsFragment.access$getBinding$p(this.this$0).recyclerView.post(new Runnable(this) {
                final /* synthetic */ RedditPostsFragment$onViewCreated$8 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    RedditPostsFragment.access$getBinding$p(this.this$0.this$0).recyclerView.scrollToPosition(0);
                }
            });
        }
    }
}
