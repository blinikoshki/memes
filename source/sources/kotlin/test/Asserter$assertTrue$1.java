package kotlin.test;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 1})
/* compiled from: Assertions.kt */
final class Asserter$assertTrue$1 extends Lambda implements Function0<String> {
    final /* synthetic */ String $message;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Asserter$assertTrue$1(String str) {
        super(0);
        this.$message = str;
    }

    public final String invoke() {
        return this.$message;
    }
}
