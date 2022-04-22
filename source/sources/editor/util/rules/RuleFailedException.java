package editor.util.rules;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, mo26107d2 = {"Leditor/util/rules/RuleFailedException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "failedRule", "Leditor/util/rules/Rule;", "cause", "", "(Leditor/util/rules/Rule;Ljava/lang/String;)V", "getFailedRule", "()Leditor/util/rules/Rule;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RuleFailedException.kt */
public final class RuleFailedException extends RuntimeException {
    private final Rule failedRule;

    public final Rule getFailedRule() {
        return this.failedRule;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RuleFailedException(Rule rule, String str) {
        super(str);
        Intrinsics.checkNotNullParameter(rule, "failedRule");
        Intrinsics.checkNotNullParameter(str, "cause");
        this.failedRule = rule;
    }
}
