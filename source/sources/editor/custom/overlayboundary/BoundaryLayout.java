package editor.custom.overlayboundary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.editor.databinding.NBoundaryLayoutBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u0000 $*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004:\u0001$B\u0019\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0018\u001a\u00020\u0019J\"\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0015H\u0002J\u0015\u0010!\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\u0019R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR \u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0000@BX.¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, mo26107d2 = {"Leditor/custom/overlayboundary/BoundaryLayout;", "V", "Landroid/view/View;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Leditor/custom/overlayboundary/BoundaryCornerMovementListener;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/memes/editor/databinding/NBoundaryLayoutBinding;", "getBinding", "()Lcom/memes/editor/databinding/NBoundaryLayoutBinding;", "binding$delegate", "Lkotlin/Lazy;", "<set-?>", "content", "getContent", "()Landroid/view/View;", "Landroid/view/View;", "", "isBoundaryShown", "()Z", "hideBoundary", "", "onCornerMoved", "cornerView", "movedX", "", "movedY", "setBoundaryVisibility", "isVisible", "setContent", "(Landroid/view/View;)V", "showBoundary", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BoundaryLayout.kt */
public final class BoundaryLayout<V extends View> extends ConstraintLayout implements BoundaryCornerMovementListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy binding$delegate;
    private V content;
    private boolean isBoundaryShown;

    private final NBoundaryLayoutBinding getBinding() {
        return (NBoundaryLayoutBinding) this.binding$delegate.getValue();
    }

    public /* synthetic */ BoundaryLayout(Context context, AttributeSet attributeSet, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet);
    }

    private BoundaryLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.binding$delegate = LazyKt.lazy(new BoundaryLayout$binding$2(this, context));
        this.isBoundaryShown = true;
        BoundaryCornerMovementListener boundaryCornerMovementListener = this;
        getBinding().topLeftCorner.setMovementListener(boundaryCornerMovementListener);
        getBinding().topRightCorner.setMovementListener(boundaryCornerMovementListener);
        getBinding().bottomLeftCorner.setMovementListener(boundaryCornerMovementListener);
        getBinding().bottomRightCorner.setMovementListener(boundaryCornerMovementListener);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u0005¢\u0006\u0002\u0010\n¨\u0006\u000b"}, mo26107d2 = {"Leditor/custom/overlayboundary/BoundaryLayout$Companion;", "", "()V", "create", "Leditor/custom/overlayboundary/BoundaryLayout;", "V", "Landroid/view/View;", "context", "Landroid/content/Context;", "content", "(Landroid/content/Context;Landroid/view/View;)Leditor/custom/overlayboundary/BoundaryLayout;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: BoundaryLayout.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <V extends View> BoundaryLayout<V> create(Context context, V v) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(v, "content");
            BoundaryLayout<V> boundaryLayout = new BoundaryLayout<>(context, (AttributeSet) null, (DefaultConstructorMarker) null);
            boundaryLayout.setContent(v);
            boundaryLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
            return boundaryLayout;
        }
    }

    public final V getContent() {
        V v = this.content;
        if (v == null) {
            Intrinsics.throwUninitializedPropertyAccessException("content");
        }
        return v;
    }

    public final boolean isBoundaryShown() {
        return this.isBoundaryShown;
    }

    /* access modifiers changed from: private */
    public final void setContent(V v) {
        getBinding().container.removeAllViews();
        getBinding().container.addView(v);
        this.content = v;
    }

    public final void showBoundary() {
        setBoundaryVisibility(true);
    }

    public final void hideBoundary() {
        setBoundaryVisibility(false);
    }

    private final void setBoundaryVisibility(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            FrameLayout frameLayout = getBinding().container;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.container");
            int id = frameLayout.getId();
            Intrinsics.checkNotNullExpressionValue(childAt, ViewHierarchyConstants.VIEW_KEY);
            if (id != childAt.getId()) {
                childAt.setVisibility(z ? 0 : 4);
            }
        }
        this.isBoundaryShown = z;
    }

    public void onCornerMoved(View view, int i, int i2) {
        Timber.m300d("--> onCornerMoved(" + i + ", " + i2 + ") layout(w=" + getWidth() + ", h=" + getHeight() + ')', new Object[0]);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        BoundaryCornerView boundaryCornerView = getBinding().topLeftCorner;
        Intrinsics.checkNotNullExpressionValue(boundaryCornerView, "binding.topLeftCorner");
        int id = boundaryCornerView.getId();
        if (valueOf == null || valueOf.intValue() != id) {
            BoundaryCornerView boundaryCornerView2 = getBinding().bottomRightCorner;
            Intrinsics.checkNotNullExpressionValue(boundaryCornerView2, "binding.bottomRightCorner");
            int id2 = boundaryCornerView2.getId();
            if (valueOf != null) {
                int intValue = valueOf.intValue();
            }
        }
    }
}
