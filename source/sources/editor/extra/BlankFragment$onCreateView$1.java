package editor.extra;

import android.view.View;
import editor.util.ExtKt;
import kotlin.Metadata;
import kotlin.random.Random;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: BlankFragment.kt */
final class BlankFragment$onCreateView$1 implements View.OnClickListener {
    final /* synthetic */ BlankFragment this$0;

    BlankFragment$onCreateView$1(BlankFragment blankFragment) {
        this.this$0 = blankFragment;
    }

    public final void onClick(View view) {
        BlankFragment.access$getBinding$p(this.this$0).getRoot().setBackgroundColor(ExtKt.nextColor(Random.Default));
    }
}
