package com.memes.chat.util.logger;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.logger.ChatLoggerHandler;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J \u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001a"}, mo26107d2 = {"Lcom/memes/chat/util/logger/ChatLogger;", "Lio/getstream/chat/android/client/logger/ChatLoggerHandler;", "()V", "INTERNAL_LOG_PREFIX", "", "logger", "Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "value", "userId", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "log", "", "tag", "", "message", "error", "", "logD", "logE", "throwable", "logI", "logT", "logW", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatLogger.kt */
public final class ChatLogger implements ChatLoggerHandler {
    public static final ChatLogger INSTANCE = new ChatLogger();
    private static final String INTERNAL_LOG_PREFIX = "Chat";
    private static final FirebaseCrashlytics logger;
    private static String userId;

    static {
        FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "FirebaseCrashlytics.getInstance()");
        logger = instance;
    }

    private ChatLogger() {
    }

    public final String getUserId() {
        return userId;
    }

    public final void setUserId(String str) {
        userId = str;
        if (str != null) {
            logger.setUserId(str);
        }
    }

    static /* synthetic */ void log$default(ChatLogger chatLogger, Object obj, String str, Throwable th, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            th = null;
        }
        chatLogger.log(obj, str, th);
    }

    private final void log(Object obj, String str, Throwable th) {
        if ((obj instanceof String) && StringsKt.startsWith$default((String) obj, INTERNAL_LOG_PREFIX, false, 2, (Object) null)) {
            return;
        }
        if (obj == null && str == null && th == null) {
            Timber.m300d("No data provided; skipping Crashlytics logging", new Object[0]);
            return;
        }
        if (obj == null) {
            obj = "";
        }
        if (str == null) {
            str = "";
        }
        FirebaseCrashlytics firebaseCrashlytics = logger;
        firebaseCrashlytics.log('[' + obj + "] " + str);
        if (th != null) {
            firebaseCrashlytics.recordException(th);
        }
    }

    public void logD(Object obj, String str) {
        Intrinsics.checkNotNullParameter(obj, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        log$default(this, obj, str, (Throwable) null, 4, (Object) null);
    }

    public void logE(Object obj, String str) {
        Intrinsics.checkNotNullParameter(obj, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        log$default(this, obj, str, (Throwable) null, 4, (Object) null);
    }

    public void logE(Object obj, String str, Throwable th) {
        Intrinsics.checkNotNullParameter(obj, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(th, "throwable");
        log(obj, str, th);
    }

    public void logI(Object obj, String str) {
        Intrinsics.checkNotNullParameter(obj, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        log$default(this, obj, str, (Throwable) null, 4, (Object) null);
    }

    public void logT(Object obj, Throwable th) {
        Intrinsics.checkNotNullParameter(obj, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(th, "throwable");
        log$default(this, obj, (String) null, th, 2, (Object) null);
    }

    public void logT(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        log$default(this, (Object) null, (String) null, th, 3, (Object) null);
    }

    public void logW(Object obj, String str) {
        Intrinsics.checkNotNullParameter(obj, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        log$default(this, obj, str, (Throwable) null, 4, (Object) null);
    }
}
