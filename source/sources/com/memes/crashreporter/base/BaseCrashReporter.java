package com.memes.crashreporter.base;

import com.memes.crashreporter.CrashLog;
import com.memes.crashreporter.CrashReporter;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/crashreporter/base/BaseCrashReporter;", "Lcom/memes/crashreporter/CrashReporter;", "()V", "report", "", "crashLog", "Lcom/memes/crashreporter/CrashLog;", "crashreporter_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BaseCrashReporter.kt */
public abstract class BaseCrashReporter implements CrashReporter {
    public void report(CrashLog crashLog) {
        Intrinsics.checkNotNullParameter(crashLog, "crashLog");
        Iterator it = crashLog.getLogs().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Intrinsics.checkNotNullExpressionValue(str, "log");
            report(str);
        }
        report(crashLog.getThrowable());
    }
}
