package p015io.getstream.chat.android.client.models;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "it", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.ContentUtils$initials$1 */
/* compiled from: Extensions.kt */
final class ContentUtils$initials$1 extends Lambda implements Function1<String, CharSequence> {
    public static final ContentUtils$initials$1 INSTANCE = new ContentUtils$initials$1();

    ContentUtils$initials$1() {
        super(1);
    }

    public final CharSequence invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        String take = StringsKt.take(str, 1);
        Objects.requireNonNull(take, "null cannot be cast to non-null type java.lang.String");
        String upperCase = take.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        return upperCase;
    }
}
