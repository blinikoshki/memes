package com.memes.crashreporter;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.memes.crashreporter.blank.BlankCrashReporter;
import com.memes.crashreporter.firebase.FirebaseCrashReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/memes/crashreporter/CrashReporterProvider;", "", "()V", "crashReporter", "Lcom/memes/crashreporter/CrashReporter;", "initBlankCrashReporter", "", "initFirebaseCrashReporter", "reporter", "crashreporter_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CrashReporterProvider.kt */
public final class CrashReporterProvider {
    public static final CrashReporterProvider INSTANCE = new CrashReporterProvider();
    /* access modifiers changed from: private */
    public static CrashReporter crashReporter;

    private CrashReporterProvider() {
    }

    public static final /* synthetic */ CrashReporter access$getCrashReporter$p(CrashReporterProvider crashReporterProvider) {
        CrashReporter crashReporter2 = crashReporter;
        if (crashReporter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("crashReporter");
        }
        return crashReporter2;
    }

    public final void initFirebaseCrashReporter() {
        FirebaseCrashlytics.getInstance();
        crashReporter = new FirebaseCrashReporter();
    }

    public final void initBlankCrashReporter() {
        crashReporter = new BlankCrashReporter();
    }

    public final CrashReporter reporter() {
        if (crashReporter == null) {
            crashReporter = new BlankCrashReporter();
        }
        CrashReporter crashReporter2 = crashReporter;
        if (crashReporter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("crashReporter");
        }
        return crashReporter2;
    }
}
