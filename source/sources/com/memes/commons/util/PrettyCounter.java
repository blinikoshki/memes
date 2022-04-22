package com.memes.commons.util;

import editor.editor.equipment.core.CoreConfig;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/commons/util/PrettyCounter;", "", "()V", "apply", "", "number", "", "", "text", "allowNegative", "", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PrettyCounter.kt */
public final class PrettyCounter {
    public static final PrettyCounter INSTANCE = new PrettyCounter();

    private PrettyCounter() {
    }

    public static /* synthetic */ String apply$default(PrettyCounter prettyCounter, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return prettyCounter.apply(str, z);
    }

    public final String apply(String str, boolean z) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return "--";
        }
        boolean startsWith$default = StringsKt.startsWith$default(str, CoreConfig.ENTITY_TOKEN_PREFIX, false, 2, (Object) null);
        if (!z && startsWith$default) {
            return "0";
        }
        Long longOrNull = StringsKt.toLongOrNull(str);
        if (longOrNull != null) {
            return apply(longOrNull.longValue());
        }
        return String.valueOf(longOrNull);
    }

    public final String apply(long j) {
        if (j < ((long) 1000)) {
            return String.valueOf(j);
        }
        char[] cArr = {' ', 'K', 'M', 'B', 'T', 'P', 'E'};
        double d = (double) j;
        int floor = (int) Math.floor(Math.log10(d));
        int i = floor / 3;
        if (floor < 3 || i >= 7) {
            String format = new DecimalFormat("#,##0").format(j);
            Intrinsics.checkNotNullExpressionValue(format, "DecimalFormat(\"#,##0\").format(number)");
            return format;
        }
        return new DecimalFormat("#0.0").format(d / Math.pow(10.0d, ((double) i) * ((double) 3))) + cArr[i];
    }

    public final String apply(int i) {
        return apply((long) i);
    }
}
