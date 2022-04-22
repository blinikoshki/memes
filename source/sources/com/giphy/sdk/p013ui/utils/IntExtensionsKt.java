package com.giphy.sdk.p013ui.utils;

import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, mo26107d2 = {"dp", "", "getDp", "(I)I", "px", "getPx", "ui-sdk_release"}, mo26108k = 2, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.utils.IntExtensionsKt */
/* compiled from: IntExtensions.kt */
public final class IntExtensionsKt {
    public static final int getDp(int i) {
        Resources system = Resources.getSystem();
        Intrinsics.checkExpressionValueIsNotNull(system, "Resources.getSystem()");
        return (int) (((float) i) / system.getDisplayMetrics().density);
    }

    public static final int getPx(int i) {
        Resources system = Resources.getSystem();
        Intrinsics.checkExpressionValueIsNotNull(system, "Resources.getSystem()");
        return (int) (((float) i) * system.getDisplayMetrics().density);
    }
}
