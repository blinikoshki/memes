package com.memes.commons.outlineprovider;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/commons/outlineprovider/ViewCornerOutlineProvider;", "", "()V", "apply", "", "targetView", "Landroid/view/View;", "radius", "", "cornerType", "Lcom/memes/commons/outlineprovider/ViewCornerOutlineProvider$CornerType;", "createOutlineProvider", "Landroid/view/ViewOutlineProvider;", "setCircleCorners", "view", "outline", "Landroid/graphics/Outline;", "CornerType", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ViewCornerOutlineProvider.kt */
public final class ViewCornerOutlineProvider {
    public static final ViewCornerOutlineProvider INSTANCE = new ViewCornerOutlineProvider();

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, mo26107d2 = {"Lcom/memes/commons/outlineprovider/ViewCornerOutlineProvider$CornerType;", "", "(Ljava/lang/String;I)V", "ALL", "LEFT", "RIGHT", "TOP", "TOP_LEFT", "TOP_RIGHT", "BOTTOM", "BOTTOM_LEFT", "BOTTOM_RIGHT", "CIRCLE", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ViewCornerOutlineProvider.kt */
    public enum CornerType {
        ALL,
        LEFT,
        RIGHT,
        TOP,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        CIRCLE
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CornerType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[CornerType.ALL.ordinal()] = 1;
            iArr[CornerType.LEFT.ordinal()] = 2;
            iArr[CornerType.RIGHT.ordinal()] = 3;
            iArr[CornerType.TOP.ordinal()] = 4;
            iArr[CornerType.TOP_LEFT.ordinal()] = 5;
            iArr[CornerType.TOP_RIGHT.ordinal()] = 6;
            iArr[CornerType.BOTTOM.ordinal()] = 7;
            iArr[CornerType.BOTTOM_LEFT.ordinal()] = 8;
            iArr[CornerType.BOTTOM_RIGHT.ordinal()] = 9;
            iArr[CornerType.CIRCLE.ordinal()] = 10;
        }
    }

    private ViewCornerOutlineProvider() {
    }

    public static /* synthetic */ void apply$default(ViewCornerOutlineProvider viewCornerOutlineProvider, View view, float f, CornerType cornerType, int i, Object obj) {
        if ((i & 4) != 0) {
            cornerType = CornerType.ALL;
        }
        viewCornerOutlineProvider.apply(view, f, cornerType);
    }

    public final void apply(View view, float f, CornerType cornerType) {
        Intrinsics.checkNotNullParameter(view, "targetView");
        Intrinsics.checkNotNullParameter(cornerType, "cornerType");
        view.setOutlineProvider(createOutlineProvider(f, cornerType));
        view.setClipToOutline(true);
    }

    private final ViewOutlineProvider createOutlineProvider(float f, CornerType cornerType) {
        return new ViewCornerOutlineProvider$createOutlineProvider$1(f, cornerType);
    }

    /* access modifiers changed from: private */
    public final void setCircleCorners(View view, Outline outline) {
        int i;
        int i2;
        int i3 = 0;
        if (view.getWidth() >= view.getHeight()) {
            i2 = view.getHeight();
            i3 = (view.getWidth() - i2) / 2;
            i = 0;
        } else {
            i2 = view.getWidth();
            i = (view.getHeight() - i2) / 2;
        }
        outline.setRoundRect(i3, i, i3 + i2, i + i2, (float) i2);
    }
}
