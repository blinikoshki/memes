package editor.common.nudge;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: NudgeButton.kt */
final class NudgeButton$setOnNudgeButtonClickListener$1 implements View.OnClickListener {
    final /* synthetic */ Function1 $listener;
    final /* synthetic */ NudgeButton this$0;

    NudgeButton$setOnNudgeButtonClickListener$1(NudgeButton nudgeButton, Function1 function1) {
        this.this$0 = nudgeButton;
        this.$listener = function1;
    }

    public final void onClick(View view) {
        NudgeEvent nudgeEvent;
        NudgeButton nudgeButton = this.this$0;
        if (nudgeButton.nudgeEvent == NudgeEvent.SESSION_BEGIN) {
            nudgeEvent = NudgeEvent.SESSION_END.setDirection(this.this$0.direction);
        } else {
            nudgeEvent = NudgeEvent.SINGLE_PUSH.setDirection(this.this$0.direction);
        }
        nudgeButton.nudgeEvent = nudgeEvent;
        this.$listener.invoke(this.this$0.nudgeEvent);
    }
}
