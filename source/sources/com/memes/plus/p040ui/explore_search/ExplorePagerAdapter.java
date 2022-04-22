package com.memes.plus.p040ui.explore_search;

import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.memes.plus.base.BaseFragmentStatePagerAdapter;
import com.memes.plus.p040ui.explore_search.people_search.PeopleSearchResultsFragment;
import com.memes.plus.p040ui.explore_search.tag_search.TagSearchResultsFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\nH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/ExplorePagerAdapter;", "Lcom/memes/plus/base/BaseFragmentStatePagerAdapter;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "(Landroidx/fragment/app/FragmentManager;)V", "peopleSearchResultFragment", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsFragment;", "tagSearchResultFragment", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResultsFragment;", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getPageTitle", "", "saveState", "Landroid/os/Parcelable;", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore_search.ExplorePagerAdapter */
/* compiled from: ExplorePagerAdapter.kt */
public final class ExplorePagerAdapter extends BaseFragmentStatePagerAdapter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int PAGE_COUNT = 2;
    private PeopleSearchResultsFragment peopleSearchResultFragment = new PeopleSearchResultsFragment();
    private TagSearchResultsFragment tagSearchResultFragment = new TagSearchResultsFragment();

    public int getCount() {
        return 2;
    }

    public Parcelable saveState() {
        return null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExplorePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/ExplorePagerAdapter$Companion;", "", "()V", "PAGE_COUNT", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.explore_search.ExplorePagerAdapter$Companion */
    /* compiled from: ExplorePagerAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Fragment getItem(int i) {
        if (i == 0) {
            return this.peopleSearchResultFragment;
        }
        if (i == 1) {
            return this.tagSearchResultFragment;
        }
        throw new RuntimeException("Unable to find fragment for " + i + " position");
    }

    public CharSequence getPageTitle(int i) {
        if (i == 0) {
            return "People";
        }
        if (i == 1) {
            return "Tags";
        }
        throw new RuntimeException("Unable to find page title for " + i + " position");
    }
}
