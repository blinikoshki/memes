package com.memes.plus.custom;

import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: HeightWrappingViewPager.kt */
final class HeightWrappingViewPager$findViewByPosition$childPosition$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ ViewPager.LayoutParams $childLayoutParams;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HeightWrappingViewPager$findViewByPosition$childPosition$2(ViewPager.LayoutParams layoutParams) {
        super(0);
        this.$childLayoutParams = layoutParams;
    }

    public final int invoke() {
        Field declaredField = this.$childLayoutParams.getClass().getDeclaredField("position");
        Intrinsics.checkNotNullExpressionValue(declaredField, "childLayoutParams.javaCl…DeclaredField(\"position\")");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(this.$childLayoutParams);
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) obj).intValue();
    }
}
