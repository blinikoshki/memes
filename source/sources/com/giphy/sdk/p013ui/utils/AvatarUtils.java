package com.giphy.sdk.p013ui.utils;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, mo26107d2 = {"Lcom/giphy/sdk/ui/utils/AvatarUtils;", "", "()V", "getDownsizedUrl", "", "url", "size", "Lcom/giphy/sdk/ui/utils/AvatarUtils$Dimension;", "Dimension", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.utils.AvatarUtils */
/* compiled from: AvatarUtils.kt */
public final class AvatarUtils {
    public static final AvatarUtils INSTANCE = new AvatarUtils();

    private AvatarUtils() {
    }

    public final String getDownsizedUrl(String str, Dimension dimension) {
        String str2;
        Intrinsics.checkParameterIsNotNull(dimension, "size");
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        int lastIndexOf$default = StringsKt.lastIndexOf$default(charSequence, ".", 0, false, 6, (Object) null);
        if (lastIndexOf$default < 0) {
            str2 = "";
        } else if (str != null) {
            str2 = str.substring(lastIndexOf$default);
            Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.String).substring(startIndex)");
        } else {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        StringBuilder sb = new StringBuilder();
        if (lastIndexOf$default < 0) {
            lastIndexOf$default = str.length();
        }
        if (str != null) {
            String substring = str.substring(0, lastIndexOf$default);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append("/");
            sb.append(dimension.getSize());
            sb.append(str2);
            return sb.toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, mo26107d2 = {"Lcom/giphy/sdk/ui/utils/AvatarUtils$Dimension;", "", "size", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getSize", "()Ljava/lang/String;", "Small", "Medium", "Big", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.utils.AvatarUtils$Dimension */
    /* compiled from: AvatarUtils.kt */
    public enum Dimension {
        Small("36h"),
        Medium("80h"),
        Big("200h");
        
        private final String size;

        private Dimension(String str) {
            this.size = str;
        }

        public final String getSize() {
            return this.size;
        }
    }
}
