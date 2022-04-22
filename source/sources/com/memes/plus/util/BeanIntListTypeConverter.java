package com.memes.plus.util;

import com.google.gson.Gson;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J \u0010\b\u001a\n \t*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/util/BeanIntListTypeConverter;", "", "()V", "jsonToList", "", "", "value", "", "listToJson", "kotlin.jvm.PlatformType", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BeanIntListTypeConverter.kt */
public final class BeanIntListTypeConverter {
    public final String listToJson(List<Integer> list) {
        return new Gson().toJson((Object) list);
    }

    public final List<Integer> jsonToList(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        Object fromJson = new Gson().fromJson(str, Integer[].class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(value, Array<Int>::class.java)");
        return ArraysKt.toList((T[]) (Object[]) fromJson);
    }
}
