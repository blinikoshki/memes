package editor.common.nudge;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NNudgeButtonBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0014J)\u0010\u001a\u001a\u00020\u00182!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00180\u001cR\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R#\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, mo26107d2 = {"Leditor/common/nudge/NudgeButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/memes/editor/databinding/NNudgeButtonBinding;", "getBinding", "()Lcom/memes/editor/databinding/NNudgeButtonBinding;", "binding$delegate", "Lkotlin/Lazy;", "direction", "Leditor/common/nudge/NudgeDirection;", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "nudgeEvent", "Leditor/common/nudge/NudgeEvent;", "applyDirection", "", "onFinishInflate", "setOnNudgeButtonClickListener", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "event", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NudgeButton.kt */
public final class NudgeButton extends FrameLayout {
    private final Lazy binding$delegate = LazyKt.lazy(new NudgeButton$binding$2(this));
    /* access modifiers changed from: private */
    public NudgeDirection direction = NudgeDirection.LEFT;
    private final Lazy layoutInflater$delegate;
    /* access modifiers changed from: private */
    public NudgeEvent nudgeEvent = NudgeEvent.IDLE;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NudgeDirection.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[NudgeDirection.UP.ordinal()] = 1;
            iArr[NudgeDirection.DOWN.ordinal()] = 2;
            iArr[NudgeDirection.LEFT.ordinal()] = 3;
            iArr[NudgeDirection.RIGHT.ordinal()] = 4;
        }
    }

    private final NNudgeButtonBinding getBinding() {
        return (NNudgeButtonBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NudgeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.layoutInflater$delegate = LazyKt.lazy(new NudgeButton$layoutInflater$2(context));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4175R.styleable.NudgeButton, 0, 0);
            try {
                this.direction = NudgeDirection.values()[obtainStyledAttributes.getInt(C4175R.styleable.NudgeButton_nb_direction, 0)];
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        getBinding();
        super.onFinishInflate();
        applyDirection();
    }

    private final void applyDirection() {
        float f;
        int i = WhenMappings.$EnumSwitchMapping$0[this.direction.ordinal()];
        if (i == 1) {
            f = 270.0f;
        } else if (i == 2) {
            f = 90.0f;
        } else if (i == 3) {
            f = 180.0f;
        } else if (i == 4) {
            f = 0.0f;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        setRotation(f);
    }

    public final void setOnNudgeButtonClickListener(Function1<? super NudgeEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        setOnClickListener(new NudgeButton$setOnNudgeButtonClickListener$1(this, function1));
    }
}
