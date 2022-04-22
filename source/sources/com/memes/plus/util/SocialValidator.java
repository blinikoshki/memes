package com.memes.plus.util;

import android.util.Log;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0004J\u0016\u0010 \u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0004J\u001a\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00102\b\b\u0002\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR\u001a\u0010\u0019\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014¨\u0006&"}, mo26107d2 = {"Lcom/memes/plus/util/SocialValidator;", "", "()V", "HIDE_SUGGESTIONS", "", "SHOW_HASH_TAGS", "SHOW_MENTION", "currentState", "getCurrentState", "()I", "setCurrentState", "(I)V", "endIndex", "getEndIndex", "setEndIndex", "matchedQuery", "", "getMatchedQuery", "()Ljava/lang/String;", "setMatchedQuery", "(Ljava/lang/String;)V", "pattern", "startIndex", "getStartIndex", "setStartIndex", "textTobeReplaced", "getTextTobeReplaced", "setTextTobeReplaced", "checkForSuggestions", "", "text", "markerPos", "getActiveWordFromText", "setMatchedString", "targetText", "endPositon", "setQueryWord", "wordWithSpecialChar", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SocialValidator.kt */
public final class SocialValidator {
    public static final int HIDE_SUGGESTIONS = 3;
    public static final SocialValidator INSTANCE = new SocialValidator();
    public static final int SHOW_HASH_TAGS = 2;
    public static final int SHOW_MENTION = 1;
    private static int currentState = 3;
    private static int endIndex = -1;
    private static String matchedQuery = "";
    private static final String pattern = "((^@|^#|\\s@|\\s#)([A-Za-z0-9]+))";
    private static int startIndex = -1;
    private static String textTobeReplaced = "";

    private SocialValidator() {
    }

    public final int getCurrentState() {
        return currentState;
    }

    public final void setCurrentState(int i) {
        currentState = i;
    }

    public final String getMatchedQuery() {
        return matchedQuery;
    }

    public final void setMatchedQuery(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        matchedQuery = str;
    }

    public final String getTextTobeReplaced() {
        return textTobeReplaced;
    }

    public final void setTextTobeReplaced(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        textTobeReplaced = str;
    }

    public final int getStartIndex() {
        return startIndex;
    }

    public final void setStartIndex(int i) {
        startIndex = i;
    }

    public final int getEndIndex() {
        return endIndex;
    }

    public final void setEndIndex(int i) {
        endIndex = i;
    }

    public final void checkForSuggestions(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "text");
        CharSequence charSequence = str;
        if (!StringsKt.contains$default(charSequence, (CharSequence) "@", false, 2, (Object) null) && !StringsKt.contains$default(charSequence, (CharSequence) "#", false, 2, (Object) null)) {
            return;
        }
        if (StringsKt.contains$default(charSequence, (CharSequence) StringUtils.SPACE, false, 2, (Object) null)) {
            Log.e("activeWord :", getActiveWordFromText(str, i));
        } else {
            getActiveWordFromText(str, i);
        }
    }

    public final String getActiveWordFromText(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "text");
        String substring = str.substring(0, i);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) StringUtils.SPACE, false, 2, (Object) null)) {
            int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) substring, StringUtils.SPACE, 0, false, 6, (Object) null) + 1;
            startIndex = lastIndexOf$default;
            endIndex = i;
            Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
            String substring2 = substring.substring(lastIndexOf$default, i);
            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            setQueryWord(substring2);
        } else {
            startIndex = 0;
            endIndex = str.length();
            setQueryWord(str);
        }
        String str2 = matchedQuery;
        Objects.requireNonNull(str2, "null cannot be cast to non-null type kotlin.CharSequence");
        return StringsKt.trim((CharSequence) str2).toString();
    }

    private final void setQueryWord(String str) {
        CharSequence charSequence = str;
        if (!Pattern.matches(pattern, charSequence)) {
            currentState = 3;
            matchedQuery = "";
        } else if (StringsKt.contains$default(charSequence, (CharSequence) "@", false, 2, (Object) null)) {
            textTobeReplaced = str;
            matchedQuery = StringsKt.replace$default(str, "@", "", false, 4, (Object) null);
            currentState = 1;
        } else if (StringsKt.contains$default(charSequence, (CharSequence) "#", false, 2, (Object) null)) {
            textTobeReplaced = str;
            matchedQuery = StringsKt.replace$default(str, "#", "", false, 4, (Object) null);
            currentState = 2;
        }
    }

    static /* synthetic */ void setMatchedString$default(SocialValidator socialValidator, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        socialValidator.setMatchedString(str, i);
    }

    private final void setMatchedString(String str, int i) {
        String str2;
        CharSequence charSequence = str;
        if (!StringsKt.contains$default(charSequence, (CharSequence) "@", false, 2, (Object) null) || str.length() <= 1) {
            str2 = "";
        } else {
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            str2 = str.substring(StringsKt.indexOf$default(charSequence, "@", 0, false, 6, (Object) null) + 1);
            Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.String).substring(startIndex)");
        }
        matchedQuery = str2;
    }
}
