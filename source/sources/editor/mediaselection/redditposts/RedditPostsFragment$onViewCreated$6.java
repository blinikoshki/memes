package editor.mediaselection.redditposts;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.memes.editor.C4175R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "text", "", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: RedditPostsFragment.kt */
final class RedditPostsFragment$onViewCreated$6<T> implements Observer<String> {
    final /* synthetic */ RedditPostsFragment this$0;

    RedditPostsFragment$onViewCreated$6(RedditPostsFragment redditPostsFragment) {
        this.this$0 = redditPostsFragment;
    }

    public final void onChanged(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            TextView textView = RedditPostsFragment.access$getBinding$p(this.this$0).searchQueryResultTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.searchQueryResultTextView");
            textView.setVisibility(8);
            TextView textView2 = RedditPostsFragment.access$getBinding$p(this.this$0).searchQueryResultTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.searchQueryResultTextView");
            textView2.setText((CharSequence) null);
            return;
        }
        TextView textView3 = RedditPostsFragment.access$getBinding$p(this.this$0).searchQueryResultTextView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.searchQueryResultTextView");
        textView3.setVisibility(0);
        TextView textView4 = RedditPostsFragment.access$getBinding$p(this.this$0).searchQueryResultTextView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.searchQueryResultTextView");
        textView4.setText(this.this$0.getString(C4175R.string.format_applied_search_query, str));
    }
}
