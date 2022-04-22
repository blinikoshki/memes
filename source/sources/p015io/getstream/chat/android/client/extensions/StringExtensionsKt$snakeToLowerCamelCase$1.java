package p015io.getstream.chat.android.client.extensions;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchResult;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "it", "Lkotlin/text/MatchResult;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.extensions.StringExtensionsKt$snakeToLowerCamelCase$1 */
/* compiled from: StringExtensions.kt */
final class StringExtensionsKt$snakeToLowerCamelCase$1 extends Lambda implements Function1<MatchResult, CharSequence> {
    public static final StringExtensionsKt$snakeToLowerCamelCase$1 INSTANCE = new StringExtensionsKt$snakeToLowerCamelCase$1();

    StringExtensionsKt$snakeToLowerCamelCase$1() {
        super(1);
    }

    public final CharSequence invoke(MatchResult matchResult) {
        Intrinsics.checkNotNullParameter(matchResult, "it");
        String replace$default = StringsKt.replace$default(matchResult.getValue(), "_", "", false, 4, (Object) null);
        Objects.requireNonNull(replace$default, "null cannot be cast to non-null type java.lang.String");
        String upperCase = replace$default.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        return upperCase;
    }
}
