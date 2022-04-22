package editor.mediaselection.redditposts;

import android.content.Context;
import com.memes.network.reddit.api.model.RedditPost;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/mediaselection/redditposts/RedditPostsAdapter;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: RedditPostsFragment.kt */
final class RedditPostsFragment$redditPostsAdapter$2 extends Lambda implements Function0<RedditPostsAdapter> {
    final /* synthetic */ RedditPostsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RedditPostsFragment$redditPostsAdapter$2(RedditPostsFragment redditPostsFragment) {
        super(0);
        this.this$0 = redditPostsFragment;
    }

    public final RedditPostsAdapter invoke() {
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new RedditPostsAdapter(requireContext, new Function2<RedditPost, Boolean, Boolean>(this) {
            final /* synthetic */ RedditPostsFragment$redditPostsAdapter$2 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(invoke((RedditPost) obj, ((Boolean) obj2).booleanValue()));
            }

            public final boolean invoke(RedditPost redditPost, boolean z) {
                Intrinsics.checkNotNullParameter(redditPost, "redditPost");
                return RedditPostsFragment.access$getRedditPostSelectedListener$p(this.this$0.this$0).onRedditPostSelected(redditPost, z);
            }
        });
    }
}
