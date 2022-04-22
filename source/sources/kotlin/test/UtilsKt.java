package kotlin.test;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0001¨\u0006\u0006"}, mo26107d2 = {"messagePrefix", "", "message", "overrideAsserter", "Lkotlin/test/Asserter;", "value", "kotlin-test"}, mo26108k = 2, mo26109mv = {1, 4, 1})
/* compiled from: Utils.kt */
public final class UtilsKt {
    public static final String messagePrefix(String str) {
        if (str == null) {
            return "";
        }
        return str + ". ";
    }

    public static final Asserter overrideAsserter(Asserter asserter) {
        Asserter asserter2 = AssertionsKt.get_asserter();
        AssertionsKt.set_asserter(asserter);
        return asserter2;
    }
}
