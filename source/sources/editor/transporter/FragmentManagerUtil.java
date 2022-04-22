package editor.transporter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.transition.Slide;
import editor.optionsui.media.tabs.MediaTabsFragment;
import editor.optionsui.text.tabs.TextTabsFragment;
import editor.util.ExtKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u001e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\rJ\u0006\u0010\u0016\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\rJ\u0006\u0010\u001a\u001a\u00020\rJ\u0006\u0010\u001b\u001a\u00020\rJ\u0006\u0010\u001c\u001a\u00020\rJ\u0006\u0010\u001d\u001a\u00020\rJ\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, mo26107d2 = {"Leditor/transporter/FragmentManagerUtil;", "", "containerId", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "(ILandroidx/fragment/app/FragmentManager;)V", "currentMediaTabsFragmentTag", "", "currentMediaTabsFragmentToken", "currentTextTabsFragmentTag", "currentTextTabsFragmentToken", "addFragment", "", "tag", "fragmentCreator", "Lkotlin/Function0;", "Landroidx/fragment/app/Fragment;", "findFragmentByTag", "replaceFragment", "showFilterTabsFragment", "showFrameTabsFragment", "showLayoutTabsFragment", "showMediaTabsFragment", "token", "showNudgeFragment", "showSavedWatermarkFragment", "showSingleSliderFragment", "showTextAdjustFragment", "showTextSpacingFragment", "showTextTabsFragment", "showWatermarkFragment", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@Deprecated(message = "More modular approach required")
/* compiled from: FragmentManagerUtil.kt */
public final class FragmentManagerUtil {
    private final int containerId;
    private String currentMediaTabsFragmentTag = "media-tabs";
    private String currentMediaTabsFragmentToken = "";
    private String currentTextTabsFragmentTag = "text-tabs";
    private String currentTextTabsFragmentToken = "";
    private final FragmentManager fragmentManager;

    public FragmentManagerUtil(int i, FragmentManager fragmentManager2) {
        Intrinsics.checkNotNullParameter(fragmentManager2, "fragmentManager");
        this.containerId = i;
        this.fragmentManager = fragmentManager2;
    }

    public final void showTextTabsFragment(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        Fragment findFragmentByTag = findFragmentByTag(this.currentTextTabsFragmentTag);
        if (StringsKt.contains$default((CharSequence) this.currentTextTabsFragmentTag, (CharSequence) this.currentTextTabsFragmentToken, false, 2, (Object) null) && findFragmentByTag != null) {
            return;
        }
        if (findFragmentByTag instanceof TextTabsFragment) {
            this.currentTextTabsFragmentToken = str;
            return;
        }
        ExtKt.clearBackStack(this.fragmentManager);
        this.currentTextTabsFragmentToken = str;
        String str2 = "text-tabs-" + this.currentTextTabsFragmentToken;
        this.currentTextTabsFragmentTag = str2;
        addFragment(str2, FragmentManagerUtil$showTextTabsFragment$1.INSTANCE);
    }

    public final void showMediaTabsFragment(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        Fragment findFragmentByTag = findFragmentByTag(this.currentMediaTabsFragmentTag);
        if (StringsKt.contains$default((CharSequence) this.currentMediaTabsFragmentTag, (CharSequence) this.currentMediaTabsFragmentToken, false, 2, (Object) null) && findFragmentByTag != null) {
            return;
        }
        if (findFragmentByTag instanceof MediaTabsFragment) {
            this.currentMediaTabsFragmentToken = str;
            return;
        }
        ExtKt.clearBackStack(this.fragmentManager);
        this.currentMediaTabsFragmentToken = str;
        String str2 = "media-tabs-" + this.currentMediaTabsFragmentToken;
        this.currentMediaTabsFragmentTag = str2;
        addFragment(str2, FragmentManagerUtil$showMediaTabsFragment$1.INSTANCE);
    }

    public final void showLayoutTabsFragment() {
        ExtKt.clearBackStack(this.fragmentManager);
        addFragment("layout-tabs", FragmentManagerUtil$showLayoutTabsFragment$1.INSTANCE);
    }

    public final void showFrameTabsFragment() {
        ExtKt.clearBackStack(this.fragmentManager);
        addFragment("frame-tabs", FragmentManagerUtil$showFrameTabsFragment$1.INSTANCE);
    }

    public final void showWatermarkFragment() {
        if (findFragmentByTag("watermark") == null) {
            ExtKt.clearBackStack(this.fragmentManager);
            addFragment("watermark", FragmentManagerUtil$showWatermarkFragment$1.INSTANCE);
        }
    }

    public final void showFilterTabsFragment() {
        if (findFragmentByTag("filter-tabs") == null) {
            ExtKt.clearBackStack(this.fragmentManager);
            addFragment("filter-tabs", FragmentManagerUtil$showFilterTabsFragment$1.INSTANCE);
        }
    }

    public final void showNudgeFragment() {
        replaceFragment("nudge-fragment", FragmentManagerUtil$showNudgeFragment$1.INSTANCE);
    }

    public final void showTextSpacingFragment() {
        replaceFragment("text-spacing", FragmentManagerUtil$showTextSpacingFragment$1.INSTANCE);
    }

    public final void showTextAdjustFragment() {
        replaceFragment("text-adjust", FragmentManagerUtil$showTextAdjustFragment$1.INSTANCE);
    }

    public final void showSavedWatermarkFragment() {
        replaceFragment("saved_watermark", FragmentManagerUtil$showSavedWatermarkFragment$1.INSTANCE);
    }

    public final void showSingleSliderFragment() {
        replaceFragment("single-slider", FragmentManagerUtil$showSingleSliderFragment$1.INSTANCE);
    }

    private final Fragment findFragmentByTag(String str) {
        return this.fragmentManager.findFragmentByTag(str);
    }

    private final void addFragment(String str, Function0<? extends Fragment> function0) {
        Fragment fragment = (Fragment) function0.invoke();
        fragment.setEnterTransition(new Slide());
        fragment.setExitTransition(new Slide(48));
        this.fragmentManager.beginTransaction().add(this.containerId, fragment, str).addToBackStack(str).commit();
    }

    private final void replaceFragment(String str, Function0<? extends Fragment> function0) {
        Fragment fragment = (Fragment) function0.invoke();
        fragment.setEnterTransition(new Slide());
        fragment.setExitTransition(new Slide(48));
        this.fragmentManager.beginTransaction().replace(this.containerId, fragment, str).addToBackStack(str).commit();
    }
}
