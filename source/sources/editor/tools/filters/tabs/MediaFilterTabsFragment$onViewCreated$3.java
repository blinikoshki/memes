package editor.tools.filters.tabs;

import androidx.lifecycle.Observer;
import editor.tools.filters.conflation.FilterRequest;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "filterTab", "Leditor/tools/filters/conflation/FilterRequest$FilterTab;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaFilterTabsFragment.kt */
final class MediaFilterTabsFragment$onViewCreated$3<T> implements Observer<FilterRequest.FilterTab> {
    final /* synthetic */ MediaFilterTabsAdapter $adapter;
    final /* synthetic */ MediaFilterTabsFragment this$0;

    MediaFilterTabsFragment$onViewCreated$3(MediaFilterTabsFragment mediaFilterTabsFragment, MediaFilterTabsAdapter mediaFilterTabsAdapter) {
        this.this$0 = mediaFilterTabsFragment;
        this.$adapter = mediaFilterTabsAdapter;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(editor.tools.filters.conflation.FilterRequest.FilterTab r2) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x0003
            goto L_0x0014
        L_0x0003:
            int[] r0 = editor.tools.filters.tabs.MediaFilterTabsFragment.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            if (r2 == r0) goto L_0x0029
            r0 = 2
            if (r2 == r0) goto L_0x0022
            r0 = 3
            if (r2 == r0) goto L_0x001b
        L_0x0014:
            editor.tools.filters.tabs.MediaFilterTabsAdapter r2 = r1.$adapter
            int r2 = r2.getEnhanceFiltersPagePosition()
            goto L_0x002f
        L_0x001b:
            editor.tools.filters.tabs.MediaFilterTabsAdapter r2 = r1.$adapter
            int r2 = r2.getDeepFryFiltersPagePosition()
            goto L_0x002f
        L_0x0022:
            editor.tools.filters.tabs.MediaFilterTabsAdapter r2 = r1.$adapter
            int r2 = r2.getBasicFiltersPagePosition()
            goto L_0x002f
        L_0x0029:
            editor.tools.filters.tabs.MediaFilterTabsAdapter r2 = r1.$adapter
            int r2 = r2.getEnhanceFiltersPagePosition()
        L_0x002f:
            editor.tools.filters.tabs.MediaFilterTabsFragment r0 = r1.this$0
            com.memes.editor.databinding.NMediaFiltersTabFragmentBinding r0 = editor.tools.filters.tabs.MediaFilterTabsFragment.access$getBinding$p(r0)
            com.google.android.material.tabs.TabLayout r0 = r0.tabLayout
            com.google.android.material.tabs.TabLayout$Tab r2 = r0.getTabAt(r2)
            if (r2 == 0) goto L_0x004d
            java.lang.String r0 = "binding.tabLayout.getTab…sition) ?: return@observe"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            editor.tools.filters.tabs.MediaFilterTabsFragment r0 = r1.this$0
            com.memes.editor.databinding.NMediaFiltersTabFragmentBinding r0 = editor.tools.filters.tabs.MediaFilterTabsFragment.access$getBinding$p(r0)
            com.google.android.material.tabs.TabLayout r0 = r0.tabLayout
            r0.selectTab(r2)
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.tools.filters.tabs.MediaFilterTabsFragment$onViewCreated$3.onChanged(editor.tools.filters.conflation.FilterRequest$FilterTab):void");
    }
}
