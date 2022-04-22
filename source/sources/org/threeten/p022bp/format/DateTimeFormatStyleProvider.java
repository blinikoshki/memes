package org.threeten.p022bp.format;

import java.util.Locale;
import org.threeten.p022bp.chrono.Chronology;

/* renamed from: org.threeten.bp.format.DateTimeFormatStyleProvider */
abstract class DateTimeFormatStyleProvider {
    public abstract DateTimeFormatter getFormatter(FormatStyle formatStyle, FormatStyle formatStyle2, Chronology chronology, Locale locale);

    DateTimeFormatStyleProvider() {
    }

    static DateTimeFormatStyleProvider getInstance() {
        return new SimpleDateTimeFormatStyleProvider();
    }

    public Locale[] getAvailableLocales() {
        throw new UnsupportedOperationException();
    }
}
