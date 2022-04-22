package org.jetbrains.anko;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 1}, mo26106d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"org/jetbrains/anko/Logging$AnkoLogger$2", "Lorg/jetbrains/anko/AnkoLogger;", "(Ljava/lang/String;)V", "loggerTag", "", "getLoggerTag", "()Ljava/lang/String;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 1, 5})
/* compiled from: Logging.kt */
public final class Logging$AnkoLogger$2 implements AnkoLogger {
    final /* synthetic */ String $tag;
    private final String loggerTag;

    Logging$AnkoLogger$2(String str) {
        this.$tag = str;
        int length = str.length();
        this.loggerTag = str;
    }

    public String getLoggerTag() {
        return this.loggerTag;
    }
}
