package editor.tools.wftransformer;

import android.graphics.Rect;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import wireframe.language.elements.WfElement;
import wireframe.language.properties.WfDimension;
import wireframe.language.properties.WfGravity;
import wireframe.language.properties.WfMargin;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, mo26107d2 = {"Leditor/tools/wftransformer/WfTransformerUtil;", "", "()V", "createStackedElementRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "element", "Lwireframe/language/elements/WfElement;", "parentRect", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WfTransformerUtil.kt */
public final class WfTransformerUtil {
    public static final WfTransformerUtil INSTANCE = new WfTransformerUtil();

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WfGravity.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[WfGravity.LEFT.ordinal()] = 1;
            iArr[WfGravity.TOP.ordinal()] = 2;
            iArr[WfGravity.CENTER.ordinal()] = 3;
            iArr[WfGravity.RIGHT.ordinal()] = 4;
            iArr[WfGravity.BOTTOM.ordinal()] = 5;
        }
    }

    private WfTransformerUtil() {
    }

    public final Rect createStackedElementRect(View view, WfElement wfElement, Rect rect) {
        int i;
        int i2;
        Rect rect2;
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(wfElement, "element");
        Intrinsics.checkNotNullParameter(rect, "parentRect");
        WfDimension width = wfElement.getWidth();
        if (width instanceof WfDimension.MatchParent) {
            i = rect.width();
        } else if (width instanceof WfDimension.WrapContent) {
            view.measure(-2, -2);
            i = view.getMeasuredWidth();
        } else if (width instanceof WfDimension.Percentage) {
            i = (rect.width() * ((WfDimension.Percentage) width).getPercentage()) / 100;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        WfDimension height = wfElement.getHeight();
        if (height instanceof WfDimension.MatchParent) {
            i2 = rect.height();
        } else if (height instanceof WfDimension.WrapContent) {
            view.measure(-2, -2);
            i2 = view.getMeasuredHeight();
        } else if (height instanceof WfDimension.Percentage) {
            i2 = (rect.height() * ((WfDimension.Percentage) height).getPercentage()) / 100;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[wfElement.getGravityInParent().ordinal()];
        if (i3 == 1) {
            rect2 = new Rect(rect.left, rect.top, rect.left + i, rect.top + i2);
        } else if (i3 == 2) {
            rect2 = new Rect(rect.left, rect.top, rect.left + i, rect.top + i2);
        } else if (i3 == 3) {
            rect2 = new Rect(rect.left + ((rect.width() / 2) - (i / 2)), rect.top + ((rect.height() / 2) - (i2 / 2)), rect.left + i, rect.top + i2);
        } else if (i3 == 4) {
            rect2 = new Rect(rect.right - i, rect.top, rect.right, rect.top + i2);
        } else if (i3 != 5) {
            rect2 = new Rect(rect.left, rect.top, rect.left + i, rect.top + i2);
        } else {
            rect2 = new Rect(rect.left, rect.bottom - i2, rect.left + i, rect.bottom);
        }
        WfMargin margin = wfElement.getMargin();
        rect2.set(rect2.left + margin.getLeft(), rect2.top + margin.getTop(), rect2.right - margin.getRight(), rect2.bottom - margin.getBottom());
        return rect2;
    }
}
