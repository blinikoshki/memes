package com.memes.plus.p040ui.home.bottomtabs;

import com.memes.plus.p040ui.explore.ExploreTabFragment;
import com.memes.plus.p040ui.profile.self_profile.SelfProfileFragment;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Lcom/memes/plus/ui/home/bottomtabs/BottomTabsFragmentKeeper;", "", "()V", "profileFragment", "Lcom/memes/plus/ui/profile/self_profile/SelfProfileFragment;", "topPostsTabFragment", "Lcom/memes/plus/ui/explore/ExploreTabFragment;", "getExploreTabFragment", "getExploreTabTag", "", "getProfileTabFragment", "getProfileTabTag", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.bottomtabs.BottomTabsFragmentKeeper */
/* compiled from: BottomTabsFragmentKeeper.kt */
public final class BottomTabsFragmentKeeper {
    private SelfProfileFragment profileFragment = SelfProfileFragment.Companion.newInstance();
    private ExploreTabFragment topPostsTabFragment = ExploreTabFragment.Companion.newInstance();

    public final String getExploreTabTag() {
        return ExploreTabFragment.TAG;
    }

    public final String getProfileTabTag() {
        return SelfProfileFragment.TAG;
    }

    public BottomTabsFragmentKeeper() {
        this.topPostsTabFragment.enableBottomNavigationTabUpdateCapability();
        this.profileFragment.enableBottomNavigationTabUpdateCapability();
    }

    public final ExploreTabFragment getExploreTabFragment() {
        return this.topPostsTabFragment;
    }

    public final SelfProfileFragment getProfileTabFragment() {
        return this.profileFragment;
    }
}
