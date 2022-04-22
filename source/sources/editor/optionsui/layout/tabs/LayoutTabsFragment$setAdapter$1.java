package editor.optionsui.layout.tabs;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import editor.custom.TabsSheetAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "position", "", "onConfigureTab"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: LayoutTabsFragment.kt */
final class LayoutTabsFragment$setAdapter$1 implements TabLayoutMediator.TabConfigurationStrategy {
    final /* synthetic */ TabsSheetAdapter $adapter;

    LayoutTabsFragment$setAdapter$1(TabsSheetAdapter tabsSheetAdapter) {
        this.$adapter = tabsSheetAdapter;
    }

    public final void onConfigureTab(TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        tab.setText((CharSequence) this.$adapter.getPageTitle(i));
    }
}
