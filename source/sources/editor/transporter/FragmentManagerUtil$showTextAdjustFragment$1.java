package editor.transporter;

import androidx.fragment.app.Fragment;
import editor.optionsui.text.textadjust.TextAdjustFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Landroidx/fragment/app/Fragment;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: FragmentManagerUtil.kt */
final class FragmentManagerUtil$showTextAdjustFragment$1 extends Lambda implements Function0<Fragment> {
    public static final FragmentManagerUtil$showTextAdjustFragment$1 INSTANCE = new FragmentManagerUtil$showTextAdjustFragment$1();

    FragmentManagerUtil$showTextAdjustFragment$1() {
        super(0);
    }

    public final Fragment invoke() {
        return new TextAdjustFragment();
    }
}
