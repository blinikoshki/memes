package com.memes.plus;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.share.internal.ShareConstants;
import com.memes.crashreporter.CrashReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/plus/LogTree;", "Ltimber/log/Timber$Tree;", "crashReporter", "Lcom/memes/crashreporter/CrashReporter;", "(Lcom/memes/crashreporter/CrashReporter;)V", "log", "", "priority", "", "tag", "", "message", "t", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: LogTree.kt */
public final class LogTree extends Timber.Tree {
    private final CrashReporter crashReporter;

    public LogTree(CrashReporter crashReporter2) {
        Intrinsics.checkNotNullParameter(crashReporter2, "crashReporter");
        this.crashReporter = crashReporter2;
    }

    /* access modifiers changed from: protected */
    public void log(int i, String str, String str2, Throwable th) {
        String str3;
        Intrinsics.checkNotNullParameter(str2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        StringBuilder sb = new StringBuilder();
        switch (i) {
            case 2:
                str3 = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
                break;
            case 3:
                str3 = "D";
                break;
            case 4:
                str3 = "I";
                break;
            case 5:
                str3 = ExifInterface.LONGITUDE_WEST;
                break;
            case 6:
                str3 = ExifInterface.LONGITUDE_EAST;
                break;
            case 7:
                str3 = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
                break;
            default:
                str3 = "U";
                break;
        }
        sb.append(str3);
        sb.append(":");
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (!StringsKt.isBlank(str2)) {
            sb.append(" msg=");
            sb.append(str2);
        }
        if (th != null) {
            sb.append(" t=");
            sb.append(th);
            sb.append("t.msg=");
            sb.append(th.getMessage());
        }
        CrashReporter crashReporter2 = this.crashReporter;
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        crashReporter2.report(sb2);
    }
}
