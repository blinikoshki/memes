package editor.optionsui.text.tabs;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import editor.custom.TabsSheetAdapter;
import editor.optionsui.text.textanimate.TextAnimateFragment;
import editor.optionsui.text.textedit.TextEditFragment;
import editor.optionsui.text.textfont.TextFontsFragment;
import editor.optionsui.text.textorder.TextOrderFragment;
import editor.optionsui.text.textpaint.TextPaintsFragment;
import editor.optionsui.text.textrandomstyle.TextRandomStyleFragment;
import editor.optionsui.text.textsize.TextSizeFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, mo26107d2 = {"Leditor/optionsui/text/tabs/TextTabsAdapter;", "Leditor/custom/TabsSheetAdapter;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/Lifecycle;)V", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "getPageTitle", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextTabsAdapter.kt */
public final class TextTabsAdapter extends TabsSheetAdapter {
    public int getItemCount() {
        return 4;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextTabsAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
    }

    public Fragment createFragment(int i) {
        switch (i) {
            case 0:
                return new TextEditFragment();
            case 1:
                return new TextSizeFragment();
            case 2:
                return new TextFontsFragment();
            case 3:
                return new TextPaintsFragment();
            case 4:
                return new TextAnimateFragment();
            case 5:
                return new TextOrderFragment();
            case 6:
                return new TextRandomStyleFragment();
            default:
                throw new RuntimeException("Unknown position: " + i);
        }
    }

    public String getPageTitle(int i) {
        switch (i) {
            case 0:
                return "Edit";
            case 1:
                return "Size";
            case 2:
                return "Font";
            case 3:
                return "Color";
            case 4:
                return "Animate";
            case 5:
                return "Order";
            case 6:
                return "Style";
            default:
                throw new RuntimeException("Unknown position: " + i);
        }
    }
}
