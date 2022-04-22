package com.getstream.sdk.chat.utils;

import android.content.Context;
import android.text.format.DateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.p022bp.LocalDate;
import org.threeten.p022bp.LocalDateTime;
import org.threeten.p022bp.LocalTime;
import org.threeten.p022bp.chrono.ChronoLocalDate;
import org.threeten.p022bp.format.DateTimeFormatter;
import p015io.getstream.chat.android.p016ui.common.C1891R;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0019H\u0002J\f\u0010\u001a\u001a\u00020\u0018*\u00020\u0019H\u0002J\f\u0010\u001b\u001a\u00020\u0018*\u00020\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo26107d2 = {"Lcom/getstream/sdk/chat/utils/DefaultDateFormatter;", "Lcom/getstream/sdk/chat/utils/DateFormatter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dateContext", "Lcom/getstream/sdk/chat/utils/DefaultDateFormatter$DateContext;", "(Lcom/getstream/sdk/chat/utils/DefaultDateFormatter$DateContext;)V", "dateFormatterDayOfWeek", "Lorg/threeten/bp/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "dateFormatterFullDate", "getDateFormatterFullDate", "()Lorg/threeten/bp/format/DateTimeFormatter;", "timeFormatter12h", "timeFormatter24h", "formatDate", "", "localDateTime", "Lorg/threeten/bp/LocalDateTime;", "formatTime", "localTime", "Lorg/threeten/bp/LocalTime;", "isToday", "", "Lorg/threeten/bp/LocalDate;", "isWithinLastWeek", "isYesterday", "DateContext", "DefaultDateContext", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: DefaultDateFormatter.kt */
public final class DefaultDateFormatter implements DateFormatter {
    private final DateContext dateContext;
    private final DateTimeFormatter dateFormatterDayOfWeek;
    private final DateTimeFormatter timeFormatter12h;
    private final DateTimeFormatter timeFormatter24h;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, mo26107d2 = {"Lcom/getstream/sdk/chat/utils/DefaultDateFormatter$DateContext;", "", "dateTimePattern", "", "is24Hour", "", "now", "Lorg/threeten/bp/LocalDate;", "yesterdayString", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: DefaultDateFormatter.kt */
    public interface DateContext {
        String dateTimePattern();

        boolean is24Hour();

        LocalDate now();

        String yesterdayString();
    }

    public DefaultDateFormatter(DateContext dateContext2) {
        Intrinsics.checkNotNullParameter(dateContext2, "dateContext");
        this.dateContext = dateContext2;
        this.timeFormatter12h = DateTimeFormatter.ofPattern("h:mm a");
        this.timeFormatter24h = DateTimeFormatter.ofPattern("HH:mm");
        this.dateFormatterDayOfWeek = DateTimeFormatter.ofPattern("EEEE");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultDateFormatter(Context context) {
        this((DateContext) new DefaultDateContext(context));
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final DateTimeFormatter getDateFormatterFullDate() {
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern(this.dateContext.dateTimePattern());
        Intrinsics.checkNotNullExpressionValue(ofPattern, "DateTimeFormatter.ofPatt…ontext.dateTimePattern())");
        return ofPattern;
    }

    public String formatDate(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return "";
        }
        LocalDate localDate = localDateTime.toLocalDate();
        Intrinsics.checkNotNullExpressionValue(localDate, "localDate");
        if (isToday(localDate)) {
            return formatTime(localDateTime.toLocalTime());
        }
        if (isYesterday(localDate)) {
            return this.dateContext.yesterdayString();
        }
        if (isWithinLastWeek(localDate)) {
            String format = this.dateFormatterDayOfWeek.format(localDate);
            Intrinsics.checkNotNullExpressionValue(format, "dateFormatterDayOfWeek.format(localDate)");
            return format;
        }
        String format2 = getDateFormatterFullDate().format(localDate);
        Intrinsics.checkNotNullExpressionValue(format2, "dateFormatterFullDate.format(localDate)");
        return format2;
    }

    public String formatTime(LocalTime localTime) {
        if (localTime == null) {
            return "";
        }
        String format = (this.dateContext.is24Hour() ? this.timeFormatter24h : this.timeFormatter12h).format(localTime);
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(localTime)");
        return format;
    }

    private final boolean isToday(LocalDate localDate) {
        return Intrinsics.areEqual((Object) localDate, (Object) this.dateContext.now());
    }

    private final boolean isYesterday(LocalDate localDate) {
        return Intrinsics.areEqual((Object) localDate, (Object) this.dateContext.now().minusDays(1));
    }

    private final boolean isWithinLastWeek(LocalDate localDate) {
        return localDate.compareTo((ChronoLocalDate) this.dateContext.now().minusDays(6)) >= 0;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Lcom/getstream/sdk/chat/utils/DefaultDateFormatter$DefaultDateContext;", "Lcom/getstream/sdk/chat/utils/DefaultDateFormatter$DateContext;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dateTimePattern", "", "is24Hour", "", "now", "Lorg/threeten/bp/LocalDate;", "yesterdayString", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: DefaultDateFormatter.kt */
    private static final class DefaultDateContext implements DateContext {
        private final Context context;

        public DefaultDateContext(Context context2) {
            Intrinsics.checkNotNullParameter(context2, "context");
            this.context = context2;
        }

        public LocalDate now() {
            LocalDate now = LocalDate.now();
            Intrinsics.checkNotNullExpressionValue(now, "LocalDate.now()");
            return now;
        }

        public String yesterdayString() {
            String string = this.context.getString(C1891R.string.stream_date_yesterday);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.stream_date_yesterday)");
            return string;
        }

        public boolean is24Hour() {
            return DateFormat.is24HourFormat(this.context);
        }

        public String dateTimePattern() {
            String bestDateTimePattern = DateFormat.getBestDateTimePattern(Locale.getDefault(), "yy MM dd");
            Intrinsics.checkNotNullExpressionValue(bestDateTimePattern, "DateFormat.getBestDateTi…getDefault(), \"yy MM dd\")");
            return bestDateTimePattern;
        }
    }
}
