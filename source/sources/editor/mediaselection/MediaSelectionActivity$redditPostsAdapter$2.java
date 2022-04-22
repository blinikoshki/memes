package editor.mediaselection;

import com.memes.network.reddit.api.model.RedditPost;
import editor.mediaselection.items.MediaSelectionItemsViewModel;
import editor.mediaselection.redditposts.RedditPostsHorizontalSelectionAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/mediaselection/redditposts/RedditPostsHorizontalSelectionAdapter;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionActivity.kt */
final class MediaSelectionActivity$redditPostsAdapter$2 extends Lambda implements Function0<RedditPostsHorizontalSelectionAdapter> {
    final /* synthetic */ MediaSelectionActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaSelectionActivity$redditPostsAdapter$2(MediaSelectionActivity mediaSelectionActivity) {
        super(0);
        this.this$0 = mediaSelectionActivity;
    }

    public final RedditPostsHorizontalSelectionAdapter invoke() {
        MediaSelectionActivity mediaSelectionActivity = this.this$0;
        return new RedditPostsHorizontalSelectionAdapter(mediaSelectionActivity, new Function2<RedditPost, Boolean, Boolean>(mediaSelectionActivity.getViewModel()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(invoke((RedditPost) obj, ((Boolean) obj2).booleanValue()));
            }

            public final boolean invoke(RedditPost redditPost, boolean z) {
                Intrinsics.checkNotNullParameter(redditPost, "p1");
                return ((MediaSelectionItemsViewModel) this.receiver).setRedditPostSelected(redditPost, z);
            }
        });
    }
}
