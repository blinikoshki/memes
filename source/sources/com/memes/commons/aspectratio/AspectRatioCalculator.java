package com.memes.commons.aspectratio;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\b¨\u0006\t"}, mo26107d2 = {"Lcom/memes/commons/aspectratio/AspectRatioCalculator;", "", "()V", "calculate", "", "width", "", "height", "(Ljava/lang/Integer;Ljava/lang/Integer;)F", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AspectRatioCalculator.kt */
public final class AspectRatioCalculator {
    public static final AspectRatioCalculator INSTANCE = new AspectRatioCalculator();

    private AspectRatioCalculator() {
    }

    public static /* synthetic */ float calculate$default(AspectRatioCalculator aspectRatioCalculator, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = 200;
        }
        if ((i & 2) != 0) {
            num2 = 200;
        }
        return aspectRatioCalculator.calculate(num, num2);
    }

    public final float calculate(Integer num, Integer num2) {
        int i = 200;
        int intValue = (num == null || num.intValue() == 0) ? 200 : num.intValue();
        if (!(num2 == null || num2.intValue() == 0)) {
            i = num2.intValue();
        }
        return ((float) intValue) / ((float) i);
    }
}
