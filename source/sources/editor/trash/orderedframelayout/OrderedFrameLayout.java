package editor.trash.orderedframelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0014J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Leditor/trash/orderedframelayout/OrderedFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "currentOrder", "", "getChildDrawingOrder", "childCount", "i", "setDrawOrder", "", "order", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: OrderedFrameLayout.kt */
public final class OrderedFrameLayout extends FrameLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int[][] DRAW_ORDERS = {new int[]{0, 1, 2}, new int[]{2, 1, 0}};
    /* access modifiers changed from: private */
    public static int ORDER_LOGIN_STATE = 1;
    /* access modifiers changed from: private */
    public static int ORDER_SIGN_UP_STATE;
    private int currentOrder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderedFrameLayout(Context context, AttributeSet attributeSet) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setChildrenDrawingOrderEnabled(true);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0010"}, mo26107d2 = {"Leditor/trash/orderedframelayout/OrderedFrameLayout$Companion;", "", "()V", "DRAW_ORDERS", "", "", "[[I", "ORDER_LOGIN_STATE", "", "getORDER_LOGIN_STATE", "()I", "setORDER_LOGIN_STATE", "(I)V", "ORDER_SIGN_UP_STATE", "getORDER_SIGN_UP_STATE", "setORDER_SIGN_UP_STATE", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: OrderedFrameLayout.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getORDER_SIGN_UP_STATE() {
            return OrderedFrameLayout.ORDER_SIGN_UP_STATE;
        }

        public final void setORDER_SIGN_UP_STATE(int i) {
            OrderedFrameLayout.ORDER_SIGN_UP_STATE = i;
        }

        public final int getORDER_LOGIN_STATE() {
            return OrderedFrameLayout.ORDER_LOGIN_STATE;
        }

        public final void setORDER_LOGIN_STATE(int i) {
            OrderedFrameLayout.ORDER_LOGIN_STATE = i;
        }
    }

    public final void setDrawOrder(int i) {
        this.currentOrder = i;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        return DRAW_ORDERS[this.currentOrder][i2];
    }
}
