package com.getstream.sdk.chat.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.p022bp.LocalDateTime;
import org.threeten.p022bp.LocalTime;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\n"}, mo26107d2 = {"Lcom/getstream/sdk/chat/utils/DateFormatter;", "", "formatDate", "", "localDateTime", "Lorg/threeten/bp/LocalDateTime;", "formatTime", "localTime", "Lorg/threeten/bp/LocalTime;", "Companion", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: DateFormatter.kt */
public interface DateFormatter {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* renamed from: com.getstream.sdk.chat.utils.DateFormatter$-CC  reason: invalid class name */
    /* compiled from: DateFormatter.kt */
    public final /* synthetic */ class CC {
        @JvmStatic
        public static DateFormatter from(Context context) {
            return DateFormatter.Companion.from(context);
        }
    }

    String formatDate(LocalDateTime localDateTime);

    String formatTime(LocalTime localTime);

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo26107d2 = {"Lcom/getstream/sdk/chat/utils/DateFormatter$Companion;", "", "()V", "from", "Lcom/getstream/sdk/chat/utils/DateFormatter;", "context", "Landroid/content/Context;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: DateFormatter.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @JvmStatic
        public final DateFormatter from(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new DefaultDateFormatter(context);
        }
    }
}
