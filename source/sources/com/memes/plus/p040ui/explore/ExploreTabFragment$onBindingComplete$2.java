package com.memes.plus.p040ui.explore;

import android.view.View;
import com.memes.plus.App;
import com.memes.plus.base.ActivityHandle;
import com.memes.plus.p040ui.explore_search.ExploreSearchFragment;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore.ExploreTabFragment$onBindingComplete$2 */
/* compiled from: ExploreTabFragment.kt */
final class ExploreTabFragment$onBindingComplete$2 implements View.OnClickListener {
    final /* synthetic */ ExploreTabFragment this$0;

    ExploreTabFragment$onBindingComplete$2(ExploreTabFragment exploreTabFragment) {
        this.this$0 = exploreTabFragment;
    }

    public final void onClick(View view) {
        ActivityHandle.DefaultImpls.replaceFragment$default(this.this$0.getActivityHandle(), new ExploreSearchFragment(), ExploreSearchFragment.TAG, false, 4, (Object) null);
        App.Companion.trackingManager().onExploreSearchBoxTapped();
    }
}
