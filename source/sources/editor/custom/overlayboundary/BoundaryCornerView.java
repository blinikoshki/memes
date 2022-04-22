package editor.custom.overlayboundary;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.memes.editor.C4175R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0014J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Leditor/custom/overlayboundary/BoundaryCornerView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "movementListener", "Leditor/custom/overlayboundary/BoundaryCornerMovementListener;", "touchAnimationEnabled", "", "onFinishInflate", "", "setMovementListener", "listener", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BoundaryCornerView.kt */
public final class BoundaryCornerView extends AppCompatImageView {
    /* access modifiers changed from: private */
    public BoundaryCornerMovementListener movementListener;
    private boolean touchAnimationEnabled = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BoundaryCornerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C4175R.styleable.BoundaryCornerView, 0, 0);
            try {
                this.touchAnimationEnabled = obtainStyledAttributes.getBoolean(C4175R.styleable.BoundaryCornerView_touch_animation_enabled, this.touchAnimationEnabled);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        setOnTouchListener(new BoundaryCornerTouchListener(getPaddingTop(), this.touchAnimationEnabled, new BoundaryCornerView$onFinishInflate$cornerTouchListener$1(this)));
    }

    public final void setMovementListener(BoundaryCornerMovementListener boundaryCornerMovementListener) {
        Intrinsics.checkNotNullParameter(boundaryCornerMovementListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.movementListener = boundaryCornerMovementListener;
    }
}
