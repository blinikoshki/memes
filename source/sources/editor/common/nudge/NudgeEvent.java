package editor.common.nudge;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.models.QuerySort;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, mo26107d2 = {"Leditor/common/nudge/NudgeEvent;", "", "(Ljava/lang/String;I)V", "direction", "Leditor/common/nudge/NudgeDirection;", "setDirection", "SESSION_BEGIN", "SESSION_END", "SINGLE_PUSH", "IDLE", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NudgeEvent.kt */
public enum NudgeEvent {
    SESSION_BEGIN,
    SESSION_END,
    SINGLE_PUSH,
    IDLE;
    
    private NudgeDirection direction;

    public final NudgeDirection direction() {
        NudgeDirection nudgeDirection = this.direction;
        if (nudgeDirection == null) {
            Intrinsics.throwUninitializedPropertyAccessException(QuerySort.KEY_DIRECTION);
        }
        return nudgeDirection;
    }

    public final NudgeEvent setDirection(NudgeDirection nudgeDirection) {
        Intrinsics.checkNotNullParameter(nudgeDirection, QuerySort.KEY_DIRECTION);
        this.direction = nudgeDirection;
        return this;
    }
}
