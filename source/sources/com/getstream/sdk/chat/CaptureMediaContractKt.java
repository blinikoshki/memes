package com.getstream.sdk.chat;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0004"}, mo26107d2 = {"dateFormat", "Ljava/text/SimpleDateFormat;", "takeIfCaptured", "Ljava/io/File;", "stream-chat-android-ui-common_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: CaptureMediaContract.kt */
public final class CaptureMediaContractKt {
    /* access modifiers changed from: private */
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US);

    /* access modifiers changed from: private */
    public static final File takeIfCaptured(File file) {
        if (file != null) {
            if (file.exists() && file.length() > 0) {
                return file;
            }
        }
        return null;
    }
}
