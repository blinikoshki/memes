package com.memes.plus.util;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/util/SimpleTimestampObfuscator;", "", "()V", "decode", "", "timestampStr", "", "encode", "timestamp", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SimpleTimestampObfuscator.kt */
public final class SimpleTimestampObfuscator {
    public static final SimpleTimestampObfuscator INSTANCE = new SimpleTimestampObfuscator();

    private SimpleTimestampObfuscator() {
    }

    public final String encode(long j) {
        if (j >= 0) {
            String valueOf = String.valueOf(j);
            Objects.requireNonNull(valueOf, "null cannot be cast to non-null type java.lang.String");
            char[] charArray = valueOf.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "(this as java.lang.String).toCharArray()");
            StringBuilder sb = new StringBuilder();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                int numericValue = Character.getNumericValue(charArray[i]) + (i % 2 == 0 ? 1 : -1);
                if (numericValue > 9) {
                    numericValue = 0;
                } else if (numericValue < 0) {
                    numericValue = 9;
                }
                sb.append(numericValue);
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "encodedTimestampBuilder.toString()");
            return sb2;
        }
        throw new NumberFormatException("Timestamp, to be encoded, can't be negative.");
    }

    public final long decode(String str) {
        Intrinsics.checkNotNullParameter(str, "timestampStr");
        char[] charArray = str.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "(this as java.lang.String).toCharArray()");
        StringBuilder sb = new StringBuilder();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            int numericValue = Character.getNumericValue(charArray[i]) + (i % 2 == 0 ? -1 : 1);
            if (numericValue > 9) {
                numericValue = 0;
            } else if (numericValue < 0) {
                numericValue = 9;
            }
            sb.append(numericValue);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "decodedTimestampBuilder.toString()");
        return Long.parseLong(sb2);
    }
}
