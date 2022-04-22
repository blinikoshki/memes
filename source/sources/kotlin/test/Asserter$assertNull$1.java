package kotlin.test;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 1})
/* compiled from: Assertions.kt */
final class Asserter$assertNull$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Object $actual;
    final /* synthetic */ String $message;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Asserter$assertNull$1(String str, Object obj) {
        super(0);
        this.$message = str;
        this.$actual = obj;
    }

    public final String invoke() {
        return UtilsKt.messagePrefix(this.$message) + "Expected value to be null, but was: <" + this.$actual + ">.";
    }
}
