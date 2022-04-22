package com.memes.crashreporter.firebase;

import com.facebook.share.internal.ShareConstants;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.memes.crashreporter.base.BaseCrashReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo26107d2 = {"Lcom/memes/crashreporter/firebase/FirebaseCrashReporter;", "Lcom/memes/crashreporter/base/BaseCrashReporter;", "()V", "report", "", "message", "", "throwable", "", "crashreporter_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FirebaseCrashReporter.kt */
public final class FirebaseCrashReporter extends BaseCrashReporter {
    public void report(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        FirebaseCrashlytics.getInstance().log(str);
    }

    public void report(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        FirebaseCrashlytics.getInstance().log("[manual_crash_report]");
        FirebaseCrashlytics.getInstance().recordException(th);
    }
}
