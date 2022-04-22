package editor.util;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: Ext.kt */
final class ExtKt$disableTouch$1 implements View.OnTouchListener {
    public static final ExtKt$disableTouch$1 INSTANCE = new ExtKt$disableTouch$1();

    ExtKt$disableTouch$1() {
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }
}
