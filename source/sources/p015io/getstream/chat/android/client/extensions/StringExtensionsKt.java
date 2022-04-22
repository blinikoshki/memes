package p015io.getstream.chat.android.client.extensions;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"camelRegex", "Lkotlin/text/Regex;", "snakeRegex", "camelCaseToSnakeCase", "", "snakeToLowerCamelCase", "stream-chat-android-client_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.extensions.StringExtensionsKt */
/* compiled from: StringExtensions.kt */
public final class StringExtensionsKt {
    private static final Regex camelRegex = new Regex("(?<=[a-zA-Z])[A-Z]");
    private static final Regex snakeRegex = new Regex("_[a-zA-Z]");

    public static final String snakeToLowerCamelCase(String str) {
        Intrinsics.checkNotNullParameter(str, "$this$snakeToLowerCamelCase");
        return snakeRegex.replace((CharSequence) str, (Function1<? super MatchResult, ? extends CharSequence>) StringExtensionsKt$snakeToLowerCamelCase$1.INSTANCE);
    }

    public static final String camelCaseToSnakeCase(String str) {
        Intrinsics.checkNotNullParameter(str, "$this$camelCaseToSnakeCase");
        String replace = camelRegex.replace((CharSequence) str, (Function1<? super MatchResult, ? extends CharSequence>) StringExtensionsKt$camelCaseToSnakeCase$1.INSTANCE);
        Objects.requireNonNull(replace, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = replace.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }
}
