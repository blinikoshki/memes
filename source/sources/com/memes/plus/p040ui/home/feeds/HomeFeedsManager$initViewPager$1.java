package com.memes.plus.p040ui.home.feeds;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "position", "", "onConfigureTab"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.feeds.HomeFeedsManager$initViewPager$1 */
/* compiled from: HomeFeedsManager.kt */
final class HomeFeedsManager$initViewPager$1 implements TabLayoutMediator.TabConfigurationStrategy {
    final /* synthetic */ HomeFeedsPagerAdapter $feedsPagerAdapter;

    HomeFeedsManager$initViewPager$1(HomeFeedsPagerAdapter homeFeedsPagerAdapter) {
        this.$feedsPagerAdapter = homeFeedsPagerAdapter;
    }

    public final void onConfigureTab(TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        tab.setText((CharSequence) this.$feedsPagerAdapter.getPageTitle(i));
    }
}
