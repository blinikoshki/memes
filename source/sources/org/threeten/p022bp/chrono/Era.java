package org.threeten.p022bp.chrono;

import java.util.Locale;
import org.threeten.p022bp.format.TextStyle;
import org.threeten.p022bp.temporal.TemporalAccessor;
import org.threeten.p022bp.temporal.TemporalAdjuster;

/* renamed from: org.threeten.bp.chrono.Era */
public interface Era extends TemporalAccessor, TemporalAdjuster {
    String getDisplayName(TextStyle textStyle, Locale locale);

    int getValue();
}
