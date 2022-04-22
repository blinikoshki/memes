package com.memes.plus.p040ui.explore;

import androidx.lifecycle.Observer;
import com.memes.plus.p040ui.posts.PostsLayoutSwitcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "isMuted", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore.ExploreTabFragment$attachPostOperationsObservers$12 */
/* compiled from: ExploreTabFragment.kt */
final class ExploreTabFragment$attachPostOperationsObservers$12<T> implements Observer<Boolean> {
    final /* synthetic */ ExploreTabFragment this$0;

    ExploreTabFragment$attachPostOperationsObservers$12(ExploreTabFragment exploreTabFragment) {
        this.this$0 = exploreTabFragment;
    }

    public final void onChanged(Boolean bool) {
        PostsLayoutSwitcher access$getPostsLayoutSwitcher$p = ExploreTabFragment.access$getPostsLayoutSwitcher$p(this.this$0);
        Intrinsics.checkNotNullExpressionValue(bool, "isMuted");
        access$getPostsLayoutSwitcher$p.updatePostPlaybackSoundMuted(bool.booleanValue());
    }
}
