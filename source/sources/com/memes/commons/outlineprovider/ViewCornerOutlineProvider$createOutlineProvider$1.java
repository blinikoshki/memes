package com.memes.commons.outlineprovider;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.commons.outlineprovider.ViewCornerOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo26107d2 = {"com/memes/commons/outlineprovider/ViewCornerOutlineProvider$createOutlineProvider$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ViewCornerOutlineProvider.kt */
public final class ViewCornerOutlineProvider$createOutlineProvider$1 extends ViewOutlineProvider {
    final /* synthetic */ ViewCornerOutlineProvider.CornerType $cornerType;
    final /* synthetic */ float $radius;

    ViewCornerOutlineProvider$createOutlineProvider$1(float f, ViewCornerOutlineProvider.CornerType cornerType) {
        this.$radius = f;
        this.$cornerType = cornerType;
    }

    public void getOutline(View view, Outline outline) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(outline, "outline");
        int width = view.getWidth();
        int height = view.getHeight();
        int roundToInt = MathKt.roundToInt(this.$radius);
        switch (ViewCornerOutlineProvider.WhenMappings.$EnumSwitchMapping$0[this.$cornerType.ordinal()]) {
            case 1:
                outline.setRoundRect(0, 0, width, height, this.$radius);
                return;
            case 2:
                outline.setRoundRect(0, 0, width + roundToInt, height, this.$radius);
                return;
            case 3:
                outline.setRoundRect(0 - roundToInt, 0, width, height, this.$radius);
                return;
            case 4:
                outline.setRoundRect(0, 0, width, height + roundToInt, this.$radius);
                return;
            case 5:
                outline.setRoundRect(0, 0, width + roundToInt, height + roundToInt, this.$radius);
                return;
            case 6:
                outline.setRoundRect(0 - roundToInt, 0, width, height + roundToInt, this.$radius);
                return;
            case 7:
                outline.setRoundRect(0, 0 - roundToInt, width, height, this.$radius);
                return;
            case 8:
                outline.setRoundRect(0, 0 - roundToInt, width + roundToInt, height, this.$radius);
                return;
            case 9:
                int i = 0 - roundToInt;
                outline.setRoundRect(i, i, width, height, this.$radius);
                return;
            case 10:
                ViewCornerOutlineProvider.INSTANCE.setCircleCorners(view, outline);
                return;
            default:
                return;
        }
    }
}
