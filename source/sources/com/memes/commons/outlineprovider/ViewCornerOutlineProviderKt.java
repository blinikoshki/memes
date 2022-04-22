package com.memes.commons.outlineprovider;

import android.content.Context;
import android.view.View;
import com.memes.commons.outlineprovider.ViewCornerOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, mo26107d2 = {"roundCorners", "", "Landroid/view/View;", "radius", "", "cornerType", "Lcom/memes/commons/outlineprovider/ViewCornerOutlineProvider$CornerType;", "dimenRes", "", "commons_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: ViewCornerOutlineProvider.kt */
public final class ViewCornerOutlineProviderKt {
    public static /* synthetic */ void roundCorners$default(View view, int i, ViewCornerOutlineProvider.CornerType cornerType, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            cornerType = ViewCornerOutlineProvider.CornerType.ALL;
        }
        roundCorners(view, i, cornerType);
    }

    public static final void roundCorners(View view, int i, ViewCornerOutlineProvider.CornerType cornerType) {
        Intrinsics.checkNotNullParameter(view, "$this$roundCorners");
        Intrinsics.checkNotNullParameter(cornerType, "cornerType");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        roundCorners(view, context.getResources().getDimension(i), cornerType);
    }

    public static /* synthetic */ void roundCorners$default(View view, float f, ViewCornerOutlineProvider.CornerType cornerType, int i, Object obj) {
        if ((i & 2) != 0) {
            cornerType = ViewCornerOutlineProvider.CornerType.ALL;
        }
        roundCorners(view, f, cornerType);
    }

    public static final void roundCorners(View view, float f, ViewCornerOutlineProvider.CornerType cornerType) {
        Intrinsics.checkNotNullParameter(view, "$this$roundCorners");
        Intrinsics.checkNotNullParameter(cornerType, "cornerType");
        ViewCornerOutlineProvider.INSTANCE.apply(view, f, cornerType);
    }
}
