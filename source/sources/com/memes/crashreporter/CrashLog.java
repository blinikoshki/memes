package com.memes.crashreporter;

import com.facebook.share.internal.ShareConstants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0002\r\u000eB\u001d\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\u0006H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/crashreporter/CrashLog;", "", "throwable", "", "logs", "Ljava/util/Stack;", "", "(Ljava/lang/Throwable;Ljava/util/Stack;)V", "getLogs", "()Ljava/util/Stack;", "getThrowable", "()Ljava/lang/Throwable;", "toString", "Builder", "Companion", "crashreporter_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CrashLog.kt */
public final class CrashLog {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Stack<String> logs;
    private final Throwable throwable;

    private CrashLog(Throwable th, Stack<String> stack) {
        this.throwable = th;
        this.logs = stack;
    }

    public /* synthetic */ CrashLog(Throwable th, Stack stack, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, stack);
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final Stack<String> getLogs() {
        return this.logs;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/crashreporter/CrashLog$Companion;", "", "()V", "createStackTrace", "", "throwable", "", "crashreporter_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: CrashLog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String createStackTrace(Throwable th) {
            String str;
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            try {
                th.printStackTrace(printWriter);
                str = stringWriter.toString();
            } catch (Exception unused) {
                str = null;
            } catch (Throwable th2) {
                printWriter.close();
                stringWriter.close();
                throw th2;
            }
            printWriter.close();
            stringWriter.close();
            return str;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/crashreporter/CrashLog$Builder;", "", "throwable", "", "(Ljava/lang/Throwable;)V", "logs", "Ljava/util/Stack;", "", "addMessage", "message", "addStackTraceFor", "build", "Lcom/memes/crashreporter/CrashLog;", "markHarmless", "crashreporter_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: CrashLog.kt */
    public static final class Builder {
        private final Stack<String> logs = new Stack<>();
        private final Throwable throwable;

        public Builder(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "throwable");
            this.throwable = th;
        }

        public final Builder markHarmless() {
            addMessage("No users were affected in the production of this exception.");
            return this;
        }

        public final Builder addMessage(String str) {
            Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            if (this.logs.isEmpty()) {
                this.logs.push("--> [begin] crash-logs");
            }
            this.logs.push(str);
            return this;
        }

        public final Builder addStackTraceFor(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "throwable");
            if (this.logs.isEmpty()) {
                this.logs.push("--> [begin] crash-logs");
            }
            String access$createStackTrace = CrashLog.Companion.createStackTrace(th);
            Stack<String> stack = this.logs;
            stack.push("stack-trace: " + access$createStackTrace);
            return this;
        }

        public final CrashLog build() {
            if (!this.logs.isEmpty()) {
                this.logs.push("--> [end] crash-logs");
            }
            return new CrashLog(this.throwable, this.logs, (DefaultConstructorMarker) null);
        }
    }

    public String toString() {
        return "CrashLog(throwable=" + this.throwable + ", logs=" + this.logs + ')';
    }
}
