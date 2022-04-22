package com.memes.plus.util.validation;

import com.memes.commons.util.RegexUtil;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/util/validation/Validations;", "", "()V", "forEmail", "", "text", "", "forName", "forPassword", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Validations.kt */
public final class Validations {
    public static final Validations INSTANCE = new Validations();

    private Validations() {
    }

    public final int forName(String str) {
        CharSequence charSequence = str;
        return charSequence == null || StringsKt.isBlank(charSequence) ? 1 : 5;
    }

    public final int forEmail(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return 1;
        }
        RegexUtil regexUtil = RegexUtil.INSTANCE;
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.ROOT");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return !regexUtil.matches(lowerCase, RegexUtil.PATTERN_EMAIL) ? 2 : 5;
    }

    public final int forPassword(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return 1;
        }
        return (str.length() < 6 || str.length() > 64) ? 3 : 5;
    }
}
