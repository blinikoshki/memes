package com.facebook.fresco.p010ui.common;

import android.net.Uri;
import com.facebook.common.internal.C1296Fn;
import java.util.function.Function;
import javax.annotation.Nullable;

/* renamed from: com.facebook.fresco.ui.common.MultiUriHelper */
public abstract class MultiUriHelper {

    /* renamed from: f */
    Function<Integer, Integer> f142f;

    public static <T> Uri getMainUri(@Nullable T t, @Nullable T t2, @Nullable T[] tArr, C1296Fn<T, Uri> fn) {
        Uri apply;
        Uri apply2;
        if (t != null && (apply2 = fn.apply(t)) != null) {
            return apply2;
        }
        if (tArr != null && tArr.length > 0 && tArr[0] != null && (apply = fn.apply(tArr[0])) != null) {
            return apply;
        }
        if (t2 != null) {
            return fn.apply(t2);
        }
        return null;
    }
}
