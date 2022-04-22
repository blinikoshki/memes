package com.memes.plus.p040ui.home.feeds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.memes.plus.p040ui.posts.PostsTabFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\f"}, mo26107d2 = {"Lcom/memes/plus/ui/home/feeds/HomeFeedsPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "getPageTitle", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.feeds.HomeFeedsPagerAdapter */
/* compiled from: HomeFeedsPagerAdapter.kt */
public final class HomeFeedsPagerAdapter extends FragmentStateAdapter {
    public int getItemCount() {
        return 3;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFeedsPagerAdapter(AppCompatActivity appCompatActivity) {
        super((FragmentActivity) appCompatActivity);
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
    }

    public Fragment createFragment(int i) {
        Timber.m300d(this + ".createFragment(" + i + ')', new Object[0]);
        if (i == HomeFeedType.FOR_YOU.getPosition()) {
            return PostsTabFragment.Companion.newInstance(HomeFeedType.FOR_YOU);
        }
        if (i == HomeFeedType.FOLLOWING.getPosition()) {
            return PostsTabFragment.Companion.newInstance(HomeFeedType.FOLLOWING);
        }
        if (i == HomeFeedType.NEW.getPosition()) {
            return PostsTabFragment.Companion.newInstance(HomeFeedType.NEW);
        }
        throw new RuntimeException("Unknown position: " + i);
    }

    public final String getPageTitle(int i) {
        if (i == HomeFeedType.FOR_YOU.getPosition()) {
            return HomeFeedType.FOR_YOU.getDisplayName();
        }
        if (i == HomeFeedType.FOLLOWING.getPosition()) {
            return HomeFeedType.FOLLOWING.getDisplayName();
        }
        if (i == HomeFeedType.NEW.getPosition()) {
            return HomeFeedType.NEW.getDisplayName();
        }
        throw new RuntimeException("Unknown position: " + i);
    }
}
