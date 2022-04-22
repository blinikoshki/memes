package editor.util.rules.musthavefreespace;

import android.os.StatFs;
import editor.util.rules.Rule;
import editor.util.rules.RuleFailedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Leditor/util/rules/musthavefreespace/MustHaveFreeSpaceRule;", "Leditor/util/rules/Rule;", "folderPath", "", "requiredMegabytes", "", "(Ljava/lang/String;J)V", "apply", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MustHaveFreeSpaceRule.kt */
public final class MustHaveFreeSpaceRule extends Rule {
    private final String folderPath;
    private final long requiredMegabytes;

    public MustHaveFreeSpaceRule(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "folderPath");
        this.folderPath = str;
        this.requiredMegabytes = j;
    }

    public void apply() {
        long availableBytes = new StatFs(this.folderPath).getAvailableBytes() / ((long) 1048576);
        if (availableBytes < this.requiredMegabytes) {
            throw new RuleFailedException(this, "Available memory: " + availableBytes + "Mb, required: " + this.requiredMegabytes + "Mb");
        }
    }
}
