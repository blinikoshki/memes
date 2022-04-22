package kotlin.test;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007¨\u0006\u0002"}, mo26107d2 = {"DefaultAsserter", "Lkotlin/test/DefaultAsserter;", "kotlin-test"}, mo26108k = 2, mo26109mv = {1, 4, 1})
/* compiled from: DefaultAsserter.kt */
public final class DefaultAsserterKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "DefaultAsserter is an object now, constructor call is not required anymore", replaceWith = @ReplaceWith(expression = "DefaultAsserter", imports = {"kotlin.test.DefaultAsserter"}))
    public static final DefaultAsserter DefaultAsserter() {
        return DefaultAsserter.INSTANCE;
    }
}
