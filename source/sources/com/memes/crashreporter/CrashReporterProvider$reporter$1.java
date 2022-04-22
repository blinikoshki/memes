package com.memes.crashreporter;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: CrashReporterProvider.kt */
final /* synthetic */ class CrashReporterProvider$reporter$1 extends MutablePropertyReference0Impl {
    CrashReporterProvider$reporter$1(CrashReporterProvider crashReporterProvider) {
        super(crashReporterProvider, CrashReporterProvider.class, "crashReporter", "getCrashReporter()Lcom/memes/crashreporter/CrashReporter;", 0);
    }

    public Object get() {
        return CrashReporterProvider.access$getCrashReporter$p((CrashReporterProvider) this.receiver);
    }

    public void set(Object obj) {
        CrashReporterProvider.crashReporter = (CrashReporter) obj;
    }
}
