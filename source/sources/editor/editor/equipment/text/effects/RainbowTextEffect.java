package editor.editor.equipment.text.effects;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo26107d2 = {"Leditor/editor/equipment/text/effects/RainbowTextEffect;", "Leditor/editor/equipment/text/effects/MultiColorTextEffect;", "textView", "Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RainbowTextEffect.kt */
public final class RainbowTextEffect extends MultiColorTextEffect {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RainbowTextEffect(TextView textView) {
        super(textView);
        Intrinsics.checkNotNullParameter(textView, "textView");
        setColors(-54494, -32990, -1179870, -14483678, -14486273, -14534145, -11271945);
    }
}
