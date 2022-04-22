package editor.tools.filters.tabs;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import editor.custom.TabsSheetAdapter;
import editor.tools.filters.basicfilters.BasicFiltersFragment;
import editor.tools.filters.deepfryfilters.DeepFryFiltersFragment;
import editor.tools.filters.mediaenhance.MediaEnhanceFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\b\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0011"}, mo26107d2 = {"Leditor/tools/filters/tabs/MediaFilterTabsAdapter;", "Leditor/custom/TabsSheetAdapter;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/Lifecycle;)V", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getBasicFiltersPagePosition", "getDeepFryFiltersPagePosition", "getEnhanceFiltersPagePosition", "getItemCount", "getPageTitle", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaFilterTabsAdapter.kt */
public final class MediaFilterTabsAdapter extends TabsSheetAdapter {
    public final int getBasicFiltersPagePosition() {
        return 0;
    }

    public final int getDeepFryFiltersPagePosition() {
        return 1;
    }

    public final int getEnhanceFiltersPagePosition() {
        return 2;
    }

    public int getItemCount() {
        return 3;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaFilterTabsAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
    }

    public Fragment createFragment(int i) {
        if (i == getBasicFiltersPagePosition()) {
            return new BasicFiltersFragment();
        }
        if (i == getDeepFryFiltersPagePosition()) {
            return new DeepFryFiltersFragment();
        }
        if (i == getEnhanceFiltersPagePosition()) {
            return new MediaEnhanceFragment();
        }
        throw new RuntimeException("Unknown position: " + i);
    }

    public String getPageTitle(int i) {
        if (i == getBasicFiltersPagePosition()) {
            return "Filters";
        }
        if (i == getDeepFryFiltersPagePosition()) {
            return "Deep Fried";
        }
        if (i == getEnhanceFiltersPagePosition()) {
            return "Custom";
        }
        throw new RuntimeException("Unknown position: " + i);
    }
}
