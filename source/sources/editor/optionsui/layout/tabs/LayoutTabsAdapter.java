package editor.optionsui.layout.tabs;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import editor.custom.TabsSheetAdapter;
import editor.optionsui.layout.background.LayoutBackgroundTabsFragment;
import editor.optionsui.layout.templates.TemplatesFragment;
import editor.optionsui.layout.wireframes.WireframesFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, mo26107d2 = {"Leditor/optionsui/layout/tabs/LayoutTabsAdapter;", "Leditor/custom/TabsSheetAdapter;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/Lifecycle;)V", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "getPageTitle", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: LayoutTabsAdapter.kt */
public final class LayoutTabsAdapter extends TabsSheetAdapter {
    public int getItemCount() {
        return 2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutTabsAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
    }

    public Fragment createFragment(int i) {
        if (i == 0) {
            return new WireframesFragment();
        }
        if (i == 1) {
            return new LayoutBackgroundTabsFragment();
        }
        if (i == 2) {
            return new TemplatesFragment();
        }
        throw new RuntimeException("Unknown position: " + i);
    }

    public String getPageTitle(int i) {
        if (i == 0) {
            return "Layout";
        }
        if (i == 1) {
            return "Background";
        }
        if (i == 2) {
            return "Templates";
        }
        throw new RuntimeException("Unknown position: " + i);
    }
}
